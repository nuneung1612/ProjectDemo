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

public class TicketTable{
    private JPanel p,p2;
    private JScrollPane scrollPane;
    private JTable table;
    private JLabel l1;
    private LinkedList <Ticket>ticketData = new LinkedList<Ticket>();
    
    public TicketTable(User user) {
        p = new JPanel();
        p2 = new JPanel();
        l1 = new JLabel("Ticket");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 60));
        l1.setBounds(355,33,300,100);
        l1.setForeground(Color.orange);

        scrollPane = new JScrollPane();
        p.add(scrollPane);
        // Table
        table = new JTable();
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        table.setRowHeight(50);
        
        p2.setBackground(new Color(243, 233, 159));
        p2.add(l1, BorderLayout.NORTH);
        p2.add(p);
        
        // Model for Table
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addColumn("ID");
        model.addColumn("Route");
        model.addColumn("Date");
        model.addColumn("Time");
        model.addColumn("Type");
        model.addColumn("Seat");
        model.addColumn("Detail");
        
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(220);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(40);
        table.getColumnModel().getColumn(4).setPreferredWidth(20);
        table.getColumnModel().getColumn(5).setPreferredWidth(20);
        table.getColumnModel().getColumn(6).setPreferredWidth(20);
        
        for (int i = 0; i < 6; i++){
            table.getColumnModel().getColumn(i).setCellRenderer(new CustomResizableText());
        }
        
        // Data Row
        ticketData = user.getTicketData();
        
        table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), table, user));
        table.setDefaultEditor(Object.class, null);
        
        for (int i = 0; i < ticketData.size() && ticketData.size() != 0; i++){
            int row = table.getRowCount();
            model.addRow(new Object[0]);
            
            model.setValueAt(ticketData.get(i).getTicketID(), row, 0);
            model.setValueAt(ticketData.get(i).getTour().getStart()+" ➔ "+ticketData.get(i).getTour().getEnd(), row, 1);
            model.setValueAt(ticketData.get(i).getTour().getDate(), row, 2);
            model.setValueAt(ticketData.get(i).getTour().getTimeOut()+" ➔ " + ticketData.get(i).getTour().getTimeArrive(), row, 3);
            model.setValueAt(ticketData.get(i).getTour().getType(), row, 4);
            model.setValueAt(ticketData.get(i).getSeat(), row, 5);
            model.setValueAt("Detail", row, 6);
        }
    }
    
    public JPanel getTable(){
        return this.p2;
    }
}

