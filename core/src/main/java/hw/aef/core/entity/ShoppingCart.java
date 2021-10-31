/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw.aef.core.entity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author anas.faour
 */
public class ShoppingCart {
    
    private Set<Work> items = new HashSet<>();

    public Set<Work> getItems() {
        return items;
    }

    public void setItems(Set<Work> items) {
        this.items = items;
    }
    
    
    
}
