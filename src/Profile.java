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
import java.util.*;

public class Profile implements ActionListener {
    //private JFrame fr;
    private JPanel p1;
    private JTextField name, last, tel, email, username, pass;
    private JLabel nametxt, lasttxt, teltxt,emailtxt,usertxt,passtxt, profile;
    private JLabel warnname, warnlast, warntel, warnemail, warnpass, warnuser;
    private LinkedList <User> userData = new LinkedList<User>();
    private JButton save;
    private User user;
    private String usertag = "Invalid username";
    private Font lbfont = new Font("Times New Roman", Font.BOLD, 18);
    private Font textfont = new Font("Times New Roman", Font.PLAIN, 16);
    private Font logo = new Font("Times New Roman", Font.BOLD, 60);
    
public Profile(User user){
    this.user = user;
    p1 = new JPanel();
    p1.setBackground(Color.white);
    
            
   
    name = new JTextField(this.user.getName());
    last = new JTextField(this.user.getLastName());
    tel = new JTextField(this.user.getTelNumber());
    email = new JTextField(this.user.getEmail());
    username  = new JTextField(this.user.getUsername());
    pass= new JTextField(this.user.getPassword());
    
    usertxt = new JLabel("Username:");
    passtxt = new JLabel("Password:");
    emailtxt = new JLabel("Email:");
    teltxt = new JLabel("Tel:");
    nametxt = new JLabel("Name:");
    lasttxt = new JLabel("Last Name:");
    profile = new JLabel("Profile");
 
    warnpass = new JLabel("Invalid password."); 
    warnname= new JLabel("Invalid name");
    warnlast = new JLabel("Invalid lastname");
    warnemail = new JLabel("Invalid email");
    warntel = new JLabel("Invalid phone number");
    warnuser =new JLabel(usertag);

    profile.setFont(logo);
    profile.setBounds(355,33,300,100);
    profile.setForeground(Color.orange);

    
    nametxt.setFont(lbfont);
    nametxt.setBounds(120, 150, 100, 100);
    name.setLocation(120,215);
    name.setSize(250,30);
    name.setFont(textfont);
    warnname.setBounds(120, 200,100,100);
    
    lasttxt.setFont(lbfont);
    lasttxt.setBounds(500,150,100,100);
    last.setLocation(500,215);
    last.setSize(250, 30);
    last.setFont(textfont);
    warnlast.setBounds(500, 200,100,100);
    
    emailtxt.setFont(lbfont);
    emailtxt.setBounds(120, 240,100,100);
    email.setLocation(120,305);
    email.setSize(250, 30);
    email.setFont(textfont);
    warnemail.setBounds(120, 290,100,100);
    
    teltxt.setFont(lbfont);
    teltxt.setBounds(500,240,100,100);
    tel.setLocation(500, 305);
    tel.setSize(250,30);
    tel.setFont(textfont);
    warntel.setBounds(500, 290,200,100);
    
    usertxt.setBounds(120,330,100,100);
    usertxt.setFont(lbfont);
    username.setLocation(120, 395);
    username.setSize(250, 30);
    username.setFont(textfont);
    warnuser.setBounds(120,380,200,100);
    
    passtxt.setBounds(500, 330,100,100);
    passtxt.setFont(lbfont);
    pass.setLocation(500,395);
    pass.setSize(250,30);
    pass.setFont(textfont);
    warnpass.setBounds(500,380,200,100);
    
    
    
           
    
    
    //Button
    save = new JButton("save");
    
    save.setBounds(397,480,70,30);
    save.setFont(lbfont);
    save.setBackground(Color.orange);
    save.setForeground(Color.black);

    warnname.setForeground(Color.red);
    warnlast.setForeground(Color.red);
    warnemail.setForeground(Color.red);
    warntel.setForeground(Color.red);
    warnpass.setForeground(Color.red);
    warnuser.setForeground(Color.red);
    
    warnname.setVisible(false);
    warnlast.setVisible(false);
    warnemail.setVisible(false);
    warntel.setVisible(false);
    warnpass.setVisible(false);
    warnuser.setVisible(false);
    
    
    save.addActionListener(this);

    
    
    

    
    p1.setLayout(null);
    p1.add(profile);
    p1.add(nametxt); p1.add(lasttxt);
    p1.add(name); p1.add(last);
    p1.add(warnname); p1.add(warnlast);
    p1.add(emailtxt);p1.add(teltxt);
    p1.add(email); p1.add(tel);
    p1.add(warnemail); p1.add(warntel);
    p1.add(usertxt); p1.add(passtxt);
    p1.add(username); p1.add(pass);
    p1.add(warnuser); p1.add(warnpass);
    p1.add(save);
    

    
    userData = FileIO.loadUserData();
}
    @Override
    public void actionPerformed(ActionEvent ev){
    
    if(ev.getSource().equals(save)){
        
         CheckingAccount ch = new CheckingAccount();
         warnname.setVisible(!ch.checkName(name.getText()));
         warnlast.setVisible(!ch.checkName(last.getText()));
         warntel.setVisible(!ch.checkTel(tel.getText()));
         warnemail.setVisible(!ch.checkEmail(email.getText()));
         warnpass.setVisible(!ch.checkPass(pass.getText()));
         if(user.getUsername().equals(username.getText())){
            warnuser.setVisible(false);
             if(ch.checkName(name.getText()) && ch.checkName(last.getText()) && ch.checkPass(pass.getText()) && ch.checkTel(tel.getText()) && ch.checkEmail(email.getText())){
                
                try{
                int index = -1;
                for (int i = 0; i < userData.size() && userData.size() != 0; i++){
                    if ((userData.get(i)).getUsername().equals(user.getUsername())){
                        index = i;
                        break;
                    }
                }
                 
                user.setName(name.getText());
                user.setLastName(last.getText());
                user.setTelNumber(tel.getText());
                user.setEmail(email.getText());
                user.setPassword(pass.getText());
                
                userData.set(index, user);
                }catch(IndexOutOfBoundsException e){
                    System.out.println("User not found");
                }
                

                JOptionPane.showConfirmDialog(null, "Update profile success!", "Notification", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

             }
         
         }
    else{
         boolean uscheck;
         uscheck = ch.checkUser(username.getText());
         warnuser.setText(ch.getUsertag());
         warnuser.setVisible(!uscheck);
        if(ch.checkName(name.getText()) && ch.checkName(last.getText()) && ch.checkPass(pass.getText()) && ch.checkTel(tel.getText()) && ch.checkUser(username.getText()) && ch.checkEmail(email.getText())){
            
                  try{
                int index = -1;
                for (int i = 0; i < userData.size() && userData.size() != 0; i++){
                    if ((userData.get(i)).getUsername().equals(user.getUsername())){
                        index = i;
                        break;
                    }
                }
                user.setName(name.getText());
                user.setLastName(last.getText());
                user.setTelNumber(tel.getText());
                user.setEmail(email.getText());
                user.setPassword(pass.getText());
                user.setUserName(username.getText());
                userData.set(index, user);
                }catch(IndexOutOfBoundsException e){
                    System.out.println("User not found");
                }

                JOptionPane.showConfirmDialog(null, "Update profile success!", "Notification", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        }    
    }
    }
    FileIO.saveUserData(userData);
    }
    public JPanel getFrame(){
        return this.p1;
    }
   

}
