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
    private String owner;
    private Tour tour;
    private String seat;
    private LinkedList ticketData = new LinkedList();
    private static final long serialVersionUID = 1234567890L;
    
    public Ticket(String owner, Tour tour,String seat){
        this.owner = owner;
        this.tour = tour;
        this.seat = seat;
        ticketData = FileIO.loadTicketData();
        ticketData.add(this);
        FileIO.saveTicketData(ticketData);
    }

    public LinkedList getTicketData() {
        return ticketData;
    }

    public void setTicketData(LinkedList ticketData) {
        this.ticketData = ticketData;
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
}
