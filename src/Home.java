import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.table.*;
public class Home implements ActionListener {
    private JFrame fr;
    private JPanel p1,p2,p3,p4,p5,tourTable;
    private JButton bSearch,b2,b3, profile, home, setting;
    private ImageIcon imch, imcp, imcs, imch1, imcp1, imcs1;
    private JLabel l1,l2,l3,l4,l5;
    private JScrollPane scrollPane;
    private JComboBox cbStart, cbEnd, cbDay,cbMonth,cbYear,cbTourType,cbSeat;
    private LinkedList tourData = new LinkedList();
    
    public Home(){
        fr = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        bSearch = new JButton("Search");
        //b2 = new JButton("Tour");
        //b3 = new JButton("User");
        
        imch = new ImageIcon(getClass().getResource("images/home.png"));
        imcp = new ImageIcon(getClass().getResource("images/profile.png"));
        imcs = new ImageIcon(getClass().getResource("images/setting.png"));
        Image sizeh = imch.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image sizep = imcp.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image sizes = imcs.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        imch1 = new ImageIcon(sizeh);
        imcp1 = new ImageIcon(sizep);
        imcs1 = new ImageIcon(sizes);
        profile = new JButton(imcp1);
        home = new JButton(imch1);
        setting = new JButton(imcs1);
        home.setContentAreaFilled(false);
        profile.setContentAreaFilled(false);
        setting.setContentAreaFilled(false);
        home.setBorderPainted(false);
        profile.setBorderPainted(false);
        setting.setBorderPainted(false);
        
        l1 = new JLabel("Start");
        l2 = new JLabel("End");
        l3 = new JLabel("Date");
        l4 = new JLabel("Type");
        l5 = new JLabel("Seat");
        l1.setFont(new Font("Sarabun", Font.BOLD, 14));
        l2.setFont(new Font("Sarabun", Font.BOLD, 14));
        l3.setFont(new Font("Sarabun", Font.BOLD, 14));
        l4.setFont(new Font("Sarabun", Font.BOLD, 14));
        l5.setFont(new Font("Sarabun", Font.BOLD, 14));
        
        cbStart = new JComboBox();
        cbEnd = new JComboBox();
        cbDay = new JComboBox();
        cbMonth = new JComboBox();
        cbYear = new JComboBox();
        cbSeat = new JComboBox();
        cbTourType = new JComboBox();
        tourTable = new TourTable().getTable();
        
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
        cbTourType.addItem("Businuss");
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
        
        
        bSearch.addActionListener(this);
         
        p2.setLayout(new FlowLayout());
        p2.add(l1);     p2.add(cbStart);    p2.add(l2);     p2.add(cbEnd);
        
        p3.setLayout(new FlowLayout());
        p3.add(l3);     p3.add(cbDay);    p3.add(cbMonth);    p3.add(cbYear);    p3.add(l4);
        p3.add(cbTourType);    p3.add(l5);     p3.add(cbSeat);       p3.add(bSearch);
        
        p4.setLayout(new GridLayout(2,1));
        p4.add(p2);     p4.add(p3);
        
        p5.setLayout(new GridLayout(6,1));
        p5.add(profile); p5.add(home); p5.add(setting);
        
        fr.add(p4, BorderLayout.NORTH);
        fr.add(p5, BorderLayout.WEST);
        fr.add(tourTable);
        
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
    public LinkedList filterSearch(String start, String end, String type, String time, int seat){
        LinkedList filter = new LinkedList();
        for (int i = 0; i < tourData.size() && tourData.size() != 0; i++){
            if (((Tour)tourData.get(i)).getStart().equals(start)){
                filter.add(i);
        }
            }
        for (int i = 0; i < filter.size() && filter.size() != 0 ; i++){
            if (!((Tour)tourData.get(i)).getEnd().equals(end)){
                filter.remove(i);
                i -= 1;
            }
        }
        for (int i = 0; i < filter.size() && filter.size() != 0 ; i++){
            if (!((Tour)tourData.get(i)).getType().equals(type)){
                filter.remove(i);
                i -= 1;
            }
        }
        for (int i = 0; i < filter.size() && filter.size() != 0 ; i++){
            if (!((Tour)tourData.get(i)).getTime().equals(time)){
                filter.remove(i);
                i -= 1;
            }
        }
        for (int i = 0; i < filter.size() && filter.size() != 0 ; i++){
            if (((Tour)tourData.get(i)).getSeat() < seat){
                filter.remove(i);
                i -= 1;
            }
        }
        return filter;
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals(bSearch)){
            String date = (String)cbDay.getSelectedItem()+"/"+(String)cbMonth.getSelectedItem()+"/"+(String)cbYear.getSelectedItem();
            p1 = new JPanel();
            
            scrollPane = new JScrollPane();
            p1.add(scrollPane);
            
            JTable table = new JTable();
            scrollPane.setViewportView(table);
            
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            model.addColumn("ID");
            model.addColumn("Time");
            model.addColumn("Start");
            model.addColumn("End");
            model.addColumn("Type");
            model.addColumn("Seat");
            model.addColumn("Available");
            
            LinkedList filter = filterSearch((String)cbStart.getSelectedItem(), (String)cbEnd.getSelectedItem(), (String)cbTourType.getSelectedItem(),date,(int)cbSeat.getSelectedItem());
            System.out.println(filter);
            for (int i = 0; i < filter.size() ; i++){
                int num = (int)filter.get(i);
                int row = table.getRowCount();
                model.addRow(new Object[0]);
                model.setValueAt(((Tour)tourData.get(num)).getBusID(), row, 0);
                model.setValueAt(((Tour)tourData.get(num)).getTime(), row, 1);
                model.setValueAt(((Tour)tourData.get(num)).getStart(), row, 2);
                model.setValueAt(((Tour)tourData.get(num)).getEnd(), row, 3);
                model.setValueAt(((Tour)tourData.get(num)).getType(), row, 4);
                model.setValueAt(((Tour)tourData.get(num)).getSeat()+"", row, 5);
                model.setValueAt(((Tour)tourData.get(num)).getSeatAvailable()+"", row, 6);
           }
            fr.remove(tourTable);
            fr.add(p1);
            fr.revalidate();
        }
    }
    public static void main(String[] args) {
        new Home();
    }
}
