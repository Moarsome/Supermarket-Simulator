/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 *
 * @author kyliec
 */
public class ItemDisplayPanel extends StarterPanel {
    
    public ItemDisplayPanel()
    {
        this.setMaximumSize(new Dimension(750,450));
        this.setLayout(new GridLayout(1,10));
        JButton itemSample = createNewButton(resizeComponent("./resources/items/coca_cola.png",50,80));
        JButton itemSample2 = createNewButton(resizeComponent("./resources/items/coca_cola.png",50,80));
        JButton itemSample3 = createNewButton(resizeComponent("./resources/items/coca_cola.png",50,80));
        JButton itemSample4 = createNewButton(resizeComponent("./resources/items/coca_cola.png",50,80));
        JButton itemSample5 = createNewButton(resizeComponent("./resources/items/coca_cola.png",50,80));
        JButton itemSample6 = createNewButton(resizeComponent("./resources/items/coca_cola.png",50,80));
        
       // this.setOpaque(false);
        this.add(itemSample);
        this.add(itemSample2);
        this.add(itemSample3);
        this.add(itemSample4);
        this.add(itemSample5);
        this.add(itemSample6);
    }
    
}
