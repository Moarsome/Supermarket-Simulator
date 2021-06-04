/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * MainPanel includes organization and management of header,body and footer panels
 * @author kyliec
 */
public class MainPanel extends JPanel 
{
    private User user;
    private HeaderPanel headerPanel;
    private BodyPanel bodyPanel;
    private FooterPanel footerPanel;
    private InventoryPanel inventoryPanel;
    private IsleMarker isleManagement;
    
    /**
     * Constructor for MainPanel
     * 
     * @param user
     * @param inventoryPanel
     */
    public MainPanel(User user, InventoryPanel inventoryPanel)
    {
        this.inventoryPanel = inventoryPanel;
        this.user = user;
        this.setLayout(new BorderLayout());
        JLayeredPane layeredPane = new JLayeredPane();
        isleManagement = new IsleMarker(this);
        
        headerPanel = new HeaderPanel(this);
        footerPanel = new FooterPanel(this);
        bodyPanel = new BodyPanel(this);
        
        isleManagement.createPanels();
        
        headerPanel.addListeners();
        
        for (int i = 0; i < 9; i++)
        {
            layeredPane.add(isleManagement.getItemPanel(i),JLayeredPane.PALETTE_LAYER);
        }
        
        this.setOpaque (false);

        this.add(footerPanel, BorderLayout.SOUTH);
        
        bodyPanel.setBounds(0,5,750,750);
        
        layeredPane.add(bodyPanel,JLayeredPane.DEFAULT_LAYER);
        
        
        this.add(layeredPane, BorderLayout.CENTER);
        
        this.add(headerPanel, BorderLayout.NORTH);

        this.setVisible(true);
    }
    
    /**
     * Retrieves header panel
     * 
     * @return
     */
    public HeaderPanel getHeaderPanel()
    {
        return this.headerPanel;
    }
    
    /**
     * Retrieves body panel
     * @return
     */
    public BodyPanel getBodyPanel()
    {
        return this.bodyPanel;
    }
    
    /** 
     * Retrieves footer panel
     * @return
     */
    public FooterPanel getFooterPanel()
    {
        return this.footerPanel;
    }
    
    /**
     * Retrieves inventory panel
     * @return
     */
    public InventoryPanel getInventoryPanel()
    {
        return this.inventoryPanel;
    }
    
    /**
     * Retrieves isle management object
     * @return
     */
    public IsleMarker getIsleMarker()
    {
        return this.isleManagement;
    }
    
    /**
     * Retrieves user
     * @return
     */
    public User getUser()
    {
        return this.user;
    }
    
    /**
     * Sets this object visible
     */
    public void enableVisible()
    {
        this.setVisible(true);
    }
}
