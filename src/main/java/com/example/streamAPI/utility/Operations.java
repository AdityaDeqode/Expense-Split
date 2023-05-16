package com.example.streamAPI.utility;

import com.example.streamAPI.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Operations {

     Scanner scanner = new Scanner(System.in);

    public void showUsers(List<User> users){
        System.out.println("Inside the Show users method");

        System.out.println("Please user Id for specific user(user1, users1, ...) details or nothing for all users");
        String userId = scanner.next();

        if (userId.length() == 0) {
            System.out.println("inside userId");
        } else {
            System.out.println("inside userId2222");
        }


    }






}
