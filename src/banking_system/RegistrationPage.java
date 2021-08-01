package banking_system;

import java.awt.EventQueue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegistrationPage extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel usernameLabel;
	private JLabel userFullnameLabel;
 	private JLabel userPasswordLabel;
 	private JLabel confirmPasswordLabel;
 	private JLabel userEmailLabel;
 	private JLabel userContactLabel;
 	private	JLabel userAgeLabel;
 	private JLabel userAddressLabel;
 	private JLabel userZipcodeLabel;
 	private JLabel pageTitle;
 	
    private JTextField usernameField;
    private JTextField userAgeField;
    private JTextField userEmailField;
    private JTextField userContactField;
    private JTextField userFullnameField;
    private JTextField userAddressField;
    private JTextField userZipcodeField;
    private JPasswordField userPasswordField;
    private JPasswordField confirmPasswordField;
    
    private JButton registerButton;
    private JButton loginButton;
    private JButton resetButton;
    private JPanel contentPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	RegistrationPage frame = new RegistrationPage();
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
    public RegistrationPage() {
    	setTitle("Bank Account");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
        
        pageTitle = new JLabel("Registration Form");
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 30));
        pageTitle.setSize(300, 35);
        pageTitle.setLocation(325, 50);
        contentPanel.add(pageTitle);
        
        userFullnameLabel = new JLabel("Full Name :");
        userFullnameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userFullnameLabel.setSize(100, 25);
        userFullnameLabel.setLocation(100, 100);
        contentPanel.add(userFullnameLabel);
        
        userFullnameField = new JTextField();
        userFullnameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userFullnameField.setSize(505, 25);
        userFullnameField.setLocation(200, 100);
        contentPanel.add(userFullnameField);
        userFullnameField.setColumns(10);
        
        
        usernameLabel = new JLabel("User name :");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameLabel.setSize(100, 25);
        usernameLabel.setLocation(100, 140);
        contentPanel.add(usernameLabel);
        
        usernameField = new JTextField();
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        usernameField.setSize(200, 25);
        usernameField.setLocation(200, 140);
        contentPanel.add(usernameField);
        usernameField.setColumns(10);
        
        
        userAgeLabel = new JLabel("Age :");
        userAgeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userAgeLabel.setSize(100, 25);
        userAgeLabel.setLocation(410, 140);
        contentPanel.add(userAgeLabel);
        
        userAgeField = new JTextField();
        userAgeField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userAgeField.setSize(200, 25);
        userAgeField.setLocation(505, 140);
        contentPanel.add(userAgeField);
        userAgeField.setColumns(10);
        
        
        userEmailLabel = new JLabel("Email :");
        userEmailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userEmailLabel.setSize(100, 25);
        userEmailLabel.setLocation(100, 180);
        contentPanel.add(userEmailLabel);
        
        userEmailField = new JTextField();
        userEmailField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userEmailField.setSize(200, 25);
        userEmailField.setLocation(200, 180);
        contentPanel.add(userEmailField);
        userEmailField.setColumns(10);
        
        
        userContactLabel = new JLabel("Contact No:");
        userContactLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userContactLabel.setSize(100, 25);
        userContactLabel.setLocation(410, 180);
        contentPanel.add(userContactLabel);
        
        userContactField = new JTextField();
        userContactField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userContactField.setSize(200, 25);
        userContactField.setLocation(505, 180);
        contentPanel.add(userContactField);
        userContactField.setColumns(10);
        
        userAddressLabel = new JLabel("Address :");
        userAddressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userAddressLabel.setSize(100, 25);
        userAddressLabel.setLocation(100, 220);
        contentPanel.add(userAddressLabel);
        
        userAddressField = new JTextField();
        userAddressField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userAddressField.setSize(300, 25);
        userAddressField.setLocation(200, 220);
        contentPanel.add(userAddressField);
        userAddressField.setColumns(10);
        
        
        userZipcodeLabel = new JLabel("Zip Code :");
        userZipcodeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userZipcodeLabel.setSize(100, 25);
        userZipcodeLabel.setLocation(510, 220);
        contentPanel.add(userZipcodeLabel);
        
        userZipcodeField = new JTextField();
        userZipcodeField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userZipcodeField.setSize(110, 25);
        userZipcodeField.setLocation(595, 220);
        contentPanel.add(userZipcodeField);
        userZipcodeField.setColumns(10);
        
        userPasswordLabel = new JLabel("Password :");
        userPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userPasswordLabel.setSize(100, 25);
        userPasswordLabel.setLocation(100, 260);
        contentPanel.add(userPasswordLabel);
        
        userPasswordField = new JPasswordField();
        userPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userPasswordField.setSize(200, 25);
        userPasswordField.setLocation(200, 260);
        contentPanel.add(userPasswordField);
        userPasswordField.setColumns(10);
        
        
        confirmPasswordLabel = new JLabel("C. Password:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        confirmPasswordLabel.setSize(100, 25);
        confirmPasswordLabel.setLocation(410, 260);
        contentPanel.add(confirmPasswordLabel);
        
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        confirmPasswordField.setSize(200, 25);
        confirmPasswordField.setLocation(505, 260);
        contentPanel.add(confirmPasswordField);
        confirmPasswordField.setColumns(10);
        
        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setSize(150, 35);
        registerButton.setLocation(200, 320);
        registerButton.setOpaque(true);
        registerButton.setForeground(Color.BLACK);
        registerButton.setBackground(Color.WHITE);
        registerButton.setBorderPainted(false);
        registerButton.addActionListener(new ActionListener() {

        	@Override
            public void actionPerformed(ActionEvent e) {
                String userName = usernameField.getText();
                String userFullName = userFullnameField.getText();
                String userEmail = userEmailField.getText();
                String userContact = userContactField.getText();
                String userAge = userAgeField.getText();
                String userAddress = userAddressField.getText();
                String userZipcode = userZipcodeField.getText();
                String userPassword = userPasswordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                try {
                    Connection connection = null;
					try {
						connection = DBConnection.getConnection();
						PreparedStatement st = (PreparedStatement) connection
		                        .prepareStatement("INSERT INTO user(user_name, user_full_name, user_email, user_contact, user_age, user_address, user_zipcode, user_password) values (?,?,?,?,?,?,?,?)");

		                    st.setString(1, userName);
		                    st.setString(2, userFullName);
		                    st.setString(3, userEmail);
		                    st.setString(4, userContact);
		                    st.setString(5, userAge);
		                    st.setString(6, userAddress);
		                    st.setString(7, userZipcode);
		                    st.setString(8, userPassword);
		                    int rs = st.executeUpdate();
		                    System.out.print(rs);
		                    if (rs == 1) {
		                        dispose();
		                        LoginPage ah = new LoginPage();
		                        ah.setTitle("Bank Account");
		                        ah.setVisible(true);
		                        JOptionPane.showMessageDialog(registerButton, "You have successfully registred");
		                    } else {
		                        JOptionPane.showMessageDialog(registerButton, "Wrong Username & Password");
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
        
        contentPanel.add(registerButton);
        
        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 16));
        resetButton.setSize(150, 35);
        resetButton.setLocation(400, 320);
        resetButton.setOpaque(true);
        resetButton.setForeground(Color.WHITE);
        resetButton.setBackground(Color.BLACK);
        resetButton.setBorderPainted(false);
        resetButton.addActionListener(new ActionListener() {

        	@Override
            public void actionPerformed(ActionEvent e) {
               String defaultValue = "";
               usernameField.setText(defaultValue);
               userAgeField.setText(defaultValue);
               userEmailField.setText(defaultValue);
               userContactField.setText(defaultValue);
               userFullnameField.setText(defaultValue);
               userAddressField.setText(defaultValue);
               userZipcodeField.setText(defaultValue);
               userPasswordField.setText(defaultValue);
               confirmPasswordField.setText(defaultValue);
               
            }
        });
        contentPanel.add(resetButton);
        
        JLabel registerLabel = new JLabel("Already a User? Click below to Login");
        registerLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        registerLabel.setSize(400, 40);
        registerLabel.setLocation(320, 420);
        contentPanel.add(registerLabel);
        
        loginButton = new JButton("Login");
        loginButton.setOpaque(true);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setSize(150, 35);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLUE);
        loginButton.setBorderPainted(false);
        loginButton.setLocation(400, 460);
        loginButton.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {
        		try {
        			dispose();
	        		LoginPage loginPage = new LoginPage();
	        		loginPage.setTitle("Bank Account");
	        		loginPage.setVisible(true);
        		} catch (Exception e1) {
        			e1.printStackTrace();
        		}
        	}
        });
        
        contentPanel.add(loginButton);
    }
    
}
