



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
public abstract class Tour implements Serializable{
    private String date;
    private String time;
    private String busID;
    private String start;
    private String end;
    protected String type;
    private LinkedList tourData = new LinkedList();
    private static final long serialVersionUID = 1234567890L;
    
    public Tour(){
        date = "";
        busID = "";
        start = "";
        end = "";
        type = "";
        time = "";
    }
    
    public Tour(String date, String busID, String start, String end, String type, String time){
        this.date = date;
        this.busID = busID;
        this.start = start;
        this.end = end;
        this.type = type;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public LinkedList getTourData() {
        return tourData;
    }

    public void setTourData(LinkedList tourData) {
        this.tourData = tourData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public abstract int getSeat();
    public abstract int getSeatAvailable();
}