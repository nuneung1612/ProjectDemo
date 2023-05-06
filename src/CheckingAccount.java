
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class CheckingAccount {
     private LinkedList userData = new LinkedList();
     private String usertag;
     private FileIO file = new FileIO();

      public boolean checkName(String name){
        if (name.equals("")){
            return false;
        }
        for (int i = 0; i < name.length(); i++){
            if(Character.isAlphabetic(name.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }
    public boolean checkTel(String tel){
        return (tel.length() == 10 && tel.charAt(0) == '0' && ( tel.charAt(1) == '9' || tel.charAt(1) == '8' || tel.charAt(1) == '6'));
    }
    
    public boolean checkPass(String pass){
        boolean hasNum = false;
        boolean hasChar = false;
        if(pass.length()<8){
            return false;
        }
        for(int i = 1; i< pass.length(); i++){
            if (Character.isAlphabetic(pass.charAt(i))){
                hasChar =true;
            }
            if (Character.isDigit(pass.charAt(i))){
                hasNum = true;
            }
            if (hasChar && hasNum ){
                return true;
            }
        }
        return false;
    }
    public boolean checkUser(String username){
        userData = file.loadUserData();
        if (userData  == null){
            return true;
        }
        if(username.equals("")){
            usertag = "Invalid username";
            return false;
        }
        for (int i = 0; i < userData.size(); i++){
            if (((User)userData.get(i)).getUsername().equals(username)){
                usertag = "This username has already used";
                    return false;
                }
        }
             return true;
    }
    public boolean checkEmail(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }
    
    public String getUsertag(){
        return this.usertag;
    }
    public void setUsertag(String usertag){
        this.usertag = usertag;
        
    }
    public LinkedList getUserData(){
        return this.userData;
    }
    
}
