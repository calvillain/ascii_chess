/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import java.util.ArrayList;
import chess.Chess.RankFile;

abstract class Piece{
	RankFile position;	//position object. tuple of rank, file
	char color;	//'w' = white, 'b' = black
	char type;	//'p' = pawn, 'K' = King, etc.
	Board board;
	
	//constructor for making a generic piece. needs color
	public Piece(char color, RankFile position, Board board){
		this.color = color;	//assigns color of piece
		this.position = position;
		this.board = board;
	}
	
	//abstract method for getting a list of valid places to move a piece.
	abstract ArrayList<RankFile> getValidMoves();
	
	public RankFile getPos(){
		return this.position;
	}
	
	public String toString(){
		return "" + this.color;
	}
}




