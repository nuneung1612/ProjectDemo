/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Login implements ActionListener {
    private JButton loginbtn;
    private JFrame fr;
    private JPanel pa; 
    private JTextField username;
    private JPasswordField pass;
    private JButton signupbtn;
    private JButton adminbtn;
    private JLabel usertxt;
    private JLabel passtxt;
    private Font logofont = new Font("Times New Roman", Font.BOLD, 40);
    private JLabel logo;
    private LinkedList userData = new LinkedList();
    private JLabel invalid;
    private ImageIcon logo1, logo2;
    
    
    public Login(){
        loginbtn = new JButton("Log in");
        fr = new JFrame("Java tour-log in");
        pa = new JPanel(); 
        username= new JTextField();
        pass = new JPasswordField();
        signupbtn = new JButton("Sign up");
        usertxt = new JLabel("Username:");
        passtxt = new JLabel("Password:");
        adminbtn = new JButton("Admin");
        //logo = new JLabel("JAVA Tour");
        invalid = new JLabel("Incorrect username or password.");
        logo1 = new ImageIcon(getClass().getResource("images/logo.png"));
        Image size = logo1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        logo2 = new ImageIcon(size);
        logo = new JLabel(logo2);


        fr.setSize(300, 500);
        pa.setBackground(Color.WHITE);
        
       // logo.setFont(logofont);
        logo.setBounds(55, 5, 200,170);
        //logo.setForeground(Color.orange);
        
     
        
        usertxt.setBounds(50, 150, 80, 25);
        usertxt.setBackground(Color.black);
        username.setLocation(50, 170);
        username.setSize(200, 30);
        
        passtxt.setBounds(50, 200, 80, 25);
        passtxt.setBackground(Color.black);
        pass.setLocation(50,220);
        pass.setSize(200,30);
        
        invalid.setBounds(50, 250, 230, 25);
        invalid.setForeground(Color.RED);
        invalid.setVisible(false);
        
       
        
        loginbtn.setBackground(Color.orange);
        loginbtn.setBounds(108,280,80,25);
        
        signupbtn.setBackground(Color.white);
        signupbtn.setBorder(null);
        signupbtn.setBounds(108,310,80,25);
        
        adminbtn.setBounds(200,450,80,25);
        adminbtn.setBackground(Color.lightGray);
        
        pa.setLayout(null);
        pa.setPreferredSize(new Dimension(300,500));
        pa.add(logo);
        pa.add(usertxt); pa.add(username); pa.add(passtxt); pa.add(pass);
        pa.add(loginbtn); pa.add(signupbtn); pa.add(adminbtn);
        pa.add(invalid);
        
        loginbtn.addActionListener(this);
        signupbtn.addActionListener(this);
        adminbtn.addActionListener(this);
        
        fr.setResizable(false);
        fr.setContentPane(pa);
        fr.setVisible(true);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
     public boolean checkUser(String username, String password){
        String text = "";
        if(username.equals("") || password.equals("")){
            return false;
        }
        try(FileInputStream fin = new FileInputStream("UserData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            userData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        for (int i = 0; i < userData.size(); i++){
            if (((User)userData.get(i)).getUsername().equals(username)){
                if (((User)userData.get(i)).getPassword().equals(password)){
                    return true;
                }
                else{
                    text = "WrongPassword" ;
                    System.out.println(text);
                    return false;
                }
                
            }
            text = "UserNotFound";
        }
        System.out.println(text);
        return false;
     }
    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource() == loginbtn){
          
            if (checkUser(username.getText(), String.valueOf(pass.getPassword()))){
                new Home();
                fr.dispose();
            
        }
            else{
                invalid.setVisible(true);
            
            }
        }
        if(ev.getSource()==signupbtn){
            System.out.println("Sign up");
            new SignUp();
            invalid.setVisible(false);
            username.setText("");
            pass.setText("");
                   
        }
        if(ev.getSource() == adminbtn){
           new Admin();
            fr.dispose();
        }
    
    }
    public static void main(String[] args) {
        new Login();
    }
    
}
