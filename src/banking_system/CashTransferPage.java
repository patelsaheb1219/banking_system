package banking_system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class CashTransferPage extends JFrame {
private static final long serialVersionUID = 1L;
	
	private JButton logoutButton;
	private JButton userAccountButton;
	private JButton transferFundButton;
	private JButton cashTransferButton;
	private JButton addRemoveButton;
    private JPanel contentPane;
    
    // Declaration of JButtons    
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private ButtonGroup radioGroup;
    
    private JLabel accountNumberLabel;
	private JLabel amountLabel;
	
	private JTextField accountNumberField;
	private JTextField amountField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	CashTransferPage frame = new CashTransferPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CashTransferPage() {

    }

    /**
     * Create the frame.
     */
    public CashTransferPage(User user) {

    	setTitle("Home Page");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        userAccountButton = new JButton("Home");
        userAccountButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        userAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        userAccountButton.setSize(150, 35);
        userAccountButton.setOpaque(true);
        userAccountButton.setForeground(Color.BLACK);
        userAccountButton.setBackground(Color.WHITE);
        userAccountButton.setBorderPainted(false);
        userAccountButton.setLocation(100, 50);
        userAccountButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
             	dispose();
                 HomePage obj;
				try {
					obj = new HomePage(user);
					obj.setTitle("Bank Account");
	                obj.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

             }
        });
        contentPane.add(userAccountButton);
        
        transferFundButton = new JButton("Transfer Funds");
        transferFundButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        transferFundButton.setFont(new Font("Arial", Font.BOLD, 16));
        transferFundButton.setSize(175, 35);
        transferFundButton.setOpaque(true);
        transferFundButton.setForeground(Color.BLACK);
        transferFundButton.setBackground(Color.WHITE);
        transferFundButton.setBorderPainted(false);
        transferFundButton.setLocation(275, 50);
        transferFundButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
                TransferPage obj = new TransferPage(user);
                obj.setTitle("Bank Account");
                obj.setVisible(true);

            }
        });
        contentPane.add(transferFundButton);
        
        
        cashTransferButton = new JButton("Cash Trasfer");
        cashTransferButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        cashTransferButton.setFont(new Font("Arial", Font.BOLD, 16));
        cashTransferButton.setSize(150, 35);
        cashTransferButton.setOpaque(true);
        cashTransferButton.setForeground(Color.WHITE);
        cashTransferButton.setBackground(Color.BLACK);
        cashTransferButton.setBorderPainted(false);
        cashTransferButton.setLocation(475, 50);
        contentPane.add(cashTransferButton);
        
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
        
        setLayout(null);
        
        jRadioButton1 = new JRadioButton();
        
        // Initialization of object of "JRadioButton" class.
        jRadioButton2 = new JRadioButton();
  
        radioGroup = new ButtonGroup();
        
        this.add(jRadioButton1);
        this.add(jRadioButton2);
        
        jRadioButton1.setBounds(300,170,150,20);
        jRadioButton2.setBounds(450,170,150,20);

        jRadioButton1.setText("Cash Withdrawal");
        jRadioButton1.setSelected(true);
        jRadioButton2.setText("Cash Deposit");
        radioGroup.add(jRadioButton1);
        radioGroup.add(jRadioButton2);
        
        accountNumberLabel = new JLabel("Account Number");
        accountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        accountNumberLabel.setSize(200, 40);
        accountNumberLabel.setLocation(250, 210);
        contentPane.add(accountNumberLabel);
        
        accountNumberField = new JTextField();
        accountNumberField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        accountNumberField.setSize(200, 40);
        accountNumberField.setLocation(420, 210);
        contentPane.add(accountNumberField);
        accountNumberField.setColumns(10);
        
        amountLabel = new JLabel("Amount");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        amountLabel.setSize(200, 40);
        amountLabel.setLocation(250, 250);
        contentPane.add(amountLabel);
        
        amountField = new JTextField();
        amountField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        amountField.setSize(200, 40);
        amountField.setLocation(420, 250);
        contentPane.add(amountField);
        amountField.setColumns(10);
        
        addRemoveButton = new JButton("Withdraw/Deposit");
        addRemoveButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addRemoveButton.setSize(150, 35);
        addRemoveButton.setLocation(375, 300);
        addRemoveButton.addActionListener(new ActionListener() {

        	@Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountNumberField.getText();
                int amount = Integer.parseInt(amountField.getText());
                try {
                	if (accountNumber != null && amount > 0) {
                		Connection connection = null;
    					try {
    						connection = DBConnection.getConnection();
    						PreparedStatement st = (PreparedStatement) connection
    		                        .prepareStatement("Select account_number, amount from user_account where account_number=? and user_id=?");
    							
    		                    st.setString(1, accountNumber);
    		                    st.setString(2, user.getUserId());
    		                    ResultSet rs = st.executeQuery();
    		                    if (rs.next()) {
    		                    	int accountAmount = Integer.parseInt(rs.getString("amount"));
    		                    	System.out.println(accountAmount);
    		                    	System.out.println(amount);
    		                    	if (jRadioButton1.isSelected()) {
    		                    		if (amount < accountAmount) {
    		                    			accountAmount = accountAmount - amount;
    		                    			PreparedStatement updateAmount = (PreparedStatement) connection
	    		    		                        .prepareStatement("update user_account set amount=? where account_number=?");
    		                    			updateAmount.setString(1,String.valueOf(accountAmount));
    		                    			updateAmount.setString(2, accountNumber);
    		                    			updateAmount.executeUpdate();
    		                    			JOptionPane.showMessageDialog(addRemoveButton, "Amount withdrawal Successfully!");
    		                    		} else {
    		                    			JOptionPane.showMessageDialog(addRemoveButton, "Account holder cannot withdraw amount as amount exceed the Account Amount", "Don't have enough balance",JOptionPane.ERROR_MESSAGE);
    		                    		}
    		                    	} else if (jRadioButton2.isSelected()) {
    		                    		accountAmount = accountAmount + amount;
		                    			PreparedStatement updateAmount = (PreparedStatement) connection
    		    		                        .prepareStatement("update user_account set amount=? where account_number=?");
		                    			updateAmount.setString(1,String.valueOf(accountAmount));
		                    			updateAmount.setString(2, accountNumber);
		                    			updateAmount.executeUpdate();
		                    			JOptionPane.showMessageDialog(addRemoveButton, "Amount added Successfully!");
    		                    	} else {
    		                    		JOptionPane.showMessageDialog(addRemoveButton, "Please select any option Withdraw/Deposit Cash", "Selection Error",JOptionPane.ERROR_MESSAGE);
    		                    	}
    		                    } else {
    		                        JOptionPane.showMessageDialog(addRemoveButton, "No Account found with the given Account Number", "Account Not Found",JOptionPane.ERROR_MESSAGE);
    		                    }
    					} catch (ClassNotFoundException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}	
                	} else {
                		JOptionPane.showMessageDialog(addRemoveButton, "Please Input valid data!", "Input Error",JOptionPane.ERROR_MESSAGE);
                	}
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
        contentPane.add(addRemoveButton);
    }
}
