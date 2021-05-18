/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author kyliec
 */
public class MainPanel extends JPanel {

    public MainPanel()
    {
        this.setLayout(new BorderLayout());
        FooterPanel footerPanel = new FooterPanel();
        BodyPanel bodyPanel = new BodyPanel();
        HeaderPanel headerPanel = new HeaderPanel(bodyPanel);
        

        this.add (footerPanel, BorderLayout.SOUTH);

        this.setOpaque (false);
        this.add (bodyPanel, BorderLayout.CENTER);

        this.add (headerPanel, BorderLayout.NORTH);

        this.setVisible(false);
    }
    
    public void enableVisible()
    {
        this.setVisible(true);
    }
    
}
