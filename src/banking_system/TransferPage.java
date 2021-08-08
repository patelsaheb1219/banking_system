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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TransferPage extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel senderLabel;
	private JLabel receiverLabel;
	private JLabel amount;
	
	private JTextField senderAccountField;
	private JTextField receiverAccountField;
	private JTextField amountField;
	
	private JButton transferButton;
	private JButton logoutButton;
	private JButton userAccountButton;
	private JButton transferFundButton;
	private JButton cashTransferButton;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	TransferPage frame = new TransferPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TransferPage() {

    }

    /**
     * Create the frame.
     */
    public TransferPage(User user) {

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
				try {
					HomePage obj = new HomePage(user);
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
        transferFundButton.setForeground(Color.WHITE);
        transferFundButton.setBackground(Color.BLACK);
        transferFundButton.setBorderPainted(false);
        transferFundButton.setLocation(275, 50);
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
        
        senderLabel = new JLabel("Sender's Account");
        senderLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        senderLabel.setSize(200, 40);
        senderLabel.setLocation(250, 170);
        contentPane.add(senderLabel);
        
        senderAccountField = new JTextField();
        senderAccountField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        senderAccountField.setSize(200, 40);
        senderAccountField.setLocation(420, 170);
        contentPane.add(senderAccountField);
        senderAccountField.setColumns(10);
        
        receiverLabel = new JLabel("Receiver's Account");
        receiverLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        receiverLabel.setSize(200, 40);
        receiverLabel.setLocation(250, 210);
        contentPane.add(receiverLabel);
        
        receiverAccountField = new JTextField();
        receiverAccountField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        receiverAccountField.setSize(200, 40);
        receiverAccountField.setLocation(420, 210);
        contentPane.add(receiverAccountField);
        receiverAccountField.setColumns(10);
        
        amount = new JLabel("Amount");
        amount.setFont(new Font("Arial", Font.PLAIN, 18));
        amount.setSize(200, 40);
        amount.setLocation(250, 250);
        contentPane.add(amount);
        
        amountField = new JTextField();
        amountField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        amountField.setSize(200, 40);
        amountField.setLocation(420, 250);
        contentPane.add(amountField);
        amountField.setColumns(10);
        
        transferButton = new JButton("Transfer");
        transferButton.setFont(new Font("Arial", Font.PLAIN, 16));
        transferButton.setSize(150, 35);
        transferButton.setLocation(375, 350);
        transferButton.addActionListener(new ActionListener() {

        	@Override
            public void actionPerformed(ActionEvent e) {
                String senderAccount = senderAccountField.getText();
                String receiverAccount = receiverAccountField.getText();
                int amount = Integer.parseInt(amountField.getText());
                try {
                	if (senderAccount != null && receiverAccount != null && amount > 0) {
                		Connection connection = null;
    					try {
    						connection = DBConnection.getConnection();
    						PreparedStatement st = (PreparedStatement) connection
    		                        .prepareStatement("Select account_number, amount from user_account where account_number=? and user_id=?");
    							
    		                    st.setString(1, senderAccount);
    		                    st.setString(2, user.getUserId());
    		                    ResultSet rs = st.executeQuery();
    		                    if (rs.next()) {
    		                    	int senderAmount = Integer.parseInt(rs.getString("amount"));
    		                    	if (amount > senderAmount) {
    		                    		JOptionPane.showMessageDialog(transferButton, "Don't have enough balance to transfer", "Insufficient Balance",JOptionPane.ERROR_MESSAGE);
    		                    	} else {
    		    						PreparedStatement rsSt = (PreparedStatement) connection
    		    		                        .prepareStatement("Select account_number, amount from user_account where account_number=?");
    		    							
    		    						rsSt.setString(1, receiverAccount);
    		    						ResultSet result = rsSt.executeQuery();
    		    						if (result.next() && result.getString("account_number") != null) {
    		    								int receiverAmount = Integer.parseInt(result.getString("amount"));
    		    								System.out.println("Before");
    		    								System.out.println(senderAmount);
    		    								System.out.println(receiverAmount);
    		    								senderAmount = senderAmount - amount;
    		    								receiverAmount = receiverAmount + amount;
    		    								System.out.println("After");
    		    								System.out.println(senderAmount);
    		    								System.out.println(receiverAmount);
    		    								PreparedStatement updateSenderAccount = (PreparedStatement) connection
    	    		    		                        .prepareStatement("update user_account set amount=? where account_number=?");
    		    								updateSenderAccount.setString(1,String.valueOf(senderAmount));
    		    								updateSenderAccount.setString(2, senderAccount);
    		    								
    		    								PreparedStatement updateReceiverAccount = (PreparedStatement) connection
    	    		    		                        .prepareStatement("update user_account set amount=? where account_number=?");
    		    								updateReceiverAccount.setString(1,String.valueOf(receiverAmount));
    		    								updateReceiverAccount.setString(2, receiverAccount);
    		    								updateSenderAccount.executeUpdate();
    		    								updateReceiverAccount.executeUpdate();
    		    								JOptionPane.showMessageDialog(transferButton, "Amount transfer successfully!");
    		    						}  else {
    		    							JOptionPane.showMessageDialog(transferButton, "Receive's Account not found", "Account Not Found",JOptionPane.ERROR_MESSAGE);
    		    						}
    		                    	}
    		                    } else {
    		                        JOptionPane.showMessageDialog(transferButton, "No Account found with the given Sender Account", "Account Not Found",JOptionPane.ERROR_MESSAGE);
    		                    }
    					} catch (ClassNotFoundException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}	
                	} else {
                		JOptionPane.showMessageDialog(transferButton, "Please Input valid data!", "Input Error",JOptionPane.ERROR_MESSAGE);
                	}
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        contentPane.add(transferButton);
    }

}
