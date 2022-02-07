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
   
   
    
    String[][] borad_ = new String[8][8];  // ตาราง
    
    String borad_file[] = {"A","B","C","D","E","F","G","H"};  //file
    
    
    boolean excep_player ; // เช็คข้อผิดพลาด ถ้าไม่มีการส่งผู้เล่นมา
    Figure  figure_arrlist [] = new Figure[64]; // สร้างผู้เล่นตามจำนวนได้สูงสุด64คน

    boolean check_info = false; // ตรวจสอบการแสดงผล
    boolean check_name = false; // ตรวจสอบชื่อผู้เล่น
    boolean check_position = false; // ตรวจสอบช่องเดินที่ไม่มี
    int check_player; // บันทึกจำนวนผู้เล่น
    int check_player_black; // บันทึกจำนวนผู้เล่น black
    int check_player_white; // บันทึกจำนวนผู้เล่น white
   // boolean indentity = true; // เช็คมายังมีชีวิตไหม
    boolean check_input_name = true; //เช็คค่าinputnameที่รับมา
    
   ArrayList<String> name_die = new ArrayList<>(); // เก็บชื่อผู้เล่นที่ตาย
    
   
    
public void Setboard( ArrayList<Figure> player){ // setGame
    Setboard(); //เคลียบอร์ด
   //ตรวจสอบชื่อซ้ำ
    if(Check_Name(player)){
    //สร้างผู้เล่น
    int count = player.size(); // นับจำนวนผู้เล่นที่ได้มา
     // count = count;
    if(Exceptios_Count(count)){ //ส่งไปเช็คว่ามีผู้เล่นส่งมาไหม
        //loop สร้างผู้เล่นตามจำนวนที่ได้รับมา
       for(int i = 0; i < count ;i++){
       figure_arrlist[i] = player.get(i);
       //สร้างชื่อที่จะแสดงบนกระดาน โดยใช้อักษร 2 ตัวแรก ถ้าซ้ำกันจะใช้อักษรลำดับต่อไปเลื่อย ๆ 
       figure_arrlist[i].Name_in_board();
       // บันทึกจำนวนฝ่าย
       if( figure_arrlist[i].party.equals("black")){
           check_player_black = check_player_black+1;
       }else if (figure_arrlist[i].party.equals("white")){
             check_player_white = check_player_white+1;
              }
       }
       check_player = count; // บันทึกจำนวนผู้เล่น
       // loop รวมชื่อบนบอร์ดของผู้เล่นทุกคนส่งไปเช็ค
       ArrayList<String> list = new ArrayList<>();
       for(int i = 0; i < count ;i++){
           list.add(figure_arrlist[i].name_board);
       }
        //ส่งไปเช็คหาชื่อซ้ำ ค่าที่คืนมาคืนต่ำแหน่งในarrของตัวที่มีชื่อซ้ำ
       if( Check_Name_Board(list) != 99){ //มีชื่อซ้ำ
          int excep_name = Check_Name_Board(list); // เก็บตำแหน่งตัวที่ซ้ำ
          System.out.print(" ชื่อที่จะใช้แสดงบนบอร์ดซ้ำ ทำการเปลี่ยน "+figure_arrlist[excep_name].name+" จาก " +figure_arrlist[excep_name].name_board +" เป็น ");
          int c_name = figure_arrlist[excep_name].name.length(); // นับอักษรชื่อตัวที่ซ้ำ
          for(int i = 1; i < c_name ;i++){ //loop เปลี่ยนชื่อไปเลื่อย ๆ 
             figure_arrlist[excep_name].Name_in_board(i); //เปลี่ยนชื่อโดยเปลี่ยนอักษรตัวที่ 2 เป็น i
             list.clear(); // ล้างค่าarraylist
                for(int j = 0; j < count ;j++){ // loop เก็บชื่อใหม่
                list.add(figure_arrlist[j].name_board);
                }
                if(Check_Name_Board(list) == 99){ // ส่งไปเช็ค ถ้าไม่ซ้ำให้ออกจาก loop
                   System.out.println(figure_arrlist[excep_name].name_board);
                   Check_Info(true);
                break;
                }//else {System.out.println(" "+figure_arrlist[excep_name].name+" กรุณาเปลี่ยนชื่อใหม่ ");}
          }
       }
       Excep_Player(true); // มีผู้เล่น
       Check_Info(true); // แสดงกระดานได้
       
    }
    else{  Excep_Player(false); /* ไม่มีผู้เล่น */  Check_Info(false); /* ไม่ต้องแสดงกระดาน */ }  
    }
  
} 
public void Setboard(){ // setGame 
   for(int i =0;i<borad_.length;i++){  //เคลียบอร์ด
         for(int j =0;j<borad_.length;j++){
             borad_[i][j] = "[ "+"  "+" ] ";
         }      
   }
} 


 public void Move (String figure_name , String file ,int rank ){  // รับชื่อผู้เล่น // ตำแหน่งเดิน
    int char_count = Char_Count(file); // นับอักษร 
    int num_player = Check_Player(figure_name); //หาว่าเป็นผู้เล่นคนที่
    
    
    if(Check_Position(char_count,rank) && Check_Input_name(num_player,figure_name)){ // เช็คค่าinput หาข้อผิดพลาด
        
         figure_arrlist[0].identity = false;
         figure_arrlist[1].identity = false;
         figure_arrlist[4].identity = false;
         figure_arrlist[5].identity = false;
         if(figure_arrlist[num_player].identity != false){ // ยังมีชีวิตอยู่
             
              if(figure_arrlist[num_player].first_turn != false){ //ถ้า turn แรกจะไม่มีการเคียบอร์ด
              figure_arrlist[num_player].Move_fig(char_count,rank); // ผู้เล่นบันทึกตำแหน่งที่ให้ไป
              borad_[figure_arrlist[num_player].position_rank][figure_arrlist[num_player].position_file] = Insert(figure_arrlist[num_player].name_board); // บันทึกชื่อผู้เล่นบนกระดาน
              figure_arrlist[num_player].first_turn = false; //จบ first_turn
              }else{
              //ไม่ใช่ first_turn มีการเคลียช่องเก่าของผู้เล่น
              borad_[figure_arrlist[num_player].position_rank][figure_arrlist[num_player].position_file] = Insert(); // เคลียช่องเก่า
              figure_arrlist[num_player].Move_fig(char_count,rank); // ผู้เล่นบันทึกตำแหน่งที่ให้ไป
              borad_[figure_arrlist[num_player].position_rank][figure_arrlist[num_player].position_file] = Insert(figure_arrlist[num_player].name_board); // บันทึกชื่อผู้เล่นบนกระดาน
              }  
         }else{ Indentity(figure_arrlist[num_player].name);  }  
         
       
    } 
   }
 
 public void Info(){ // แสดงข้อมูล 
    if(check_info == true){
    System.out.println("\trank\t file");
    System.out.println("\t\t  A      B      C      D      E      F      G      H");
    System.out.print("\t0 :\t");
    for(int i =0;i<borad_.length;i++){
      System.out.print(borad_[0][i]);
    }
    System.out.print("\n\t1 :\t");
    for(int i =0;i<borad_.length;i++){
      System.out.print(borad_[1][i]);
    }
    System.out.print("\n\t2 :\t");
    for(int i =0;i<borad_.length;i++){
      System.out.print(borad_[2][i]);
    }
    System.out.print("\n\t3 :\t");
    for(int i =0;i<borad_.length;i++){
      System.out.print(borad_[3][i]);
    }
    System.out.print("\n\t4 :\t");
    for(int i =0;i<borad_.length;i++){
      System.out.print(borad_[4][i]);
    }
    System.out.print("\n\t5 :\t");
    for(int i =0;i<borad_.length;i++){
      System.out.print(borad_[5][i]);
    }
    System.out.print("\n\t6 :\t");
    for(int i =0;i<borad_.length;i++){
      System.out.print(borad_[6][i]);
    }
    System.out.print("\n\t7 :\t");
    for(int i =0;i<borad_.length;i++){
      System.out.print(borad_[7][i]);
    } 
    System.out.println();
    InfoBoard();
    }
     else{ // เกินข้อผิดพลาดอะไร ถึงแสดงกระดานไม่ได้
        if(excep_player == false){
           System.out.println(" ยังไม่มีผู้เล่น !!");
        }
        if(check_name == false){
           System.out.println(" มีผู้เล่นชื่อซ้ำกัน !!");
        }if(check_position == false){
          System.out.println(" ไม่มีช่องที่ป้อนมา !!");
        }if(check_input_name == false){
          System.out.println(" ไม่มีชื่อ INPUT นี้บนกระดาน !!");
        }   
    }
    
 }
 public void Info(String name){System.out.println(name+" ผู้เล่นคนี้ตายแล้วไม่สามารถเดินได้ !!");}
  public void InfoBoard(){
    Count_Die();// ลบผู้เล่นที่ตาย
    System.out.println(" ข้อมูลบนการดาน ");
    System.out.print(" จำนวนผู้เล่นฝ่ายดำ  : " + check_player_black);
    for(int i =0;i<check_player;i++){
     if( figure_arrlist[i].party.equals("black")){
            System.out.print(" : "+figure_arrlist[i].name);
            if(figure_arrlist[i].identity == false){
                System.out.print(" (ตาย)");
            }
       }
    } 
    System.out.println();
    System.out.print(" จำนวนผู้เล่นฝ่ายขาว : " + check_player_white);
    for(int i =0;i<check_player;i++){
     if( figure_arrlist[i].party.equals("white")){
            System.out.print(" : "+figure_arrlist[i].name);
            if(figure_arrlist[i].identity == false){
                System.out.print(" (ตาย)");
            }
       }
    } 
    System.out.println();
    System.out.print(" ตำแหน่งผู้เล่นฝ่ายดำ : ");
    for(int i =0;i<check_player;i++){
     String file = Return_Char_Count(figure_arrlist[i].position_file);
     
     if(figure_arrlist[i].party.equals("black")){
        if(figure_arrlist[i].first_turn != true){
        System.out.print(figure_arrlist[i].name+" "+file+figure_arrlist[i].position_rank+" : ");
     } 
        else if(figure_arrlist[i].first_turn == true && figure_arrlist[i].identity == true ){
         System.out.print(figure_arrlist[i].name+" ยังไม่มีตำแหน่ง : ");
         }
         /* else if(figure_arrlist[i].identity == false ){
         System.out.print(figure_arrlist[i].name+" ผู้เล่นตายแล้ว : ");
         }*/
     }    
    }System.out.println();
    
    System.out.print(" ตำแหน่งผู้เล่นฝ่ายขาว: ");
    for(int i =0;i<check_player;i++){
     String file = Return_Char_Count(figure_arrlist[i].position_file);
     
     if(figure_arrlist[i].party.equals("white")){
        if(figure_arrlist[i].first_turn != true){
        System.out.print(figure_arrlist[i].name+" "+file+figure_arrlist[i].position_rank+" : ");
     } 
        else if(figure_arrlist[i].first_turn == true && figure_arrlist[i].identity == true ){
         System.out.print(figure_arrlist[i].name+" ยังไม่มีตำแหน่ง : ");
         }
         /* else if(figure_arrlist[i].identity == false ){
         System.out.print(figure_arrlist[i].name+" ผู้เล่นตายแล้ว : ");
         }*/
     }    
    }
  
    System.out.println();
  }
 
 
   public boolean Check_Position(int file,int rank){ // เช็คช่องเดินที่ไม่มี
    if(file >8 || rank > 8 ){
        Check_Info(false);
        check_position = false;
        return false; }
    if(file <0 || rank < 0 ){
        check_position = false;
        Check_Info(false);
        return false;}
    check_position = true;
    return true;
   }
   public boolean Excep_Player(boolean t){ // ตรวจสอบการเดินเกินช่อง หรือ ช่องเดียวกัน
        return  excep_player = t; // ถ้าไม่มีข้อผิดพลาด info แสดงได้
   }
   public boolean Exceptios_Count(int count){ // เช็คข้อผิดพลาด
         if(count < 0) return false; else return true;
      }
   public boolean Check_Info(boolean t){ // เช็คข้อผิดพลาด
       return check_info = t ;
      }
   public boolean Check_Name(ArrayList<Figure> figure){ // เช็คข้อผิดพลาด ชื่อซ้ำ
       int count = figure.size();
       for(int i = 0 ;i<count;i++){ //loop หาชื่อที่ซ้ำกัน
           for(int j = i+1 ;j < count;j++){
                      //System.out.println(figure.get(i).name +" == "+ figure.get(j).name) ;
                  if(figure.get(i).name == figure.get(j).name){
                      //System.out.println(figure.get(i).name +" == "+ figure.get(j).name) ;
                      Check_Info(false); // ไม่ต้องแสดงบอร์ด
                      Excep_Player(true); //มีผู้เล่น แต่ชื่อซ้ำกัน
                      return check_name = false; // มีชื่อซ้ำกัน
                 }
            }
       }
       return check_name = true ; // ไม่มีชื่อซ้ำกัน
      }
   public int Check_Name_Board(ArrayList<String> figure){
       int count = figure.size();
       for(int i = 0 ;i<count;i++){ //loop หาชื่อที่ซ้ำกัน
           for(int j = i+1 ;j < count;j++){
                  if(figure.get(i).equals(figure.get(j))){
                   return j; //ส่งตำแหน่งตัวที่ซ้ำกลับไป
                 }
            }
       }
   return 99 ;}
   
   public int Check_Player(String name){
   
       if(name != null){
        for(int i = 0 ;i<check_player;i++){
          if(figure_arrlist[i].name.equals(name)){
            return i;
         }
        }
       }else{System.out.println(" ไม่มีชื่อผู้เล่น ");}
   return 99;
   }
   
   public String Insert(String name){
       String fullname = "[ "+""+name+""+" ] ";
       return fullname;
   }
   public String Insert(){
       String fullname = "[ "+"  "+" ] ";
       return fullname;
   }
   
   public boolean Check_Input_name(int num_name,String name){
        
       if(num_name != 99){
       check_input_name = true;
       }else{
       check_input_name = false; 
       Check_Info(false);
       System.out.print(name+" ");
       }
       return check_input_name;
   }
  public void Indentity(String name){
             name_die.add(name);
             Info(name);
             
  }
  public void Count_Die(){
         
      for(int i = 0 ;i<check_player;i++){
              if( figure_arrlist[i].party.equals("black")){
                  if(figure_arrlist[i].identity == false){
                      check_player_black = check_player_black-1;
                  }
              }              
              else if (figure_arrlist[i].party.equals("white")){   
                  if(figure_arrlist[i].identity == false){
                  check_player_white = check_player_white-1;     
                  }
              } 
      }      
  }
  
   public int Char_Count(String data){ // นับอักษร
      switch (data) {
       case "A" : return 0;
         case "B" : return 1;
           case "C" : return 2;
             case "D" : return 3;
               case "E" : return 4;
                 case "F" : return 5;
                   case "G" : return 6;
                     case "H" : return 7;
       default: System.out.println(" ใช้ตัวพิมใหญ่ A-H เท่านั้น");  return 99;
       }
   }
   public String Return_Char_Count(int data){ // นับอักษร
      switch (data) {
       case 0 : return "A";
         case 1 : return "B";
           case 2 : return "C";
             case 3 : return "D";
               case 4 : return "E";
                 case 5 : return "F";
                   case 6 : return "G";
                     case 7 : return "H";
       default: return "";
       }
   }
   
   
}
