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
        model.addColumn("Name");
        model.addColumn("LastName");
        model.addColumn("Email");
        model.addColumn("Tel.");
        model.addColumn("Username");
        // Data Row
        try(FileInputStream fin = new FileInputStream("UserData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            userData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        for (int i = 0; i < userData.size() && userData.size() != 0; i++){
            int row = table.getRowCount();
            model.addRow(new Object[0]);
            model.setValueAt(((User)userData.get(i)).getName(), row, 0);
            model.setValueAt(((User)userData.get(i)).getLastName(), row, 1);
            model.setValueAt(((User)userData.get(i)).getEmail(), row, 2);
            model.setValueAt(((User)userData.get(i)).getTelNumber(), row, 3);
            model.setValueAt(((User)userData.get(i)).getUsername()+"", row, 4);
        }
       }
    public JPanel getTable(){
        return p;
    }
}