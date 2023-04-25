import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.table.*;
public class Home implements ActionListener {
    private JFrame fr;
    private JPanel p1,p2,p3,p4,inlefttop,p6,centerbg,tourTable,inleftbottom,leftbg,inpro;
    private JButton bSearch,b2,b3, profile, home, setting;
    private ImageIcon imch, imcp, imcs, imch1, imcp1, imcs1;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,free1,prof,hm,set;
    private JScrollPane scrollPane;
    private JComboBox cbStart, cbEnd, cbDay,cbMonth,cbYear,cbTourType,cbSeat,cbTimeOuth, cbTimeOutm, cbTimeArriveh,cbTimeArrivem;
    private LinkedList <Tour> tourData = new LinkedList<Tour>();
    private LinkedList <User>userData = new LinkedList<User>();
    private User user;
    
    
    public Home(String username){
        try(FileInputStream fin = new FileInputStream("UserData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            userData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        for (int i = 0; i < userData.size() && userData.size() != 0; i++){
            if ((userData.get(i)).getUsername().equals(username)){
                this.user = userData.get(i);
        }
            }
        
        fr = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        inlefttop = new JPanel();
        p6 = new JPanel();
        centerbg = new JPanel();
        inlefttop = new JPanel();
        inleftbottom = new JPanel();
        leftbg = new JPanel();
        inpro = new JPanel();
        bSearch = new JButton("Search");
        //b2 = new JButton("Tour");
        //b3 = new JButton("User");
        
        imch = new ImageIcon(getClass().getResource("images/home.png"));
        imcp = new ImageIcon(getClass().getResource("images/profile.png"));
        imcs = new ImageIcon(getClass().getResource("images/setting.png"));
        Image sizeh = imch.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        Image sizep = imcp.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        Image sizes = imcs.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        imch1 = new ImageIcon(sizeh);
        imcp1 = new ImageIcon(sizep);
        imcs1 = new ImageIcon(sizes);
        profile = new JButton(imcp1);
        home = new JButton(imch1);
        setting = new JButton(imcs1);
        home.setContentAreaFilled(false); home.setBorderPainted(false);
        profile.setContentAreaFilled(false); profile.setBorderPainted(false);
        setting.setContentAreaFilled(false); setting.setBorderPainted(false);
        
        l1 = new JLabel("Start");
        l1.setFont(new Font("Arabic", Font.BOLD, 14));
        l2 = new JLabel("End");
        l2.setFont(new Font("Arabic", Font.BOLD, 14));
        l3 = new JLabel("Date  ");
        l3.setFont(new Font("Arabic", Font.BOLD, 14));
        l4 = new JLabel("Type ");
        l4.setFont(new Font("Arabic", Font.BOLD, 13));
        l5 = new JLabel("Seat   ");
        l5.setFont(new Font("Arabic", Font.BOLD, 13));
        l6 = new JLabel("Timeout");
        l6.setFont(new Font("Arabic", Font.BOLD, 13));
        l7 = new JLabel(":");
        l7.setFont(new Font("Arabic", Font.BOLD, 14));
        l8 = new JLabel(" TimeArrive");
        l8.setFont(new Font("Arabic", Font.BOLD, 13));
        l9 = new JLabel(":");
        l9.setFont(new Font("Arabic", Font.BOLD, 14));
        free1 = new JLabel();
        prof = new JLabel("Profile.getname");
        prof.setFont(new Font("Arabic", Font.BOLD, 12));
        /*hm = new JLabel("Home");
        hm.setFont(new Font("Arabic", Font.BOLD, 14));
        set = new JLabel("Setting");
        set.setFont(new Font("Arabic", Font.BOLD, 14));*/
        
        cbStart = new JComboBox();
        cbEnd = new JComboBox();
        cbDay = new JComboBox();
        cbMonth = new JComboBox();
        cbYear = new JComboBox();
        cbSeat = new JComboBox();
        cbTourType = new JComboBox();
        cbTimeOuth = new JComboBox();
        cbTimeOutm = new JComboBox();
        cbTimeArriveh = new JComboBox();
        cbTimeArrivem = new JComboBox();
        tourTable = new TourTable("Enter").getTable();
        
        Color yellow = new Color(247, 208, 96);
        Color cream = new Color(243, 233, 159);
        
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
        
        cbYear.addItem("2023");
        cbTourType.addItem("Economy");
        cbTourType.addItem("Business");
        cbTourType.addItem("FirstClass");
        
        cbSeat.addItem(1);      cbSeat.addItem(2);      cbSeat.addItem(3);
        cbSeat.addItem(4);      cbSeat.addItem(5);      cbSeat.addItem(6);
        cbSeat.addItem(7);      cbSeat.addItem(8);      cbSeat.addItem(9);
        cbSeat.addItem(10);      cbSeat.addItem(11);      cbSeat.addItem(12);
        cbSeat.addItem(13);      cbSeat.addItem(14);      cbSeat.addItem(14);
        cbSeat.addItem(15);      cbSeat.addItem(16);      cbSeat.addItem(17);
        cbSeat.addItem(18);      cbSeat.addItem(19);      cbSeat.addItem(20);
        cbSeat.addItem(21);      cbSeat.addItem(22);      cbSeat.addItem(23);
        cbSeat.addItem(24);      cbSeat.addItem(25);      cbSeat.addItem(26);
        cbSeat.addItem(27);      cbSeat.addItem(28);      cbSeat.addItem(29);
        cbSeat.addItem(30);      cbSeat.addItem(31);      
        
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
        
        
        bSearch.addActionListener(this);
        profile.addActionListener(this);
         
        p2.setLayout(new FlowLayout());
        p2.add(l1);     p2.add(cbStart);    p2.add(l2);     p2.add(cbEnd);
        p2.setBackground(cream);
        
        p3.setLayout(new FlowLayout());
        p3.add(l3);     p3.add(cbDay);    p3.add(cbMonth);    p3.add(cbYear);    p3.add(l4);
        p3.add(cbTourType);    p3.add(l5);     p3.add(cbSeat);p6.add(bSearch);
        p3.setBackground(cream);
        
        p6.setLayout(new FlowLayout());
        p6.add(l6); p6.add(cbTimeOuth);    p6.add(l7); p6.add(cbTimeOutm);
        p6.add(l8); p6.add(cbTimeArriveh); p6.add(l9); p6.add(cbTimeArrivem); p6.add(bSearch);
        p6.setBackground(cream);
        
        p4.setLayout(new GridLayout(3,1));
        p4.add(p2);     p4.add(p3);  p4.add(p6);
        
        tourTable.setBackground(cream);
        centerbg.setLayout(new FlowLayout());
        centerbg.add(p4); centerbg.add(tourTable);
        centerbg.setBackground(cream);
                    
        inpro.setLayout(new BorderLayout());
        prof.setHorizontalAlignment(JLabel.CENTER);
        inpro.add(profile, BorderLayout.CENTER); inpro.add(prof, BorderLayout.SOUTH);
        inpro.setBackground(yellow);
        
        inlefttop.setLayout(new GridLayout(2,1));
        inlefttop.add(inpro); inlefttop.add(home);
        inlefttop.setBackground(yellow);
        
        inleftbottom.setLayout(new GridLayout(2,1));
        inleftbottom.add(setting);inleftbottom.add(free1);
        inleftbottom.setBackground(yellow);
        
        leftbg.setLayout(new BorderLayout());
        leftbg.add(inlefttop, BorderLayout.NORTH); leftbg.add(inleftbottom, BorderLayout.SOUTH);
        leftbg.setBackground(yellow);
        
        fr.add(centerbg, BorderLayout.CENTER);
        fr.add(leftbg, BorderLayout.WEST);   
        
        fr.setSize(1000,600);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        
        try(FileInputStream fin = new FileInputStream("TourData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            tourData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        
        
        
    }
    public LinkedList filterSearch(String start, String end, String type, String date, int seat, String time){
        LinkedList filter = new LinkedList();
        int num;
        for (int i = 0; i < tourData.size() && tourData.size() != 0; i++){
            if ((tourData.get(i)).getStart().equals(start)){
                filter.add(i);
        }
            }
        for (int i = 0; i < filter.size() && filter.size() != 0 ; i++){
            num = (int)filter.get(i);
            if (!(tourData.get(num)).getEnd().equals(end)){
                filter.remove(i);
                i -= 1;
            }
        }
        for (int i = 0; i < filter.size() && filter.size() != 0 ; i++){
            num = (int)filter.get(i);
            if (!(tourData.get(num)).getType().equals(type)){
                filter.remove(i);
                i -= 1;
            }
        }
        for (int i = 0; i < filter.size() && filter.size() != 0 ; i++){
            num = (int)filter.get(i);
            if (!(tourData.get(num)).getDate().equals(date)){
                filter.remove(i);
                i -= 1;
            }
        }
        for (int i = 0; i < filter.size() && filter.size() != 0 ; i++){
            num = (int)filter.get(i);
            if (!(tourData.get(num)).getTime().equals(time)){
                filter.remove(i);
                i -= 1;
            }
        }
        for (int i = 0; i < filter.size() && filter.size() != 0 ; i++){
            num = (int)filter.get(i);
            if ((tourData.get(num)).getSeatAvailable() < seat){
                filter.remove(i);
                i -= 1;
            }
        }
        return filter;
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals(bSearch)){
            String date = (String)cbDay.getSelectedItem()+"/"+(String)cbMonth.getSelectedItem()+"/"+(String)cbYear.getSelectedItem();
            String time = ((String)cbTimeOuth.getSelectedItem() + ":"+(String)cbTimeOutm.getSelectedItem()+"->"+(String)cbTimeArriveh.getSelectedItem()+":"+(String)cbTimeArrivem.getSelectedItem());
            LinkedList filter = filterSearch((String)cbStart.getSelectedItem(), (String)cbEnd.getSelectedItem(), (String)cbTourType.getSelectedItem(),date,(int)cbSeat.getSelectedItem(), time);
            centerbg.remove(tourTable);
            tourTable = new TourTable("Enter", filter).getTable();
            centerbg.add(tourTable);
            
            centerbg.revalidate();
            fr.repaint();
        }
        if(ae.getSource().equals(profile)){
            new Profile(user);
            fr.dispose();
            
        }
    }
}