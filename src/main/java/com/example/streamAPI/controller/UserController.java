package com.example.streamAPI.controller;


import com.example.streamAPI.model.ExpenseRequest;
import com.example.streamAPI.model.User;
import com.example.streamAPI.service.ExpenseService;
import com.example.streamAPI.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/expenses")
public class UserController {

    private final ExpenseService expenseService;
    private final UserService userService;

    public UserController(ExpenseService expenseService, UserService userService) {
        this.expenseService = expenseService;
        this.userService = userService;
    }

    @PostMapping("/expenses")
    public ResponseEntity<String> addExpense(@RequestBody ExpenseRequest expenseRequest) {
        try {
            expenseService.addExpense(
                    expenseRequest.getPayerId(),
                    expenseRequest.getAmount(),
                    expenseRequest.getExpenseType(),
                    expenseRequest.getParticipants(),
                    expenseRequest.getAmounts()
            );
            return ResponseEntity.ok("Expense added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add expense: " + e.getMessage());
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable String userId) {
        try {
            User user = userService.getUserById(userId);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}

    // Additional API endpoints as needed

//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    UserService userService;
//
//    @PostMapping
//    public ResponseEntity<String> addUser(@RequestBody User user) {
//        userRepository.save(user);
//        userService.inputType();
//
//
//        return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
//    }
//
//
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<User> getUser(@PathVariable String userId) {
//        Optional<User> optionalUser = userRepository.findById(userId);
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        return ResponseEntity.ok(users);
//    }
//
//}
