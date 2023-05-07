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

public class TicketTable extends JFrame {
    private JPanel p;
    private JScrollPane scrollPane;
    private JTable table;
    private LinkedList <Ticket>ticketData = new LinkedList<Ticket>();
    
    public TicketTable(User user) {
        p = new JPanel();

        scrollPane = new JScrollPane();
        p.add(scrollPane);
        // Table
        table = new JTable();
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        table.setRowHeight(50);
        
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        // Model for Table
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addColumn("From");
        model.addColumn("To");
        model.addColumn("Date");
        model.addColumn("Time");
        model.addColumn("Type");
        model.addColumn("Seat");
        model.addColumn("Detail");
        
        for (int i = 0; i < 6; i++){
            table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
        
        // Data Row
        ticketData = FileIO.loadTicketData();
        
        table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.setDefaultEditor(Object.class, null);
        
        for (int i = 0; i < ticketData.size() && ticketData.size() != 0; i++){
            int row = table.getRowCount();
            model.addRow(new Object[0]);
            
            model.setValueAt(ticketData.get(i).getTour().getStart(), row, 0);
            model.setValueAt(ticketData.get(i).getTour().getEnd(), row, 1);
            model.setValueAt(ticketData.get(i).getTour().getDate(), row, 2);
            model.setValueAt(ticketData.get(i).getTour().getTimeOut()+" ➔ " + ticketData.get(i).getTour().getTimeArrive(), row, 3);
            model.setValueAt(ticketData.get(i).getTour().getType(), row, 4);
            model.setValueAt(ticketData.get(i).getSeat(), row, 5);
            model.setValueAt("Detail", row, 6);
        }
        table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), table, user));
        table.setDefaultRenderer(String.class, centerRenderer);
    }
    
    public JPanel getTable(){
        return this.p;
    }
}

