package com.example.streamAPI.service;

import com.example.streamAPI.Repository.BuyerRepository;
import com.example.streamAPI.Repository.ExpenseRepository;
import com.example.streamAPI.Repository.UserRepository;
import com.example.streamAPI.model.Buyer;
import com.example.streamAPI.model.Expense;
import com.example.streamAPI.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final BuyerRepository buyerRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public ExpenseService(ExpenseRepository expenseRepository, BuyerRepository buyerRepository, UserRepository userRepository, UserService userService) {
        this.expenseRepository = expenseRepository;
        this.buyerRepository = buyerRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public void addExpense(String payerId, double amount, String expenseType, List<String> participants, List<Double> amounts) {
        Expense expense = new Expense();
        expense.setPayerId(payerId);
        expense.setAmount(amount);
        expense.setExpenseType(expenseType);

        // Calculate owed amounts based on expense type
        Map<String, Double> owedAmounts = new HashMap<>();
        if (expenseType.equals("EQUAL")) {
            double perPersonAmount = amount / participants.size();
            for (String participant : participants) {
                owedAmounts.put(participant, perPersonAmount);
            }
        } else if (expenseType.equals("EXACT")) {
            if (participants
                    .size() != amounts.size()) {
                throw new IllegalArgumentException("Number of participants and amounts must match");
            }
            for (int i = 0; i < participants.size(); i++) {
                owedAmounts.put(participants.get(i), amounts.get(i));
            }
        }
        // Update balances and create buyers
        List<Buyer> buyers = new ArrayList<>();
        for (Map.Entry<String, Double> entry : owedAmounts.entrySet()) {
            String participant = entry.getKey();
            Double owedAmount = entry.getValue();

            User user = userService.getUserById(participant);

            Buyer buyer = new Buyer();
            buyer.setUser(user);
            buyer.setExpense(expense);

            buyers.add(buyer);

            user.setBalance(user.getBalance() - owedAmount);
        }

        expense.setBuyers(buyers);

        expenseRepository.save(expense);
        buyerRepository.saveAll(buyers);
        userRepository.saveAll(buyers.stream().map(Buyer::getUser).collect(Collectors.toList()));
    }

// Additional methods as needed
}
