/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import java.util.ArrayList;
import chess.Chess.RankFile;

/**
 * abstract class for Piece object.
 * @author Calvin Lee, Bartosz Kidacki
 *
 */
abstract class Piece {
	RankFile position; // position object. tuple of rank, file
	char color; // 'w' = white, 'b' = black
	char type; // 'p' = pawn, 'K' = King, etc.
	boolean unmoved;
	Board board;
	Player player;	//owner of this piece
	

	// constructor for making a generic piece. needs color, position, board, and player.
	public Piece(char color, RankFile position, Board board, Player player) {
		this.color = color; // assigns color of piece
		this.position = position;
		this.board = board;
		this.player = player;
		this.unmoved = true;
	}

	// abstract method for getting a list of valid places to move a piece.
	abstract ArrayList<RankFile> getValidMoves();

	// returns true if this piece is successfully moved to this location.
	// returns false otherwise
	boolean movePiece(RankFile rf) {
		//error conditions for invalid rank file parameters
		if (rf.rank < 1 || rf.rank > 8 || rf.file < 'a' || rf.file > 'h'){
			return false;
		}
		
		if (this.getValidMoves().contains(rf)) { // if this is one of the valid moves
			RankFile oldrf = this.position;
			this.position = rf; // change this piece's position field
			
			//if taking opponent's piece
			if ( board.getPiece(rf) != null ) {
				//remove this piece from opponent's pieces list
				this.player.opponent.pieces.remove(board.getPiece(rf));
				//System.out.println("removed! opponent's remaining pieces:");
				//System.out.println(this.player.opponent.pieces);
			}
			Piece takenPiece = null; 
			if (board.getPiece(rf) != null){
				takenPiece = board.getPiece(rf);
			}
			board.setPiece(this, rf); // update the board by adding to new
			// position
			board.removePiece(oldrf); // and deleting from old position
			this.unmoved = false;
			
			
			boolean wasChecked = player.check;
			boolean willCheck = false;
			
			int i = 0;
			int j = 0;
			
			ArrayList<RankFile> nextMoves;
			Piece isKing;
			//System.out.println(player.opponent.pieces);
			while (i < player.opponent.pieces.size()){
				//System.out.println("checking opponent's pieces..");
				//System.out.println(player.opponent.pieces.get(i));
				//look for opponent's pieces that are checking your king
				nextMoves = player.opponent.pieces.get(i).getValidMoves();
				while (j < nextMoves.size()){
					
					isKing = board.getPiece(nextMoves.get(j)); 
					
					if (isKing != null && isKing.color == this.color && isKing.type == 'K'){
						//this means this move will result in your king being placed in check.
						//revert! this move is not allowed!
						willCheck = true;
						
					}
					j++;	//next move
				}
				i++;	//next piece
				j = 0;
			}

			
			
			i = 0;
			j = 0;
			
			while (i < player.pieces.size()){
				//look for pieces that are checking opponent's king
				nextMoves = player.pieces.get(i).getValidMoves();
				while (j < nextMoves.size()){
					isKing = board.getPiece(nextMoves.get(j)); 
					
					if (isKing != null && isKing.color != this.color && isKing.type == 'K'){
						//this means this move has put your opponent's king in check
						player.opponent.check = true;
					}
					j++;	//next move
				}
				i++;	//next piece
				j = 0;
			}
			
			//if you were not checked, and this move will not make you checked
			if ( (!wasChecked) && (!willCheck) ) {
				return true;	//it's allowed.
			//if you were not checked, and this move will make you checked
			}else if ( (!wasChecked) && (willCheck) ) {
				//it's not allowed. must revert, and return false!
				board.setPiece(this, oldrf);
				board.removePiece(rf);
				if (takenPiece != null){
					board.setPiece(takenPiece, rf);
				}
				return false;
			//if you were checked, and this move will not make you checked 
			}else if ( (wasChecked) && (!willCheck) ) {
				//this move is allowed!
				player.check = false;
				return true;
			//if you were checked, and this move will still make you checked
			}else if ( (wasChecked) && (willCheck) ) {
				//it's not allowed. must revert, and return false!
				board.setPiece(this, oldrf);
				board.removePiece(rf);
				if (takenPiece != null){
					board.setPiece(takenPiece, rf);
				}
			}
		}//if this is not one of the valid moves
		return false;
	}
	
	
	
	//same method, different signaure
	boolean movePiece(int rank, char file) {
		RankFile rf = new RankFile(rank, file);
		return this.movePiece(rf);
	}


	//returns this piece's position (RankFile object)
	public RankFile getPos() {
		return this.position;
	}

	public String toString() {
		return "" + this.color + this.type;
	}
}
