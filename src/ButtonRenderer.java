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
public class ButtonRenderer extends JButton implements TableCellRenderer {
     public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value == null ? "" : value.toString());
        return this;
    }
}