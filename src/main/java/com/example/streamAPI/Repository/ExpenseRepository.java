package com.example.streamAPI.Repository;

import com.example.streamAPI.model.Expense;
import com.example.streamAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, String> {


}
