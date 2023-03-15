/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodlist.exception;

/**
 *
 * @author romar
 */
public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(Object id) {
        super( "Resource Not found with id = " + id);
    }
}
