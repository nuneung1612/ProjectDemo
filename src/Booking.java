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
public class Booking {
   private JDialog fr;
   private JLabel l1;
   
   public Booking(String type){
       fr = new JDialog(fr,true);
       l1 = new JLabel(type);
       
       fr.add(l1);
       
       fr.setSize(600,300);
       fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       fr.setVisible(true);
   }
}