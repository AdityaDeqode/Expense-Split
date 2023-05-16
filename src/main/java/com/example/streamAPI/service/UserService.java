package com.example.streamAPI.service;

import com.example.streamAPI.Repository.UserRepository;
import com.example.streamAPI.model.User;
import com.example.streamAPI.utility.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @Autowired
//    Operations operations;
//
//
//    private static Scanner scanner = new Scanner(System.in);
//
//    public void inputType(){
//
//        System.out.println("Inside the input types method");
//
//        System.out.println("Enter the Expense type you want to check (Show/Expenses)");
//        String operation = scanner.next();
//
//        if(operation.equals("Show")){
//
////            operations.showUsers(users);
//            System.out.println("Hello Aditya");
//        }
//        else if(operation.equals("Expenses")){
//
//            System.out.println("Hello Aditya2222");
//        }
//
//
//    }


}
