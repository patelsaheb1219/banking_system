package banking_system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TransferPage extends JFrame {
	private static final long serialVersionUID = 1L;
	
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
    }

}
