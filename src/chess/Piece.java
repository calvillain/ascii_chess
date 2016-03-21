/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import java.util.ArrayList;
import chess.Chess.RankFile;

abstract class Piece {
	RankFile position; // position object. tuple of rank, file
	char color; // 'w' = white, 'b' = black
	char type; // 'p' = pawn, 'K' = King, etc.
	Board board;

	// constructor for making a generic piece. needs color
	public Piece(char color, RankFile position, Board board) {
		this.color = color; // assigns color of piece
		this.position = position;
		this.board = board;
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
		if (this.getValidMoves().contains(rf)) { // if this is one of the valid
			// moves
			RankFile oldrf = this.position;
			this.position = rf; // change this piece's position field
			board.setPiece(this, rf); // update the board by adding to new
			// position
			board.removePiece(oldrf); // and deleting from old position

			return true;
		}
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
