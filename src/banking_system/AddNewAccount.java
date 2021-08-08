package banking_system;

/**
 * @author Roshani Patel C0
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

// Add New Account Class/ Frame
public class AddNewAccount extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// variable declaration	
	private JLabel addAccountLabel; // Label for add Account
	private JLabel accountHolderNameLabel; // Label for account holder name
	private JLabel accountTypeLabel; // Label for account type
	private JLabel amountLabel; // Label for amount
	
	private JTextField accountHolderNameField; // Textfield for account holder name
	private JTextField amountField; // Textfield for user account's amount 
	
	private JComboBox<String> accountTypeField; // Dropdown for the account type
	
	private JButton logoutButton; // Button for Logout
	private JButton userAccountButton; // Button to navigate userAccount
	private JButton addAccountButton; // Button to navigate addnew account
    private JPanel contentPane; // created a panel to show different elements

    /**
     * Launch the application.
    */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddNewAccount frame = new AddNewAccount();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddNewAccount() {

    }

    /**
     * Create the frame.
    */
    public AddNewAccount(User user) {
    	
    	// List of account Type    	
    	String accountType[] = {"checking", "current", "saving", "trading"}; 
    	
    	// Initial Screen setup    	
    	setTitle("Home Page");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Added home button for navigation       
        userAccountButton = new JButton("Back");
        
        //Design of the button        
        userAccountButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        userAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        userAccountButton.setSize(150, 35);
        userAccountButton.setOpaque(true);
        userAccountButton.setForeground(Color.WHITE);
        userAccountButton.setBackground(Color.BLACK);
        userAccountButton.setBorderPainted(false);
        userAccountButton.setLocation(100, 50);
        // Action listener of the button
        userAccountButton.addActionListener(new ActionListener() {
       	 public void actionPerformed(ActionEvent e) {
            	dispose();
                HomePage obj;
				obj = new HomePage();
				obj.setTitle("Bank Account");
				obj.setVisible(true);

            }
       });
        
       // Added home button to panel
       contentPane.add(userAccountButton);
        
       	// Logout button design and initiation        
        logoutButton = new JButton("Logout");
        logoutButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setSize(175, 35);
        logoutButton.setOpaque(true);
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setBorderPainted(false);
        logoutButton.setLocation(650, 50);
        // Action listener of the button
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(logoutButton, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    LoginPage obj = new LoginPage();
                    obj.setTitle("Bank Account");
                    obj.setVisible(true);
                } else {
                	
                }

            }
        });
        contentPane.add(logoutButton);
        
        // Add New Account Label Screen        
        addAccountLabel = new JLabel("Add a New Account");
        addAccountLabel.setFont(new Font("Arial", Font.BOLD, 20));
        addAccountLabel.setSize(400, 40);
        addAccountLabel.setLocation(360, 100);
        contentPane.add(addAccountLabel);
        
        // Account holder name label        
        accountHolderNameLabel = new JLabel("Account holder name");
        accountHolderNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        accountHolderNameLabel.setSize(400, 40);
        accountHolderNameLabel.setLocation(260, 150);
        contentPane.add(accountHolderNameLabel);
        
        // Account holder name Textfield
        accountHolderNameField = new JTextField(user.getUserFullName()); // Name will initiated with same as user's name while registration
        accountHolderNameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        accountHolderNameField.setSize(400, 40);
        accountHolderNameField.setLocation(255, 180);
        contentPane.add(accountHolderNameField);
        accountHolderNameField.setColumns(10);
        
        // Account Type Label
        accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        accountTypeLabel.setSize(400, 40);
        accountTypeLabel.setLocation(260, 230);
        contentPane.add(accountTypeLabel);

        // Account Type Dropdown ComboBox
        accountTypeField = new JComboBox<>(accountType);
        accountTypeField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        accountTypeField.setSize(400, 40);
        accountTypeField.setOpaque(true);
        accountTypeField.setLocation(255, 260);
        contentPane.add(accountTypeField);
        
        // Account Amount Label
        amountLabel = new JLabel("Amount");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        amountLabel.setSize(400, 40);
        amountLabel.setLocation(260, 310);
        contentPane.add(amountLabel);
        
        amountField = new JTextField("1");
        amountField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        amountField.setSize(400, 40);
        amountField.setLocation(255, 340);
        contentPane.add(amountField);
        amountField.setColumns(10);
        
        // Add Account button
        addAccountButton = new JButton("Add");
        addAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        addAccountButton.setSize(150, 35);
        addAccountButton.setLocation(260, 400);
        addAccountButton.setOpaque(true);
        addAccountButton.setForeground(Color.WHITE);
        addAccountButton.setBackground(Color.BLACK);
        addAccountButton.setBorderPainted(false);
        // Action listener of the button
        addAccountButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Get user input data        		
        		String accountHolderName = accountHolderNameField.getText(); // Account holder name
        		String accountType = (String) accountTypeField.getSelectedItem(); // Account Type field
        		int amount = Integer.parseInt(amountField.getText()); // Amount to add
        		
        		// Validate entered field        		
        		if (accountHolderName != null && accountType != null && amount > 0) {
        			try {
        				
        				// Get Connection from DBConnection Class        				
						Connection connection = DBConnection.getConnection();
						
						// Create prepared statement for find last added account number						
						PreparedStatement selectStatement = (PreparedStatement) connection
		                        .prepareStatement("SELECT MAX(account_number) as account_number FROM user_account");
						// Execute query						
						ResultSet rs = selectStatement.executeQuery();
						
						// Prepared statement for insertion						
						PreparedStatement insertStatement = (PreparedStatement) connection
		                        .prepareStatement("INSERT INTO user_account(account_number, user_id, account_holder_name, account_type, amount, account_status) values (?,?,?,?,?,?)");
						// If already one account added in DB then next account will be added by +1 to it.
						if (rs.next()) {
							int account_number = Integer.parseInt(rs.getString("account_number")) + 1;
							insertStatement.setInt(1, account_number);
							insertStatement.setInt(2, Integer.parseInt(user.getUserId()));
							insertStatement.setString(3, accountHolderName);
							insertStatement.setString(4, accountType);
							insertStatement.setInt(5, amount);
							insertStatement.setString(6, "active");
						} 
						// If no account find then account will be added with below account number
						else {
							insertStatement.setInt(1, 2021000001);
							insertStatement.setInt(2, Integer.parseInt(user.getUserId()));
							insertStatement.setString(3, accountHolderName);
							insertStatement.setString(4, accountType);
							insertStatement.setInt(5, amount);
							insertStatement.setString(6, "active");
						}
						int result = insertStatement.executeUpdate();
						
						// If result got 1 then it will go to home page						
						if (result == 1) {
							JOptionPane.showMessageDialog(addAccountButton, "Account Created Successfully!");
							HomePage obj = new HomePage(user);
							obj.setTitle("Bank Account");
			                obj.setVisible(true);
						} 
						// Show error						
						else {
							JOptionPane.showMessageDialog(addAccountButton, "Opps! Error occur account cannot be created!", "Error Occur", JOptionPane.ERROR_MESSAGE);
						}
						
						// Close connection						
						connection.close();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		} else {
        			JOptionPane.showMessageDialog(addAccountButton, "Please enter all the fields.", "Error occur", JOptionPane.ERROR_MESSAGE);
        		}
        		
        	}
        });
        contentPane.add(addAccountButton);
    }
}