 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author s6203101111142
 */
import java.io.*;
import java.util.LinkedList;
public class Ticket implements Serializable{
    private String ticketID;
    private String owner;
    private Tour tour;
    private String seat;
    private static final long serialVersionUID = 1234567890L;
    
    public Ticket(String owner, Tour tour,String seat){
        int num = 0;
        this.owner = owner;
        this.tour = tour;
        this.seat = seat;
        
        num = FileIO.loadTicketID();
        num += 1;
        ticketID = String.format("%04d", num);
        FileIO.saveTicketID(num);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    
}
