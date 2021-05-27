/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import supermarketsimulatorlisteners.CartRemoveItem;
import supermarketsimulatorlisteners.CartViewListener;

/**
 *
 * @author kyliec
 */

public class FooterPanel extends StarterPanel{
    private MainPanel mainPanel;
    private JButton viewCartButton;
    private JScrollPane viewCartPane;
    private JPanel cartPanel;
    private JButton selectedButton;
    
    public FooterPanel(MainPanel mainPanel)
    {
        this.mainPanel = mainPanel;
        
        viewCartButton = createNewButton(resizeComponent("./resources/viewCart.png",110,40));
        viewCartButton.putClientProperty("status", true);
        viewCartButton.addActionListener(new CartViewListener(this));
        
        cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel,BoxLayout.X_AXIS));
        
        viewCartPane = new JScrollPane();
        viewCartPane.setPreferredSize(new Dimension(750, 80));
        viewCartPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        viewCartPane.setVisible(true);
        viewCartPane.setViewportView(cartPanel);
        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        viewCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setOpaque(false);
        this.add(viewCartPane,0);
        this.add(viewCartButton,0);
    }
    
    public void addItemToCart(ItemDatabase item)
    {
        JButton itemButton = createNewButton(resizeComponent(item.getImgURL(),40,64));
        itemButton.addActionListener(new CartRemoveItem(mainPanel));
        itemButton.putClientProperty("item", item);
        
        cartPanel.add(itemButton);
        cartPanel.add(Box.createRigidArea(new Dimension(5, 0)));
    }
    
    public void showInventory()
    {
        this.removeAll();
        this.add(viewCartPane,0);
        this.add(viewCartButton,0);
        this.revalidate();
        this.repaint();
    }
    
    public void hideInventory()
    {
        this.remove(viewCartPane);
        this.revalidate();
        this.repaint();
    }
    
    public void setSelectedButton(JButton button)
    {
        this.selectedButton = button;
    }
    
    public JButton getSelectedButton()
    {
        return this.selectedButton;
    }
}
