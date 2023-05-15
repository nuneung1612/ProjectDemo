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
public class UserTable {
    private JPanel p;
    private JScrollPane scrollPane;
    private JTable table;
    private LinkedList <User> userData = new LinkedList<User>();
    
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
        model.addColumn("Email");
        model.addColumn("Tel.");
        model.addColumn("Remove");
        
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(40);
        table.getColumnModel().getColumn(4).setPreferredWidth(20);
        
        scrollPane.setPreferredSize(new Dimension(800, 400));
        table.setRowHeight(50);
        table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox(), table, new User()));
        for(int i = 0; i<4;i++){
            table.getColumnModel().getColumn(i).setCellRenderer(new CustomResizableText());
        }
        // Data Row
        userData = FileIO.loadUserData();
        for (int i = 0; i < userData.size() && userData.size() != 0; i++){
            int row = table.getRowCount();
            model.addRow(new Object[0]);
            model.setValueAt((userData.get(i)).getUsername()+"", row, 0);
            model.setValueAt(userData.get(i).getName().substring(0, 1).toUpperCase()+userData.get(i).getName().substring(1).toLowerCase()+
                    " "+userData.get(i).getLastName().substring(0, 1).toUpperCase()+userData.get(i).getLastName().substring(1).toLowerCase(), row, 1);
            model.setValueAt((userData.get(i)).getEmail(), row, 2);
            model.setValueAt((userData.get(i)).getTelNumber(), row, 3);
            model.setValueAt("Remove", row, 4);
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
        model.addColumn("Email");
        model.addColumn("Tel.");
        model.addColumn("Remove");
        
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(40);
        table.getColumnModel().getColumn(4).setPreferredWidth(20);
        
        scrollPane.setPreferredSize(new Dimension(800, 400));
        table.setRowHeight(50);
        table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox(), table, new User()));
        for(int i = 0; i<4;i++){
            table.getColumnModel().getColumn(i).setCellRenderer(new CustomResizableText());
        }
        // Data Row
        userData = FileIO.loadUserData();
        for (int i = 0; i < filter.size() && filter.size() != 0; i++){
            int row = table.getRowCount();
            int num = (int)filter.get(i);
            model.addRow(new Object[0]);
            model.setValueAt((userData.get(num)).getUsername()+"", row, 0);
            model.setValueAt(userData.get(num).getName().substring(0, 1).toUpperCase()+userData.get(num).getName().substring(1).toLowerCase()+
                    " "+userData.get(num).getLastName().substring(0, 1).toUpperCase()+userData.get(num).getLastName().substring(1).toLowerCase(), row, 1);
            model.setValueAt((userData.get(num)).getEmail(), row, 2);
            model.setValueAt((userData.get(num)).getTelNumber(), row, 3);
            model.setValueAt("Remove", row, 4);
        }
    }
    public JPanel getTable(){
        return p;
    }
}