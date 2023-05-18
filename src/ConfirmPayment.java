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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ConfirmPayment implements ActionListener, ItemListener{

    
    private JDesktopPane desktopPane;
    private JDialog fr;
    private JInternalFrame frame1, frame2, frame3;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10, lrtop,lrbottom,time, tspace, booktxt;
    private JButton b1,b2,b3;
    private JRadioButton bp1, bp2,bp3, bp4;
    private JPanel p1, p2, pReciept, ptime, ptxt, ppayHead, ppay, pbt, bookpane;
    private String seat = "";
    private boolean payment = false;
    private Tour tour;
    private User user;
    private LinkedList<String> booking = new LinkedList<String>();
    private LinkedList<Tour> tourData = new LinkedList<Tour>();
    private LinkedList <User> userData = new LinkedList<User>();
    
    public ConfirmPayment(Tour tour, User user, LinkedList<String> booking){
        
        Color lred = new Color(255,102,102);
        
        this.tour = tour;
        this.user = user;
        this.booking = booking;
        
        Font fontre = new Font("Times New Roman", Font.BOLD,16);
        Font rehead = new Font("Times New Roman", Font.BOLD,20);
        Font txt = new Font("Serif", Font.PLAIN, 16);
        Font bookhead = new Font("Times New Roman", Font.BOLD,35);
        Font txtb = new Font("Serif", Font.PLAIN, 18);
        tourData = FileIO.loadTourData();
        userData = FileIO.loadUserData();
        
        desktopPane = new JDesktopPane();
        frame1 = new JInternalFrame("Ticket Detail",false,false,false,false);
        frame2 = new JInternalFrame("Receipt",false,false,false,false);
        frame3 = new JInternalFrame("Payment",false,false,false,false);
        fr = new JDialog(fr, "Result", true);
        fr.setResizable(false);
        
        booktxt = new JLabel("- Booking Detail -");
        booktxt.setFont(bookhead);
        booktxt.setForeground(Color.white);
        
        
        l1 = new JLabel("   Tour ID:    "+tour.getBusID()); l1.setFont(txtb);
        l2 = new JLabel("   Destination:  From  "+tour.getStart()+"   To  "+tour.getEnd());  l2.setFont(txtb);
        l3 = new JLabel("   Date:    "+tour.getDate()+"    Time:"   +tour.getTimeOut()+" ➔ "+tour.getTimeArrive());  l3.setFont(txtb);
        l4 = new JLabel("   Booking Name:  "+user.getName()+"    "+user.getLastName());  l4.setFont(txtb);
        for(String a: booking){
            seat += a+" , ";
        }
        seat = seat.substring(0, seat.length()-2);
        l5 = new JLabel("   Seat:  "+seat);  l5.setFont(txtb);
        
        lrtop = new JLabel("************************************************************");
        l6 = new JLabel("                                          Receipt                                         ");
        lrbottom = new JLabel("************************************************************");
        time = new JLabel();
        l7 = new JLabel("        Bus                                         Seat                                          Total ");
        tspace = new JLabel("------------------------------------------------------------------------------------------");
        l8 = new JLabel("        "+tour.getBusID()+"-"+tour.getType()+"                         x"+booking.size()+"                                           "+tour.getPrice()*booking.size());
        l6.setFont(rehead);
        l7.setFont(fontre);
        l8.setFont(txt);
        lrtop.setFont(fontre);
        lrbottom.setFont(fontre);
        time.setFont(txt);
        tspace.setFont(rehead);
        l9 = new JLabel("- Payment Method -");
        l9.setFont(rehead);
        l9.setForeground(Color.orange);
        time.setVisible(false);
        l8.setVisible(false);
        l10 = new JLabel("Please finish the payment first");
        b1 = new JButton("Confirm");
        b2 = new JButton("Cancle");
        bp1 = new JRadioButton("Mobile Banking");
        bp2 = new JRadioButton("Visa/MasterCard");
        bp3 = new JRadioButton("Counter Service");
        bp4 =new JRadioButton("Promptpay");
        
        b3 = new JButton("Pay Now");
        b3.setBackground(Color.orange);
        
        
        p1 = new JPanel();
        p2 = new JPanel(new FlowLayout());
        pReciept = new JPanel(new GridLayout(3,1));
        ptime = new JPanel(new GridLayout(3,1));
        ptxt = new JPanel(new GridLayout(1,1));
        ppayHead = new JPanel(new FlowLayout());
        ppay = new JPanel(new GridLayout(4,1));
        pbt = new JPanel(new FlowLayout());
        bookpane = new JPanel (new GridLayout(7,1));
        pReciept.setBackground(Color.white);
        ptime.setBackground(Color.white);
        ptxt.setBackground(Color.white);
        bookpane.setBackground(Color.white);
        b1.setBackground(Color.orange);
        b2.setBackground(lred);
        b2.setForeground(Color.white);
        b1.setEnabled(false);
        p2.setBackground(Color.orange);
        p2.add(booktxt);
        bookpane.add(p2);
        bookpane.add(l1);
        bookpane.add(l2);
        bookpane.add(l3);
        bookpane.add(l4);
        bookpane.add(l5);
        bookpane.add(p1);


        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        pReciept.add(lrtop);pReciept.add(l6); pReciept.add(lrbottom); 
        p1.setLayout(new FlowLayout());
        p1.setBackground(Color.white);
        p1.add(b1);     p1.add(b2);
        
        
        ptime.add(time); ptime.add(tspace); ptime.add(l7);
        
        pbt.setBackground(Color.white);
        pbt.add(b3);
        b3.setEnabled(false);
        ptxt.add(l8);
        
        ppayHead.setBackground(Color.white);
        ppay.setBackground(Color.white);
        pbt.setBackground(Color.white);
        ppayHead.add(l9);
        bp1.setFont(txt); bp1.setOpaque(false); bp1.addItemListener(this);
        bp2.setFont(txt); bp2.setOpaque(false); bp2.addItemListener(this);
        bp3.setFont(txt); bp3.setOpaque(false); bp3.addItemListener(this);
        bp4.setFont(txt); bp4.setOpaque(false); bp4.addItemListener(this);
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(bp1);bgroup.add(bp2);bgroup.add(bp3);bgroup.add(bp4);
        ppay.add(bp1); ppay.add(bp2);ppay.add(bp3);ppay.add(bp4);
        
        frame1.add(bookpane);
        frame1.setSize(500,600);
        frame1.setVisible(true);
        
        frame2.setLayout(new GridLayout(3,1));
        frame2.add(pReciept);     frame2.add(ptime);     frame2.add(ptxt);
        frame2.setSize(500,310);
        frame2.setLocation(500, 250);
        frame2.setVisible(true);
        
        frame3.add(ppayHead, BorderLayout.NORTH);
        frame3.add(ppay, BorderLayout.CENTER);
        frame3.add(pbt, BorderLayout.SOUTH);
        
        frame3.setSize(500,250);
        frame3.setLocation(500,0);
        frame3.setVisible(true);
        
        desktopPane.add(frame1);
        desktopPane.add(frame2);
        desktopPane.add(frame3);
        
        fr.add(desktopPane);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        
        int x = (screenWidth - 1000) / 2;
        int y = (screenHeight - 600) / 2;
        
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setLocation(x, y);
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
        if (e.getSource().equals(b2)){
            fr.dispose();
        }
        
        else if (e.getSource().equals(b1)){
            if (payment == true){
                
                for(String a: booking){
                    Ticket tic = new Ticket(user.getUsername(),tour,a);
                    user.getTicketData().add(tic);
                    tour.setBookSeat(seatToNum(a));
                }
                
                try{
                int indexUser = -1;
                for (int i = 0; i < userData.size() && userData.size() != 0; i++){
                    if ((userData.get(i)).getUsername().equals(user.getUsername())){
                        indexUser = i;
                        break;
                    }
                }
                userData.set(indexUser, user);
                }catch(IndexOutOfBoundsException ex){
                    System.out.println("Tour not found");
                }
                FileIO.saveUserData(userData);
                
                try{
                int indexTour = -1;
                for (int i = 0; i < tourData.size() && tourData.size() != 0; i++){
                    if ((tourData.get(i)).getBusID().equals(tour.getBusID())){
                        indexTour = i;
                        break;
                    }
                }
                tourData.set(indexTour, tour);
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
        else if(e.getSource().equals(b3)){
             payment = true;
             LocalDateTime localDate = LocalDateTime.now();
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YY HH:mm");
             time.setText("        Java Tour                                                                   "+dtf.format(localDate));
             time.setVisible(true); l8.setVisible(true);
           
             
             b1.setEnabled(true);
            
            JOptionPane.showMessageDialog(null, "Payment complete.", "Payment",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void itemStateChanged(ItemEvent e) {
        
        if(e.getStateChange() == ItemEvent.SELECTED){
            if(e.getSource().equals(bp1) || e.getSource().equals(bp2)||e.getSource().equals(bp3)||e.getSource().equals(bp4)){
                b3.setEnabled(true);
            }  
        }
    }
}
