/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author s6203101111142
 */
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
public class TourTable {
    private JPanel p;
    private JScrollPane scrollPane;
    private JTable table;
    private LinkedList tourData = new LinkedList();
    
    public TourTable() {
        p = new JPanel();
        // ScrollPane for Table
        scrollPane = new JScrollPane();
        p.add(scrollPane);
        // Table
        table = new JTable();
        scrollPane.setViewportView(table);
        // Model for Table
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addColumn("ID");
        model.addColumn("Time");
        model.addColumn("Start");
        model.addColumn("End");
        model.addColumn("Type");
        model.addColumn("Seat");
        model.addColumn("Available");
        // Data Row
        try(FileInputStream fin = new FileInputStream("TourData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            tourData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        for (int i = 0; i < tourData.size() && tourData.size() != 0; i++){
            int row = table.getRowCount();
            model.addRow(new Object[0]);
            model.setValueAt(((Tour)tourData.get(i)).getBusID(), row, 0);
            model.setValueAt(((Tour)tourData.get(i)).getTime(), row, 1);
            model.setValueAt(((Tour)tourData.get(i)).getStart(), row, 2);
            model.setValueAt(((Tour)tourData.get(i)).getEnd(), row, 3);
            model.setValueAt(((Tour)tourData.get(i)).getType(), row, 4);
            model.setValueAt(((Tour)tourData.get(i)).getSeat()+"", row, 5);
            model.setValueAt(((Tour)tourData.get(i)).getSeatAvailable()+"", row, 6);
        }
       }
    public JPanel getTable(){
        return p;
    }
}
