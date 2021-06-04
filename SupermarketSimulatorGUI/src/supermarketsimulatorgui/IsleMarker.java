/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Set;
import javax.swing.JButton;

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
    private ArrayList<ItemDisplayPanel> itemPanels;
    private JButton selectedItem;
    private User user;
    private MainPanel mainPanel;
    private BodyPanel bodyPanel;
    /**
     * Constructor for IsleMarker Class
     * @param mainPanel
     */
    public IsleMarker(MainPanel mainPanel) {
        // ARRAY LIST OF SETS
        isles = new ArrayList<>(isleNames.length);
        itemPanels = new ArrayList<>();
        selectedItem = null;
        this.mainPanel = mainPanel;
        this.bodyPanel = mainPanel.getBodyPanel();
        this.user = mainPanel.getUser();
        
        addIsles();
    }

    /**
     *
     */
    public void addIsles()
    {
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
     *
     */
    public void createPanels()
    {
        for (int i = 0; i < 9; i++)
        {
            ItemDisplayPanel itemPanel = new ItemDisplayPanel(mainPanel, this, i);
            itemPanel.setVisible(false);
            itemPanel.setBounds(0, 180, 750, 320);
            itemPanels.add(itemPanel);
        }
        itemPanels.get(0).setVisible(true);
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
     *
     * @param selectedItem
     * @param isleNum
     * @return
     */
    public ItemDatabase getItem(int selectedItem, int isleNum)
    {
        Set<ItemDatabase> isleDatabase = isles.get(isleNum);
        
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

    /**
     *
     * @return
     */
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
    public void setIsle(int isle) 
    {
        itemPanels.get(this.isle-1).setVisible(false);
        this.isle = isle;
        itemPanels.get(this.isle-1).setVisible(true);
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
    
    /**
     *
     * @return
     */
    public ArrayList<ItemDisplayPanel> getItemPanels()
    {
        return this.itemPanels;
    }
    
    /**
     *
     * @param isleNum
     * @return
     */
    public ItemDisplayPanel getItemPanel(int isleNum)
    {
        return this.itemPanels.get(isleNum);
    }
    
    /**
     *
     * @return
     */
    public JButton getSelectedItem()
    {
        return this.selectedItem;
    }
    
    /**
     *
     * @param selectedItem
     */
    public void setSelectedItem(JButton selectedItem)
    {
        this.selectedItem = selectedItem;
    }
}
