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
import java.util.ArrayList; //  ArrayList<Integer> list = new ArrayList<>();
public  class Bishop extends Figure{
    
    ArrayList<Integer> list_fild = new ArrayList<>();
    ArrayList<Integer> list_rank = new ArrayList<>();
    
    public Bishop(){}
    public Bishop(String data,String party_data,int rank ,int file,String file_rank_data){
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

       boolean right_up;
       boolean left_up;
       boolean right_down;
       boolean left_down;
       boolean stoper = true;
       if(rank > position_rank && file > position_file){right_down = true;}else{right_down = false;}
       if(rank < position_rank && file > position_file){right_up = true;}else{right_up = false;}
       if(rank < position_rank && file < position_file){left_up = true;}else{left_up = false;}
       if(rank > position_rank && file < position_file){left_down = true;}else{left_down = false;}
       if(rank ==position_rank && file == position_file ){return true;}
      
       System.out.println(" right_up = "+right_up+"\n left_up = "+left_up+"\n right_down = "+right_down+"\n left_down = "+left_down);
       if(right_up == false && left_up == false && right_down ==false && left_down == false){System.out.println(" \""+name+"\" Can't Move \""+file_rabk+"\" Because Role is  \""+name+"\""); return false;}  
       if(left_up){// left_up -- 
           for(int i = position_rank-1;stoper;i--){
               for(int j = position_file-1;stoper;j-- ){
                  System.out.println("rank = "+ i +" file = "+j);
                  list_fild.add(j);
                  list_rank.add(i);
                  
                 
                  if(i <=0 && j<=0){stoper = false;}
                  if(board.board[i][j] != null){
                     System.out.println(board.board[i][j].name);
                   }i--;
               }

           }
       
       
       
       }

     
     
         return false;
     }

}
