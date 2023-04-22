/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author s6203101111142
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class Login implements ActionListener {
    private JFrame fr;
    private JPanel p1;
    private JTextField txt1, txt2;
    private JButton b1,b2,b3;
    private LinkedList userData = new LinkedList();
    
    public Login(){
        fr = new JFrame();
        txt1 = new JTextField("Username");
        txt2 = new JTextField("Password");
        b1 = new JButton("Login");
        b2 = new JButton("Admin");
        b3 = new JButton("Sign Up");
        p1 = new JPanel();
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        p1.setLayout(new FlowLayout());
        p1.add(b2);    p1.add(b3);
        
        fr.setLayout(new GridLayout(4,1));
        fr.add(txt1);   fr.add(txt2);   fr.add(b1); fr.add(p1);
        
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
    
    public boolean checkUser(String username, String password){
        String text = "";
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
                text = "WrongPassword" ;
            }
            text = "UserNotFound";
        }
        System.out.println(text);
        return false;
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals(b1)){
            if (checkUser(txt1.getText(), txt2.getText())){
                new Home();
                fr.dispose();
            }
        }
        else if (ae.getSource().equals(b2)){
            new Admin();
        }
        else if (ae.getSource().equals(b3)){
            new SignUp();
        }
    }
}
