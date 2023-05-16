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
import java.util.LinkedList;
import javax.swing.*;
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
    private LinkedList<JCheckBox> allSeatArray = new LinkedList<JCheckBox>();
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
        b1 = new JButton("Submit");
        
        b1.addActionListener(this);
        b1.setBackground(Color.orange);
        b1.setBorderPainted(false);

        
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
        
        
        seatA1.setOpaque(false);   seatA2.setOpaque(false);  seatA3.setOpaque(false);   seatA4.setOpaque(false);
        seatA5.setOpaque(false);   seatA6.setOpaque(false); seatA7.setOpaque(false);   seatA8.setOpaque(false);
        seatA9.setOpaque(false);   seatA10.setOpaque(false); seatB1.setOpaque(false);   seatB2.setOpaque(false);
        seatB3.setOpaque(false);  seatB4.setOpaque(false); seatB5.setOpaque(false);seatB6.setOpaque(false);
        seatB7.setOpaque(false);  seatB8.setOpaque(false);  seatB9.setOpaque(false);   seatB10.setOpaque(false);
        seatC1.setOpaque(false); seatC2.setOpaque(false);seatC3.setOpaque(false);   seatC4.setOpaque(false);
        seatC5.setOpaque(false);  seatC6.setOpaque(false);  seatC7.setOpaque(false);seatC8.setOpaque(false);
        seatC9.setOpaque(false); seatC10.setOpaque(false);seatD1.setOpaque(false);seatD2.setOpaque(false);
        seatD3.setOpaque(false);  seatD4.setOpaque(false);   seatD5.setOpaque(false);  seatD6.setOpaque(false);
        seatD7.setOpaque(false);   seatD8.setOpaque(false);   seatD9.setOpaque(false);  seatD10.setOpaque(false);
        
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
        
        allSeatArray.add(seatA1);      allSeatArray.add(seatA2);      allSeatArray.add(seatA3);      allSeatArray.add(seatA4);
        allSeatArray.add(seatA5);      allSeatArray.add(seatA6);      allSeatArray.add(seatA7);      allSeatArray.add(seatA8);
        allSeatArray.add(seatA9);      allSeatArray.add(seatA10);      allSeatArray.add(seatB1);      allSeatArray.add(seatB2);
        allSeatArray.add(seatB3);      allSeatArray.add(seatB4);      allSeatArray.add(seatB5);      allSeatArray.add(seatB6);
        allSeatArray.add(seatB7);      allSeatArray.add(seatB8);      allSeatArray.add(seatB9);      allSeatArray.add(seatB10);
        allSeatArray.add(seatC1);      allSeatArray.add(seatC2);      allSeatArray.add(seatC3);      allSeatArray.add(seatC4);
        allSeatArray.add(seatC5);      allSeatArray.add(seatC6);      allSeatArray.add(seatC7);      allSeatArray.add(seatC8);
        allSeatArray.add(seatC9);      allSeatArray.add(seatC10);      allSeatArray.add(seatD1);      allSeatArray.add(seatD2);
        allSeatArray.add(seatD3);      allSeatArray.add(seatD4);      allSeatArray.add(seatD5);      allSeatArray.add(seatD6);
        allSeatArray.add(seatD7);      allSeatArray.add(seatD8);      allSeatArray.add(seatD9);      allSeatArray.add(seatD10);
        
        setSeat(tour);
        p = setSeatPanel(tour);
        
        p1.setLayout(new FlowLayout());
        p1.add(lTotal);     p1.add(b1);
        p.setBackground(Color.white);
        p1.setBackground(Color.white);
               
        
        fr.add(p);
        fr.add(p1, BorderLayout.SOUTH);

        fr.setSize(300,600);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
    }
    
    public void setSeat(TourPackage tour){
        int n = 0;
        for (int i = 0; i < tour.getSeat()+n; i++){
            if (tour.getSeat()%7 == 0 && i%10 > 6){
                n++;
            }else{
                seatArray.add(allSeatArray.get(i));
            }
        }
        int i = 0;
        for (boolean booked: tour.getAvailableSeat()){
                seatArray.get(i).setEnabled(booked);
                i++;
        }
    }
    
    public JPanel setSeatPanel(TourPackage tour){
        if (tour.getSeat()%7 == 0){
            p.setLayout(new GridLayout(7,5));
            for (int i = 0; i < 7; i++){
                
                p.add(seatArray.get(i));
                p.add(new JLabel());
                p.add(new JLabel());
                p.add(seatArray.get(i+7));
                p.add(seatArray.get(i+14));
            }
        }else{
            p.setLayout(new GridLayout(10,5));
            if (tour.getSeat() == 20){
                for (int i = 0; i < 10; i++){
                    p.add(seatArray.get(i));
                    p.add(new JLabel());
                    p.add(new JLabel());
                    p.add(seatArray.get(i+10));
                    p.add(new JLabel());
                }
            }else{
                for (int i = 0; i < 10; i++){
                    p.add(seatArray.get(i));
                    p.add(seatArray.get(i+10));
                    p.add(new JLabel());
                    p.add(seatArray.get(i+20));
                    p.add(seatArray.get(i+30));
                }
            } 
        }
        return p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fr.dispose();
        new ConfirmPayment(tour, user, seatSelect);
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