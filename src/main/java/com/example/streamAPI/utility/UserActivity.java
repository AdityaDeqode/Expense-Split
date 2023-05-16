package com.example.streamAPI.utility;

import com.example.streamAPI.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Component
//@AllArgsConstructor
//@NoArgsConstructor
public class UserActivity {

    @Autowired
    Operations operations;

    private static Scanner scanner = new Scanner(System.in);

//    public void addUsers(){
//        List<User> users = new ArrayList<>();
//        User user1 = new User("user1", "Aditya" , "Aditya1@gmail.com", "9977455845");
//        User user2 = new User("user2", "Aman" , "Aman@gmail.com", "1234");
//        User user3 = new User("user3", "Arun" , "Arun@gmail.com", "12345");
//        User user4 = new User("user4", "Ajay" , "Ajay@gmail.com", "123456");
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//        System.out.println(users);
//        inputTypes(users);
//
//    }

    public void inputTypes(List<User> users){
        System.out.println("Inside the input types method");

        System.out.println("Enter the Expense type you want to check (Show/Expenses)");
        String operation = scanner.next();

        if(operation.equals("Show")){

            operations.showUsers(users);
            System.out.println("Hello Aditya");
        }
        else if(operation.equals("Expenses")){

            System.out.println("Hello Aditya2222");
        }




    }


}
