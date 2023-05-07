 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author s6203101111142
 */
public interface TourPackage {
    public abstract int getSeat();
    public abstract int getSeatAvailable();
    public abstract void setBookSeat(int bookSeat);
    public abstract double getPrice();
    public abstract boolean[] getAvailableSeat();
}
