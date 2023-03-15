/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodlist.controller;

import foodlist.model.Food;
import foodlist.service.FoodService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author romar
 */
@RestController
@RequestMapping("/foods")
public class FoodController {
    
    @Autowired
    private FoodService foodService;//instancia a classe Service
    
    @GetMapping
    public ResponseEntity<List<Food>> findAll() {
        List<Food> list = foodService.listar();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(path = {"/foods/{id}"})
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Food list = foodService.listarId(id);
        return ResponseEntity.ok().body(list);
    }
    
    @PostMapping
    public ResponseEntity<Food> create(@RequestBody Food food) {
        food = foodService.create(food);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(food.getId()).toUri();
        return ResponseEntity.created(uri).body(food);
    }
    
    @RequestMapping(value = {"/foods/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Food> update(@RequestBody Food food, @PathVariable("id") Long id) {
        foodService.update(food, id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping(path ={"/foods/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        foodService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
