/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hk416;

/**
 *
 * @author HK416
 */
import java.util.ArrayList; // import the ArrayList // ArrayList<type> list = new ArrayList<>();
import java.util.Scanner; // Scanner myObj = new Scanner(System.in); 
public class HK416 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Figure> list = new ArrayList<>(); //ใช้ ArrayList ช่วยในการเพิ่มผู้เล่นได้หลายคน
       
        //สร้างกระดาน
        Board board = new Board(); 
        //สร้างผู้เล่นกี่คนก็ได้ ห้ามเกินช่องที่มี 64 
        list.add(new Figure("Mel","black"));
        list.add(new Figure("Fubuki","black"));
        list.add(new Figure("Rosenthal","black"));
        list.add(new Figure("Haato","black"));
        list.add(new Figure("Aqua","white"));
        list.add(new Figure("Shion","white"));
        list.add(new Figure("Ayame","white"));
        list.add(new Figure("Choco","white"));
        list.add(new Figure("Chocos","white"));
        list.add(new Figure("Subaru","white"));
        
        board.Setboard(list); // ส่งชื่อผู้เล่น และ ฝ่าย
        // board.Move("ชื่อผู่เล่น","file",rank)
        board.Move("Mel","A",0);
        board.Move("Fubuki","B",0);
        board.Move("Rosenthal","C",0);
        board.Move("Haato","D",0);
        board.Move("Aqua","A",7);
        board.Move("Shion","B",7);
        board.Move("Ayame","C",7);
        board.Move("Choco","D",7);
        board.Move("Subaru","E",7);
       
        board.Info();
       

        
        
        
        
        
        //System.out.println(list.get(0).name +" file " +list.get(0).position_file+" rank " + list.get(0).position_rank);

    }
    
}
    

