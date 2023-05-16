package com.example.streamAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String payerId;
    private double amount;
    private String expenseType;

    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL)
    private List<Buyer> buyers;

    // constructors, getters, setters
}
