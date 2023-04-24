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
import java.io.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.table.*;
public class Booking implements ActionListener, ItemListener {
    
    private JDialog fr;
    private JPanel p, p1;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,lA,lB,lC,lD,lTotal;
    private Tour tour;
    private JButton b1;
    private JCheckBox seatA1,seatA2,seatA3,seatA4,seatA5,seatA6,seatA7,seatA8,seatA9,seatA10;
    private JCheckBox seatB1,seatB2,seatB3,seatB4,seatB5,seatB6,seatB7,seatB8,seatB9,seatB10;
    private JCheckBox seatC1,seatC2,seatC3,seatC4,seatC5,seatC6,seatC7,seatC8,seatC9,seatC10;
    private JCheckBox seatD1,seatD2,seatD3,seatD4,seatD5,seatD6,seatD7,seatD8,seatD9,seatD10;
    private LinkedList<JCheckBox> seatArray = new LinkedList<JCheckBox>();
    private LinkedList<String> seatSelect = new LinkedList<String>();
    private int selectSeat = 0;
    private User user;
    
   
    public Booking(Tour tour, User user){
        fr = new JDialog(fr, "Booking(" + tour.getBusID()+"/"+tour.getType()+")",true);
        this.tour = tour;
        this.user = user;
        
        p = new JPanel();
        p1 = new JPanel();
        l1 = new JLabel("1");
        l2 = new JLabel("2");
        l3 = new JLabel("3");
        l4 = new JLabel("4");
        l5 = new JLabel("5");
        l6 = new JLabel("6");
        l7 = new JLabel("7");
        l8 = new JLabel("8");
        l9 = new JLabel("9");
        l10 = new JLabel("10");
        lA = new JLabel("A");
        lB = new JLabel("B");
        lC = new JLabel("C");
        lD = new JLabel("D");
        lTotal = new JLabel("Total: "+this.selectSeat+" is select.");
        b1 = new JButton("Summit");
        
        b1.addActionListener(this);
        
        seatA1 = new JCheckBox("A1");   seatA2 = new JCheckBox("A2");   seatA3 = new JCheckBox("A3");   seatA4 = new JCheckBox("A4");
        seatA5 = new JCheckBox("A5");   seatA6 = new JCheckBox("A6");   seatA7 = new JCheckBox("A7");   seatA8 = new JCheckBox("A8");
        seatA9 = new JCheckBox("A9");   seatA10 = new JCheckBox("A10"); seatB1 = new JCheckBox("B1");   seatB2 = new JCheckBox("B2");
        seatB3 = new JCheckBox("B3");   seatB4 = new JCheckBox("B4");   seatB5 = new JCheckBox("B5");   seatB6 = new JCheckBox("B6");
        seatB7 = new JCheckBox("B7");   seatB8 = new JCheckBox("B8");   seatB9 = new JCheckBox("B9");   seatB10 = new JCheckBox("B10");
        seatC1 = new JCheckBox("C1");   seatC2 = new JCheckBox("C2");   seatC3 = new JCheckBox("C3");   seatC4 = new JCheckBox("C4");
        seatC5 = new JCheckBox("C5");   seatC6 = new JCheckBox("C6");   seatC7 = new JCheckBox("C7");   seatC8 = new JCheckBox("C8");
        seatC9 = new JCheckBox("C9");   seatC10 = new JCheckBox("C10"); seatD1 = new JCheckBox("D1");   seatD2 = new JCheckBox("D2");
        seatD3 = new JCheckBox("D3");   seatD4 = new JCheckBox("D4");   seatD5 = new JCheckBox("D5");   seatD6 = new JCheckBox("D6");
        seatD7 = new JCheckBox("D7");   seatD8 = new JCheckBox("D8");   seatD9 = new JCheckBox("D9");   seatD10 = new JCheckBox("D10");
        
        seatA1.addItemListener(this);     seatA2.addItemListener(this);     seatA3.addItemListener(this);     seatA4.addItemListener(this);
        seatA5.addItemListener(this);     seatA6.addItemListener(this);     seatA7.addItemListener(this);     seatA8.addItemListener(this);
        seatA9.addItemListener(this);     seatA10.addItemListener(this);     seatB1.addItemListener(this);     seatB2.addItemListener(this);
        seatB3.addItemListener(this);     seatB4.addItemListener(this);     seatB5.addItemListener(this);     seatB6.addItemListener(this);
        seatB7.addItemListener(this);     seatB8.addItemListener(this);     seatB9.addItemListener(this);     seatB10.addItemListener(this);
        seatC1.addItemListener(this);     seatC2.addItemListener(this);     seatC3.addItemListener(this);     seatC4.addItemListener(this);
        seatC5.addItemListener(this);     seatC6.addItemListener(this);     seatC7.addItemListener(this);     seatC8.addItemListener(this);
        seatC9.addItemListener(this);     seatC10.addItemListener(this);     seatD1.addItemListener(this);     seatD2.addItemListener(this);
        seatD3.addItemListener(this);     seatD4.addItemListener(this);     seatD5.addItemListener(this);     seatD6.addItemListener(this);
        seatD7.addItemListener(this);     seatD8.addItemListener(this);     seatD9.addItemListener(this);     seatD10.addItemListener(this);

        if (tour instanceof EconomyTour){
            seatArray.add(seatA1);      seatArray.add(seatA2);      seatArray.add(seatA3);      seatArray.add(seatA4);
            seatArray.add(seatA5);      seatArray.add(seatA6);      seatArray.add(seatA7);      seatArray.add(seatA8);
            seatArray.add(seatA9);      seatArray.add(seatA10);      seatArray.add(seatB1);      seatArray.add(seatB2);
            seatArray.add(seatB3);      seatArray.add(seatB4);      seatArray.add(seatB5);      seatArray.add(seatB6);
            seatArray.add(seatB7);      seatArray.add(seatB8);      seatArray.add(seatB9);      seatArray.add(seatB10);
            seatArray.add(seatC1);      seatArray.add(seatC2);      seatArray.add(seatC3);      seatArray.add(seatC4);
            seatArray.add(seatC5);      seatArray.add(seatC6);      seatArray.add(seatC7);      seatArray.add(seatC8);
            seatArray.add(seatC9);      seatArray.add(seatC10);      seatArray.add(seatD1);      seatArray.add(seatD2);
            seatArray.add(seatD3);      seatArray.add(seatD4);      seatArray.add(seatD5);      seatArray.add(seatD6);
            seatArray.add(seatD7);      seatArray.add(seatD8);      seatArray.add(seatD9);      seatArray.add(seatD10);
            
            int i = 0;
            for (boolean booked: ((EconomyTour) tour).getAvailableSeat()){
                seatArray.get(i).setEnabled(booked);
                i++;
            }
            
            p.setLayout(new GridLayout(11,6));
            p.add(new JLabel());   p.add(lA);  p.add(lB);  p.add(new JLabel());  p.add(lC);  p.add(lD);
            p.add(l1);  p.add(seatA1);   p.add(seatB1);  p.add(new JLabel());   p.add(seatC1);  p.add(seatD1);
            p.add(l2);  p.add(seatA2);   p.add(seatB2);  p.add(new JLabel());   p.add(seatC2);  p.add(seatD2);
            p.add(l3);  p.add(seatA3);   p.add(seatB3);  p.add(new JLabel());   p.add(seatC3);  p.add(seatD3);
            p.add(l4);  p.add(seatA4);   p.add(seatB4);  p.add(new JLabel());   p.add(seatC4);  p.add(seatD4);
            p.add(l5);  p.add(seatA5);   p.add(seatB5);  p.add(new JLabel());   p.add(seatC5);  p.add(seatD5);
            p.add(l6);  p.add(seatA6);   p.add(seatB6);  p.add(new JLabel());   p.add(seatC6);  p.add(seatD6);
            p.add(l7);  p.add(seatA7);   p.add(seatB7);  p.add(new JLabel());   p.add(seatC7);  p.add(seatD7);
            p.add(l8);  p.add(seatA8);   p.add(seatB8);  p.add(new JLabel());   p.add(seatC8);  p.add(seatD8);
            p.add(l9);  p.add(seatA9);   p.add(seatB9);  p.add(new JLabel());   p.add(seatC9);  p.add(seatD9);
            p.add(l10);  p.add(seatA10);   p.add(seatB10);  p.add(new JLabel());   p.add(seatC10);  p.add(seatD10);
            
        }else if(tour instanceof BusinessTour){
            seatArray.add(seatA1);      seatArray.add(seatA2);      seatArray.add(seatA3);      seatArray.add(seatA4);
            seatArray.add(seatA5);      seatArray.add(seatA6);      seatArray.add(seatA7);       seatArray.add(seatB1);      
            seatArray.add(seatB2);
            seatArray.add(seatB3);      seatArray.add(seatB4);      seatArray.add(seatB5);      seatArray.add(seatB6);
            seatArray.add(seatB7);
            seatArray.add(seatC1);      seatArray.add(seatC2);      seatArray.add(seatC3);      seatArray.add(seatC4);
            seatArray.add(seatC5);      seatArray.add(seatC6);      seatArray.add(seatC7);      
            
            int i = 0;
            for (boolean booked: ((BusinessTour) tour).getAvailableSeat()){
                seatArray.get(i).setEnabled(booked);
                i++;
            }
            
            p.setLayout(new GridLayout(8,6));
            p.add(new JLabel());   p.add(lA);  p.add(new JLabel());  p.add(new JLabel());  p.add(lB);  p.add(lC);
            p.add(l1);  p.add(seatA1);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB1);  p.add(seatC1);
            p.add(l2);  p.add(seatA2);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB2);  p.add(seatC2);
            p.add(l3);  p.add(seatA3);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB3);  p.add(seatC3);
            p.add(l4);  p.add(seatA4);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB4);  p.add(seatC4);
            p.add(l5);  p.add(seatA5);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB5);  p.add(seatC5);
            p.add(l6);  p.add(seatA6);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB6);  p.add(seatC6);
            p.add(l7);  p.add(seatA7);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB7);  p.add(seatC7);
        }else if(tour instanceof FirstClassTour){
            seatArray.add(seatA1);      seatArray.add(seatA2);      seatArray.add(seatA3);      seatArray.add(seatA4);
            seatArray.add(seatA5);      seatArray.add(seatA6);      seatArray.add(seatA7);      seatArray.add(seatA8);
            seatArray.add(seatA9);      seatArray.add(seatA10);      seatArray.add(seatB1);      seatArray.add(seatB2);
            seatArray.add(seatB3);      seatArray.add(seatB4);      seatArray.add(seatB5);      seatArray.add(seatB6);
            seatArray.add(seatB7);      seatArray.add(seatB8);      seatArray.add(seatB9);      seatArray.add(seatB10);
            
            int i = 0;
            for (boolean booked: ((FirstClassTour) tour).getAvailableSeat()){
                seatArray.get(i).setEnabled(booked);
                i++;
            }
            
            p.setLayout(new GridLayout(11,6));
            p.add(new JLabel());   p.add(lA);  p.add(new JLabel());  p.add(new JLabel());  p.add(lB);  p.add(new JLabel());
            p.add(l1);  p.add(seatA1);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB1);  p.add(new JLabel());
            p.add(l2);  p.add(seatA2);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB2);  p.add(new JLabel());
            p.add(l3);  p.add(seatA3);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB3);  p.add(new JLabel());
            p.add(l4);  p.add(seatA4);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB4);  p.add(new JLabel());
            p.add(l5);  p.add(seatA5);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB5);  p.add(new JLabel());
            p.add(l6);  p.add(seatA6);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB6);  p.add(new JLabel());
            p.add(l7);  p.add(seatA7);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB7);  p.add(new JLabel());
            p.add(l8);  p.add(seatA8);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB8);  p.add(new JLabel());
            p.add(l9);  p.add(seatA9);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB9);  p.add(new JLabel());
            p.add(l10);  p.add(seatA10);   p.add(new JLabel());  p.add(new JLabel());   p.add(seatB10);  p.add(new JLabel());
        }
        p1.setLayout(new FlowLayout());
        p1.add(lTotal);     p1.add(b1);
        
        fr.add(p);
        fr.add(p1, BorderLayout.SOUTH);

        fr.setSize(600,300);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
    }
    
    public int seatToNum(String seat){
        String letter = seat.substring(0, 1);
        int num = Integer.parseInt(seat.substring(1));
        if(tour instanceof BusinessTour){
            if (letter.equals("B")){
                num += 7;
            }else if (letter.equals("C")){
                num += 14;
            }
        }else{
            if (letter.equals("B")){
                num += 10;
            }else if(letter.equals("C")){
                num += 20;
            }else if (letter.equals("D")){
                num += 30;
            }
        }
        return num-1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(String a: seatSelect){
            new Ticket(user.getUsername(),tour.getBusID(),a);
            tour.setBookSeat(seatToNum(a));
        }
        fr.dispose();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
         if (e.getStateChange() == ItemEvent.SELECTED) {
            selectSeat++;
            seatSelect.add(((JCheckBox)e.getSource()).getText());
        }else{
            selectSeat--;
            seatSelect.remove(((JCheckBox)e.getSource()).getText());
        }
        lTotal.setText("Total: "+this.selectSeat+" is select.");
    }
    
}