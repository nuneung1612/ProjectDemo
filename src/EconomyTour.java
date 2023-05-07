 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author s6203101111142
 */
public class EconomyTour extends Tour {
    private int seat = 40;
    private double price;
    private boolean availableSeat[] = new boolean[40];
    
    public EconomyTour(String day, String month, String year, String busID, String start, String end, String timeOut, String timeArrive, int distance){
        super(day, month, year, busID, start, end, "Economy",timeOut, timeArrive,distance);
        for (int i = 0; i < 40; i++){
            availableSeat[i] = true;
        }
    }
    
    public int getSeat(){
        return this.seat;
    }
    
    public int getSeatAvailable(){
        int seatAvailable = 0;
        for (int i = 0; i < 40; i++){
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
        price = 50+(this.getDistance()*15);
        return this.price;
    }
}