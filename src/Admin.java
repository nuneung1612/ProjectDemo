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
public class Admin implements ActionListener{
    private JFrame fr;
    private JPanel p1,p2,p3,p4,tourTable,userTable;
    private JButton b1,b2,b3;
    private JLabel l1,l2,l3;
    private JComboBox cb1, cb2, cb3,cb4,cb5,cb6;
    private LinkedList tourData = new LinkedList();
    
    public Admin(){
        fr = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        b1 = new JButton("User");
        b2 = new JButton("Tour");
        b3 = new JButton("Add");
        l1 = new JLabel("start");
        l2 = new JLabel("End");
        l3 = new JLabel("date");
        cb1 = new JComboBox();
        cb2 = new JComboBox();
        cb3 = new JComboBox();
        cb4 = new JComboBox();
        cb5 = new JComboBox();
        cb6 = new JComboBox();
        tourTable = new TourTable().getTable();
        userTable = new UserTable().getTable();
        cb1.addItem("Bankkok");
        cb2.addItem("ChaingMai");
        cb3.addItem("1");
        cb3.addItem("2");
        cb3.addItem("3");
        cb4.addItem("Jun");
        cb4.addItem("Feb");
        cb5.addItem("2023");
        cb6.addItem("Economy");
        cb6.addItem("Businuss");
        cb6.addItem("FirstClass");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
         
        p1.setLayout(new GridLayout(2,1));
        p1.add(b1);     p1.add(b2);
        
        p2.setLayout(new FlowLayout());
        p2.add(l1);     p2.add(cb1);    p2.add(l2);     p2.add(cb2);
        
        p3.setLayout(new FlowLayout());
        p3.add(l3);     p3.add(cb3);    p3.add(cb4);    p3.add(cb5);    p3.add(cb6);    p3.add(b3);
        
        p4.setLayout(new GridLayout(2,1));
        p4.add(p2);     p4.add(p3);
        
        fr.add(p1, BorderLayout.WEST);
        fr.add(p4, BorderLayout.NORTH);
        fr.add(tourTable);
        
        fr.setSize(1000,600);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String id = String.format("%04d", tourData.size());
        String date = (String)cb3.getSelectedItem()+"/"+(String)cb4.getSelectedItem()+"/"+(String)cb5.getSelectedItem();
        if (ae.getSource().equals(b1)){
            fr.remove(tourTable);
            fr.remove(p4);
            fr.add(userTable);
            fr.revalidate();
        }
        else if (ae.getSource().equals(b2)){
            fr.remove(userTable);
            fr.add(p4, BorderLayout.NORTH);
            fr.add(tourTable);
            fr.revalidate();
        }
        else if (ae.getSource().equals(b3)){
            new Tour(date, id, (String)cb1.getSelectedItem(),(String)cb2.getSelectedItem(),30,30,(String)cb6.getSelectedItem());
            fr.remove(tourTable);
            tourTable = new TourTable().getTable();
            fr.add(tourTable);
            fr.revalidate();
        }
    }
}
