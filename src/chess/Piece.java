package chess;

import java.util.ArrayList;
import chess.Chess.Pos;

class Piece{
	Pos position;
	char color;	//'w' = white, 'b' = black
	char type;
	
	public String toString(){
		return "" + this.color;
	}
	
}

class Pawn extends Piece implements Movable{
	public Pawn(){
		this.type = 'p';
	}
	public boolean move(int rank, char file) {
		// returns true if this piece can be moved to this location. returns false otherwise
		return false;
	}

	public ArrayList<Pos> getValidMoves() {
		// gets a list of valid moves for this specific type of piece
		return null;
	}
	
	public String toString(){
		return "" + super.toString() + this.type;
	}

	
}
