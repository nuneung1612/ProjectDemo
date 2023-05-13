/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author s6203101111142
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
public class TourTable{
    private JPanel p;
    private JScrollPane scrollPane;
    private JTable table;
    private LinkedList <Tour>tourData = new LinkedList<Tour>();
    private ImageIcon imbin = new ImageIcon(getClass().getResource("images/bin.png"));
    private Image sizebin = imbin.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    private ImageIcon imbins = new ImageIcon(sizebin);
    
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
        model.addColumn("Price");
        model.addColumn(type);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(10);
        table.getColumnModel().getColumn(6).setPreferredWidth(30);
        
        
        for (int i = 0; i < 7; i++){
            table.getColumnModel().getColumn(i).setCellRenderer(new CustomResizableText());
        }
        
        // Data Row
        tourData = FileIO.loadTourData();
        
        if (type.equals("Delete")){
            table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(imbins));
            table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), table, user, imbins));
        }
        else{
            table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
            table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), table, user));
        }
        table.setDefaultEditor(Object.class, null);
        
        
        for (int i = 0; i < tourData.size() && tourData.size() != 0; i++){
            int row = table.getRowCount();
            model.addRow(new Object[0]);
            model.setValueAt((tourData.get(i)).getBusID()+" - "+(tourData.get(i)).getType()+" Tour", row, 0);
            model.setValueAt((tourData.get(i)).getDate(), row, 1);
            model.setValueAt((tourData.get(i)).getTimeOut()+" ➔ " + (tourData.get(i)).getTimeArrive(), row, 2);
            model.setValueAt((tourData.get(i)).getStart()+" ➔ "+ (tourData.get(i)).getEnd(), row, 3);
            model.setValueAt((tourData.get(i)).getSeatAvailable()+"", row, 4);
            model.setValueAt((tourData.get(i)).getPrice()+"", row, 5);
            model.setValueAt(type, row, 6);
        }
        
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
            model.addColumn("Price");
            model.addColumn(type);
            
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(40);
            table.getColumnModel().getColumn(2).setPreferredWidth(50);
            table.getColumnModel().getColumn(3).setPreferredWidth(220);
            table.getColumnModel().getColumn(4).setPreferredWidth(10);
            table.getColumnModel().getColumn(5).setPreferredWidth(10);
            table.getColumnModel().getColumn(6).setPreferredWidth(30);

            for (int i = 0; i < 7; i++){
                table.getColumnModel().getColumn(i).setCellRenderer(new CustomResizableText());
            }
            
            tourData = FileIO.loadTourData();
            for (int i = 0; i < filter.size() ; i++){
                int num = (int)filter.get(i);
                int row = table.getRowCount();
                model.addRow(new Object[0]);
                model.setValueAt((tourData.get(num)).getBusID()+" - "+(tourData.get(num)).getType()+" Tour", row, 0);
                model.setValueAt((tourData.get(num)).getDate(), row, 1);
                model.setValueAt((tourData.get(num)).getTimeOut()+" ➔ " + (tourData.get(num)).getTimeArrive(), row, 2);
                model.setValueAt((tourData.get(num)).getStart()+" ➔ "+ (tourData.get(num)).getEnd(), row, 3);
                model.setValueAt((tourData.get(num)).getSeatAvailable()+"", row, 4);
                model.setValueAt((tourData.get(num)).getPrice()+"", row, 5);
                model.setValueAt(type, row, 6);
           }
        table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), table, user));
    }
    public JPanel getTable(){
        return p;
    }
}