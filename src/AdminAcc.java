/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.io.*;
public class AdminAcc implements Serializable{
    private String password;
    public AdminAcc(){
        this.password = "admin1234";
    }
    public void setPassword(String password){
        this.password = password;
        
    }
    public String getPassword(){
        return this.password;
    }
}
