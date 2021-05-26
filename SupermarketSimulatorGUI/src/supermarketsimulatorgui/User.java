/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.util.ArrayList;

/**
 * User class for the Supermarket simulator
 * @author kyliec
 */
public class User {
    private static int userStaticID = 0;
    
    private float budget;
    private float cartCost;
    private int userID;
    private String name;
    private String password;
    private boolean isShopping;
    private ArrayList<ItemDatabase> inventory;
    
    /**
     * Constructor for user
     *
     */
    
    public User()
    {
        userStaticID++;
        
        this.userID = userStaticID;
        this.isShopping = true;
        this.inventory = new ArrayList<>();
        this.cartCost = 0.0f;
    }
    
    /**
     * getter for the user budget
     * @return the budget
     */
    public float getBudget() {
        return Math.round(budget * 100.0f) / 100.0f;
    }

    /**
     * setter for the user budget
     * @param budget the budget to set
     */
    public void setBudget(float budget) {
        
        this.budget = budget;
    }

    /**
     * Adds money to the user's budget
     *
     * @param budget
     */
    
    public void addBudget(float budget)
    {
        this.budget += budget;
    }
    
    /**
     * getter for the user name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the user name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getter for the isShopping Boolean
     * @return Boolean isShopping
     */
    public boolean getIsShopping()
    {
        return this.isShopping;
    }
    
    /**
     * Set the boolean for whether user is currently shopping
     *
     * @param isShopping
     */
    
    public void setIsShopping(boolean isShopping)
    {
        this.isShopping = isShopping;
    }
    
    /**
     * getter for the user cart
     * @return float cart
     */
    public float getCartCost() {
        return cartCost;
    }
    
    /**
     * setter for the user cart
     * @param cart 
     */
    public void addCartCost(float cartCost) {
        this.cartCost += cartCost;
    }

    /**
     * getter for the user inventory
     * @return the inventory
     */
    public ArrayList<ItemDatabase> getInventory() {
        return inventory;
    }

    /**
     * setter for the user inventory
     * @param inventory the inventory to set
     */
    public void setInventory(ArrayList<ItemDatabase> inventory) {
        this.inventory = inventory;
    }
    
    public void addInventory(ItemDatabase item) {
        inventory.add(item);
        addCartCost(item.getPrice());
    }
    
    public int getUserID()
    {
        return this.userID;
    }  
    
    public void setUsername(String name)
    {
        this.name = name;
    }
    
    public String getUsername()
    {
        return this.name;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return this.password;
    }  
    
}
