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
public class FileIO{
    public static void saveUserData(LinkedList user){
        try(FileOutputStream fOut = new FileOutputStream("UserData.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fOut);){
            oout.writeObject(user);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static void saveTourData(LinkedList tour){
        try(FileOutputStream fOut = new FileOutputStream("TourData.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fOut);){
            oout.writeObject(tour);
        }catch(IOException e){
        System.out.println(e); 
        }
    }
    
    public static void saveTicketID(int id){
        try(FileWriter fw = new FileWriter("TicketID.dat");){
            fw.write(String.valueOf(id));
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static void saveAdminData(AdminAcc admin){
        try(FileOutputStream fOut = new FileOutputStream("AdminAcc.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fOut);){
            oout.writeObject(admin);
        }catch(IOException e){
        System.out.println(e);
        }
    }
    
    public static LinkedList loadUserData(){
        try(FileInputStream fin = new FileInputStream("UserData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            return ((LinkedList)in.readObject());
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
            return new LinkedList();
        }
    }
    
    public static  LinkedList loadTourData(){
        try(FileInputStream fin = new FileInputStream("TourData.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            return ((LinkedList)in.readObject());
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
            return new LinkedList();
        }
    }

    public static AdminAcc loadAdminData(){
        try(FileInputStream fin = new FileInputStream("AdminAcc.dat");
            ObjectInputStream in = new ObjectInputStream(fin);){
            return ((AdminAcc)in.readObject());
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
            return new AdminAcc();
        }
    }
    
    public static int loadTicketID(){
        int ch;
        String text = "";
        try(FileReader fr = new FileReader("TicketID.dat");){
            while ((ch = fr.read()) != -1){
                text += (char)ch;
            }
            return Integer.parseInt(text);
        }catch(IOException e){
            System.out.println(e);
            return 0;
        }    
    }
}
