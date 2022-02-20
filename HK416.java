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
        board.Setboard(); // ส่งชื่อผู้เล่น และ ฝ่าย
        //board.Move("ชื่อผู่เล่น","file")
      
        board.Move("Rook1/B", "a3");
        board.Move("Rook2/B", "f1");
        board.Move("Rook2/B", "f7");

        board.Move("Pawn6/W", "g7");
        board.Move("Rook2/B", "h7");
        board.Move("Rook2/B", "e7");
        board.Move("Rook2/B", "a7");
        board.Move("Rook2/B", "g7");
        board.Move("Rook1/W", "a5");
        board.Move("Rook1/B", "a1");
        board.Move("Bishop1/B", "a1");
       
        board.Info();
        
        
      
        
 

        
        
        
        
        
        
    }
    
}
    

