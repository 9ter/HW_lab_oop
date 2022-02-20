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
import java.util.ArrayList;
public class Board   { 
    
    Figure[][] board = new Figure[8][8];
  
  
   
 

 
    int player_number; // บันทึกจำนวนผู้เล่น
    int player_black; // บันทึกจำนวนผู้เล่น black
    int player_white; // บันทึกจำนวนผู้เล่น white
    
  // ArrayList<String> name_die = new ArrayList<>(); // เก็บชื่อผู้เล่นที่ตา
    
   
    
public void Setboard(){ // setGame
   
    board[0][0] = new Rook("Rook1/B","Black",0,0,"a1");
    board[0][1] = new Knight("Knight1/B","Black",0,1);
    board[0][3] = new Bishop("Bishop1/B","Black",3,3,"c1");
    board[0][3] = new Queen("Queen/B","Black",0,3);
    board[0][4] = new King("King/B","Black",0,4);
    board[0][5] = new Bishop("Bishop2/B","Black",0,5,"f1");
    board[0][6] = new Knight("Knight2/B","Black",0,6);
    board[0][7] = new Rook("Rook2/B","Black",0,7,"h1");

    for(int  i =0 ;i< board.length;i++){
      String s = String.valueOf(i+1);
      board[1][i] = new Pawn("Pawn"+s+"/B","Black",1,i,""+pawn(i)+"2");
    }
    for(int  i =0 ;i< board.length;i++){
        String s = String.valueOf(i+1);
      board[6][i] = new Pawn("Pawn"+s+"/W","White",6,i,""+pawn(i)+"7");
    }
    
    board[7][0] = new Rook("Rook1/W","White",7,0,"a8");
    board[7][1] = new Knight("Knight1/W","White",7,1);
    board[7][2] = new Bishop("Bishop1/W","White",7,2,"c8");
    board[7][3] = new Queen("Queen/W","White",7,3);
    board[7][4] = new King("King/W","White",7,4);
    board[7][5] = new Bishop("Bishop2/W","White",7,5,"f8");
    board[7][6] = new Knight("Knight2/W","White",7,6);
    board[7][7] = new Rook("Rook2/W","White",7,7,"h8");
    
    for(int i =0;i<board.length;i++){ // นับผู้เล่น
        for(int j =0;j<board.length;j++){
            if(board[i][j] != null){
            if(board[i][j].party.equals("White")){
            player_white = player_white+1;
            }else{player_black = player_black+1;}
            }
        }
    }
    
    Info();
 
} 

 public void Move (String figure_name , String file ){  // รับชื่อผู้เล่น // ตำแหน่งเดิน
    
    if(Check_Name(figure_name) && Check_Input(file,figure_name)){
     String position[] = file.split("");
     int file_count = Char_Count(position[0]); //  File
     int rank = Integer.parseInt(position[1]); //  Rank
     rank = rank-1;
     if(Check_Position(file_count,rank,figure_name)){
         System.out.println(" "+figure_name+" Move " + file);
     int rank_ = PositiosRank(figure_name);
     int file_ = PositiosFile(figure_name);
     board[rank_][file_].Move(this, rank, file_count,file);
     }    
    }    
   }
 
 public void Info(){ // แสดงข้อมูล 
    System.out.println("");
    System.out.println("  ┆    A   ┆    B   ┆    C   ┆    D   ┆    E   ┆    F   ┆    G   ┆    H   ┆");
    System.out.println("  ┌--------┬--------┬--------┬--------┬--------┬--------┬--------┬--------┐");
    //System.out.print("┆ ");
    for(int i = 0 ; i < board.length; i++){
         System.out.print(i+1);
        for(int j = 0 ; j < board.length; j++){
         if(board[i][j] != null && board[i][j].identity == true ){
            System.out.print(" ┆  "+board[i][j].name_board);
         }else{System.out.print(" ┆       ");}
        }
        System.out.print("\n  └--------┴--------┴--------┴--------┴--------┴--------┴--------┴--------┘");
        System.out.println("");
    }
    System.out.println("\n");
    //InfoBoard();
    System.out.println("\n----------------------------------------------------------------------------");
    System.out.println("\n\n");
}
 /*public void Info_die(String name){System.out.println(name+" This player is dead, unable to walk. !!");}
 public void InfoBoard(){
    System.out.println(" ข้อมูลบนการดาน ");
    System.out.print(" จำนวนผู้เล่นฝ่ายดำ  : " + player_black);
    for(int i =0;i<board.length;i++){
     if( figure_arrlist[i].party.equals("black")){
            System.out.print(" : "+figure_arrlist[i].name);
            if(figure_arrlist[i].identity == false){
                System.out.print(" (ตาย)");
            }
       }
    } 
    System.out.println();
    System.out.print(" จำนวนผู้เล่นฝ่ายขาว : " + player_white);
    for(int i =0;i<board.length;i++){
     if( figure_arrlist[i].party.equals("white")){
            System.out.print(" : "+figure_arrlist[i].name);
            if(figure_arrlist[i].identity == false){
                System.out.print(" (ตาย)");
            }
       }
    } 
    System.out.println();
    System.out.print(" ตำแหน่งผู้เล่นฝ่ายดำ : ");
    for(int i =0;i<board.length;i++){
    // String file = Return_Char_Count(figure_arrlist[i].position_file);
     
     if(figure_arrlist[i].party.equals("black") && figure_arrlist[i].identity == true){
        if(figure_arrlist[i].first_turn != true){
       // System.out.print(figure_arrlist[i].name+" "+file+figure_arrlist[i].position_rank+" : ");
     } 
        else if(figure_arrlist[i].first_turn == true && figure_arrlist[i].identity == true ){
         System.out.print(figure_arrlist[i].name+" ยังไม่มีตำแหน่ง : ");
         }
         /* else if(figure_arrlist[i].identity == false ){
         System.out.print(figure_arrlist[i].name+" ผู้เล่นตายแล้ว : ");
         }*/
     //}    
  /*  }System.out.println();
    
    System.out.print(" ตำแหน่งผู้เล่นฝ่ายขาว: ");
    for(int i =0;i<board.length;i++){
     //String file = Return_Char_Count(figure_arrlist[i].position_file);
     
     if(figure_arrlist[i].party.equals("white") && figure_arrlist[i].identity == true ){
        if(figure_arrlist[i].first_turn != true){
    //    System.out.print(figure_arrlist[i].name+" "+file+figure_arrlist[i].position_rank+" : ");
     } 
        else if(figure_arrlist[i].first_turn == true && figure_arrlist[i].identity == true ){
         System.out.print(figure_arrlist[i].name+" ยังไม่มีตำแหน่ง : ");
         }
         /* else if(figure_arrlist[i].identity == false ){
         System.out.print(figure_arrlist[i].name+" ผู้เล่นตายแล้ว : ");
         }
     }    
    }
  
    System.out.println("\n");
  }
*/
 /*public void Event_Info(String name , String name_){
 System.out.println(" !! Event !!");
 System.out.println(" !! "+name_+"  ถูกกินโดย " + name);
 }
 */
   public boolean Check_Position(int file,int rank ,String name){ // เช็คช่องเดินที่ไม่มี
    if(file >= board.length || rank >= board.length ){
        //Check_Info(false);
        System.out.println("  "+name+" INPUT ERROE try again !!");
        System.out.println("  example : board.Move(\""+name+"\",\"a4\");");
        return false; 
    }
    if(file < 0 || rank < 0 ){
        //Check_Info(false);
        System.out.println("  "+name+" INPUT ERROE try again !!");
        System.out.println("  example : board.Move(\""+name+"\",\"a4\");");
        return false;
    }
    return true;
   }
   
 /*  public boolean Check_Position_Board(Figure figure,int rank, int file){ // เช็คช่องเดินที่ไม่มี
        
        //  System.out.println(figure.name);
        for(int i = 0 ; i< board.length;i++){
            if(figure.party.equals("white")){
               if(figure_arrlist[i].position_file == file && figure_arrlist[i].position_rank == rank && figure_arrlist[i].party.equals("white") ){
                //System.out.println(figure_arrlist[i].name);
                //Infosuperpositions(figure.name,figure.party,figure_arrlist[i].name,figure_arrlist[i].position_file,figure_arrlist[i].position_rank);
                return false;
               }else if (figure_arrlist[i].position_file == file && figure_arrlist[i].position_rank == rank && figure_arrlist[i].party.equals("black")){
                   Event(figure_arrlist[i].position_rank,figure_arrlist[i].position_rank,i);
                   Event_Info(figure.name,figure_arrlist[i].name);
                   
               }
            }
            if(figure.party.equals("black")){
               if(figure_arrlist[i].position_file == file && figure_arrlist[i].position_rank == rank && figure_arrlist[i].party.equals("black")){
                //System.out.println(figure_arrlist[i].name);
              //  Infosuperpositions(figure.name,figure.party,figure_arrlist[i].name,figure_arrlist[i].position_file,figure_arrlist[i].position_rank);
                return false;
               }else if (figure_arrlist[i].position_file == file && figure_arrlist[i].position_rank == rank && figure_arrlist[i].party.equals("white")){
                   Event(figure_arrlist[i].position_rank,figure_arrlist[i].position_rank,i);
                   Event_Info(figure.name,figure_arrlist[i].name);
                   
               }
            }
           }
        

         return true;
   }
   public void Event(int rank ,int file,int arr_posi){
   
       figure_arrlist[arr_posi].position_file = 99 ;  figure_arrlist[arr_posi].position_rank = 99;
       figure_arrlist[arr_posi].Identity(false);
       borad_[rank][file] = "[ "+"  "+" ] ";
   
   } 


   public boolean Check_Info(boolean t){ 
       return check_info = t ;
      }

*/
   public boolean Check_Name(String figure_name){ 
       for(int i =0;i<board.length;i++){
         for(int j =0;j<board.length;j++){
             if(board[i][j] != null){
             if(board[i][j].name.equals(figure_name)&&board[i][j].identity){
                 //System.out.println(board[i][j].name);
                 return true ;
             }     
             }      
         }
     }
       System.out.println(" "+figure_name+" Name INPUT ERROR or Player Die please try again");
     return  false ;
   }

   
   

  public int  PositiosRank(String figure_name){ 
      for(int i =0;i<board.length;i++){
         for(int j =0;j<board.length;j++){
             if(board[i][j] != null){
             if(board[i][j].name.equals(figure_name)){
                  return i ;
             }     
             }      
         }
     }
     System.out.println(" PositiosRank INPUT ERROR please try again");
     return  99 ; 
  }
   public int  PositiosFile(String figure_name){
       for(int i =0;i<board.length;i++){
         for(int j =0;j<board.length;j++){
             if(board[i][j] != null){
             if(board[i][j].name.equals(figure_name)){
                  return j ;
             }     
             }      
         }
     }
     System.out.println(" PositiosFild INPUT ERROR please try again");
     return  99 ;
  }
  
   public int Char_Count(String data){ // นับอักษร
      char file_char = data.charAt(0);
      int file_num = Character.getNumericValue(file_char-'0');
      return file_num -1 ;  
   }
   public String pawn(int data){ // นับอักษร
     switch(data){
         case 0 : return "a";
         case 1 : return "b";
         case 2 : return "c";
         case 3 : return "d";
         case 4 : return "e";
         case 5 : return "f";
         case 6 : return "g";
         case 7 : return "h";
         default : return "" ; 
     }
   }
   
   public boolean Check_Input(String data ,String name){ // นับอักษร
      int delta = data.length();
      if(delta < 2 || delta>2 ){
       System.out.println(" "+name+" INPUT ERROR example : board.Move(\""+name+"\",\"a4\");");
       System.out.println();
       return false;
      }else{return true;}
     
   }
}
