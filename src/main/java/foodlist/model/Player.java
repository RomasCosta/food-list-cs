/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodlist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author romar
 */
@Data
@Entity
public class Player {
    
    @Id
    @GeneratedValue(generator = "increment")//gera o id automatico
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "foodId")
    private Food foods;

   
}
