/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
    //unfinised
public class Profile implements ActionListener {
    private JFrame fr;
    private JPanel p1, p2, p3, p4 ,p5;
    private JTextField name, last, tel, email, username, pass;
   // private JPasswordField oldpass newpass;
    private JLabel nametxt, lasttxt, teltxt,emailtxt,usertxt,passtxt,pic;
    private JLabel warnname, warnlast, warntel, warnemail, warnpass, empt1, empt2, warnuser;
    private LinkedList <User> userData = new LinkedList<User>();
    private JButton home, pro, setting, save;
    private User user;
    private String usertag = "Invalid username";
    private ImageIcon imch, imcp, imcs, imch1, imcp1, imcs1;
    private Font lbfont = new Font("Times New Roman", Font.BOLD, 18);
    private Font textfont = new Font("Times New Roman", Font.PLAIN, 16);
    
public Profile(User user){
    this.user = user;
    fr = new JFrame("Java Touer - Profile");
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    p4 = new JPanel();
    p5 = new JPanel();
    p4.setBackground(Color.white);
            
    Color blue1 = new Color(76, 177, 221 );

    name = new JTextField(this.user.getName());
    last = new JTextField(this.user.getLastName());
    tel = new JTextField(this.user.getTelNumber());
    email = new JTextField(this.user.getEmail());
    username  = new JTextField(this.user.getUsername());
    pass= new JTextField(this.user.getPassword());
    
    usertxt = new JLabel("Username:");
    passtxt = new JLabel("Password:");
    emailtxt = new JLabel("Email:");
    teltxt = new JLabel("Tel:");
    nametxt = new JLabel("Name:");
    lasttxt = new JLabel("Last Name:");
    pic = new JLabel("pic p3 north");
  
    warnpass = new JLabel("Invalid password."); 
    warnname= new JLabel("Invalid name");
    warnlast = new JLabel("Invalid lastname");
    warnemail = new JLabel("Invalid email");
    warntel = new JLabel("Invalid phone number");
    warnuser =new JLabel(usertag);
    empt1 =  new JLabel();
    empt2 = new JLabel();
    

    
    nametxt.setFont(lbfont);
    nametxt.setBounds(120, 150, 100, 100);
    name.setLocation(120,215);
    name.setSize(250,30);
    name.setFont(textfont);
    warnname.setBounds(120, 200,100,100);
    
    lasttxt.setFont(lbfont);
    lasttxt.setBounds(500,150,100,100);
    last.setLocation(500,215);
    last.setSize(250, 30);
    last.setFont(textfont);
    warnlast.setBounds(500, 200,100,100);
    
    emailtxt.setFont(lbfont);
    emailtxt.setBounds(120, 240,100,100);
    email.setLocation(120,305);
    email.setSize(250, 30);
    email.setFont(textfont);
    warnemail.setBounds(120, 290,100,100);
    
    teltxt.setFont(lbfont);
    teltxt.setBounds(500,240,100,100);
    tel.setLocation(500, 305);
    tel.setSize(250,30);
    tel.setFont(textfont);
    warntel.setBounds(500, 290,200,100);
    
    usertxt.setBounds(120,330,100,100);
    usertxt.setFont(lbfont);
    username.setLocation(120, 395);
    username.setSize(250, 30);
    username.setFont(textfont);
    warnuser.setBounds(120,380,200,100);
    
    passtxt.setBounds(500, 330,100,100);
    passtxt.setFont(lbfont);
    pass.setLocation(500,395);
    pass.setSize(250,30);
    pass.setFont(textfont);
    warnpass.setBounds(500,380,200,100);
    
    
    
           
    
    
    //Button
    save = new JButton("save");
    imch = new ImageIcon(getClass().getResource("images/home.png"));
    imcp = new ImageIcon(getClass().getResource("images/profile.png"));
    imcs = new ImageIcon(getClass().getResource("images/setting.png"));
    Image sizeh = imch.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);    
    Image sizep = imcp.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    Image sizes = imcs.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    imch1 = new ImageIcon(sizeh);
    imcp1 = new ImageIcon(sizep);
    imcs1 = new ImageIcon(sizes);
    home = new JButton(imch1);
    pro = new JButton(imcp1);
    setting = new JButton(imcs1);
    
    save.setBounds(397,480,70,30);
    save.setFont(lbfont);
    save.setBackground(Color.orange);
    save.setForeground(Color.black);
    
    
    home.setBackground(blue1);
    pro.setBackground(Color.white);
    
    
    setting.setBackground(blue1);
    
    warnname.setForeground(Color.red);
    warnlast.setForeground(Color.red);
    warnemail.setForeground(Color.red);
    warntel.setForeground(Color.red);
    warnpass.setForeground(Color.red);
    warnuser.setForeground(Color.red);
    
    warnname.setVisible(false);
    warnlast.setVisible(false);
    warnemail.setVisible(false);
    warntel.setVisible(false);
    warnpass.setVisible(false);
    warnuser.setVisible(false);
    
    
    save.addActionListener(this);
    home.addActionListener(this);
    
//    p2.setBackground(Color.orange);
    
    p1.setLayout(null);
//    p1.add(p2, BorderLayout.WEST);
    p1.add(p4);
    
//    p2.setLayout(new GridLayout(6,1));
//    p2.add(home); p2.add(pro); p2.add(setting);
    
//    p3.setLayout(new BorderLayout());
//    p3.add(p4,BorderLayout.CENTER);
    
    p4.setLayout(null);
    p4.add(nametxt); p4.add(lasttxt);
    p4.add(name); p4.add(last);
    p4.add(warnname); p4.add(warnlast);
    p4.add(emailtxt);p4.add(teltxt);
    p4.add(email); p4.add(tel);
    p4.add(warnemail); p4.add(warntel);
    p4.add(usertxt); p4.add(passtxt);
    p4.add(username); p4.add(pass);
    p4.add(warnuser); p4.add(warnpass);
    p4.add(save);
    
//    
//    p4.add(nametxt); p4.add(lasttxt);
//    p4.add(name); p4.add(last);
//    p4.add(warnname); p4.add(warnlast);
//    p4.add(emailtxt); p4.add(teltxt);
//    p4.add(email); p4.add(tel);
//    p4.add(warnemail); p4.add(warntel);
//    p4.add(usertxt); p4.add(passtxt);
//    p4.add(username); p4.add(pass);
//    p4.add(warnuser); p4.add(warnpass);
//    p4.add(empt2);p4.add(p5);
//    
//    p5.setLayout(new FlowLayout());
//    p5.add(save);
    
    
    //p4.add(warn)
    
    //fr.setResizable(false);
    //fr.setContentPane(p1);
    //fr.setSize(1000,600);
    //fr.setVisible(true);
    //fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    try(FileInputStream fin = new FileInputStream("UserData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            userData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
    
}
    @Override
    public void actionPerformed(ActionEvent ev){
    
    if(ev.getSource().equals(save)){
        
         CheckingAccount ch = new CheckingAccount();
         warnname.setVisible(!ch.checkName(name.getText()));
         warnlast.setVisible(!ch.checkName(last.getText()));
         warntel.setVisible(!ch.checkTel(tel.getText()));
         warnemail.setVisible(!ch.checkEmail(email.getText()));
         warnpass.setVisible(!ch.checkPass(pass.getText()));
         if(user.getUsername().equals(username.getText())){
            warnuser.setVisible(false);
             if(ch.checkName(name.getText()) && ch.checkName(last.getText()) && ch.checkPass(pass.getText()) && ch.checkTel(tel.getText()) && ch.checkEmail(email.getText())){
                
                try{
                int index = -1;
                for (int i = 0; i < userData.size() && userData.size() != 0; i++){
                    if ((userData.get(i)).getUsername().equals(user.getUsername())){
                        index = i;
                        break;
                    }
                }
                 
                user.setName(name.getText());
                user.setLastName(last.getText());
                user.setTelNumber(tel.getText());
                user.setEmail(email.getText());
                user.setPassword(pass.getText());
                
                userData.set(index, user);
                }catch(IndexOutOfBoundsException e){
                    System.out.println("User not found");
                }
                

                JOptionPane.showConfirmDialog(null, "Update profile success!", "Notification", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

             }
         
         }
    else{
         boolean uscheck;
         uscheck = ch.checkUser(username.getText());
         warnuser.setText(ch.getUsertag());
         warnuser.setVisible(!uscheck);
        if(ch.checkName(name.getText()) && ch.checkName(last.getText()) && ch.checkPass(pass.getText()) && ch.checkTel(tel.getText()) && ch.checkUser(username.getText()) && ch.checkEmail(email.getText())){
            
                  try{
                int index = -1;
                for (int i = 0; i < userData.size() && userData.size() != 0; i++){
                    if ((userData.get(i)).getUsername().equals(user.getUsername())){
                        index = i;
                        break;
                    }
                }
                user.setName(name.getText());
                user.setLastName(last.getText());
                user.setTelNumber(tel.getText());
                user.setEmail(email.getText());
                user.setPassword(pass.getText());
                user.setUserName(username.getText());
                userData.set(index, user);
                }catch(IndexOutOfBoundsException e){
                    System.out.println("User not found");
                }

                JOptionPane.showConfirmDialog(null, "Update profile success!", "Notification", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                
}    
        }
    }
    try(FileOutputStream fOut = new FileOutputStream("UserData.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fOut);){
                    oout.writeObject(userData);
                }catch(IOException e){
                    System.out.println(e);
                }
    }
    public JPanel getFrame(){
        return this.p4;
    }

//    public static void main(String[] args) {
//        
//        User a = new User("Pranpreeya","Mengmungmee", "gyugg21@gmail.com","0959677761","nuneung1122","nuneung112");
//        User b = new User("Pranpreeya","Mengmungmee", "gyugg21@gmail.com","0959677761","nuneung1","nuneung112");
//        new Profile(a);
//        
//        
//    }
}
