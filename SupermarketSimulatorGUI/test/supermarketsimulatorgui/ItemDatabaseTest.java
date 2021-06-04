/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kyliec
 */
public class ItemDatabaseTest {
    
    public ItemDatabaseTest() {
    }

    /**
     * Test of getName method, of class ItemDatabase.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ItemDatabase instance = ItemDatabase.BERRIES_MIXED;
        String expResult = "Orchard Gold Mixed Berries: 500g";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class ItemDatabase.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ItemDatabase instance = ItemDatabase.HIENEKEN;
        instance.setName("hken");
    }

    /**
     * Test of getImgURL method, of class ItemDatabase.
     */
    @Test
    public void testGetImgURL() {
        System.out.println("getImgURL");
        ItemDatabase instance = ItemDatabase.COKE;
        String expResult = "/resources/items/coca_cola.png";
        String result = instance.getImgURL();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class ItemDatabase.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        ItemDatabase instance = ItemDatabase.COKE;
        float expResult = 3.0F;
        float result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPrice method, of class ItemDatabase.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        float price = 0.0F;
        ItemDatabase instance = ItemDatabase.COKE;
        instance.setPrice(3.5f);
    }

    /**
     * Test of getItemID method, of class ItemDatabase.
     */
    @Test
    public void testGetItemID() {
        System.out.println("getItemID");
        ItemDatabase instance = ItemDatabase.COKE;
        int expResult = 6;
        int result = instance.getItemID();
        assertEquals(expResult, result);
    }
}
