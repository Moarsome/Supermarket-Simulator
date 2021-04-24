/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

/**
 * Enumeration for Supermarket Inventory
 * @author kyliec
 */
public enum ItemDatabase {

// Confectionary
    TOBLERONE("Toblerone: 360g", 7.5f),
    STARBURST_LOLLIES("Starburst Snakes: 180g", 4.5f),
    FERRERO_ROCHER("Ferrero Rocher: 6pc", 8.0f),
    LINDT_LINDOR("Lindt: Lindor Block", 5.0f),
    LINDT_LINDOR_DARK("Lindt: Lindor Dark Block", 5.0f),
    WHITTAKERS_HAZELNUT("Whittakers: Hazelnut Block", 5.50f),
    WHITTAKERS_DAIRYMILK("Whittakers: Dairy Milk Block", 4.0f),
    
    // Snacks
    CORNCHIPS_CHEESE("Mexicano Corn Chips Cheese: 300g", 4.0f),
    CORNCHIPS_JALAPENO("Mexicano Corn Chips Jalapeno: 300g", 4.0f),
    CORNCHIPS_SALSA("Mexicano Corn Chips Salsa: 300g", 4.0f),
    CHIPS_READYSALTED("ETA Ripple cut Ready Salted: 150g", 3.50f),
    CHIPS_S_AND_V("ETA Ripple cut Salt And Vinegar: 150g", 3.50f),
    CHIPS_SOURCREAM("ETA Ripple cut Sour Cream And Chives: 150g", 3.50f),
    RICE_CRACKER("Fantastic Rice Crackers Original: 100g", 1.90f),
    RICE_CRACKER_BBQ("Fantastic Rice Crackers BBQ: 100g", 1.90f),
    RICE_CRACKER_SEAWEED("Fantastic Rice Crackers Seaweed: 100g", 1.90f),
    
    // Drinks
    COKE("Coca-Cola: 1.5L", 3.0f),
    WATER("Water: 750ml", 4.0f),
    V("V: 350ml", 4.0f),
    RED_BULL("Red Bull 350ml", 4.0f),
    MONSTER("Monster 350ml", 4.0f),
    KERI_ORANGE("Keri Juice: Orange", 5.50f),
    KERI_APPLE("Keri Juice: Apple", 5.50f),
    KERI_PINEAPPLE("Keri Juice: Pineapple", 5.50f),
    
    // Beer & Wine
    HIENEKEN("Heineken 24pk", 26.50f),
    CORONA_EXTRA("Corona Extra Beer 12pk", 25.0f),
    ROSE("Rose: 750ml", 14.50f),
    PINOT_GRIS("Pinot Gris: 750ml", 15.0f),
    PINOT_NIOR("Pinot Nior: 750ml", 15.0f),
    MERLOT("Merlot: 750ml", 8.0f),
    SAUVIGNON_BLANC("Sauvignon Blanc: 750ml", 17.0f),

    // Breads
    BREAD_WHITE("Tip Top: White Bread", 2.6f),
    BREAD_BROWN("Tip Top: Whole Meal Bread", 2.1f),
    BREAD_MULTIGRAIN("Tip Top: Multigrain Bread", 3.8f),
    BAGEL("Abe's Bagels: Natural 4pk", 5.50f),
    
    
    // Pasta
    SPAGHETTI("Diamond Pasta Spaghetti: 500g", 5.0f),
    LASAGNE_SHEET("Diamond Pasta Lasagne Sheet: 200g", 4.50f),
    SPAGHETTI_SPIRAL("Diamond Pasta Spirals: 500g", 5.0f),
    SPAGHETTI_PENNE("Diamond Pasta Penne: 500g", 5.0f),
    MIGORENG("Indomie: Mi Goreng 5pk", 5.0f),
    MIGORENG_BBQCHICKEN("Indomie: Mi Goreng BBQ Chicken 5pk", 5.0f),
    
    // Spices/Sauces
    SALT("Salt", 3.0f),
    PEPPER("Pepper", 5.0f),
    KETCHUP("Ketchup", 4.0f),
    MAYONNAISE("Mayonnaise", 4.0f),
    MUSTARD("Mustard", 4.0f),
    BBQ_SAUCE("BBQ sauce", 4.0f),
    
    // Dairy
    MILK_FULLCREAM("Anchor Fullcream milk 2L", 4.50f),
    MILK_TRIM("Anchor Trim milk 2L", 4.0f),
    CREAM("Anchor Full Cream: 500ml", 5.50f),
    CHEESE_TASTY("Mainland: Cheese Block: Tasty 1KG", 15.0f),
    CHEESE_COLBY("Mainland: Cheese Block: Colby 1KG", 15.0f),
    CHEESE_EDAM("Mainland: Cheese Black: Edam 1KG", 15.0f),
    BUTTER_UNSALTED("Mainland: Butter Unsalted 400g", 5.50f),
    BUTTER_SALTED("Mainland: Butter Salted 400g", 5.50f),
    
    // Frozen
    ICE_CREAM_CHOCOLATE("Tip Top Ice Cream: Chocolate 2L", 7.0f),
    ICE_CREAM_VANILLA("Tip Top Ice Cream: Vanilla 2L", 7.0f),
    ICE_CREAM_COOKIE("Tip Top Ice Cream: Cookies And Cream 2L", 7.0f),
    BERRIES_MIXED("Orchard Gold Mixed Berries: 500g", 6.50f),
    SAUSAGE_ROLL("Big Ben Sausage Roll: 150g", 3.0f),
    FRIES_CRINKLE("McCain Fries: Crinkle Cut 900g", 3.90f),
    FRIES_SHOESTRING("McCain Fries: Shoestring 900g", 3.90f);

    private String name;
    private float price;

    /**
     * constructor for the ItemDatabase
     * @param name
     * @param price
     */
    ItemDatabase(String name, float price) {
        this.name = name;
        this.price = price;
    }

    
    
    /**
     * Getter method for the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method for Price
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Setter method for Price
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }    
}
