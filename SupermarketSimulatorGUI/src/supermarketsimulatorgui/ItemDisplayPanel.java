/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author kyliec
 */
public class ItemDisplayPanel extends StarterPanel {

    public ItemDisplayPanel() {
        this.setMaximumSize(new Dimension(750, 350));
        this.setLayout(new GridBagLayout());
                
        addPanels(this);
        
        //this.setOpaque(false);
        
    }

    private void addPanels(JPanel panel){
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.weighty = 0.1;
        c.insets = new Insets(0,20,50,0);
        c.fill = GridBagConstraints.NONE;
        
        ArrayList<JButton> isleItems = new ArrayList<>();
        String[] imgURL = {"coca_cola.png", "red_bull.png", "keri_pineapple.png"};
        
        for (int i = 0; i < 6; i++)
        {
            //isleItems.add(e);
        }
        
        JButton itemSample = createNewButton(resizeComponent("./resources/items/coca_cola.png", 50, 80));
        JButton itemSample2 = createNewButton(resizeComponent("./resources/items/coca_cola.png", 50, 80));
        JButton itemSample3 = createNewButton(resizeComponent("./resources/items/coca_cola.png", 50, 80));
        JButton itemSample4 = createNewButton(resizeComponent("./resources/items/coca_cola.png", 50, 80));
        JButton itemSample5 = createNewButton(resizeComponent("./resources/items/coca_cola.png", 50, 80));
        JButton itemSample6 = createNewButton(resizeComponent("./resources/items/coca_cola.png", 50, 80));
        
        changeGridLayout(c, 0, 0);
        panel.add(itemSample, c);
        changeGridLayout(c, 1, 0);
        panel.add(itemSample2, c);
        changeGridLayout(c, 2, 0);
        panel.add(itemSample3, c);
        changeGridLayout(c, 0, 1);
        panel.add(itemSample4, c);
        changeGridLayout(c, 1, 1);
        panel.add(itemSample5, c);
        changeGridLayout(c, 2, 1);
        panel.add(itemSample6, c);
    }
}
