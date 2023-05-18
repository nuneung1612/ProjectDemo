


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author s6203101111142
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class TicketDetail {
    private JFrame fr;
    private JPanel p1,p2;
    private JLabel l1,l2,l3,l4,l5,l6,l7,eticket;
    private LinkedList <Tour> tourData = new LinkedList<Tour>();
    private LinkedList <User> userData = new LinkedList<User>();
    private ImageIcon barcode;
    
    public TicketDetail(Ticket ticket, User user){
        Font textfont = new Font("Times New Roman", Font.PLAIN, 16);
        Font header = new Font("Times New Roman", Font.BOLD, 45);
        barcode = new ImageIcon(getClass().getResource("images/barcode.png"));
       
        Image sizebc = barcode.getImage().getScaledInstance(300, 120, Image.SCALE_SMOOTH);
        ImageIcon bc1 = new ImageIcon(sizebc);
 
        
        fr = new JFrame("Ticket");
        p1 = new JPanel(new GridLayout(8,1));
        p2 = new JPanel(new FlowLayout());
 
        eticket = new JLabel("E-Ticket");
        eticket.setFont(header);
        eticket.setForeground(Color.white);
        p2.setBackground(Color.orange);
        tourData = FileIO.loadTourData();
        userData = FileIO.loadUserData();
        boolean expire = true;
        for (int i = 0; i< tourData.size(); i++){
            if(tourData.get(i).getBusID().equals(ticket.getTour().getBusID())){
                l1 = new JLabel("      Ticket ID:   "+ticket.getTicketID());
                l2 = new JLabel("      Bus Type:   "+ticket.getTour().getBusID()+" - "+ticket.getTour().getType());
                l3 = new JLabel("      Destination:  "+ticket.getTour().getStart()+"  -  "+ticket.getTour().getEnd());
                l4 = new JLabel("      Date:  "+ticket.getTour().getDate()+"    Time:  "+ticket.getTour().getTimeOut()+" --> "+ticket.getTour().getTimeArrive());
                l5 = new JLabel("      Booking Name:  "+user.getName()+"     "+user.getLastName());
                l6 = new JLabel("      Seat:  "+ticket.getSeat());
                l7 = new JLabel(bc1);
                l1.setFont(textfont);
                l2.setFont(textfont);
                l3.setFont(textfont);
                l4.setFont(textfont);
                l5.setFont(textfont);
                l6.setFont(textfont);
                
                p2.add(eticket);
                p1.add(p2);
                p1.add(l1);     p1.add(l2);     p1.add(l3);     
                p1.add(l4);     p1.add(l5);     p1.add(l6);  p1.add(l7);
                p1.setBackground(Color.white);
                fr.add(p1);
                fr.setResizable(false);
                fr.setSize(400,500);
                fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                fr.setVisible(true);
                
                expire = false;
            }
        }
        if(expire){
            JOptionPane.showConfirmDialog(null, "Ticket Expire", "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            for (int i = 0 ; i < user.getTicketData().size(); i++){
                if (ticket.getTicketID().equals(user.getTicketData().get(i).getTicketID())){
                    user.getTicketData().remove(i);
                }
            }
            int index = userData.indexOf(user);
            userData.set(index, user);
            FileIO.saveUserData(userData);
        }        
    }
}
