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
public abstract class  Figure {
    
    String name ; //ชื่อ
    String name_board; //ชื่อบนกระดาน
    int position_file; // ตำแหน่งบนบอร์ด
    int position_rank; // ตำแหน่งบนบอร์ด
    String file_rank;
    boolean identity = true; // ตัวตน ถ้าโดนกินจะหายไป
    String party ; // ฝ่าย
   
   
    public abstract void Move (Board board ,int rank ,int file,String file_rabk );
   
    public void Name_in_board (){ // สร้างชื่อที่จะแสดงบนกระดาน
     if(name != null){
         String name_board[] = name.split("");
         String name_party[] = name.split("/");
         int num = name_party[0].length();
         String name_num =name_board[num-1]; 
         String Fullname_board = name_board[0]+name_board[1]+name_num+"/"+name_party[1];
         this.name_board = Fullname_board;
     }
    }
     public void Identity (Boolean t){ // สถานะตาย
     identity = t;
    }
}
