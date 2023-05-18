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
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
public class Admin implements ActionListener, WindowFocusListener, DocumentListener{
    private JFrame fr;
    private JPanel p1,p2,p3,p4,p5,p6,p7,p8,tourTable,userTable,p9,ph;
    private JButton b1,b2,b3,b4,logout,resetpass;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,head,tourhead;
    private JComboBox cbStart, cbEnd, cbDay,cbMonth,cbYear,cbTourType, cbTimeOuth, cbTimeOutm, cbTimeArriveh,cbTimeArrivem;
    private JTextField txt1;
    private int num = 0;
    private LinkedList <Tour> tourData = new LinkedList<Tour>();
    private LinkedList <User> userData = new LinkedList<User>();
    private Tour tour;
    private User user = new User();
    //new
    private ImageIcon imguser, imgtable, imgsetting, imglogout;
    private AdminAcc admin;
    
    public Admin(AdminAcc admin){
        this.admin = admin;
        Color cream = new Color(243, 233, 159);
        Font logo = new Font("Times New Roman", Font.BOLD, 60);
        Font header = new Font("Times New Roman", Font.BOLD, 40);
        imguser = new ImageIcon(getClass().getResource("images/useredit.png"));
        imgtable = new ImageIcon(getClass().getResource("images/table.png"));
        imgsetting = new ImageIcon(getClass().getResource("images/setting.png"));
        imglogout = new ImageIcon(getClass().getResource("images/logout.png"));
        Image sizeuser = imguser.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image sizetable = imgtable.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image sizeset = imgsetting.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image sizelog = imglogout.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        
        ImageIcon imguser1 = new ImageIcon(sizeuser);
        ImageIcon imgtable1 = new ImageIcon(sizetable);
        ImageIcon imgsetting1 = new ImageIcon(sizeset);
        ImageIcon imglogout1 = new ImageIcon(sizelog);
        Color re = new Color(255,102,102);
        Font lbfont = new Font("Times New Roman", Font.BOLD, 15);
        fr = new JFrame("Admin");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();
        p8 = new JPanel();
        p9 = new JPanel();
        ph = new JPanel(new FlowLayout());
        b1 = new JButton("Edit user",imguser1);
        b2 = new JButton("Tour table",imgtable1);
        b3 = new JButton("Add");
        b4 = new JButton(imgsetting1);
        logout = new JButton("Log out",imglogout1);
        resetpass = new JButton("Reset Password");
        l1 = new JLabel("From");
        l2 = new JLabel("To");
        l3 = new JLabel("Date");
        l4 = new JLabel("Type");
        l5 = new JLabel("Time out");
        l6 = new JLabel(":");
        l7 = new JLabel("Time Arrive");
        l8 = new JLabel(":");
        l9 = new JLabel("Search User");
        head = new JLabel("Setting");
        tourhead = new JLabel("Tour Table Editor");
        tourhead.setFont(header);
        ph.add(tourhead);
        ph.setBackground(cream);
        txt1 = new JTextField(10);
        
        
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
        b1.setContentAreaFilled(false); b1.setBorderPainted(false);
        b1.setVerticalTextPosition(SwingConstants.BOTTOM);
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        b2.setContentAreaFilled(false); b2.setBorderPainted(false);
        b2.setVerticalTextPosition(SwingConstants.BOTTOM);
        b2.setHorizontalTextPosition(SwingConstants.CENTER);
        b4.setContentAreaFilled(false); b4.setBorderPainted(false);
        b3.setBackground(Color.orange);
        Color yellow = new Color(247, 208, 96);
        p1.setBackground(yellow);
        
        head.setFont(logo);
        head.setBounds(350,33,300,100);
        head.setForeground(Color.orange);
        logout.setBounds(360,200,140,60);
        logout.setBackground(Color.LIGHT_GRAY);
        logout.setFont(lbfont);
       
        resetpass.setBounds(360,300,140,60);
        resetpass.setBackground(re);
        resetpass.setForeground(Color.white);
        resetpass.setFont(lbfont);
        p9.setBackground(Color.white);
        
        tourTable = new TourTable("Delete", user).getTable();
        userTable = new UserTable().getTable();
        
        cbStart.addItem("Bangkok"); cbStart.addItem("Krabi"); cbStart.addItem("Kanchanaburi");
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
        
        cbEnd.addItem("Bangkok"); cbEnd.addItem("Krabi"); cbEnd.addItem("Kanchanaburi");
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
        cbMonth.addItem("Jan"); cbMonth.addItem("Feb"); cbMonth.addItem("Mar");
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
        cbTimeOutm.addItem("10");     cbTimeOutm.addItem("11");     cbTimeOutm.addItem("12");
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
        cbTimeArrivem.addItem("10");     cbTimeArrivem.addItem("11");     cbTimeArrivem.addItem("12");
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
        b4.addActionListener(this);
        logout.addActionListener(this);
        resetpass.addActionListener(this);
        txt1.getDocument().addDocumentListener(this);
         
        fr.addWindowFocusListener(this);
        fr.setResizable(false);
        
        p1.setLayout(new GridLayout(6,1));
        p1.add(b1);     p1.add(b2);
        p1.add(new JLabel()); p1.add(new JLabel());
        p1.add(new JLabel()); p1.add(b4);
        p1.setBackground(Color.orange);
        
        p2.setLayout(new FlowLayout());
        p2.add(l1);     p2.add(cbStart);    p2.add(l2);     p2.add(cbEnd);
        p2.setBackground(cream);
        p3.setLayout(new FlowLayout());
        p3.add(l3);     p3.add(cbDay);    p3.add(cbMonth);    p3.add(cbYear);    p3.add(l4);
        p3.add(cbTourType); p3.add(b3);
        p3.setBackground(cream);
        p5.setLayout(new FlowLayout());
        p5.add(l5);     p5.add(cbTimeOuth); p5.add(l6);     p5.add(cbTimeOutm);
        p5.add(l7);     p5.add(cbTimeArriveh);      p5.add(l8); p5.add(cbTimeArrivem);
        p5.setBackground(cream);
        p4.setLayout(new GridLayout(3,1));
        p4.add(p2);     p4.add(p3);     p4.add(p5);
        p4.setBackground(cream);

        p6.add(p4, BorderLayout.NORTH);
        p6.add(tourTable);
        p6.setBackground(cream);
        
        p7.setLayout(new FlowLayout());
        p7.add(l9);     p7.add(txt1);
        p7.setBackground(cream);
        p8.add(p7,BorderLayout.NORTH);
        p8.add(userTable);
        p8.setBackground(cream);
        
        p9.setLayout(null);
        p9.add(logout); p9.add(resetpass); p9.add(head);
        
        fr.add(p1, BorderLayout.WEST);
        fr.add(p6);
        
        fr.setSize(1000,600);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        tourData = FileIO.loadTourData();
        if (tourData.size() != 0){
            num = Integer.parseInt((tourData.get(tourData.size() - 1)).getBusID());
        }
        num += 1;
        String id = String.format("%04d", num);
        String date = (String)cbDay.getSelectedItem()+"/"+(String)cbMonth.getSelectedItem()+"/"+(String)cbYear.getSelectedItem();
        String timeOut = (String)cbTimeOuth.getSelectedItem() + ":"+(String)cbTimeOutm.getSelectedItem();
        String timeArrive = (String)cbTimeArriveh.getSelectedItem()+":"+(String)cbTimeArrivem.getSelectedItem();
        int distance = Math.abs(cbStart.getSelectedIndex()-cbEnd.getSelectedIndex());
        if (ae.getSource().equals(b1)){
            fr.remove(p6);
            fr.remove(p9);
            fr.add(p8);
            fr.revalidate();
            fr.repaint();
        }
        else if (ae.getSource().equals(b2)){
            fr.remove(p8);
            fr.remove(p9);
            fr.add(p6);
            fr.revalidate();
            fr.repaint();
        }
        else if (ae.getSource().equals(b3)){
            if (cbTourType.getSelectedItem().equals("Economy")){
                tour = new EconomyTour((String)cbDay.getSelectedItem(), (String)cbMonth.getSelectedItem(), 
                        (String)cbYear.getSelectedItem(), id, (String)cbStart.getSelectedItem(),(String)cbEnd.getSelectedItem(),timeOut,timeArrive,distance);
            }
            else if (cbTourType.getSelectedItem().equals("Business")){
                tour = new BusinessTour((String)cbDay.getSelectedItem(), (String)cbMonth.getSelectedItem(), 
                        (String)cbYear.getSelectedItem(), id, (String)cbStart.getSelectedItem(),(String)cbEnd.getSelectedItem(),timeOut,timeArrive,distance);
            }
            else if (cbTourType.getSelectedItem().equals("FirstClass")){
                tour = new FirstClassTour((String)cbDay.getSelectedItem(), (String)cbMonth.getSelectedItem(), 
                        (String)cbYear.getSelectedItem(), id, (String)cbStart.getSelectedItem(),(String)cbEnd.getSelectedItem(),timeOut,timeArrive,distance);
            }
            tourData = FileIO.loadTourData();
            tourData.add(tour);
            FileIO.saveTourData(tourData);
            JOptionPane.showMessageDialog(null, "Add complete", "Add", JOptionPane.PLAIN_MESSAGE);
        }
        else if(ae.getSource().equals(b4)){
            fr.remove(p6);
            fr.remove(p8);
            fr.add(p9);
            fr.revalidate();
            fr.repaint();
        
        }
        else if(ae.getSource().equals(logout)){
             int val = JOptionPane.showConfirmDialog(null, "Are you sure?", "Notification", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
             if(val == JOptionPane.YES_OPTION){
                fr.dispose();
                new Login();
            }
             
        }
        else if(ae.getSource().equals(resetpass)){
            boolean checkold = false;
            String old;
            while(checkold==false){
                old = JOptionPane.showInputDialog(null,"Please enter the old password:","Reset admin password",JOptionPane.INFORMATION_MESSAGE);
                if(old.equals(admin.getPassword())){
                    String newpass = JOptionPane.showInputDialog(null,"Please enter the new password:","Reset admin password",JOptionPane.INFORMATION_MESSAGE);
                    admin.setPassword(newpass);
                    FileIO.saveAdminData(admin);
                    
                    break;
                }
                else{
                     JOptionPane.showConfirmDialog(null, "Wrong password, try again.", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                 }
            }
            
        }
    }

    public LinkedList userSearch(){
        userData = FileIO.loadUserData();
        String text = txt1.getText();
        LinkedList filter = new LinkedList();
        for (int i = 0; i < userData.size(); i++){
            if (text.length() > userData.get(i).getUsername().length()){
                continue;
            }
            if (text.equals(userData.get(i).getUsername().substring(0, text.length()).toLowerCase())){
                filter.add(i);
            }
        }
        return filter;
    }
    @Override
    public void windowGainedFocus(WindowEvent e) {
        if (fr.isAncestorOf(p6)) {
            p6.remove(tourTable);
            fr.remove(p6);
            tourTable = new TourTable("Delete",user).getTable();
            p6.add(tourTable);
            fr.add(p6);
            fr.revalidate();
            fr.repaint();
        }else if(fr.isAncestorOf(p8)){
            p8.remove(userTable);
            fr.remove(p8);
            userTable = new UserTable().getTable();
            p8.add(userTable);
            fr.add(p8);
            fr.revalidate();
            fr.repaint();
        }else if(fr.isAncestorOf(p9)){
            
            fr.add(p9);
            fr.revalidate();
            fr.repaint();
    }
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        LinkedList filter = userSearch();
        p8.remove(userTable);
        fr.remove(p8);
        userTable = new UserTable(filter).getTable();
        p8.add(userTable);
        fr.add(p8);
        fr.revalidate();
        fr.repaint();
        txt1.requestFocus();
        }

    @Override
    public void removeUpdate(DocumentEvent e) {
        LinkedList filter = userSearch();
        p8.remove(userTable);
        fr.remove(p8);
        userTable = new UserTable(filter).getTable();
        p8.add(userTable);
        fr.add(p8);
        fr.revalidate();
        fr.repaint();
        txt1.requestFocus();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {}

    
    @Override
    public void windowLostFocus(WindowEvent e) {}
  
}