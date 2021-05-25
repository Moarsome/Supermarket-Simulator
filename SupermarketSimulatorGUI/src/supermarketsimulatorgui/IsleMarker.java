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
    Set<ItemDatabase> snacks = EnumSet.range(ItemDatabase.CORNCHIPS_CHEESE, ItemDatabase.RICE_CRACKER);
    Set<ItemDatabase> drinks = EnumSet.range(ItemDatabase.COKE, ItemDatabase.KERI_PINEAPPLE);
    Set<ItemDatabase> alcohol = EnumSet.range(ItemDatabase.HIENEKEN, ItemDatabase.MERLOT);
    Set<ItemDatabase> bread = EnumSet.range(ItemDatabase.BREAD_WHITE, ItemDatabase.BREAD_MULTIGRAIN);
    Set<ItemDatabase> pasta = EnumSet.range(ItemDatabase.SPAGHETTI, ItemDatabase.SPAGHETTI_PENNE);
    Set<ItemDatabase> condiments = EnumSet.range(ItemDatabase.SALT, ItemDatabase.KETCHUP);
    Set<ItemDatabase> dairy = EnumSet.range(ItemDatabase.MILK_FULLCREAM, ItemDatabase.CREAM);
    Set<ItemDatabase> frozen = EnumSet.range(ItemDatabase.ICE_CREAM_CHOCOLATE, ItemDatabase.BERRIES_MIXED);

    private int isle = 1;
    private ArrayList<Set<ItemDatabase>> isles;
    private final String[] isleNames = {"Confectionary", "Snacks", "Drinks", "Alcohol", "Bread", "Pasta & Noodles", "Condiments", "Dairy", "Frozen"};
    /**
     * Constructor for IsleMarker Class
     */
    public IsleMarker() {
        // ARRAY LIST OF SETS
        isles = new ArrayList<>(isleNames.length);

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
     * @param isleChange
     * 
     */
    public void changeIsle(int isleChange) {
        this.isle += isleChange;
    }
    
    /**
     * getter method for item in a isle
     * @param selectedItem
     * @return 
     */
    public ItemDatabase getItem(int selectedItem)
    {
        Set<ItemDatabase> isleDatabase = isles.get(this.isle-1);
        
        int index = 0;
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
     * getter method for isleName
     * @param isleNum
     * @return 
     */
    public String getIsleName(int isleNum) {
        return isleNames[isleNum - 1].toUpperCase();
    }

    public Set<ItemDatabase> getCurrentIsle()
    {
        return isles.get(isle);
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
