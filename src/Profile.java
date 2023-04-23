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
    //unfinised
public class Profile implements ActionListener {
    private JFrame fr;
    private JPanel p1, p2, p3, p4 ,p5;
    private JTextField name, last, tel, email, oldpass, newpass;
    private JLabel nametxt, lasttxt, teltxt,emailtxt,oldpasstxt,newpasstxt,pic;
    private JLabel warnname, warnlast, warntel, warnemail, warnpass, empt1, empt2;
    private LinkedList userData = new LinkedList();
    private JButton home, pro, setting, save;
public Profile (){
    fr = new JFrame("Java Touer - Profile");
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    p4 = new JPanel();
    p5 = new JPanel();
    p4.setBackground(Color.white);
            

    name = new JTextField();
    last = new JTextField();
    tel = new JTextField();
    email = new JTextField();
    oldpass  = new JTextField();
    newpass = new JTextField();
    
    newpasstxt = new JLabel("New Password:");
    oldpasstxt = new JLabel("Old Password:");
    emailtxt = new JLabel("Email:");
    teltxt = new JLabel("Tel:");
    nametxt = new JLabel("Name:");
    lasttxt = new JLabel("Last Name:");
    pic = new JLabel("pic p3 north");
  
    warnpass = new JLabel("Invalid password."); 
    warnname= new JLabel("Invalid name");
    warnlast = new JLabel("Invalid lastname");
    warnemail = new JLabel("Invalid email");
    warntel = new JLabel("Invalid phone number");
    empt1 =  new JLabel();
    empt2 = new JLabel();
    
    home = new JButton("home");
    pro = new JButton("Profile");
    setting = new JButton("setting");
    save = new JButton("save");
    
    p1.setLayout(new BorderLayout());
    p1.add(p2, BorderLayout.WEST);
    p1.add(p3,BorderLayout.CENTER);
    
    p2.setLayout(new GridLayout(6,1));
    p2.add(home); p2.add(pro); p2.add(setting);
    
    p3.setLayout(new BorderLayout());
    p3.add(pic, BorderLayout.NORTH);
    p3.add(p4,BorderLayout.CENTER);
    
    p4.setLayout(new GridLayout(10,2));
    p4.add(nametxt); p4.add(lasttxt);
    p4.add(name); p4.add(last);
    p4.add(warnname); p4.add(warnlast);
    p4.add(emailtxt); p4.add(teltxt);
    p4.add(email); p4.add(tel);
    p4.add(warnemail); p4.add(warntel);
    p4.add(oldpasstxt); p4.add(newpasstxt);
    p4.add(oldpass); p4.add(newpass);
    p4.add(warnpass); p4.add(empt1);
    p4.add(empt2);p4.add(p5);
    
    p5.setLayout(new FlowLayout());
    p5.add(save);
    
    
    //p4.add(warn)
    
    fr.setContentPane(p1);
    fr.setSize(1000,600);
    fr.setVisible(true);
   // fr.pack();
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
}
    
    
    
public void actionPerformed(ActionEvent ev){

}    
    public static void main(String[] args) {
        new Profile();
    }
}
