/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import supermarketsimulatorlisteners.LoginListener;
import supermarketsimulatorlisteners.DBListener;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author kyliec
 */
public final class LoginPanel extends StarterPanel {
    private JLabel userIcon;
    private JLabel loginHeader;
    private JLabel textFeedback;
    private JTextField budgetInput;
    private JTextField userInput;
    private JPasswordField passInput;
    private JButton submitButton;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel innerPane;
    private final MainPanel mainPanel;
    private User user;
    
    /**
     *
     * @param mainPanel
     * @param user
     */
    public LoginPanel(MainPanel mainPanel, User user)
    {
        this.mainPanel = mainPanel;
        this.user = user;
        
        this.setSize(new Dimension(750,750));
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        
        createComponents();
        
        this.setOpaque(false);
    }

    /**
     *
     */
    public void createComponents()
    {
        innerPane = new JPanel();
        innerPane.setMaximumSize(new Dimension(300,230));
        innerPane.setAlignmentY(TOP_ALIGNMENT);
        innerPane.setLayout(new GridBagLayout());
        innerPane.setOpaque(false);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,0,5,0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        userIcon = new JLabel(resizeComponent("/resources/userIcon.png", 80,100));
        userIcon.setAlignmentX(CENTER_ALIGNMENT);
        loginHeader = new JLabel(resizeComponent("/resources/shoppingLogo.png", 509,124));
        loginHeader.setAlignmentX(CENTER_ALIGNMENT);
        
        budgetInput = new JTextField("Enter budget");
        designTextField(budgetInput);
        
        userInput = new JTextField("Username");
        designTextField(userInput);
        
        passInput = new JPasswordField("Password");
        designTextField(passInput);
        
        submitButton = createNewButton(resizeComponent("/resources/submit.png", 208, 40));
        submitButton.setActionCommand("register");
        submitButton.addActionListener(new DBListener(this, mainPanel));
        
        loginButton = createNewButton(resizeComponent("/resources/login.png", 104, 40));
        loginButton.setActionCommand("login");
        loginButton.addActionListener(new LoginListener(this));
        
        registerButton = createNewButton(resizeComponent("/resources/register.png", 104, 40));
        registerButton.setActionCommand("register");
        registerButton.addActionListener(new LoginListener(this));
        registerButton.setEnabled(false);
        
        textFeedback = new JLabel("Enter registration details or choose 'login' to access an existing user");
        textFeedback.setAlignmentX(CENTER_ALIGNMENT);
        
        addComponents(constraints);
    }
    
    /**
     *
     * @param constraints
     */
    public void addComponents(GridBagConstraints constraints)
    {
        constraints.gridwidth = 2;
        innerPane.add(budgetInput,constraints);
        budgetInput.setVisible(false);

        constraints.gridwidth = 1;
        innerPane.add(registerButton,constraints);
        changeGridLayout(constraints, 1, 0);
        innerPane.add(loginButton,constraints);
        constraints.gridwidth = 2;
        changeGridLayout(constraints, 0, 3);
        innerPane.add(submitButton, constraints);
        changeGridLayout(constraints, 0, 1);
        innerPane.add(userInput, constraints);
        changeGridLayout(constraints, 0, 2);
        innerPane.add(passInput, constraints);
        
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(loginHeader);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(userIcon);
        this.add(innerPane);
        this.add(textFeedback);
    }
    
    /**
     *
     * @param user
     */
    public void setUser(User user)
    {
        this.user = user;
    }
    
    /**
     * @return the userInput
     */
    public JTextField getUserInput() {
        return userInput;
    }

    /**
     * @return the passInput
     */
    public JTextField getPassInput() {
        return passInput;
    }
    
    /**
     *
     * @return
     */
    public JLabel getTextFeedback()
    {
        return this.textFeedback;
    }
    
    /**
     *
     * @param newText
     */
    public void setTextFeedback(String newText)
    {
        this.textFeedback.setText(newText);
    }
    
    /**
     *
     * @return
     */
    public JTextField getBudgetInput()
    {
        return this.budgetInput;
    }
    
    /**
     *
     */
    public void switchToSetBudget()
    {
        registerButton.setVisible(false);
        loginButton.setVisible(false);
        userInput.setVisible(false);
        passInput.setVisible(false);
        budgetInput.setVisible(true);
        
        this.submitButton.setActionCommand("budget");
    }
    
    /**
     *
     */
    public void switchToLogin()
    {
        this.loginButton.setEnabled(false);
        this.registerButton.setEnabled(true);
        this.submitButton.setActionCommand("login");
        this.setTextFeedback("Enter username and password or switch to 'register' to create a new user");
    }
    
    /**
     *
     */
    public void switchToRegister()
    {
        this.loginButton.setEnabled(true);
        this.registerButton.setEnabled(false);
        this.submitButton.setActionCommand("register");
        this.setTextFeedback("Enter registration details or choose 'login' to access an existing user");
    }
    
    /**
     *
     */
    public void resetPanel()
    {
        registerButton.setVisible(true);
        loginButton.setVisible(true);
        userInput.setVisible(true);
        passInput.setVisible(true);
        budgetInput.setVisible(false);
        
        switchToRegister();
    }
}
