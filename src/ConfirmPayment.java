/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author s6203101111142
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class ConfirmPayment implements ActionListener{
    private JDesktopPane desktopPane;
    private JDialog fr;
    private JInternalFrame frame1, frame2, frame3;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    private JButton b1,b2,b3,b4,b5,b6;
    private JPanel p1, p2;
    private String seat = "";
    private boolean payment = false;
    private Tour tour;
    private User user;
    private LinkedList<String> booking = new LinkedList<String>();
    private LinkedList<Tour> tourData = new LinkedList<Tour>();
    
    public ConfirmPayment(Tour tour, User user, LinkedList<String> booking){
        this.tour = tour;
        this.user = user;
        this.booking = booking;
        
        tourData = FileIO.loadTourData();
        
        desktopPane = new JDesktopPane();
        frame1 = new JInternalFrame("Ticket Detail",false,false,false,false);
        frame2 = new JInternalFrame("Receipt",false,false,false,false);
        frame3 = new JInternalFrame("Payment",false,false,false,false);
        fr = new JDialog(fr, "Result", true);
        
        l1 = new JLabel("TourId:"+tour.getBusID());
        l2 = new JLabel("Destination: From  "+tour.getStart()+"To  "+tour.getEnd());
        l3 = new JLabel("Date:"+tour.getDate()+"    Time"+tour.getTimeOut()+" ➔ "+tour.getTimeArrive());
        l4 = new JLabel("BookingName: "+user.getName()+"    "+user.getLastName());
        for(String a: booking){
            seat += a+" , ";
        }
        seat = seat.substring(0, seat.length()-2);
        l5 = new JLabel("Seat: "+seat);
        
        l6 = new JLabel("Receipt");
        l7 = new JLabel("Bus                       seat                Total");
        l8 = new JLabel(tour.getBusID()+"-"+tour.getType()+"    "+booking.size()+"                "+tour.getPrice()*booking.size());
        
        l9 = new JLabel("Payment Method");
        l10 = new JLabel("Please do the Payment first");
        b1 = new JButton("Cancel");
        b2 = new JButton("Confirm");
        b3 = new JButton("Mobile bank");
        b4 = new JButton("Visa/MasterCard");
        b5 = new JButton("Conter Service");
        b6 = new JButton("Promplay");
        
        p1 = new JPanel();
        p2 = new JPanel();
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        
        p1.setLayout(new FlowLayout());
        p1.add(b1);     p1.add(b2);
        
        p2.setLayout(new GridLayout(2,2));
        p2.add(b3);     p2.add(b4);     p2.add(b5);     p2.add(b6);
        
        frame1.setLayout(new GridLayout(6,1));
        frame1.add(l1);     frame1.add(l2);     frame1.add(l3);     
        frame1.add(l4);     frame1.add(l5);     frame1.add(p1);
        frame1.setSize(500,600);
        frame1.setVisible(true);
        
        frame2.setLayout(new GridLayout(3,1));
        frame2.add(l6);     frame2.add(l7);     frame2.add(l8);
        frame2.setSize(500,250);
        frame2.setLocation(500, 0);
        frame2.setVisible(true);
        
        frame3.add(l9, BorderLayout.NORTH);
        frame3.add(p2);
        frame3.setSize(500,330);
        frame3.setLocation(500, 250);
        frame3.setVisible(true);
        
        desktopPane.add(frame1);
        desktopPane.add(frame2);
        desktopPane.add(frame3);
        
        fr.add(desktopPane);
        
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(1000,600);
        fr.setVisible(true);
        
        
          
    }
    
    public int seatToNum(String seat){
        String letter = seat.substring(0, 1);
        int num = Integer.parseInt(seat.substring(1));
        if(tour instanceof BusinessTour){
            if (letter.equals("B")){
                num += 7;
            }else if (letter.equals("C")){
                num += 14;
            }
        }else{
            if (letter.equals("B")){
                num += 10;
            }else if(letter.equals("C")){
                num += 20;
            }else if (letter.equals("D")){
                num += 30;
            }
        }
        return num-1;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)){
            fr.dispose();
        }
        
        else if (e.getSource().equals(b2)){
            if (payment == true){
                for(String a: booking){
                    new Ticket(user.getUsername(),tour,a);
                    tour.setBookSeat(seatToNum(a));
                }
                try{
                int index = -1;
                for (int i = 0; i < tourData.size() && tourData.size() != 0; i++){
                    if ((tourData.get(i)).getBusID().equals(tour.getBusID())){
                        index = i;
                        break;
                    }
                }
                tourData.set(index, tour);
                }catch(IndexOutOfBoundsException ex){
                    System.out.println("Tour not found");
                }
                FileIO.saveTourData(tourData);
                
                JOptionPane.showMessageDialog(null, "Booking complete.", "Booking",JOptionPane.INFORMATION_MESSAGE);
                fr.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Please pay first.", "Booking",JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            payment = true;
            JOptionPane.showMessageDialog(null, "Payment complete.", "Payment",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
