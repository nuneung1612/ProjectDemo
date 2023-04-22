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
public class SignupGUI  implements ActionListener {

    private JFrame fr;
    private JPanel pa; 
    private JTextField username, email, tel, name, lastname;
    private JPasswordField pass;
    private JButton signupbtn;
    private JLabel usertxt, passtxt, emailtxt, teltxt, nametxt, lastnametxt;
    private Font signupfont = new Font("Times New Roman", Font.BOLD, 36);
    private JLabel signlogo;
    
    public SignupGUI(){
 
        fr = new JFrame("Java tour-sign up");
        pa = new JPanel(); 
        username= new JTextField();
        name = new JTextField();
        lastname = new JTextField();
        email = new JTextField();
        tel = new JTextField();
        lastname = new JTextField();
        
        pass = new JPasswordField();
        signupbtn = new JButton("Sign up");
        usertxt = new JLabel("User name:");
        passtxt = new JLabel("Password:");
        emailtxt = new JLabel("Email:");
        teltxt = new JLabel("Tel:");
        nametxt = new JLabel("Name:");
        lastnametxt = new JLabel("Last Name:");
     
       signlogo= new JLabel("Sign Up");

        fr.setSize(300, 500);
        pa.setBackground(Color.WHITE);
        
        signlogo.setFont(signupfont);
        signlogo.setBounds(90, 15, 250,40);
        signlogo.setForeground(Color.orange);
        
        nametxt.setBounds(50,50+20,40,15);
        nametxt.setForeground(Color.black);
        name.setLocation (50,70+20);
        name.setSize(200,30);
        
        lastnametxt.setBounds(50,100+20,80,25);
        lastnametxt.setForeground(Color.black);
        lastname.setLocation(50,120+20);
        lastname.setSize(200,30);
        
        emailtxt.setBounds(50, 150+20, 80, 25);
        email.setLocation(50, 170+20);
        email.setSize(200, 30);
        
        teltxt.setBounds(50, 200+20, 80, 25);
        tel.setLocation(50,220+20);
        tel.setSize(200,30);
        
        usertxt.setBounds(50, 250+20, 80, 25);
        username.setLocation(50, 270+20);
        username.setSize(200,30);
        
        passtxt.setBounds(50, 300+20, 80, 25);
        pass.setLocation(50,320+20);
        pass.setSize(200,30);
        

        signupbtn.setBackground(Color.orange);
       // signupbtn.setBorder(null);
        signupbtn.setBounds(108,380+20,80,25);
        
      
        
        pa.setLayout(null);
        pa.setPreferredSize(new Dimension(300,500));
       // pa.add(logo);
        pa.add(usertxt); pa.add(username); pa.add(passtxt); pa.add(pass);
        pa.add(signupbtn); pa.add(name); pa.add(lastname); pa.add(nametxt); pa.add(lastnametxt);
        pa.add(email); pa.add(tel); pa.add(emailtxt); pa.add(teltxt); pa.add(signlogo);
        
       
        signupbtn.addActionListener(this);
  
        
        fr.setResizable(false);
        fr.setContentPane(pa);
        fr.setVisible(true);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
    public boolean checkName(String name){
        for (int i = 0; i < name.length(); i++){
            if(Character.isAlphabetic(name.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }
    public boolean checkEmail(String em){
        return true;
    }

    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == signupbtn){
            new User(name.getText(),lastname.getText(),email.getText(),tel.getText(),username.getText(),String.valueOf(pass.getPassword()));
            fr.dispose();
        }
    
    }
}
