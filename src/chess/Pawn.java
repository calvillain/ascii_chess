package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

//Piece subclass for Pawn.
class Pawn extends Piece implements Movable{
	boolean unmoved;
	
	public Pawn(char color, RankFile position, Board board){
		super(color, position, board);
		this.type = 'p';
		this.unmoved = true;
	}
	// returns true if this piece is successfully moved to this location. returns false otherwise
	public boolean move(RankFile rf) {
		if (this.getValidMoves().contains(rf)) {	//if this is one of the valid moves
			this.position = rf;	//move the piece	//change this piece's position field
			board.setPiece(this, rf);		//update the board
			return true;
		}
		return false;
	}
	
	// gets a list of valid moves for this specific type of piece
	public ArrayList<RankFile> getValidMoves() {
		int r = this.position.rank;
		char f = this.position.file;
		
		ArrayList<RankFile> ans = new ArrayList<RankFile>();
		int forward;	//determines which direction is forward 
		if (color == 'w') {
			forward = 1;	//white = "up is forward"
		} else {
			forward = -1;	//black = "down is forward"
		}
		
		ans.add(new RankFile(r + forward, f));	//adds forward position
		
		if (this.unmoved) {	//adds 2nd forward position, if unmoved
			ans.add(new RankFile(r + (2*forward), f));
		}
		
		Piece p = board.getPiece(r + forward, (char)(f+1));	//diagonal 1
		if (p != null) {
			if (p.color != this.color) {
				ans.add(new RankFile(r + forward, (char)(f+1)));
			}
		}
		p = board.getPiece(r + forward, (char)(f-1));	//diagonal 2
		if (p != null) {
			if (p.color != this.color) {
				ans.add(new RankFile(r + forward, (char)(f-1)));
			}
		}
	
		return ans;
	}
	
	public String toString(){
		return "" + super.toString() + this.type;
	}

}