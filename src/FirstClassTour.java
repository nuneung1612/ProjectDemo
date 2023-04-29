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
public class FirstClassTour extends Tour {
    private int seat = 20;
    private double price = 1000;
    private boolean availableSeat[] = new boolean[20];
    
    public FirstClassTour(String day, String month, String year, String busID, String start, String end, String timeOut, String timeArrive){
        super(day, month, year, busID, start, end, "FirstClass", timeOut, timeArrive);
        for (int i = 0; i < 20; i++){
            availableSeat[i] = true;
        }
    }
    
    public int getSeat(){
        return this.seat;
    }
    
    public int getSeatAvailable(){
        int seatAvailable = 0;
        for (int i = 0; i < 20; i++){
            if (availableSeat[i]){
                seatAvailable += 1;
            }
        }
        return seatAvailable;
    }
    public void setBookSeat(int bookSeat){
        availableSeat[bookSeat] = false;
    }

    public boolean[] getAvailableSeat() {
        return availableSeat;
    }
    @Override
    public double getPrice() {
        return this.price;
    }
}