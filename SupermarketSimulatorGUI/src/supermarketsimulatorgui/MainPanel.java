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
 *
 * @author kyliec
 */
public class MainPanel extends JPanel {

    private User user;
    private HeaderPanel headerPanel;
    
    public MainPanel(IsleMarker isleManagement)
    {
        this.setLayout(new BorderLayout());
        JLayeredPane layeredPane = new JLayeredPane();
        ItemDisplayPanel itemPanel = new ItemDisplayPanel(isleManagement);
        FooterPanel footerPanel = new FooterPanel();
        BodyPanel bodyPanel = new BodyPanel();
        headerPanel = new HeaderPanel(bodyPanel, user);
        
        this.setOpaque (false);

        this.add(footerPanel, BorderLayout.SOUTH);

        //layeredPane.setPreferredSize(new Dimension(500,500));
        //layeredPane.setBounds(0, 200, 400, 400);
        
        bodyPanel.setBounds(0,70,750,750);
        itemPanel.setBounds(0, 160, 750, 350);
        layeredPane.add(bodyPanel,JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(itemPanel,JLayeredPane.PALETTE_LAYER);
        
        this.add(layeredPane, BorderLayout.CENTER);
        
        this.add(headerPanel, BorderLayout.NORTH);

        this.setVisible(true);
    }
    
    public HeaderPanel getHeaderPanel()
    {
        return this.headerPanel;
    }
    
    public void enableVisible()
    {
        this.setVisible(true);
    }
    
    public void setUser(User user)
    {
        this.user = user;
    }
    
}
