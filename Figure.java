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
public class Figure {
    
    String name ; //ชื่อ
    String name_board; //ชื่อบนกระดาน
    int position_file; // ตำแหน่งบนบอร์ด
    int position_rank; // ตำแหน่งบนบอร์ด
    boolean identity = true; // ตัวตน ถ้าโดนกินจะหายไป
    String party ; // ฝ่าย
    
     boolean first_turn = true; // ตรวจสอบเทินแรกหรือไหม
    
   public Figure( ){
   }
   public Figure(String data,String party_data){
   name = data; 
   party = party_data;
   }
  
   
   public void Move_fig (int file,int rank){
     position_file = file;
     position_rank = rank;
   }
   
    public void Name_in_board (){ // สร้างชื่อที่จะแสดงบนกระดาน โดยใช้อักษร 2 ตัวแรก ถ้าซ้ำกันจะใช้อักษรลำดับต่อไปเลื่อย ๆ
     if(this.name != null){
         char nd1 = this.name.charAt(0);
         char nb2 = this.name.charAt(1);
         this.name_board = nd1+""+nb2;
     }
     else{
         System.out.print(" ผู้เล่นคนนี้ไม่มีชื่อ ");
     }
     
    }
    public void Name_in_board (int t){ // ถ้าซ้ำกันจะใช้อักษรลำดับต่อไปเลื่อย ๆ
     if(name != null){
         char nd1 = name.charAt(0);
         char nb2 = name.charAt(t);
         this.name_board = nd1+""+nb2;
     }
    }
     public void Identity (Boolean t){ // สถานะตาย
     identity = t;
    }
}
