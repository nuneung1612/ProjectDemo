/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.awt.*;
import javax.swing.*;


public class Setting{
    private JFrame fr;
    private User user;
    private JPanel p1;
    private JButton logout, delete;
    private JLabel set;
  
    
    public Setting(User user){
        this.user = user;
        Color del = new Color(255,102,102);
        
        Font lbfont = new Font("Times New Roman", Font.BOLD, 16);
        Font logo = new Font("Times New Roman", Font.BOLD, 60);
        fr = new JFrame();
        p1 = new JPanel(null);
        logout = new JButton("Log out");
        delete = new JButton("Delete Account");
        set = new JLabel("Setting");
        set.setForeground(Color.orange);
        set.setFont(logo);
        set.setBounds(355,33,300,100);
        logout.setFont(lbfont);
        logout.setBounds(380,200,100,60);
        logout.setBackground(Color.LIGHT_GRAY);
        delete.setBounds(360,300,140,60);
        delete.setFont(lbfont);
        delete.setBackground(del);
        delete.setForeground(Color.white);
        p1.add(logout); p1.add(delete);
        p1.setBackground(Color.white);
        p1.add(set);
        

        
    
    }

    
     public JPanel getPanel(){
          return this.p1;
      }
     public JButton getLogout(){
         return this.logout;
     }
     public JButton getDelete(){
         return this.delete;
     }
    public static void main(String[] args) {
      //  new Setting();
    }
    
}
