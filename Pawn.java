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
public  class Pawn extends Figure {
    public Pawn(){
    }
    public Pawn(String data,String party_data,int rank ,int file,String file_rank_data){
    name = data; 
    party = party_data;
    Name_in_board();
    position_file = file;
    position_rank = rank;
    file_rank = file_rank_data;
   }
    
   public void Move(Board board ,int rank ,int file ,String file_rabk){
       board.board[position_rank][position_file] = null;
       board.board[rank][file] = this;
       position_rank = rank;
       position_file = file;
       
   }

}
