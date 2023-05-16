package com.example.streamAPI.Repository;

import com.example.streamAPI.model.Buyer;
import com.example.streamAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, String> {




}
