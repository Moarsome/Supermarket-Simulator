/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Creates the final inventory panel
 * 
 * @author kyliec
 */
public class InventoryPanel extends StarterPanel {
    private JLabel headerLabel;
    private JLabel descriptorLabel;
    private JScrollPane scrollPane;
    private JButton continueButton;
    private ArrayList<JPanel> panelList;
    private JPanel viewPanel;
    private int itemCount;
    private JButton currentlySelected;
    private JFrame frame;
    
    /**
     * Constructor for the panel
     * 
     * @param frame
     */
    public InventoryPanel(JFrame frame)
    {
        this.frame = frame;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(new Dimension(750,750));
        this.setOpaque(false);
        
        createComponents();
        
        addComponents();
    }
    
    /**
     * Creates JComponents for the panel
     */
    public void createComponents()
    {
        panelList = new ArrayList<>();
        
        itemCount = 0;
        
        headerLabel = new JLabel("ALL YOUR BOUGHT ITEMS");
        headerLabel.setAlignmentX(CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Avenir", Font.PLAIN, 24));
        
        descriptorLabel = new JLabel("Click any item for more information.");
        descriptorLabel.setAlignmentX(CENTER_ALIGNMENT);
        descriptorLabel.setFont(new Font("Avenir", Font.PLAIN, 18));
        
        continueButton = createNewButton(resizeComponent("/resources/continue.png",100,40));
        continueButton.setAlignmentX(CENTER_ALIGNMENT);
        continueButton.addActionListener(new continueListener());
        
        
        viewPanel = new JPanel();
        viewPanel.setOpaque(false);
        viewPanel.setLayout(new BoxLayout(viewPanel,BoxLayout.Y_AXIS));
        
        scrollPane = new JScrollPane();
        scrollPane.setOpaque(false);
        scrollPane.setMaximumSize(new Dimension(600, 400));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(viewPanel);
    }
    
    /**
     * Adds created JComponents to panel
     */
    public void addComponents()
    {
        this.add(headerLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(descriptorLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(scrollPane);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(continueButton);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
    }
    
    /**
     * Adds ItemDatabase item to the inventory panel
     * 
     * @param item
     */
    public void addItemToPanel(ItemDatabase item)
    {
        if (itemCount < 6)
        {
            if (itemCount == 0)
            {
                JPanel newPanel = new JPanel();
                newPanel.setOpaque(false);
                newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.X_AXIS));
                panelList.add(newPanel);
            }
            itemCount++;
            
            JPanel currentPanel = panelList.get(panelList.size()-1);
            JButton tempButton = createNewButton(resizeComponent(item.getImgURL(), 80,80));
            tempButton.putClientProperty("item", item);
            tempButton.setAlignmentX(LEFT_ALIGNMENT);
            tempButton.addActionListener(new selectionListener());
            currentPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            currentPanel.add(tempButton);
        }
        else
        {
            itemCount = 0;
        }
    }
    
    /**
     * Creates a new row of items to display
     */
    public void enablePanel()
    {
        for (JPanel panel:panelList)
        {
            viewPanel.add(panel);
            viewPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
    }
    
    /**
     * Retrieves continue button
     * 
     * @return
     */
    public JButton getContinueButton()
    {
        return this.continueButton;
    }
    
    /**
    * ActionListener for restarting the simulator
    * 
    * @author kyliec
    */
    private class continueListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            descriptorLabel.setText("Loading...");
            
            SupermarketFrame.removePanels(frame);
            SupermarketFrame.createPanels(frame);
        }
    }
    
    /**
    * ActionListener for selecting items on panel
    * 
    * @author kyliec
    */
    private class selectionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton selectedButton = (JButton) e.getSource();
            ItemDatabase item = (ItemDatabase) selectedButton.getClientProperty("item");
            
            if (selectedButton != currentlySelected)
            {
                // Select button
                if (currentlySelected != null)
                {
                    // Deselect previous button
                    currentlySelected.setBorderPainted(false);

                }
                currentlySelected = selectedButton;
                selectedButton.setBorderPainted(true);

                descriptorLabel.setText("Selected: $"+item.getPrice()+" '"+item.getName()+"' in inventory");
            }
        }
        
    }
}


