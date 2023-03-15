/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodlist.service;

import foodlist.exception.ResourceNotFoundException;
import foodlist.model.Food;
import foodlist.repository.FoodRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author romar
 */
@Service
public class FoodService {
    
    @Autowired
    private FoodRepository foodRepository;
    
    
    public List<Food> listar() {  
        return foodRepository.findAll();
    }
    
    public Food listarId(Long id) {
        Optional<Food> obj = foodRepository.findById(id);
        return obj.orElseThrow( () -> new ResourceNotFoundException(id));
    }
    
    public Food create(Food food) {
        return foodRepository.save(food);
    }
    
    public Food update(Food food, Long id) {
        food.setId(id);
        return foodRepository.save(food);
    }
    
    public void deletar(Long id) {
        foodRepository.deleteById(id);
    }
    
}
