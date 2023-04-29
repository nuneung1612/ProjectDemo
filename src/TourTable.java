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
public class TourTable extends JFrame {
    private JPanel p;
    private JScrollPane scrollPane;
    private JTable table;
    private LinkedList <Tour>tourData = new LinkedList<Tour>();
    
    public TourTable(String type, User user) {
        p = new JPanel();

        scrollPane = new JScrollPane();
        p.add(scrollPane);
        // Table
        table = new JTable();
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        table.setRowHeight(50);
        
        // Model for Table
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addColumn("Tour");
        model.addColumn("Date");
        model.addColumn("Time");
        model.addColumn("Route");
        model.addColumn("Available Seat");
        model.addColumn(type);
        
        table.getColumnModel().getColumn(1).setPreferredWidth(20);
        table.getColumnModel().getColumn(2).setPreferredWidth(20);
        table.getColumnModel().getColumn(3).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setMaxWidth(735);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(15);
        
        
        
        for (int i = 0; i < 6; i++){
            table.getColumnModel().getColumn(i).setCellRenderer(new CustomResizableText());
        }
        
        // Data Row
        try(FileInputStream fin = new FileInputStream("TourData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            tourData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.setDefaultEditor(Object.class, null);
        
        
        for (int i = 0; i < tourData.size() && tourData.size() != 0; i++){
            int row = table.getRowCount();
            model.addRow(new Object[0]);
            model.setValueAt((tourData.get(i)).getBusID()+" - "+(tourData.get(i)).getType()+" Tour", row, 0);
            model.setValueAt((tourData.get(i)).getDate(), row, 1);
            model.setValueAt((tourData.get(i)).getTimeOut()+" ➔ " + (tourData.get(i)).getTimeArrive(), row, 2);
            model.setValueAt((tourData.get(i)).getStart()+" ➔ "+ (tourData.get(i)).getEnd(), row, 3);
            model.setValueAt((tourData.get(i)).getSeatAvailable()+"", row, 4);
            model.setValueAt(type, row, 5);
        }
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox(), table, user));
    }
    public TourTable(String type, LinkedList filter, User user) {
            p = new JPanel();
            
            scrollPane = new JScrollPane();
            p.add(scrollPane);
            
            JTable table = new JTable();
            scrollPane.setViewportView(table);
            scrollPane.setPreferredSize(new Dimension(800, 400));
            table.setRowHeight(50);
                        
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.addColumn("Tour");
            model.addColumn("Date");
            model.addColumn("Time");
            model.addColumn("Route");
            model.addColumn("Available Seat");
            model.addColumn(type);
            
            table.getColumnModel().getColumn(1).setPreferredWidth(20);
            table.getColumnModel().getColumn(2).setPreferredWidth(20);
            table.getColumnModel().getColumn(3).setPreferredWidth(300);
            table.getColumnModel().getColumn(3).setMaxWidth(735);
            table.getColumnModel().getColumn(4).setPreferredWidth(10);
            table.getColumnModel().getColumn(5).setPreferredWidth(15);

            for (int i = 0; i < 6; i++){
                table.getColumnModel().getColumn(i).setCellRenderer(new CustomResizableText());
            }
            
            try(FileInputStream fin = new FileInputStream("TourData.dat");
                ObjectInputStream in = new ObjectInputStream(fin);){
                tourData = (LinkedList)in.readObject();
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e);
            }
            for (int i = 0; i < filter.size() ; i++){
                int num = (int)filter.get(i);
                int row = table.getRowCount();
                model.addRow(new Object[0]);
                model.setValueAt((tourData.get(num)).getBusID()+" - "+(tourData.get(num)).getType()+" Tour", row, 0);
                model.setValueAt((tourData.get(num)).getDate(), row, 1);
                model.setValueAt((tourData.get(num)).getTimeOut()+" ➔ " + (tourData.get(num)).getTimeArrive(), row, 2);
                model.setValueAt((tourData.get(num)).getStart()+" ➔ "+ (tourData.get(num)).getEnd(), row, 3);
                model.setValueAt((tourData.get(num)).getSeatAvailable()+"", row, 4);
                model.setValueAt(type, row, 5);
           }
        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox(), table, user));
    }
    public JPanel getTable(){
        return p;
    }
}