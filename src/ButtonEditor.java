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
import java.util.LinkedList;
import javax.swing.*;
class ButtonEditor extends DefaultCellEditor implements ActionListener {
   private JButton btn;
   private String lbl;
   private LinkedList <Tour>tourData = new LinkedList<Tour>();
   private LinkedList userData = new LinkedList();
   private JTable table;
   private User user;
   private ImageIcon icon;

   public ButtonEditor(JCheckBox txt, JTable table, User user) {
    super(txt);
    
    btn=new JButton();
    btn.setOpaque(true);
    this.table = table;
    this.user = user;
    
    btn.addActionListener(this);
  }
   
   public ButtonEditor(JCheckBox txt, JTable table, User user, ImageIcon icon) {
        super(txt);
    
        btn=new JButton();
        btn.setOpaque(true);
        this.table = table;
        this.user = user;
        this.icon = icon;
        lbl = null;

        btn.addActionListener(this);
        
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
   }

   @Override
  public Component getTableCellEditorComponent(JTable table, Object obj,
    boolean selected, int row, int col) {
    
    btn.setIcon(icon == null ? null: icon);
    lbl=(obj==null) ? "":obj.toString();
    btn.setText(lbl);
    return btn;
    }
  
    @Override
      public void actionPerformed(ActionEvent e) {
        tourData = FileIO.loadTourData();
        userData = FileIO.loadUserData();
        
        int row = table.getSelectedRow();
        if (table.getColumnModel().getColumn(table.getColumnCount()-1).getHeaderValue().equals("Enter") && table.getSelectedColumn() == table.getColumnCount()-1){
            String id = ((String)table.getValueAt(row, 0)).substring(0,4);
            for (int i = 0; i < tourData.size() && tourData.size() != 0; i++){
                if (tourData.get(i).getBusID().equals(id)){
                    new Booking((tourData.get(i)),user, true);
                    break;
                }
            }
        }
         else if (table.getColumnModel().getColumn(table.getColumnCount()-1).getHeaderValue().equals("Delete") && table.getSelectedColumn() == table.getColumnCount()-1){
            int x = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete", JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION){
                tourData.remove(row);
            }
        }
        else if (table.getColumnModel().getColumn(table.getColumnCount()-1).getHeaderValue().equals("Remove") && table.getSelectedColumn() == table.getColumnCount()-1){
            int x = JOptionPane.showConfirmDialog(null, "Are you sure?", "Remove", JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION){
                userData.remove(row);
            }
        }
        else if (table.getColumnModel().getColumn(table.getColumnCount()-1).getHeaderValue().equals("Detail") && table.getSelectedColumn() == table.getColumnCount()-1){
            String id = ((String)table.getValueAt(row, 0));
            for (int i = 0; i < user.getTicketData().size() && user.getTicketData().size() != 0; i++){
                if (user.getTicketData().get(i).getTicketID().equals(id)){
                    new TicketDetail(user.getTicketData().get(i), user);
                }
            }
        }
        else if (table.getColumnModel().getColumn(table.getColumnCount()-2).getHeaderValue().equals("Available") && table.getSelectedColumn() == table.getColumnCount()-2){
            String id = ((String)table.getValueAt(row, 0)).substring(0,4);
            for (int i = 0; i < tourData.size() && tourData.size() != 0; i++){
                if (tourData.get(i).getBusID().equals(id)){
                    new Booking((tourData.get(i)),user, false);
                    break;
                }
            }
        }
        FileIO.saveTourData(tourData);
        FileIO.saveUserData(userData);
    }
}

