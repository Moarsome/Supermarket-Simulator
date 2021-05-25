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
    TOBLERONE("Toblerone: 360g", 7.5f, "toblerone.png",0), //
    FERRERO_ROCHER("Ferrero Rocher: 6pc", 8.0f, "ferrero_rocher.png",1),//
    WHITTAKERS_DAIRYMILK("Whittakers: Dairy Milk Block", 4.0f, "whittakers_dairymilk.png",2),//
    
    // Snacks
    CORNCHIPS_CHEESE("Mexicano Corn Chips Cheese: 300g", 4.0f, "mexicano_cheese.png",3),//
    CHIPS_READYSALTED("ETA Ripple cut Ready Salted: 150g", 3.50f,"eta_salt.png",4),//
    RICE_CRACKER("Fantastic Rice Crackers Original: 100g", 1.90f, "ricecracker_original.png",5),//
    
    // Drinks
    COKE("Coca-Cola: 1.5L", 3.0f, "coca_cola.png",6),//
    RED_BULL("Red Bull 350ml", 4.0f, "red_bull.png",7),//
    KERI_PINEAPPLE("Keri Juice: Pineapple", 5.50f, "keri_pineapple.png",8),//
    
    // Beer & Wine
    HIENEKEN("Heineken 24pk", 26.50f, "heineken.png",9),//
    ROSE("Rose: 750ml", 14.50f, "wine_rose.png",10),//
    MERLOT("Merlot: 750ml", 8.0f, "wine_merlot.png",11),//

    // Breads
    BREAD_WHITE("Tip Top: White Bread", 2.6f, "tiptop_white.png",12),//
    BREAD_BROWN("Tip Top: Whole Meal Bread", 2.1f, "tiptop_brown.png",13),//
    BREAD_MULTIGRAIN("Tip Top: Multigrain Bread", 3.8f, "tiptop_multigrain.png",14),//
    
    
    // Pasta
    SPAGHETTI("Diamond Pasta Spaghetti: 500g", 5.0f, "spaghetti.png",15),//
    SPAGHETTI_SPIRAL("Diamond Pasta Spirals: 500g", 5.0f, "spiral.png", 16),//
    SPAGHETTI_PENNE("Diamond Pasta Penne: 500g", 5.0f, "penne.png",17),//
    
    // Spices/Sauces
    SALT("Salt", 3.0f, "salt.png", 18),//
    PEPPER("Pepper", 5.0f, "pepper.png", 19),//
    KETCHUP("Ketchup", 4.0f, "ketchup.png", 20),//
    
    // Dairy
    MILK_FULLCREAM("Anchor Fullcream milk 2L", 4.50f, "anchor_fullcream.png", 21),//
    MILK_TRIM("Anchor Trim milk 2L", 4.0f, "anchor_trim.png", 22),//
    CREAM("Anchor Full Cream: 500ml", 5.50f, "anchor_cream.png", 23),//
    
    // Frozen
    ICE_CREAM_CHOCOLATE("Tip Top Ice Cream: Chocolate 2L", 7.0f, "icecream_chocolate.png", 24),//
    ICE_CREAM_VANILLA("Tip Top Ice Cream: Vanilla 2L", 7.0f, "icecream_vanilla.png", 25),//
    BERRIES_MIXED("Orchard Gold Mixed Berries: 500g", 6.50f, "mixed_berries.png", 26);//

    private String name;
    private String imgURL;
    private float price;
    private int itemID;

    /**
     * constructor for the ItemDatabase
     * @param name
     * @param price
     */
    ItemDatabase(String name, float price, String imgURL, int itemID) {
        this.name = name;
        this.price = price;
        this.imgURL = imgURL;
        this.itemID = itemID;
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
    
    public String getImgURL()
    {
        return "./resources/items/"+this.imgURL;
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

    public int getItemID() {
        return itemID;
    }
}
