



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author s6203101111142
 */
import java.io.*;
import java.util.*;
public class Tour implements Serializable{
    private String time;
    private String busID;
    private String start;
    private String end;
    private int seat;
    private int seatAvailable;
    private String type;
    private LinkedList tourData = new LinkedList();
    
    public Tour(){
        time = "";
        busID = "";
        start = "";
        end = "";
        seat = 0;
        seatAvailable = 0;
        type = "";
    }
    
    public Tour(String time, String busID, String start, String end,int seat, int seatAvailable, String type){
        this.time = time;
        this.busID = busID;
        this.start = start;
        this.end = end;
        this.seat = seat;
        this.type = type;
        this.seatAvailable = seat;
        try(FileInputStream fin = new FileInputStream("TourData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            tourData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        tourData.add(this);
        try(FileOutputStream fOut = new FileOutputStream("TourData.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fOut);){
            oout.writeObject(tourData);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(int seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
