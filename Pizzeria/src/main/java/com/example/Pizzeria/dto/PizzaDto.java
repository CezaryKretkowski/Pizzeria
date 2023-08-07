package com.example.Pizzeria.dto;

import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record PizzaDto(int id,String name, String description, float price,String  image) {
}
