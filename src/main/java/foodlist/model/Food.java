/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodlist.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author romar
 */
@Data //lombok para gerar hash, getter&setters
@Entity//indica que será uma entidade/tabela de banco de dados.
public class Food {
    
    @Id//indica qual será o id
    @GeneratedValue(generator = "increment")//gera o id automatico
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    
    private String nome;
    
    @OneToMany(mappedBy = "foods")
    private List<Player> players = new ArrayList<>();

    
}
