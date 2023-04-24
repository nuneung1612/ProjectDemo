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
    
    public User(){
        name = "";
        lastName = "";
        telNumber = "";
        email = "";
        userName = "";
        password = "";
    }
    
    public User(String name, String lastname, String email, String telNumber, String userName, String password){
        this.name = name;
        this.email = email;
        this.lastName = lastname;
        this.password = password;
        this.userName = userName;
        this.telNumber = telNumber;
        try(FileInputStream fin = new FileInputStream("UserData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            userData = (LinkedList)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        userData.add(this);
        try(FileOutputStream fOut = new FileOutputStream("UserData.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fOut);){
            oout.writeObject(userData);
        }catch(IOException e){
            System.out.println(e);
        }
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
}