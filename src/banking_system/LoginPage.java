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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginPage extends JFrame {
	 private static final long serialVersionUID = 1L;
	 
	 	private JLabel usernameLabel;
	 	private JLabel userpasswordLabel;
	 	private JLabel pageTitle;
	 	
	    private JTextField usernameField;
	    private JPasswordField passwordField;
	    
	    private JButton loginButton;
	    private JButton registerButton;
	    private JPanel contentPanel;

	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	LoginPage frame = new LoginPage();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    /**
	     * Create the frame.
	     */
	    public LoginPage() {
	    	setTitle("Bank Account");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	        contentPanel = new JPanel();
	        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPanel);
	        contentPanel.setLayout(null);
	        
	        pageTitle = new JLabel("Login Page");
	        pageTitle.setFont(new Font("Arial", Font.PLAIN, 30));
	        pageTitle.setSize(300, 35);
	        pageTitle.setLocation(375, 150);
	        contentPanel.add(pageTitle);
	        
	        usernameLabel = new JLabel("Name :");
	        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        usernameLabel.setSize(100, 40);
	        usernameLabel.setLocation(300, 225);
	        contentPanel.add(usernameLabel);
	        
	        usernameField = new JTextField();
	        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        usernameField.setSize(190, 40);
	        usernameField.setLocation(400, 225);
	        contentPanel.add(usernameField);
	        usernameField.setColumns(10);
	        
	        userpasswordLabel = new JLabel("Password :");
	        userpasswordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        userpasswordLabel.setSize(100, 40);
	        userpasswordLabel.setLocation(300, 275);
	        contentPanel.add(userpasswordLabel);
	        
	        
	        passwordField = new JPasswordField();
	        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        passwordField.setSize(190, 40);
	        passwordField.setLocation(400, 275);
	        contentPanel.add(passwordField);

	        loginButton = new JButton("Login");
	        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
	        loginButton.setSize(150, 35);
	        loginButton.setLocation(375, 350);
	        loginButton.addActionListener(new ActionListener() {

	        	@Override
	            public void actionPerformed(ActionEvent e) {
	                String userName = usernameField.getText();
	                String password = passwordField.getText();
	                try {
	                    Connection connection = null;
						try {
							connection = DBConnection.getConnection();
							PreparedStatement st = (PreparedStatement) connection
			                        .prepareStatement("Select user_id, user_name, user_password, user_full_name, user_email, user_contact, user_age, user_address, user_zipcode from user where user_name=? and user_password=?");
								
			                    st.setString(1, userName);
			                    st.setString(2, password);
			                    ResultSet rs = st.executeQuery();
			                    if (rs.next()) {
			                    	User user = new User();
			                    	user.setUserName(rs.getString("user_name"));
			                    	user.setUserFullName(rs.getString("user_full_name"));
			                    	user.setUserEmail(rs.getString("user_email"));
			                    	user.setUserContact(rs.getString("user_contact"));
			                    	user.setUserAge(rs.getString("user_age"));
			                    	user.setUserAddress(rs.getString("user_address"));
			                    	user.setUserZipcode(rs.getString("user_zipcode"));
			                    	user.setUserId(rs.getString("user_id"));
			                        dispose();
			                        HomePage ah = new HomePage(user);
			                        ah.setTitle("Home Page");
			                        ah.setVisible(true);
			                        JOptionPane.showMessageDialog(loginButton, "You have successfully logged in");
			                    } else {
			                        JOptionPane.showMessageDialog(loginButton, "Wrong Username & Password");
			                    }
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
	            }
	        });

	        contentPanel.add(loginButton);
	        
	        JLabel registerLabel = new JLabel("Not a Registed User? Click below to register");
	        registerLabel.setFont(new Font("Arial", Font.PLAIN, 18));
	        registerLabel.setSize(400, 40);
	        registerLabel.setLocation(270, 400);
	        contentPanel.add(registerLabel);
	        
	        registerButton = new JButton("Register");
	        registerButton.setOpaque(true);
	        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
	        registerButton.setSize(150, 35);
	        registerButton.setForeground(Color.WHITE);
	        registerButton.setBackground(Color.BLUE);
	        registerButton.setBorderPainted(false);
	        registerButton.setLocation(375, 450);
	        registerButton.addActionListener(new ActionListener() { 
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	        			dispose();
		        		RegistrationPage registrationPage = new RegistrationPage();
		        		registrationPage.setTitle("Bank Account");
		        		registrationPage.setVisible(true);
	        		} catch (Exception e1) {
	        			e1.printStackTrace();
	        		}
	        	}
	        });
	        
	        contentPanel.add(registerButton);
	    }
}
