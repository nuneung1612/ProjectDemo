/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author s6203101111142
 */
import java.io.*;
import java.util.*;
public class User implements Serializable {
    private String name,lastName,email,telNumber,userName,password;
    private LinkedList userData = new LinkedList();
    private LinkedList <Ticket>ticketData = new LinkedList<Ticket>();
    private static final long serialVersionUID = 1234567890L;
    
    public User(){
        name = "Admin";
        lastName = "Admin";
        telNumber = "Admin";
        email = "Admin";
        userName = "Admin";
        password = "Admin";
    }
    
    public User(String name, String lastname, String email, String telNumber, String userName, String password){
        this.name = name;
        this.email = email;
        this.lastName = lastname;
        this.password = password;
        this.userName = userName;
        this.telNumber = telNumber;
        userData = FileIO.loadUserData();
        userData.add(this);
        FileIO.saveUserData(userData);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setLastName(String lastname){
        this.lastName = lastname;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setTelNumber(String telNumber){
        this.telNumber = telNumber;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getTelNumber(){
        return this.telNumber;
    }
    
    public String getUsername(){
        return this.userName;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public LinkedList<Ticket> getTicketData() {
        return ticketData;
    }

    public void setTicketData(LinkedList<Ticket> ticketData) {
        this.ticketData = ticketData;
    }
}