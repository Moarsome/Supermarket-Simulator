/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.util.ArrayList;
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
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBudget method, of class User.
     */
    @Test
    public void testGetBudget() {
        System.out.println("getBudget");
        User instance = new User();
        instance.setBudget(10.0f);
        float expResult = 10.0F;
        float result = instance.getBudget();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setBudget method, of class User.
     */
    @Test
    public void testSetBudget() {
        System.out.println("setBudget");
        float budget = 5.0F;
        User instance = new User();
        instance.setBudget(budget);
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User();
        instance.setName("poyan");
        String expResult = "poyan";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Poyan";
        User instance = new User();
        instance.setName(name);
    }

    /**
     * Test of getIsShopping method, of class User.
     */
    @Test
    public void testGetIsShopping() {
        System.out.println("getIsShopping");
        User instance = new User();
        boolean expResult = true;
        boolean result = instance.getIsShopping();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsShopping method, of class User.
     */
    @Test
    public void testSetIsShopping() {
        System.out.println("setIsShopping");
        boolean isShopping = false;
        User instance = new User();
        instance.setIsShopping(isShopping);
    }    
}
