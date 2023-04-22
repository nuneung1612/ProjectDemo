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
public class SignUp implements ActionListener {
    private JTextField txt1,txt2,txt3,txt4,txt5,txt6;
    private JButton b1;
    private JDialog d1;
    
    public SignUp(){
        txt1 = new JTextField("Name");
        txt2 = new JTextField("LastName");
        txt3 = new JTextField("Email");
        txt4 = new JTextField("Tel.");
        txt5 = new JTextField("Username");
        txt6 = new JTextField("Password");
        b1 = new JButton("SignUp");
        d1 = new JDialog(d1, "SignUp", true);
        
        b1.addActionListener(this);
        
        d1.setLayout(new GridLayout(7,1));
        d1.add(txt1);
        d1.add(txt2);
        d1.add(txt3);
        d1.add(txt4);
        d1.add(txt5);
        d1.add(txt6);
        d1.add(b1);
        
        d1.pack();
        d1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        d1.setVisible(true);
    }
        
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals(b1)){
            new User(txt1.getText(),txt2.getText(),txt3.getText(),txt4.getText(),txt5.getText(),txt6.getText());
            d1.dispose();
        }
     
    }
    
}
