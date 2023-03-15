/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodlist.service;

import foodlist.exception.ResourceNotFoundException;
import foodlist.model.Player;
import foodlist.repository.PlayerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author romar
 */
@Service
public class PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    
    public List<Player> listarAll() {
        return playerRepository.findAll();
    }
    
    public Player listarId(Long id) {
        Optional<Player> obj = playerRepository.findById(id);
        return obj.orElseThrow( () -> new ResourceNotFoundException(id));
    }
    
    public Player create(Player player) {
        return playerRepository.save(player);
    }
    
    public Player update(Player player, Long id) {
        player.setId(id);
        return playerRepository.save(player);
    }
    
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }
}
