/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author s6203101111142
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
public class Admin implements ActionListener, WindowListener{
    private JFrame fr;
    private JPanel p1,p2,p3,p4,p5,tourTable,userTable;
    private JButton b1,b2,b3;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    private JComboBox cbStart, cbEnd, cbDay,cbMonth,cbYear,cbTourType, cbTimeOuth, cbTimeOutm, cbTimeArriveh,cbTimeArrivem;
    private int num = 0;
    private LinkedList <Tour> tourData = new LinkedList<Tour>();
    private Tour tour;
    private User user = new User();
    
    public Admin(){
        fr = new JFrame("Admin");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        b1 = new JButton("User");
        b2 = new JButton("Tour");
        b3 = new JButton("Add");
        l1 = new JLabel("start");
        l2 = new JLabel("End");
        l3 = new JLabel("date");
        l4 = new JLabel("Type");
        l5 = new JLabel("Timeout");
        l6 = new JLabel(":");
        l7 = new JLabel("TimeArrive");
        l8 = new JLabel(":");
        cbStart = new JComboBox();
        cbEnd = new JComboBox();
        cbDay = new JComboBox();
        cbMonth = new JComboBox();
        cbYear = new JComboBox();
        cbTourType = new JComboBox();
        cbTimeOuth = new JComboBox();
        cbTimeOutm = new JComboBox();
        cbTimeArriveh = new JComboBox();
        cbTimeArrivem = new JComboBox();
        
        
        
        tourTable = new TourTable("Delete", user).getTable();
        userTable = new UserTable().getTable();
        
        cbStart.addItem("Bankkok"); cbStart.addItem("Krabi"); cbStart.addItem("Kanchanaburi");
        cbStart.addItem("Kalasin"); cbStart.addItem("Kamphaeng Phet"); cbStart.addItem("Khon Kaen");
        cbStart.addItem("Chanthaburi"); cbStart.addItem("Chachoengsao"); cbStart.addItem("Chonburi");
        cbStart.addItem("Chainat"); cbStart.addItem("Chaiyaphum"); cbStart.addItem("Khon Kaen");
        cbStart.addItem("Chiang Rai"); cbStart.addItem("Chiang Mai"); cbStart.addItem("Trang");
        cbStart.addItem("Trat"); cbStart.addItem("Tak"); cbStart.addItem("Nakhon Nayok");
        cbStart.addItem("Nakhon Pathom"); cbStart.addItem("Nakhon Phanom"); cbStart.addItem("Nakhon Ratchasima");
        cbStart.addItem("Nakhon Si Thammarat"); cbStart.addItem("Nakhon Sawan"); cbStart.addItem("Nonthaburi");
        cbStart.addItem("Narathiwat"); cbStart.addItem("Nan"); cbStart.addItem("Bueng Kan");
        cbStart.addItem("Prachinburi"); cbStart.addItem("Pattani"); cbStart.addItem("Phra Nakhon Si Ayutthaya");
        cbStart.addItem("Phayao"); cbStart.addItem("Phang Nga"); cbStart.addItem("Phatthalung");
        cbStart.addItem("Phichit"); cbStart.addItem("Phitsanulok"); cbStart.addItem("Phetchaburi");
        cbStart.addItem("Phetchabun"); cbStart.addItem("Phrae"); cbStart.addItem("Phuket");
        cbStart.addItem("Maha Sarakham "); cbStart.addItem("Mukdahan"); cbStart.addItem("Mae Hong Son");
        cbStart.addItem("Yasothon"); cbStart.addItem("Yala"); cbStart.addItem("Roi Et");
        cbStart.addItem("Ranong"); cbStart.addItem("Rayong"); cbStart.addItem("Ratchaburi");
        cbStart.addItem("Loei"); cbStart.addItem("Sisaket"); cbStart.addItem("Sakon Nakhon");
        cbStart.addItem("Songkhla"); cbStart.addItem("Satun"); cbStart.addItem("Samut Prakan");
        cbStart.addItem("Samut Songkhram"); cbStart.addItem("Samut Sakhon"); cbStart.addItem("Sa Kaeo");
        cbStart.addItem("Saraburi"); cbStart.addItem("Sing Buri"); cbStart.addItem("Sukhothai");
        cbStart.addItem("Suphan Buri"); cbStart.addItem("Surat Thani"); cbStart.addItem("Surin");
        cbStart.addItem("Nong Khai"); cbStart.addItem("Nong Bua Lamphu"); cbStart.addItem("Ang Thong");
        cbStart.addItem("Amnat Charoen"); cbStart.addItem("Udon Thani"); cbStart.addItem("Uttaradit");
        cbStart.addItem("Uthai Thani"); cbStart.addItem("Ubon Ratchathani");
        
        cbEnd.addItem("Bankkok"); cbEnd.addItem("Krabi"); cbEnd.addItem("Kanchanaburi");
        cbEnd.addItem("Kalasin"); cbEnd.addItem("Kamphaeng Phet"); cbEnd.addItem("Khon Kaen");
        cbEnd.addItem("Chanthaburi"); cbEnd.addItem("Chachoengsao"); cbEnd.addItem("Chonburi");
        cbEnd.addItem("Chainat"); cbEnd.addItem("Chaiyaphum"); cbEnd.addItem("Khon Kaen");
        cbEnd.addItem("Chiang Rai"); cbEnd.addItem("Chiang Mai"); cbEnd.addItem("Trang");
        cbEnd.addItem("Trat"); cbEnd.addItem("Tak"); cbEnd.addItem("Nakhon Nayok");
        cbEnd.addItem("Nakhon Pathom"); cbEnd.addItem("Nakhon Phanom"); cbEnd.addItem("Nakhon Ratchasima");
        cbEnd.addItem("Nakhon Si Thammarat"); cbEnd.addItem("Nakhon Sawan"); cbEnd.addItem("Nonthaburi");
        cbEnd.addItem("Narathiwat"); cbEnd.addItem("Nan"); cbEnd.addItem("Bueng Kan");
        cbEnd.addItem("Prachinburi"); cbEnd.addItem("Pattani"); cbEnd.addItem("Phra Nakhon Si Ayutthaya");
        cbEnd.addItem("Phayao"); cbEnd.addItem("Phang Nga"); cbEnd.addItem("Phatthalung");
        cbEnd.addItem("Phichit"); cbEnd.addItem("Phitsanulok"); cbEnd.addItem("Phetchaburi");
        cbEnd.addItem("Phetchabun"); cbEnd.addItem("Phrae"); cbEnd.addItem("Phuket");
        cbEnd.addItem("Maha Sarakham "); cbEnd.addItem("Mukdahan"); cbEnd.addItem("Mae Hong Son");
        cbEnd.addItem("Yasothon"); cbEnd.addItem("Yala"); cbEnd.addItem("Roi Et");
        cbEnd.addItem("Ranong"); cbEnd.addItem("Rayong"); cbEnd.addItem("Ratchaburi");
        cbEnd.addItem("Loei"); cbEnd.addItem("Sisaket"); cbEnd.addItem("Sakon Nakhon");
        cbEnd.addItem("Songkhla"); cbEnd.addItem("Satun"); cbEnd.addItem("Samut Prakan");
        cbEnd.addItem("Samut Songkhram"); cbEnd.addItem("Samut Sakhon"); cbEnd.addItem("Sa Kaeo");
        cbEnd.addItem("Saraburi"); cbEnd.addItem("Sing Buri"); cbEnd.addItem("Sukhothai");
        cbEnd.addItem("Suphan Buri"); cbEnd.addItem("Surat Thani"); cbEnd.addItem("Surin");
        cbEnd.addItem("Nong Khai"); cbEnd.addItem("Nong Bua Lamphu"); cbEnd.addItem("Ang Thong");
        cbEnd.addItem("Amnat Charoen"); cbEnd.addItem("Udon Thani"); cbEnd.addItem("Uttaradit");
        cbEnd.addItem("Uthai Thani"); cbEnd.addItem("Ubon Ratchathani");
        
        cbDay.addItem("1"); cbDay.addItem("2"); cbDay.addItem("3");
        cbDay.addItem("4"); cbDay.addItem("5"); cbDay.addItem("6");
        cbDay.addItem("7"); cbDay.addItem("8"); cbDay.addItem("9");
        cbDay.addItem("10"); cbDay.addItem("11"); cbDay.addItem("12");
        cbDay.addItem("13"); cbDay.addItem("14"); cbDay.addItem("15"); 
        cbDay.addItem("16"); cbDay.addItem("17"); cbDay.addItem("18"); 
        cbDay.addItem("19"); cbDay.addItem("20"); cbDay.addItem("21"); 
        cbDay.addItem("22"); cbDay.addItem("23"); cbDay.addItem("24"); 
        cbDay.addItem("25"); cbDay.addItem("26"); cbDay.addItem("27"); 
        cbDay.addItem("28"); cbDay.addItem("29"); cbDay.addItem("30"); 
        cbDay.addItem("31");
        cbMonth.addItem("Jun"); cbMonth.addItem("Feb"); cbMonth.addItem("Mar");
        cbMonth.addItem("Apr"); cbMonth.addItem("May"); cbMonth.addItem("Jun");
        cbMonth.addItem("Jul"); cbMonth.addItem("Aug"); cbMonth.addItem("Sep");
        cbMonth.addItem("Oct"); cbMonth.addItem("Nov"); cbMonth.addItem("Dec");
        
        cbTimeOuth.addItem("00");     cbTimeOuth.addItem("01");     cbTimeOuth.addItem("02");
        cbTimeOuth.addItem("03");     cbTimeOuth.addItem("04");     cbTimeOuth.addItem("05");
        cbTimeOuth.addItem("06");     cbTimeOuth.addItem("07");     cbTimeOuth.addItem("08");
        cbTimeOuth.addItem("09");     cbTimeOuth.addItem("10");     cbTimeOuth.addItem("11");
        cbTimeOuth.addItem("12");     cbTimeOuth.addItem("13");     cbTimeOuth.addItem("14");
        cbTimeOuth.addItem("15");     cbTimeOuth.addItem("16");     cbTimeOuth.addItem("17");
        cbTimeOuth.addItem("18");     cbTimeOuth.addItem("19");     cbTimeOuth.addItem("20");
        cbTimeOuth.addItem("22");     cbTimeOuth.addItem("23");     
        
        cbTimeOutm.addItem("00");     cbTimeOutm.addItem("01");     cbTimeOutm.addItem("02");
        cbTimeOutm.addItem("03");     cbTimeOutm.addItem("04");     cbTimeOutm.addItem("05");
        cbTimeOutm.addItem("06");     cbTimeOutm.addItem("07");     cbTimeOutm.addItem("08");   cbTimeOutm.addItem("09");
        cbTimeOutm.addItem("10");     cbTimeOutm.addItem("11");     cbTimeOutm.addItem("012");
        cbTimeOutm.addItem("13");     cbTimeOutm.addItem("14");     cbTimeOutm.addItem("15");
        cbTimeOutm.addItem("16");     cbTimeOutm.addItem("17");     cbTimeOutm.addItem("18");
        cbTimeOutm.addItem("19");     cbTimeOutm.addItem("20");     cbTimeOutm.addItem("21");
        cbTimeOutm.addItem("22");     cbTimeOutm.addItem("23");     cbTimeOutm.addItem("24");
        cbTimeOutm.addItem("25");     cbTimeOutm.addItem("26");     cbTimeOutm.addItem("27");
        cbTimeOutm.addItem("28");     cbTimeOutm.addItem("29");     cbTimeOutm.addItem("30");
        cbTimeOutm.addItem("31");     cbTimeOutm.addItem("32");     cbTimeOutm.addItem("33");
        cbTimeOutm.addItem("34");     cbTimeOutm.addItem("35");     cbTimeOutm.addItem("36");
        cbTimeOutm.addItem("37");     cbTimeOutm.addItem("38");     cbTimeOutm.addItem("39");
        cbTimeOutm.addItem("40");     cbTimeOutm.addItem("41");     cbTimeOutm.addItem("42");
        cbTimeOutm.addItem("43");     cbTimeOutm.addItem("44");     cbTimeOutm.addItem("45");
        cbTimeOutm.addItem("46");     cbTimeOutm.addItem("47");     cbTimeOutm.addItem("48");
        cbTimeOutm.addItem("49");     cbTimeOutm.addItem("50");     cbTimeOutm.addItem("51");
        cbTimeOutm.addItem("52");     cbTimeOutm.addItem("53");     cbTimeOutm.addItem("54");
        cbTimeOutm.addItem("55");     cbTimeOutm.addItem("56");     cbTimeOutm.addItem("57");
        cbTimeOutm.addItem("58");     cbTimeOutm.addItem("59");     
        
        cbTimeArriveh.addItem("00");     cbTimeArriveh.addItem("01");     cbTimeArriveh.addItem("02");
        cbTimeArriveh.addItem("03");     cbTimeArriveh.addItem("04");     cbTimeArriveh.addItem("05");
        cbTimeArriveh.addItem("06");     cbTimeArriveh.addItem("07");     cbTimeArriveh.addItem("08");
        cbTimeArriveh.addItem("09");     cbTimeArriveh.addItem("10");     cbTimeArriveh.addItem("11");
        cbTimeArriveh.addItem("12");     cbTimeArriveh.addItem("13");     cbTimeArriveh.addItem("14");
        cbTimeArriveh.addItem("15");     cbTimeArriveh.addItem("16");     cbTimeArriveh.addItem("17");
        cbTimeArriveh.addItem("18");     cbTimeArriveh.addItem("19");     cbTimeArriveh.addItem("20");
        cbTimeArriveh.addItem("22");     cbTimeArriveh.addItem("23");     
        
        cbTimeArrivem.addItem("00");     cbTimeArrivem.addItem("01");     cbTimeArrivem.addItem("02");
        cbTimeArrivem.addItem("03");     cbTimeArrivem.addItem("04");     cbTimeArrivem.addItem("05");
        cbTimeArrivem.addItem("06");     cbTimeArrivem.addItem("07");     cbTimeArrivem.addItem("08");   cbTimeArrivem.addItem("09");
        cbTimeArrivem.addItem("10");     cbTimeArrivem.addItem("11");     cbTimeArrivem.addItem("012");
        cbTimeArrivem.addItem("13");     cbTimeArrivem.addItem("14");     cbTimeArrivem.addItem("15");
        cbTimeArrivem.addItem("16");     cbTimeArrivem.addItem("17");     cbTimeArrivem.addItem("18");
        cbTimeArrivem.addItem("19");     cbTimeArrivem.addItem("20");     cbTimeArrivem.addItem("21");
        cbTimeArrivem.addItem("22");     cbTimeArrivem.addItem("23");     cbTimeArrivem.addItem("24");
        cbTimeArrivem.addItem("25");     cbTimeArrivem.addItem("26");     cbTimeArrivem.addItem("27");
        cbTimeArrivem.addItem("28");     cbTimeArrivem.addItem("29");     cbTimeArrivem.addItem("30");
        cbTimeArrivem.addItem("31");     cbTimeArrivem.addItem("32");     cbTimeArrivem.addItem("33");
        cbTimeArrivem.addItem("34");     cbTimeArrivem.addItem("35");     cbTimeArrivem.addItem("36");
        cbTimeArrivem.addItem("37");     cbTimeArrivem.addItem("38");     cbTimeArrivem.addItem("39");
        cbTimeArrivem.addItem("40");     cbTimeArrivem.addItem("41");     cbTimeArrivem.addItem("42");
        cbTimeArrivem.addItem("43");     cbTimeArrivem.addItem("44");     cbTimeArrivem.addItem("45");
        cbTimeArrivem.addItem("46");     cbTimeArrivem.addItem("47");     cbTimeArrivem.addItem("48");
        cbTimeArrivem.addItem("49");     cbTimeArrivem.addItem("50");     cbTimeArrivem.addItem("51");
        cbTimeArrivem.addItem("52");     cbTimeArrivem.addItem("53");     cbTimeArrivem.addItem("54");
        cbTimeArrivem.addItem("55");     cbTimeArrivem.addItem("56");     cbTimeArrivem.addItem("57");
        cbTimeArrivem.addItem("58");     cbTimeArrivem.addItem("59");  
        
        
        cbYear.addItem("2023");
        cbTourType.addItem("Economy");
        cbTourType.addItem("Business");
        cbTourType.addItem("FirstClass");
                  
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
         
        fr.addWindowListener(this);
        
        p1.setLayout(new GridLayout(2,1));
        p1.add(b1);     p1.add(b2);
        
        p2.setLayout(new FlowLayout());
        p2.add(l1);     p2.add(cbStart);    p2.add(l2);     p2.add(cbEnd);
        
        p3.setLayout(new FlowLayout());
        p3.add(l3);     p3.add(cbDay);    p3.add(cbMonth);    p3.add(cbYear);    p3.add(l4);
        p3.add(cbTourType); p3.add(b3);
        
        p5.setLayout(new FlowLayout());
        p5.add(l5);     p5.add(cbTimeOuth); p5.add(l6);     p5.add(cbTimeOutm);
        p5.add(l7);     p5.add(cbTimeArriveh);      p5.add(l8); p5.add(cbTimeArrivem);
        
        p4.setLayout(new GridLayout(3,1));
        p4.add(p2);     p4.add(p3);     p4.add(p5);
        
        fr.add(p1, BorderLayout.WEST);
        fr.add(p4, BorderLayout.NORTH);
        fr.add(tourTable);
        
        fr.setSize(1000,600);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try(FileInputStream fin = new FileInputStream("TourData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            tourData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        if (tourData.size() != 0){
            num = Integer.parseInt((tourData.get(tourData.size() - 1)).getBusID());
        }
        num += 1;
        String id = String.format("%04d", num);
        String date = (String)cbDay.getSelectedItem()+"/"+(String)cbMonth.getSelectedItem()+"/"+(String)cbYear.getSelectedItem();
        String timeOut = (String)cbTimeOuth.getSelectedItem() + ":"+(String)cbTimeOutm.getSelectedItem();
        String timeArrive = (String)cbTimeArriveh.getSelectedItem()+":"+(String)cbTimeArrivem.getSelectedItem();
        if (ae.getSource().equals(b1)){
            fr.remove(tourTable);
            fr.remove(p4);
            fr.add(userTable);
            fr.revalidate();
            fr.repaint();
        }
        else if (ae.getSource().equals(b2)){
            fr.remove(userTable);
            fr.add(p4, BorderLayout.NORTH);
            fr.add(tourTable);
            fr.revalidate();
            fr.repaint();
        }
        else if (ae.getSource().equals(b3)){
            if (cbTourType.getSelectedItem().equals("Economy")){
                tour = new EconomyTour((String)cbDay.getSelectedItem(), (String)cbMonth.getSelectedItem(), (String)cbYear.getSelectedItem(), id, (String)cbStart.getSelectedItem(),(String)cbEnd.getSelectedItem(),timeOut,timeArrive);
            }
            else if (cbTourType.getSelectedItem().equals("Business")){
                tour = new BusinessTour((String)cbDay.getSelectedItem(), (String)cbMonth.getSelectedItem(), (String)cbYear.getSelectedItem(), id, (String)cbStart.getSelectedItem(),(String)cbEnd.getSelectedItem(),timeOut,timeArrive);
            }
            else if (cbTourType.getSelectedItem().equals("FirstClass")){
                tour = new FirstClassTour((String)cbDay.getSelectedItem(), (String)cbMonth.getSelectedItem(), (String)cbYear.getSelectedItem(), id, (String)cbStart.getSelectedItem(),(String)cbEnd.getSelectedItem(),timeOut,timeArrive);
            }
            try(FileInputStream fin = new FileInputStream("TourData.dat");
                ObjectInputStream in = new ObjectInputStream(fin);){
                tourData = ((LinkedList)in.readObject());
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e);
            }
            tourData.add(tour);
            try(FileOutputStream fOut = new FileOutputStream("TourData.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fOut);){
                oout.writeObject(tourData);
            }catch(IOException e){
            System.out.println(e);
            }
            fr.remove(tourTable);
            tourTable = new TourTable("Delete",user).getTable();
            fr.add(tourTable);
            fr.revalidate();
            fr.repaint();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {
        fr.remove(tourTable);
        tourTable = new TourTable("Delete",user).getTable();
        fr.add(tourTable);
        fr.revalidate();
        fr.repaint();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {}
    
}