package banking_system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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

public class AddNewAccount extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel addAccountLabel;
	private JLabel accountHolderNameLabel;
	private JLabel accountTypeLabel;
	private JLabel amountLabel;
	
	private JTextField accountHolderNameField;
	private JTextField amountField;
	
	private JComboBox<String> accountTypeField;
	
	private JButton logoutButton;
	private JButton userAccountButton;
	private JButton addAccountButton;
    private JPanel contentPane;

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
    	
    	setTitle("Home Page");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        userAccountButton = new JButton("Back");
        userAccountButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        userAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        userAccountButton.setSize(150, 35);
        userAccountButton.setOpaque(true);
        userAccountButton.setForeground(Color.WHITE);
        userAccountButton.setBackground(Color.BLACK);
        userAccountButton.setBorderPainted(false);
        userAccountButton.setLocation(100, 50);
        userAccountButton.addActionListener(new ActionListener() {
       	 public void actionPerformed(ActionEvent e) {
            	dispose();
                HomePage obj;
				obj = new HomePage();
				obj.setTitle("Bank Account");
				obj.setVisible(true);

            }
       });
       contentPane.add(userAccountButton);
        
        
        logoutButton = new JButton("Logout");
        logoutButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setSize(175, 35);
        logoutButton.setOpaque(true);
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setBorderPainted(false);
        logoutButton.setLocation(650, 50);
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
        
        addAccountLabel = new JLabel("Add a New Account");
        addAccountLabel.setFont(new Font("Arial", Font.BOLD, 20));
        addAccountLabel.setSize(400, 40);
        addAccountLabel.setLocation(360, 100);
        contentPane.add(addAccountLabel);
        
        
        accountHolderNameLabel = new JLabel("Account holder name");
        accountHolderNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        accountHolderNameLabel.setSize(400, 40);
        accountHolderNameLabel.setLocation(260, 150);
        contentPane.add(accountHolderNameLabel);
        
        accountHolderNameField = new JTextField(user.getUserFullName());
        accountHolderNameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        accountHolderNameField.setSize(400, 40);
        accountHolderNameField.setLocation(255, 180);
        contentPane.add(accountHolderNameField);
        accountHolderNameField.setColumns(10);
        
        
        accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        accountTypeLabel.setSize(400, 40);
        accountTypeLabel.setLocation(260, 230);
        contentPane.add(accountTypeLabel);
        
        accountTypeField = new JComboBox<>(accountType);
        accountTypeField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        accountTypeField.setSize(400, 40);
        accountTypeField.setOpaque(true);
        accountTypeField.setLocation(255, 260);
        contentPane.add(accountTypeField);
        
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
        
        addAccountButton = new JButton("Add");
        addAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        addAccountButton.setSize(150, 35);
        addAccountButton.setLocation(260, 400);
        addAccountButton.setOpaque(true);
        addAccountButton.setForeground(Color.WHITE);
        addAccountButton.setBackground(Color.BLACK);
        addAccountButton.setBorderPainted(false);
        addAccountButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String accountHolderName = accountHolderNameField.getText();
        		String accountType = (String) accountTypeField.getSelectedItem(); 
        		int amount = Integer.parseInt(amountField.getText());
        		System.out.println(accountHolderName);
        		System.out.println(accountType);
        		System.out.println(amount);
        		if (accountHolderName != null && accountType != null && amount > 0) {
        			try {
						Connection connection = DBConnection.getConnection();
						
						PreparedStatement selectStatement = (PreparedStatement) connection
		                        .prepareStatement("SELECT MAX(account_number) as account_number FROM user_account");
						ResultSet rs = selectStatement.executeQuery();
						PreparedStatement insertStatement = (PreparedStatement) connection
		                        .prepareStatement("INSERT INTO user_account(account_number, user_id, account_holder_name, account_type, amount, account_status) values (?,?,?,?,?,?)");
						if (rs.next()) {
							int account_number = Integer.parseInt(rs.getString("account_number")) + 1;
							insertStatement.setInt(1, account_number);
							insertStatement.setInt(2, Integer.parseInt(user.getUserId()));
							insertStatement.setString(3, accountHolderName);
							insertStatement.setString(4, accountType);
							insertStatement.setInt(5, amount);
							insertStatement.setString(6, "active");
						} else {
							insertStatement.setInt(1, 2021000001);
							insertStatement.setInt(2, Integer.parseInt(user.getUserId()));
							insertStatement.setString(3, accountHolderName);
							insertStatement.setString(4, accountType);
							insertStatement.setInt(5, amount);
							insertStatement.setString(6, "active");
						}
						int result = insertStatement.executeUpdate();
						if (result == 1) {
							JOptionPane.showMessageDialog(addAccountButton, "Account Created Successfully!");
							HomePage obj = new HomePage(user);
							obj.setTitle("Bank Account");
			                obj.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(addAccountButton, "Opps! Error occur account cannot be created!");
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		} else {
        			JOptionPane.showMessageDialog(addAccountButton, "Please enter all the fields.");
        		}
        		
        	}
        });
        contentPane.add(addAccountButton);
    }
}