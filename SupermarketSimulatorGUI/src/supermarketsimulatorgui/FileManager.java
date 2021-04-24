/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for file I/O
 *
 * @author kyliec
 */
public class FileManager {

    /**
    * Create text file with user name
    *
    * @param user
    */
    public void createFile(User user) {
        try {
            File file = new File("./resources/"+user.getName()+"Inventory.txt");
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
    * Write to the specified user file
    *
    * @param user
    */
    
    public void writeToFile(User user) {
        createFile(user);
        try {
            FileWriter fileWrite = new FileWriter("./resources/"+user.getName()+"Inventory.txt");
            String savedText = "";
            // user details formatted as NAME/BUDGET
            savedText += user.getName() + "/" + user.getBudget() + "\n";

            for (Map.Entry<ItemDatabase, Integer> entry : user.getInventory().entrySet()) {
                ItemDatabase item = entry.getKey();
                int count = entry.getValue();

                savedText += item.getName() + "/" + count + "\n";
            }

            fileWrite.write(savedText);

            fileWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
    * Check if the file exists
    *
    * @return boolean
    * @param userName
    */
    
    public boolean checkFileExists(String userName)
    {
        File file = new File("./resources/"+userName+"Inventory.txt");
        
        return file.isFile();
    }
    
    /**
    * Reading data from text file
    *
    * @return User
    * @param userName
    */
    
    public User readFromFile(String userName) {
        BufferedReader reader;
        User user = new User(userName);
        
        try {
            reader = new BufferedReader(new FileReader("./resources/"+userName+"Inventory.txt"));
            String line = reader.readLine();
            int lineNum = 0;

            while (line != null) {
                // read the first line for user and budget
                if (lineNum == 0) {
                    // first part is user name
                    user.setName(line.substring(0, line.indexOf('/')));
                    // second part is budget
                    try {
                        user.setBudget(Float.valueOf(line.substring(line.indexOf('/') + 1)));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid float input");
                    }
                }
                else
                {
                    try
                    {
                        String tempItemName = line.substring(0, line.indexOf('/'));
                        ItemDatabase tempItem = this.getItemFromName(tempItemName);
                        int tempStock = Integer.valueOf(line.substring(line.indexOf('/') + 1));
                        System.out.println("Loaded item: "+tempItem.getName()+", quantity: "+tempStock);
                        user.addInventory(tempItem, tempStock);
                    }
                    catch (NumberFormatException e) 
                        {
                        System.out.println("Invalid int input");
                    }
                }
                
                
                // read next line
                
                lineNum++;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("User does not exist. Please try again: ");
        }
        System.out.println("\nSuccessfully loaded '"+user.getName()+"' with remaining budget $"+user.getBudget());
        return user;
    }

    
    /**
    * Convert from ArrayList inventory to HashMap inventory
    *
    * @param cart
    * @param user
    */
    public void convertToMap(ArrayList<ItemDatabase> cart, User user) {
        HashMap<ItemDatabase,Integer> inventory = user.getInventory();
        
        for (ItemDatabase item : cart) {
            System.out.println("Checking out: "+item.getName());
            if (inventory.containsKey(item)) {
                inventory.put(item, inventory.get(item) + 1);
            } else {
                inventory.put(item, 1);
            }
        }
    }
    
    /**
    * Retrieve ItemDatabase object from its string name
    *
    * @param itemName
    */
    public ItemDatabase getItemFromName(String itemName)
    {
        for (ItemDatabase item:ItemDatabase.values()) 
        {
            if (item.getName().equals(itemName))
            {
                return item;
            }
        }
        System.out.println("did not find");
        return null;
    }
}
