package com.example.Pizzeria.services.home;

import com.example.Pizzeria.dto.CreatePizzaDto;
import com.example.Pizzeria.dto.PizzaDto;
import com.example.Pizzeria.dto.UpdatePizzaDto;
import com.example.Pizzeria.entities.products.Pizza;
import com.example.Pizzeria.repositories.StaticFileRepository;
import com.example.Pizzeria.repositories.PizzaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final StaticFileRepository staticFileRepository;


    @Transactional
    public void add(CreatePizzaDto pizzaDto, MultipartFile image){
        try {
            String filePath = staticFileRepository.saveImage(image);

            pizzaRepository.save(Pizza.builder()
                    .name(pizzaDto.name())
                    .description(pizzaDto.description())
                    .imageUrl(filePath)
                    .price(pizzaDto.price())
                    .build());

        }catch (Exception e){
            throw new RuntimeException();
        }
    }


    public List<PizzaDto> getAll(){

        return pizzaRepository.findAll().stream().map(index->PizzaDto.builder()
                   .id(index.getId())
                   .name(index.getName())
                   .description(index.getDescription())
                   .price(index.getPrice())
                   .image("imageData/"+index.getImageUrl()).build()

       ).toList();
    }

    public void update(UpdatePizzaDto updatePizzaDto, MultipartFile file) {
        System.out.println(updatePizzaDto);
        try{
            var pizza = pizzaRepository.findById(updatePizzaDto.id()).get();
            pizza.setName(updatePizzaDto.name());
            pizza.setDescription(updatePizzaDto.description());
            pizza.setPrice(updatePizzaDto.price());

            if(!file.isEmpty()){
                String filePath = staticFileRepository.saveImage(file);
                pizza.setImageUrl(filePath);
            }
            pizzaRepository.save(pizza);
        }catch (Exception e){
            throw new RuntimeException();
        }


    }
}
