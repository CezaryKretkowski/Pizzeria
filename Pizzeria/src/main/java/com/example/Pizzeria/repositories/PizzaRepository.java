package com.example.Pizzeria.repositories;


import com.example.Pizzeria.entities.products.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
}
