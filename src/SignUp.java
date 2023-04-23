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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
public class SignUp implements ActionListener {

    private JDialog fr;
    private JPanel pa; 
    private JTextField username, email, tel, name, lastname;
    private JPasswordField pass;
    private JButton signupbtn;
    private JLabel usertxt, passtxt, emailtxt, teltxt, nametxt, lastnametxt, warnuser, warnname, warnlast, warnemail, warnpass, warntel;
    private Font signupfont = new Font("Times New Roman", Font.BOLD, 36);
    private Font passfont = new Font("Times New Roman", Font.PLAIN, 10);
    private JLabel signlogo, passrequire;
    private LinkedList userData = new LinkedList();
    private String usertag = "Invalid username";
    
    public SignUp(){
 
        fr = new JDialog(fr,"Java tour-sign up",true);
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
        
        passrequire = new JLabel("At least 8 characters, contain alphabet and number");
        passrequire.setFont(passfont);
        passrequire.setBounds(50,415,300,20);
     
       signlogo= new JLabel("Sign Up");
       
       //warning text
       warnuser =new JLabel(usertag);
       warnpass = new JLabel("Invalid password."); 
       warnname= new JLabel("Invalid name");
       warnlast = new JLabel("Invalid lastname");
       warnemail = new JLabel("Invalid email");
       warntel = new JLabel("Invalid phone number");
       
       
       

        fr.setSize(310, 540);
        pa.setBackground(Color.WHITE);
        
        signlogo.setFont(signupfont);
        signlogo.setBounds(90, 15, 250,40);
        signlogo.setForeground(Color.orange);
        
        nametxt.setBounds(50,50+20,80,25);
        nametxt.setForeground(Color.black);
        name.setLocation (50,70+20);
        name.setSize(200,30);
        warnname.setBounds(50,115,80,20);
        warnname.setForeground(Color.RED);
        warnname.setVisible(false);
        
        
        lastnametxt.setBounds(50,100+30,80,25);
        lastnametxt.setForeground(Color.black);
        lastname.setLocation(50,120+30);
        lastname.setSize(200,30);
        warnlast.setBounds(50,175,100,20);
        warnlast.setForeground(Color.RED);
        warnlast.setVisible(false);
        
        emailtxt.setBounds(50, 150+40, 80, 25);
        email.setLocation(50, 170+40);
        email.setSize(200, 30);
        warnemail.setBounds(50,235,100,20);
        warnemail.setForeground(Color.RED);
        warnemail.setVisible(false);
        
        teltxt.setBounds(50, 200+50, 80, 25);
        tel.setLocation(50,220+50);
        tel.setSize(200,30);
        warntel.setBounds(50,295,300,20);
        warntel.setForeground(Color.RED);
        warntel.setVisible(false);
        
        usertxt.setBounds(50, 250+60, 80, 25);
        username.setLocation(50, 270+60);
        username.setSize(200,30);
        warnuser.setBounds(50,355,300,20);
        warnuser.setForeground(Color.RED);
        warnuser.setVisible(false);
        
        passtxt.setBounds(50, 300+70, 80, 25);
        pass.setLocation(50,320+70);
        pass.setSize(200,30);
        warnpass.setBounds(50,415,100,20);
        warnpass.setForeground(Color.RED);
        warnpass.setVisible(false);
        

        signupbtn.setBackground(Color.orange);
       // signupbtn.setBorder(null);
        signupbtn.setBounds(108,380+70,80,25);
        
      
        
        pa.setLayout(null);
        pa.setPreferredSize(new Dimension(300,500));
       // pa.add(logo);
        pa.add(usertxt); pa.add(username); pa.add(passtxt); pa.add(pass);
        pa.add(signupbtn); pa.add(name); pa.add(lastname); pa.add(nametxt); pa.add(lastnametxt);
        pa.add(email); pa.add(tel); pa.add(emailtxt); pa.add(teltxt); pa.add(signlogo);
        pa.add(warnname); pa.add(warnlast); pa.add(warnemail); pa.add(warntel); pa.add(warnuser);
        pa.add(warnpass); pa.add(passrequire);
        
       
        signupbtn.addActionListener(this);
  
        
        fr.setResizable(false);
        fr.setContentPane(pa);
        fr.setVisible(true);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
    public boolean checkName(String name){
        if (name.equals("")){
            return false;
        }
        for (int i = 0; i < name.length(); i++){
            if(Character.isAlphabetic(name.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }
    public boolean checkTel(String tel){
        return (tel.length() == 10 && tel.charAt(0) == '0' && ( tel.charAt(1) == '9' || tel.charAt(1) == '8' || tel.charAt(1) == '6'));
    }
    
    public boolean checkPass(String pass){
        boolean hasNum = false;
        boolean hasChar = false;
        if(pass.length()<8){
            return false;
        }
        for(int i = 1; i< pass.length(); i++){
            if (Character.isAlphabetic(pass.charAt(i))){
                hasChar =true;
            }
            if (Character.isDigit(pass.charAt(i))){
                hasNum = true;
            }
            if (hasChar && hasNum ){
                return true;
            }
        }
        return false;
    }
  public boolean checkUser(String username){
  
        try(FileInputStream fin = new FileInputStream("UserData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            userData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        if (userData  == null){
            return true;
        }
        if(username.equals("")){
            usertag = "Invalid username";
            warnuser.setText(usertag);
            return false;
        }
        for (int i = 0; i < userData.size(); i++){
            if (((User)userData.get(i)).getUsername().equals(username)){
                usertag = "This username has already used";
                warnuser.setText(usertag);
                    return false;
                }
        }
             return true;
    }
    public boolean checkEmail(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }
    @Override
    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == signupbtn){
            warnname.setVisible(!checkName(name.getText()));
            warnlast.setVisible(!checkName(lastname.getText()));
            warnpass.setVisible(!checkPass(String.valueOf(pass.getPassword())));
            warntel.setVisible(!checkTel(tel.getText()));
         
            warnuser.setVisible(!checkUser(username.getText()));
            warnemail.setVisible(!checkEmail(email.getText()));
            passrequire.setVisible(checkPass(String.valueOf(pass.getPassword())));
            
            if(checkName(name.getText()) && checkName(lastname.getText()) && checkPass(String.valueOf(pass.getPassword())) && checkTel(tel.getText()) && checkUser(username.getText()) && checkEmail(email.getText())){
                new User(name.getText(),lastname.getText(),email.getText(),tel.getText(),username.getText(),String.valueOf(pass.getPassword()));
                 JOptionPane.showConfirmDialog(null, "Sign up success!", "Notification", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                fr.dispose();
            
            }
       
        }
}

}
