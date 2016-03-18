/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import java.util.ArrayList;
import chess.Chess.RankFile;

class Piece{
	RankFile position;	//position object. tuple of rank, file
	char color;	//'w' = white, 'b' = black
	char type;	//'p' = pawn, 'K' = King, etc.
	
	//constructor for making a generic piece. needs color
	public Piece(char color, RankFile position){
		this.color = color;	//assigns color of piece
		this.position = position;
	}
	
	public RankFile getPos(){
		return this.position;
	}
	
	public String toString(){
		return "" + this.color;
	}
}

//subclass for Pawn.
class Pawn extends Piece implements Movable{
	public Pawn(char color, RankFile position){
		super(color, position);
		this.type = 'p';
	}
	public boolean move(int rank, char file) {
		// returns true if this piece can be moved to this location. returns false otherwise
		return false;
	}

	public ArrayList<RankFile> getValidMoves() {
		// gets a list of valid moves for this specific type of piece
		return null;
	}
	
	public String toString(){
		return "" + super.toString() + this.type;
	}
}

class Queen extends Piece implements Movable{
	public Queen(char color, RankFile position){
		super(color, position);
		this.type = 'Q';
	}
	public boolean move(int rank, char file) {
		// returns true if this piece can be moved to this location. returns false otherwise
		return false;
	}

	public ArrayList<RankFile> getValidMoves() {
		// gets a list of valid moves for this specific type of piece
		return null;
	}
	
	public String toString(){
		return "" + super.toString() + this.type;
	}
}
