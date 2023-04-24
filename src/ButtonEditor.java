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
import java.io.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.table.*;
class ButtonEditor extends DefaultCellEditor
{
   protected JButton btn;
   private String lbl;
   private Boolean clicked;
   private LinkedList <Tour>tourData = new LinkedList<Tour>();
   private JTable table;

   public ButtonEditor(JTextField txt, JTable table) {
    super(txt);
    
    btn=new JButton();
    btn.setOpaque(true);
    this.table = table;
    
    //WHEN BUTTON IS CLICKED
    btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        
        fireEditingStopped();
      }
    });
  }

   //OVERRIDE A COUPLE OF METHODS
   @Override
  public Component getTableCellEditorComponent(JTable table, Object obj,
      boolean selected, int row, int col) {

      //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
     lbl=(obj==null) ? "":obj.toString();
     btn.setText(lbl);
     clicked=true;
    return btn;
    }
   //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
   @Override
  public Object getCellEditorValue() {
      
     if(clicked){
        
        try(FileInputStream fin = new FileInputStream("TourData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            tourData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        
        int row = table.getSelectedRow();
        if (lbl.equals("Enter")){
            String id = (String)table.getValueAt(row, 0);
            for (int i = 0; i < tourData.size() && tourData.size() != 0; i++){
                if (tourData.get(i).getBusID().equals(id)){
                    new Booking((tourData.get(i)).getType());
                    break;
                }
            }
        }
         else if (lbl.equals("Delete")){
            tourData.remove(row);
            JOptionPane.showMessageDialog(btn,"Data deleat successfully.\nPlease click reset.");
        }
        try(FileOutputStream fOut = new FileOutputStream("TourData.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fOut);){
            oout.writeObject(tourData);
        }catch(IOException e){
            System.out.println(e);
            }
      }
    //SET IT TO FALSE NOW THAT ITS CLICKED
    clicked=false;
    return new String(lbl);
  }

   @Override
  public boolean stopCellEditing() {

         //SET CLICKED TO FALSE FIRST
      clicked=false;
    return super.stopCellEditing();
  }

   @Override
  protected void fireEditingStopped() {
    // TODO Auto-generated method stub
    super.fireEditingStopped();
  }
}
