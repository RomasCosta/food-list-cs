/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodlist.controller;

import foodlist.model.Player;
import foodlist.service.PlayerService;
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
@RequestMapping("/players")
public class PlayerController {
    
    @Autowired
    private PlayerService playerService;
    
    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
        List<Player> listarTudo = playerService.listarAll();
        return ResponseEntity.ok().body(listarTudo);
    }
    
    @GetMapping(path = {"/players/{id}"})
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Player listarId = playerService.listarId(id);
        return ResponseEntity.ok().body(listarId);
    }
    
    @PostMapping
    public ResponseEntity<Player> create(@RequestBody Player player) {
        player = playerService.create(player);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(player.getId()).toUri();
        return ResponseEntity.created(uri).body(player);
    }
    
    @RequestMapping(value = {"/players/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Player> update(@RequestBody Player player, @PathVariable("id") Long id) {
        playerService.update(player, id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping(path ={"/players/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        playerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
