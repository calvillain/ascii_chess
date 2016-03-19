package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

//Piece subclass for Rook.
class Rook extends Piece{
	public Rook(char color, RankFile position, Board board){
		super(color, position, board);
		this.type = 'R';
	}

	// returns true if this piece is successfully moved to this location. returns false otherwise
	public boolean move(RankFile rf) {
		// NEEDS IMPLEMENTATION!
		return false;
	}

	// gets a list of valid moves for this specific type of piece
	public ArrayList<RankFile> getValidMoves() {
	// NEEDS IMPLEMENTATION!
		return null;
	}

	public String toString(){
		return "" + super.toString() + this.type;
	}
}
