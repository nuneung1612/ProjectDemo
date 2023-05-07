



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
public abstract class Tour implements Serializable, TourPackage{
    private String day;
    private String month;
    private String year;
    private String date;
    private String timeOut;
    private String timeArrive;
    private String busID;
    private String start;
    private String end;
    private int distance;
    protected String type;
    private LinkedList tourData = new LinkedList();
    private static final long serialVersionUID = 1234567890L;
    
    
    public Tour(String day, String month, String year, String busID, String start, String end, String type, String timeOut, String timeArrive, int distance){
        this.date = day+"/"+month+"/"+year;
        this.busID = busID; 
        this.start = start;
        this.end = end;
        this.type = type;
        this.timeOut = timeOut;
        this.timeArrive = timeArrive;
        this.day = day;
        this.month = month;
        this.year = year;
        this.distance = distance;
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

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getTimeArrive() {
        return timeArrive;
    }

    public void setTimeArrive(String timeArrive) {
        this.timeArrive = timeArrive;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}