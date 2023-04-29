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
public class CustomResizableText extends DefaultTableCellRenderer {
    
    public Component  getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String text = label.getText();
        
        if (text.length() > 35) {
            label.setFont(new Font("Arabic", Font.BOLD, 11));
        } else {
            label.setFont(new Font("Arabic", Font.BOLD, 13));
        }
        label.setHorizontalAlignment( JLabel.CENTER );

        return label;
    }
    
}
