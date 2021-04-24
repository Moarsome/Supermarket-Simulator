/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.util.ArrayList;

/**
 *
 * @author kyliec
 */
public class SelectItem {
    private ArrayList<ItemDatabase> cart;
    private User user;
    
    /**
     * Constructor for SelectItem
     * @param user 
     */
    public SelectItem(User user)
    {
        this.user = user;
        cart = new ArrayList<ItemDatabase>();
    }
    
    /**
     * adds selected item to cart
     * @param item 
     */
    public void addToCart(ItemDatabase item)
    {
        cart.add(item);
        user.setCart(user.getCart() + item.getPrice());
        
        System.out.println("'"+item.getName()+"' added to cart, total cart cost is $"+user.getCart());
        
    }
    /**
     * removes selected item for cart
     * @param item 
     */
    public void removeFromCart(ItemDatabase item)
    {
        cart.remove(item);
        user.setCart(user.getCart() - item.getPrice());
    }
    
    
    /**
     * Prints out cart content
     * @return 
     */
    public void printCartContent()
    {   
        int iterator = 1;
        
        for(ItemDatabase item: cart)
        {
            System.out.println(iterator + ". " + item.getName());
            iterator++;
        }
    }
    
     /**
     * getter method for cart 
     * @return 
     */
    public ArrayList<ItemDatabase> getCartContent()
    {
        return cart;
    }
    
    public float getTotalCost()
    {
        float totalCost = 0.0f;
        
        for (ItemDatabase item:cart)
        {
            totalCost += item.getPrice();
        }
        
        return totalCost;
    }
}
