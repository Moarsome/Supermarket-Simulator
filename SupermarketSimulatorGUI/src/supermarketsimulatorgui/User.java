/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.util.HashMap;

/**
 * User class for the Supermarket simulator
 * @author kyliec
 */
public class User {
    private static int userStaticID = 0;
    
    private float budget;
    private int userID;
    private String name;
    private String password;
    private boolean isShopping;
    private HashMap<ItemDatabase, Integer> inventory;
    private float cart;
    
    /**
     * Constructor for user
     *
     * @param budget
     * @param name
     */
    
    public User(float budget, String name, String password)
    {
        userStaticID++;
        
        this.userID = userStaticID;
        this.budget = budget;
        this.name = name;
        this.password = password;
        this.isShopping = true;
        this.inventory = new HashMap<ItemDatabase, Integer>();
    }
    
    /**
     * 2nd Constructor for user
     *
     * @param name
     * @param password
     */
    
    public User(String name, String password)
    {
        userStaticID++;
        
        this.userID = userStaticID;
        this.budget = 0.0f;
        this.name = name;
        this.password = password;
        this.isShopping = true;
        this.inventory = new HashMap<ItemDatabase, Integer>();
    }
    
    /**
     * 3rd Constructor for user
     *
     * @param user
     * @param password
     */
    
    public User(User user, String password)
    {
        userStaticID++;
        
        
        this.userID = userStaticID;
        this.budget = user.budget;
        this.name = user.name;
        this.password = password;
        this.isShopping = true;
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
    public float getCart() {
        return cart;
    }
    
    /**
     * setter for the user cart
     * @param cart 
     */
    public void setCart(float cart) {
        this.cart = cart;
    }

    /**
     * getter for the user inventory
     * @return the inventory
     */
    public HashMap<ItemDatabase, Integer> getInventory() {
        return inventory;
    }

    /**
     * setter for the user inventory
     * @param inventory the inventory to set
     */
    public void setInventory(HashMap<ItemDatabase, Integer> inventory) {
        this.inventory = inventory;
    }
    
    public void addInventory(ItemDatabase item, int stock) {
        inventory.put(item, stock);
    }
    
    public int getUserID()
    {
        return this.userID;
    }  
    
    public int getPassword()
    {
        return this.userID;
    }  
    
}
