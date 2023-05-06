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
public class UserTable {
    private JPanel p;
    private JScrollPane scrollPane;
    private JTable table;
    private LinkedList userData = new LinkedList();
    private FileIO file = new FileIO();
    
    public UserTable() {
        p = new JPanel();
        // ScrollPane for Table
        scrollPane = new JScrollPane();
        p.add(scrollPane);
        // Table
        table = new JTable();
        scrollPane.setViewportView(table);
        // Model for Table
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addColumn("Username");
        model.addColumn("Name");
        model.addColumn("LastName");
        model.addColumn("Email");
        model.addColumn("Tel.");
        model.addColumn("Remove");
        
        scrollPane.setPreferredSize(new Dimension(800, 400));
        table.setRowHeight(50);
        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox(), table, new User()));
        // Data Row
        userData = file.loadUserData();
        for (int i = 0; i < userData.size() && userData.size() != 0; i++){
            int row = table.getRowCount();
            model.addRow(new Object[0]);
            model.setValueAt(((User)userData.get(i)).getUsername()+"", row, 0);
            model.setValueAt(((User)userData.get(i)).getName(), row, 1);
            model.setValueAt(((User)userData.get(i)).getLastName(), row, 2);
            model.setValueAt(((User)userData.get(i)).getEmail(), row, 3);
            model.setValueAt(((User)userData.get(i)).getTelNumber(), row, 4);
            model.setValueAt("Remove", row, 5);
        }
    }
    public UserTable(LinkedList filter) {
        p = new JPanel();
        // ScrollPane for Table
        scrollPane = new JScrollPane();
        p.add(scrollPane);
        // Table
        table = new JTable();
        scrollPane.setViewportView(table);
        // Model for Table
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addColumn("Username");
        model.addColumn("Name");
        model.addColumn("LastName");
        model.addColumn("Email");
        model.addColumn("Tel.");
        model.addColumn("Remove");
        
        scrollPane.setPreferredSize(new Dimension(800, 400));
        table.setRowHeight(50);
        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox(), table, new User()));
        // Data Row
        userData = file.loadUserData();
        for (int i = 0; i < filter.size() && filter.size() != 0; i++){
            int row = table.getRowCount();
            int num = (int)filter.get(i);
            model.addRow(new Object[0]);
            model.setValueAt(((User)userData.get(num)).getUsername()+"", row, 0);
            model.setValueAt(((User)userData.get(num)).getName(), row, 1);
            model.setValueAt(((User)userData.get(num)).getLastName(), row, 2);
            model.setValueAt(((User)userData.get(num)).getEmail(), row, 3);
            model.setValueAt(((User)userData.get(num)).getTelNumber(), row, 4);
            model.setValueAt("Remove", row, 5);
        }
    }
    
    public JPanel getTable(){
        return p;
    }
}