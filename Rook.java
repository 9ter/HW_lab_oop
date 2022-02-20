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
public class Rook extends Figure{
   
    public Rook(String data,String party_data,int rank ,int file ,String file_rank_data){
        name = data;   
        party = party_data;   
        Name_in_board();
        position_file = file;  
        position_rank = rank;
        file_rank = file_rank_data;
   }
    
   public void Move(Board board ,int rank ,int file ,String file_rank_data){
       if(Check_Positions_Event(board,rank,file,file_rank_data)){
       System.out.println(" Succeed !! \""+board.board[position_rank][position_file].name+"\" Move \""+file_rank_data+"\"");
       System.out.println("-----------------------------------------------------------------------------------------------------------------------");
       board.board[position_rank][position_file] = null;
       board.board[rank][file] = this;
       position_rank = rank;
       position_file = file;
       file_rank = file_rank_data;
       }
       
   }
   
   public boolean Check_Positions_Event(Board board,int rank ,int file,String file_rabk){
   
       boolean right  ;
       boolean left  ;
       boolean up ;
       boolean down ;
        //กำหนดทิศทาง
       if(position_rank < rank){up = false;down=true;}else if(position_rank==rank){up = false;down=false;}else{up = true;down=false;}
       if(position_file < file){right = true; left = false;}else if(position_file ==file){right = false;left = false;}else{left = true;right = false;}
      
       if(right && left == false){//right
           if(position_rank != rank){System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because Role is  \""+name+"\""); return false;}  
           for(int i = position_file +1  ;i <= file;i++){
               if(board.board[position_rank][i] != null){
                   if(board.board[position_rank][i].party.equals(party)){
                       System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because \""+board.board[position_rank][i].name+"\" is \""+party+"\" party");
                       return false;               
                   }              
                   String party_em = board.board[position_rank][i].party; //kill          
                   for(int j =position_file+1;j<=file;j++){
                       if(board.board[position_rank][j] != null){
                           if(board.board[position_rank][j].party.equals(party_em)){
                               if(j < file){
                                   System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because Position \""+board.board[position_rank][j].file_rank+"\" have \""+board.board[position_rank][j].name+"\" is enemies ");
                                   System.out.println(" \"Relocation\"");                           
                                   System.out.println(" !! Event !! "+name+" KILL "+board.board[position_rank][j].name);  board.board[position_rank][j].Identity(false);                          
                                   Event_but_err(board,board.board[position_rank][j].position_rank,board.board[position_rank][j].position_file,board.board[position_rank][j].file_rank);                          
                                   return false;                           
                               }else{System.out.println(" !! Event !! "+name+" KILL "+board.board[position_rank][j].name);  board.board[position_rank][j].Identity(false);}                      
                           }               
                       }                        
                   }      
               }      
           }      
       }else if (right == false && left){ //left
           if(position_rank != rank){System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because Role is  \""+name+"\""); return false;}         
           for(int i = position_file -1 ;i >= file;i --){            
               if(board.board[position_rank][i] != null){
                   if(board.board[position_rank][i].party.equals(party)){
                       System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because \""+board.board[position_rank][i].name+"\" is \""+party+"\" party");
                       return false;
                   }
                   String party_em = board.board[position_rank][i].party; //kill
                   for(int j =position_file-1;j>=file;j--){
                       if(board.board[position_rank][j] != null){
                           if(board.board[position_rank][j].party.equals(party_em)){
                               if(j > file){                    
                                   System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because Position \""+board.board[position_rank][j].file_rank+"\" have \""+board.board[position_rank][j].name+"\" is enemies ");                          
                                   System.out.println(" \"Relocation\"");                         
                                   System.out.println(" !! Event !! "+name+" KILL "+board.board[position_rank][j].name);  board.board[position_rank][j].Identity(false);                          
                                   Event_but_err(board,board.board[position_rank][j].position_rank,board.board[position_rank][j].position_file,board.board[position_rank][j].file_rank);                          
                                   return false;
                               }else{System.out.println(" !! Event !! "+name+" KILL "+board.board[position_rank][j].name);  board.board[position_rank][j].Identity(false);}
                           }
                       }
                   }
               }
           }   
       }else if (down && up == false ){ //down
         if(position_file != file){System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because Role is  \""+name+"\""); return false;}
           for(int i = position_rank +1 ;i <= rank;i ++){
               if(board.board[i][position_file] != null){           
                   if(board.board[i][position_file].party.equals(party)){
                       System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because \""+board.board[i][position_file].name+"\" is \""+party+"\" party");
                       return false;
                   }
                   String party_em = board.board[i][position_file].party; //kill
                   for(int j =position_rank+1;j<=rank;j++){
                       if(board.board[j][position_file] != null){
                           if(board.board[j][position_file].party.equals(party_em)){                          
                               if(j < rank){
                                   System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because Position \""+board.board[j][position_file].file_rank+"\" have \""+board.board[j][position_file].name+"\" is enemies ");                          
                                   System.out.println(" \"Relocation\"");                         
                                   System.out.println(" !! Event !! "+name+" KILL "+board.board[j][position_file].name);  board.board[j][position_file].Identity(false);                          
                                   Event_but_err(board,board.board[j][position_file].position_rank,board.board[j][position_file].position_file,board.board[j][position_file].file_rank);                          
                                   return false;
                               }else{System.out.println(" !! Event !! "+name+" KILL "+board.board[j][position_file].name);  board.board[j][position_file].Identity(false);}
                           }
                       }
                   } 
               } 
           }    
       }
       else if (up && down == false ){ //up
           if(position_file != file){System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because Role is  \""+name+"\""); return false;}
           for(int i = position_rank -1 ;i >= rank;i--){
               if(board.board[i][position_file] != null){
               if(board.board[i][position_file].party.equals(party)){
                 System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because \""+board.board[i][position_file].name+"\" is \""+party+"\" party");
                   return false;
               }
               String party_em = board.board[i][position_file].party; //kill
               for(int j =position_rank-1;j>=rank;j--){
                       if(board.board[j][position_file] != null){
                           if(board.board[j][position_file].party.equals(party_em)){                          
                               if(j > rank){
                                   System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because Position \""+board.board[j][position_file].file_rank+"\" have \""+board.board[j][position_file].name+"\" is enemies ");                          
                                   System.out.println(" \"Relocation\"");                         
                                   System.out.println(" !! Event !! "+name+" KILL "+board.board[j][position_file].name);  board.board[j][position_file].Identity(false);                          
                                   Event_but_err(board,board.board[j][position_file].position_rank,board.board[j][position_file].position_file,board.board[j][position_file].file_rank);                          
                                   return false;
                               }else{System.out.println(" !! Event !! "+name+" KILL "+board.board[j][position_file].name);  board.board[j][position_file].Identity(false);}
                           }
                       }
                   }
               }
           }
          
       }
   return true;  
   }
   
   public void Event_but_err(Board board,int rank ,int file,String file_rabk_data){
       file_rank = file_rabk_data;
       System.out.println(" Succeed !! \""+board.board[position_rank][position_file].name+"\" Move \""+file_rank+"\"");
       System.out.println("-----------------------------------------------------------------------------------------------------------------------");
       board.board[position_rank][position_file] = null;
       board.board[rank][file] = this;
       position_rank = rank;
       position_file = file;
   }
}
