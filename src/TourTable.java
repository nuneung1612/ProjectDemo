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
        scrollPane.setPreferredSize(new Dimension(700, 400));
        table.setRowHeight(20);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        // Model for Table
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addColumn("ID");
        model.addColumn("Date");
        model.addColumn("Time");
        model.addColumn("Start");
        model.addColumn("End");
        model.addColumn("Type");
        model.addColumn("Seat");
        model.addColumn("Available");
        model.addColumn(type);
        
        for (int i = 0; i < 9; i++){
            table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
        
        // Data Row
        try(FileInputStream fin = new FileInputStream("TourData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            tourData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        table.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.setDefaultEditor(Object.class, null);
        
        
        for (int i = 0; i < tourData.size() && tourData.size() != 0; i++){
            int row = table.getRowCount();
            model.addRow(new Object[0]);
            model.setValueAt((tourData.get(i)).getBusID(), row, 0);
            model.setValueAt((tourData.get(i)).getDate(), row, 1);
            model.setValueAt((tourData.get(i)).getTime(), row, 2);
            model.setValueAt((tourData.get(i)).getStart(), row, 3);
            model.setValueAt((tourData.get(i)).getEnd(), row, 4);
            model.setValueAt((tourData.get(i)).getType(), row, 5);
            model.setValueAt((tourData.get(i)).getSeat()+"", row, 6);
            model.setValueAt((tourData.get(i)).getSeatAvailable()+"", row, 7);
            model.setValueAt(type, row, 8);
        }
        table.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(new JCheckBox(), table, user));
        table.setDefaultRenderer(String.class, centerRenderer);
    }
    public TourTable(String type, LinkedList filter, User user) {
            p = new JPanel();
            
            scrollPane = new JScrollPane();
            p.add(scrollPane);
            
            JTable table = new JTable();
            scrollPane.setViewportView(table);
            scrollPane.setPreferredSize(new Dimension(700, 400));
            table.setRowHeight(20);
            
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            model.addColumn("ID");
            model.addColumn("Date");
            model.addColumn("Time");
            model.addColumn("Start");
            model.addColumn("End");
            model.addColumn("Type");
            model.addColumn("Seat");
            model.addColumn("Available");
            model.addColumn(type);
            
            for (int i = 0; i < 9; i++){
                table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
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
                model.setValueAt((tourData.get(num)).getBusID(), row, 0);
                model.setValueAt((tourData.get(num)).getDate(), row, 1);
                model.setValueAt((tourData.get(num)).getTime(), row, 2);
                model.setValueAt((tourData.get(num)).getStart(), row, 3);
                model.setValueAt((tourData.get(num)).getEnd(), row, 4);
                model.setValueAt((tourData.get(num)).getType(), row, 5);
                model.setValueAt((tourData.get(num)).getSeat()+"", row, 6);
                model.setValueAt((tourData.get(num)).getSeatAvailable()+"", row, 7);
                model.setValueAt(type, row, 8);
           }
        table.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(new JCheckBox(), table, user));
    }
    public JPanel getTable(){
        return p;
    }
}