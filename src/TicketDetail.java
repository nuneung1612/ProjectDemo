


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
    private JLabel l1,l2,l3,l4,l5;
    private LinkedList <Ticket>ticketData = new LinkedList<Ticket>();
    private LinkedList <Tour> tourData = new LinkedList<Tour>();
    
    public TicketDetail(Ticket ticket, User user){
        fr = new JFrame("Ticket");
        ticketData = FileIO.loadTicketData();
        tourData = FileIO.loadTourData();
        boolean expire = true;
        for (int i = 0; i< tourData.size(); i++){
            if(tourData.get(i).getBusID().equals(ticket.getTour().getBusID())){
                l1 = new JLabel("TourId:"+ticket.getTour().getBusID());
                l2 = new JLabel("Destination: From  "+ticket.getTour().getStart()+"To  "+ticket.getTour().getEnd());
                l3 = new JLabel("Date:"+ticket.getTour().getDate()+"    Time"+ticket.getTour().getTimeOut()+" ➔ "+ticket.getTour().getTimeArrive());
                l4 = new JLabel("BookingName: "+user.getName()+"    "+user.getLastName());
                l5 = new JLabel("Seat: "+ticket.getSeat());
                fr.setLayout(new GridLayout(6,1));
                fr.add(l1);     fr.add(l2);     fr.add(l3);     
                fr.add(l4);     fr.add(l5);     
                fr.setSize(500,600);
                fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                fr.setVisible(true);
                expire = false;
            }
        }
        if(expire){
            JOptionPane.showConfirmDialog(null, "Ticket Expire", "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            for (int i = 0 ; i < ticketData.size(); i++){
                if (ticket.getTicketID().equals(ticketData.get(i).getTicketID())){
                    ticketData.remove(i);
                    FileIO.saveTicketData(ticketData);
                }
            }
        }        
    }
}
