package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

//Piece subclass for Rook.
class Rook extends Piece implements Movable{
	public Rook(char color, RankFile position, Board board){
		super(color, position, board);
		this.type = 'R';
	}
	public boolean move(RankFile rf) {
		// returns true if this piece is successfully moved to this location. returns false otherwise
		// NEEDS IMPLEMENTATION!
		return false;
	}

	public ArrayList<RankFile> getValidMoves() {
		// gets a list of valid moves for this specific type of piece
		// NEEDS IMPLEMENTATION!
		return null;
	}
	
	public String toString(){
		return "" + super.toString() + this.type;
	}
}
