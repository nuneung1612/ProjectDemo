

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.util.LinkedList;
import java.util.regex.*;
public class CheckingAccount {
     private LinkedList userData = new LinkedList();
     private String usertag;

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
        userData = FileIO.loadUserData();
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
           String ePattern = "[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*";
           Pattern p = Pattern.compile(ePattern);
           Matcher m = p.matcher(email);
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
