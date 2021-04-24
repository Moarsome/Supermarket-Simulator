/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Set;

/**
 * organizes the ItemDatabase class into Isles
 * @author kyliec
 */
public class IsleMarker {

    // ORGANISING PRODUCTS INTO CATEGORIES
    Set<ItemDatabase> confectionary = EnumSet.range(ItemDatabase.TOBLERONE, ItemDatabase.WHITTAKERS_DAIRYMILK);
    Set<ItemDatabase> snacks = EnumSet.range(ItemDatabase.CORNCHIPS_CHEESE, ItemDatabase.RICE_CRACKER_SEAWEED);
    Set<ItemDatabase> drinks = EnumSet.range(ItemDatabase.COKE, ItemDatabase.KERI_PINEAPPLE);
    Set<ItemDatabase> alcohol = EnumSet.range(ItemDatabase.HIENEKEN, ItemDatabase.SAUVIGNON_BLANC);
    Set<ItemDatabase> bread = EnumSet.range(ItemDatabase.BREAD_WHITE, ItemDatabase.BAGEL);
    Set<ItemDatabase> pasta = EnumSet.range(ItemDatabase.SPAGHETTI, ItemDatabase.MIGORENG_BBQCHICKEN);
    Set<ItemDatabase> condiments = EnumSet.range(ItemDatabase.SALT, ItemDatabase.BBQ_SAUCE);
    Set<ItemDatabase> dairy = EnumSet.range(ItemDatabase.MILK_FULLCREAM, ItemDatabase.BUTTER_SALTED);
    Set<ItemDatabase> frozen = EnumSet.range(ItemDatabase.ICE_CREAM_CHOCOLATE, ItemDatabase.FRIES_SHOESTRING);

    private int isle = 0;
    private ArrayList<Set<ItemDatabase>> isles;
    private final String[] isleNames = {"Confectionary", "Snacks", "Drinks", "Alcohol", "Bread", "Pasta & Noodles", "Condiments", "Dairy", "Frozen"};
    private User user;
    
    /**
     * Constructor for IsleMarker Class
     * @param user 
     */
    public IsleMarker(User user) {

        this.user = user;
        // ARRAY LIST OF SETS
        isles = new ArrayList<Set<ItemDatabase>>(isleNames.length);

        isles.add(confectionary);
        isles.add(snacks);
        isles.add(drinks);
        isles.add(alcohol);
        isles.add(bread);
        isles.add(pasta);
        isles.add(condiments);
        isles.add(dairy);
        isles.add(frozen);
    }

    /**
     * changes isle number
     * @param isleChangeyes
     * 
     * @return Boolean
     */
    public boolean changeIsle(int isleChange) {
        int newIsle = this.isle + isleChange;
        if (newIsle > 0 && newIsle <= isles.size()) {
            // PRINT OUT ISLE NAMES IF APPLICABLE
            this.isle = newIsle;
            boolean leftIsle = newIsle - 1 > 0;
            boolean rightIsle = newIsle + 1 <= isles.size();
            
            System.out.println("YOU ARE NOW IN ISLE " + newIsle + " (" + getIsleName(newIsle) + ") // AVAILABLE BUDGET: $" + user.getBudget() + "\n");
            if (leftIsle) {
                System.out.print("< ISLE " + (newIsle - 1) + " (" + getIsleName(newIsle - 1) + ")");
            }
            System.out.print(" || ");
            if (rightIsle) {
                System.out.print("ISLE " + (newIsle + 1) + " (" + getIsleName(newIsle + 1) + ") >");
            }
            boolean[] comm =  {leftIsle, rightIsle, true};
            printIsleItems();
            printCommands(comm);
            
            return true;
        }
        System.out.println("Isle out of boundaries! Please try again.");
        return false;
    }

       /**
        * prints contents of the current isle
        */
    public void printIsleItems()
    {
        Set<ItemDatabase> isleDatabase = isles.get(this.isle-1);
        
        System.out.println("\n\n0: Checkout");
        int index = 1;
        for (ItemDatabase item:isleDatabase)
        {
            System.out.println(index+": $"+item.getPrice()+" "+item.getName());
            index++;
        }
    }
    
    /**
     * getter method for item in a isle
     * @param selectedItem
     * @return 
     */
    public ItemDatabase getItem(int selectedItem)
    {
        Set<ItemDatabase> isleDatabase = isles.get(this.isle-1);
        
        int index = 1;
        for (ItemDatabase item:isleDatabase)
        {
            if (index == selectedItem)
            {
                return item;
            }
            index++;
        }
        return null;
    }
    
    /**
     * prints commands 
     * @param availableCommands 
     */
    public void printCommands(boolean[] availableCommands) {
        // EFFICIENT AND READABLE METHOD TO PRINT AVAILABLE COMMANDS
        
        String[] commands = {"left", "right", "cart"};
        System.out.println("\nCOMMANDS: ");
        boolean first = true;

        for (int i = 0; i < commands.length; i++) {
            if (availableCommands[i] == true) {
                if (first == true) {
                    first = false;
                } else {
                    System.out.print(", ");
                }

                System.out.print(commands[i]);
            }
        }
        System.out.print("\n> ");

    }

    
    /**
     * getter method for isleName
     * @param isleNum
     * @return 
     */
    public String getIsleName(int isleNum) {
        return isleNames[isleNum - 1];
    }

    /**
     * getter method for isle number
     * @return the isle
     */
    public int getIsle() {
        return isle;
    }

    /**
     * setter method for isle number
     * @param isle the isle to set
     */
    public void setIsle(int isle) {
        this.isle = isle;
    }

    /**
     * getter method for Isles
     * @return the isles
     */
    public ArrayList<Set<ItemDatabase>> getIsles() {
        return isles;
    }

    /**
     * setter method for Isles
     * @param isles the isles to set
     */
    public void setIsles(ArrayList<Set<ItemDatabase>> isles) {
        this.isles = isles;
    }

}
