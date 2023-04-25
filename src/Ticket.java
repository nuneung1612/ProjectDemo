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
    private String tour;
    private String seat;
    private LinkedList ticketData = new LinkedList();
    
    public Ticket(String owner, String tour,String seat){
        this.owner = owner;
        this.tour = tour;
        this.seat = seat;
        try(FileInputStream fin = new FileInputStream("TicketData.dat");
                ObjectInputStream in = new ObjectInputStream(fin);){
                ticketData = ((LinkedList)in.readObject());
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e);
            }
            ticketData.add(tour);
            try(FileOutputStream fOut = new FileOutputStream("TicketData.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fOut);){
                oout.writeObject(ticketData);
            }catch(IOException e){
            System.out.println(e);
            }
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

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
