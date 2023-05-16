package com.example.streamAPI.model;

import java.util.List;

public class ExpenseRequest {

    private String payerId;
    private double amount;
    private String expenseType;
    private List<String> participants;
    private List<Double> amounts;

    public ExpenseRequest(String payerId, double amount, String expenseType, List<String> participants, List<Double> amounts) {
        this.payerId = payerId;
        this.amount = amount;
        this.expenseType = expenseType;
        this.participants = participants;
        this.amounts = amounts;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public List<Double> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<Double> amounts) {
        this.amounts = amounts;
    }
}
