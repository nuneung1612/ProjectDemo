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
public class BusinessTour extends Tour {
    private int seat = 21;
    private double price = 500;
    private boolean availableSeat[] = new boolean[21];
    
    public BusinessTour(){
        super();
    }
    public BusinessTour(String date, String busID, String start, String end, String time){
        super(date, busID, start, end, "Business", time);
        for (int i = 0; i < 21; i++){
            this.availableSeat[i] = true;
        }
    }
    
    public int getSeat(){
        return this.seat;
    }
    
    public int getSeatAvailable(){
        int seatAvailable = 0;
        for (int i = 0; i < 21; i++){
            if (this.availableSeat[i]){
                seatAvailable += 1;
            }
        }
        return seatAvailable;
    }
}