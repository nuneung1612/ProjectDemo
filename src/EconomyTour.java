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
public class EconomyTour extends Tour {
    private int seat = 30;
    private double price = 200;
    private boolean availableSeat[] = new boolean[30];
    
    public EconomyTour(){
        super();
    }
    
    public EconomyTour(String date, String busID, String start, String end, String time){
        super(date, busID, start, end, "Economy",time);
        for (int i = 0; i < 30; i++){
            availableSeat[i] = true;
        }
    }
    
    public int getSeat(){
        return this.seat;
    }
    
    public int getSeatAvailable(){
        int seatAvailable = 0;
        for (int i = 0; i < 30; i++){
            if (availableSeat[i]){
                seatAvailable += 1;
            }
        }
        return seatAvailable;
    }
}
