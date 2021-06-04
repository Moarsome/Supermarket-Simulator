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
        
        createComponents();
        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setOpaque(false);
        this.add(viewCartButton,0);
    }
    
    public void createComponents()
    {
        viewCartButton = createNewButton(resizeComponent("/resources/viewCart.png",110,40));
        viewCartButton.putClientProperty("status", false);
        viewCartButton.addActionListener(new CartViewListener(this));
        viewCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel,BoxLayout.X_AXIS));
        
        viewCartPane = new JScrollPane();
        viewCartPane.setPreferredSize(new Dimension(750, 80));
        viewCartPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        viewCartPane.setVisible(true);
        viewCartPane.setViewportView(cartPanel);
    }
    
    public JButton addItemToCart(ItemDatabase item)
    {
        Component space = Box.createRigidArea(new Dimension(5, 0));
        JButton itemButton = createNewButton(resizeComponent(item.getImgURL(),55,55));
        itemButton.addActionListener(new CartRemoveItem(mainPanel));
        itemButton.putClientProperty("item", item);
        itemButton.putClientProperty("space", space);
            
        cartPanel.add(itemButton);
        cartPanel.add(space);
        
        return itemButton;
    }
    
    public void showInventory()
    {
        mainPanel.getBodyPanel().setIndicatorText("Opened inventory! Select any item to view details");
        
        this.removeAll();
        this.add(viewCartPane,0);
        this.add(viewCartButton,0);
        this.revalidate();
        this.repaint();
    }
    
    public void hideInventory()
    {
        mainPanel.getBodyPanel().setIndicatorText("Closed inventory!");
        
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
    
    public JPanel getCartPanel()
    {
        return this.cartPanel;
    }
}
