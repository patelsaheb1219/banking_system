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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel userFullnameLabel;
	private JLabel accountListLabel;
	private JLabel noAccountLabel;
	
	private JButton logoutButton;
	private JButton userAccountButton;
	private JButton transferFundButton;
	private JButton cashTransferButton;
	private JButton addAccountButton;
	
    private JPanel contentPane;

    Connection connection = null;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePage frame = new HomePage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HomePage() {

    }

    /**
     * Create the frame.
     * @throws ClassNotFoundException 
     */
    public HomePage(User user) throws ClassNotFoundException, SQLException {
    	try {
        	setTitle("Home Page");
            setBounds(300, 90, 900, 600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(true);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            userAccountButton = new JButton("Home");
            userAccountButton.setBackground(UIManager.getColor("Button.disabledForeground"));
            userAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
            userAccountButton.setSize(150, 35);
            userAccountButton.setOpaque(true);
            userAccountButton.setForeground(Color.WHITE);
            userAccountButton.setBackground(Color.BLACK);
            userAccountButton.setBorderPainted(false);
            userAccountButton.setLocation(100, 50);
            
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
            
            
            String welcomeMessage = "Welcome, " + user.getUserFullName();
            userFullnameLabel = new JLabel(welcomeMessage);
            userFullnameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            userFullnameLabel.setSize(400, 40);
            userFullnameLabel.setLocation(50, 100);
            contentPane.add(userFullnameLabel);
            
            accountListLabel = new JLabel("Account Details");
            accountListLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            accountListLabel.setSize(400, 40);
            accountListLabel.setLocation(50, 125);
            contentPane.add(accountListLabel);
            
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
            cashTransferButton.setForeground(Color.BLACK);
            cashTransferButton.setBackground(Color.WHITE);
            cashTransferButton.setBorderPainted(false);
            cashTransferButton.setLocation(475, 50);
            cashTransferButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	dispose();
                    CashTransferPage obj = new CashTransferPage(user);
                    obj.setTitle("Bank Account");
                    obj.setVisible(true);

                }
            });
            contentPane.add(cashTransferButton);

            
    		connection = DBConnection.getConnection();
    		PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select * from user_account where user_id=?");
    		st.setString(1, user.getUserId());
            ResultSet rs = st.executeQuery();
            int i = 0;
            
            AccountDetail[] accountDetails = new AccountDetail[4]; 
        	while(rs.next()) {
        		int accountNumber = Integer.parseInt(rs.getString("account_number"));
        		String accountHolderName = rs.getString("account_holder_name");
        		String accountType = rs.getString("account_type");
        		int amount = Integer.parseInt(rs.getString("amount"));
        		String accountStatus = rs.getString("account_status");
        		accountDetails[i] = new AccountDetail(accountNumber, accountHolderName, accountType, amount, accountStatus);
        		i++;
        	}
        	
            if (i == 0) {
            	
            	noAccountLabel = new JLabel("Opps! You don't have any bank account");
            	noAccountLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            	noAccountLabel.setSize(400, 40);
            	noAccountLabel.setLocation(300, 200);
                contentPane.add(noAccountLabel);
                
            	accountListLabel = new JLabel("Please add a new account");
                accountListLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                accountListLabel.setSize(400, 40);
                accountListLabel.setLocation(375, 225);
                contentPane.add(accountListLabel);
                
                addAccountButton = new JButton("Add New Account");
                addAccountButton.setBackground(UIManager.getColor("Button.disabledForeground"));
                addAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
                addAccountButton.setSize(200, 35);
                addAccountButton.setOpaque(true);
                addAccountButton.setForeground(Color.BLACK);
                addAccountButton.setBackground(Color.WHITE);
                addAccountButton.setBorderPainted(false);
                addAccountButton.setLocation(360, 275);
                addAccountButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	dispose();
                        AddNewAccount obj = new AddNewAccount(user);
                        obj.setTitle("Bank Account");
                        obj.setVisible(true);
                    }
                });
                contentPane.add(addAccountButton);
            } else {
            	Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            	Vector<String> headers = new Vector<String>();
            	headers.add("AccountNumner");
            	headers.add("Account Holder Name");
            	headers.add("Account Type");
            	headers.add("Amount");
            	headers.add("Account Status");
            	JLabel accountNumberHeader = new JLabel("Account Number");
            	accountNumberHeader.setFont(new Font("Arial", Font.BOLD, 14));
            	accountNumberHeader.setSize(150, 40);
            	accountNumberHeader.setLocation(110, 180);
            	contentPane.add(accountNumberHeader);
            	
            	JLabel accountHolderNameHeader = new JLabel("Account Holder Name");
            	accountHolderNameHeader.setFont(new Font("Arial", Font.BOLD, 14));
            	accountHolderNameHeader.setSize(160, 40);
            	accountHolderNameHeader.setLocation(250, 180);
            	contentPane.add(accountHolderNameHeader);
            	
            	JLabel accountTypeHeader = new JLabel("Account Type");
            	accountTypeHeader.setFont(new Font("Arial", Font.BOLD, 14));
            	accountTypeHeader.setSize(150, 40);
            	accountTypeHeader.setLocation(420, 180);
            	contentPane.add(accountTypeHeader);
            	
            	JLabel amountHeader = new JLabel("Amount");
            	amountHeader.setFont(new Font("Arial", Font.BOLD, 14));
            	amountHeader.setSize(160, 40);
            	amountHeader.setLocation(540, 180);
            	contentPane.add(amountHeader);
            	
            	JLabel accountStatusHeader = new JLabel("Account Status");
            	accountStatusHeader.setFont(new Font("Arial", Font.BOLD, 14));
            	accountStatusHeader.setSize(150, 40);
            	accountStatusHeader.setLocation(640, 180);
            	contentPane.add(accountStatusHeader);
            	for (int acc = 0; acc < accountDetails.length; acc++) {
            		if (accountDetails[acc] != null) {
            			JLabel accountNumber = new JLabel(String.valueOf(accountDetails[acc].getAccountNumber()));
            			accountNumber.setFont(new Font("Arial", Font.PLAIN, 14));
            			accountNumber.setSize(150, 40);
            			accountNumber.setLocation(110, getHeight(acc));
            			contentPane.add(accountNumber);
            			
                    	JLabel accountHolderName = new JLabel(accountDetails[acc].getAccountHolderName());
                    	accountHolderName.setFont(new Font("Arial", Font.PLAIN, 14));
                    	accountHolderName.setSize(160, 40);
                    	accountHolderName.setLocation(250, getHeight(acc));
                    	contentPane.add(accountHolderName);
                    	
                    	JLabel accountType = new JLabel(accountDetails[acc].getAccountType());
                    	accountType.setFont(new Font("Arial", Font.PLAIN, 14));
                    	accountType.setSize(150, 40);
                    	accountType.setLocation(420, getHeight(acc));
                    	contentPane.add(accountType);
                    	
                    	JLabel amount = new JLabel(String.valueOf(accountDetails[acc].getAmount()));
                    	amount.setFont(new Font("Arial", Font.PLAIN, 14));
                    	amount.setSize(160, 40);
                    	amount.setLocation(540, getHeight(acc));
                    	contentPane.add(amount);
                    	
                    	JLabel accountStatus = new JLabel(accountDetails[acc].getAccountStatus());
                    	accountStatus.setFont(new Font("Arial", Font.PLAIN, 14));
                    	accountStatus.setSize(150, 40);
                    	accountStatus.setOpaque(true);
                    	accountStatus.setLocation(640, getHeight(acc));
                    	contentPane.add(accountStatus);
            		}	
            	}
            }
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public int getHeight(int index) {
    	if (index == 0) {
    		return 210;
    	} else if (index == 1) {
    		return 235;
    	} else if (index == 2) {
    		return 260;
    	} else {
    		return 285;
    	}
    }
}
