/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

public class Player {
	char color;
	Board board;
	Player opponent;
	boolean check;
	boolean checkmate;
	ArrayList<Piece> pieces;
	
	
	//constructor for player object
	public Player(char color, Board board){
		this.color = color;
		this.board = board;
		this.check = false;
		this.checkmate = false;
		pieces = new ArrayList<Piece>();
		
		if (color == 'b'){
		//place black pieces
			board.position[0][0] = new Rook('b', new RankFile(8, 'a'), board, this);
			board.position[0][1] = new Knight('b', new RankFile(8,'b'), board, this);
			board.position[0][2] = new Bishop('b', new RankFile(8,'c'), board, this);
			board.position[0][3] = new Queen('b', new RankFile(8,'d'), board, this);
			board.position[0][4] = new King('b', new RankFile(8,'e'), board, this);
			board.position[0][5] = new Bishop('b', new RankFile(8,'f'), board, this);
			board.position[0][6] = new Knight('b', new RankFile(8,'g'), board, this);
			board.position[0][7] = new Rook('b', new RankFile(8,'h'), board, this);
			board.position[1][0] = new Pawn('b', new RankFile(7,'a'), board, this);
			board.position[1][1] = new Pawn('b', new RankFile(7,'b'), board, this);
			board.position[1][2] = new Pawn('b', new RankFile(7,'c'), board, this);
			board.position[1][3] = new Pawn('b', new RankFile(7,'d'), board, this);
			board.position[1][4] = new Pawn('b', new RankFile(7,'e'), board, this);
			board.position[1][5] = new Pawn('b', new RankFile(7,'f'), board, this);
			board.position[1][6] = new Pawn('b', new RankFile(7,'g'), board, this);
			board.position[1][7] = new Pawn('b', new RankFile(7,'h'), board, this);
		//add them to black's pieces arraylist
			this.pieces.add(board.position[0][0]);
			this.pieces.add(board.position[0][1]);
			this.pieces.add(board.position[0][2]);
			this.pieces.add(board.position[0][3]);
			this.pieces.add(board.position[0][4]);
			this.pieces.add(board.position[0][5]);
			this.pieces.add(board.position[0][6]);
			this.pieces.add(board.position[0][7]);
			this.pieces.add(board.position[1][0]);
			this.pieces.add(board.position[1][1]);
			this.pieces.add(board.position[1][2]);
			this.pieces.add(board.position[1][3]);
			this.pieces.add(board.position[1][4]);
			this.pieces.add(board.position[1][5]);
			this.pieces.add(board.position[1][6]);
			this.pieces.add(board.position[1][7]);
		}else if (color=='w'){
		//place white pieces
			board.position[6][0] = new Pawn('w', new RankFile(2,'a'), board, this);
			board.position[6][1] = new Pawn('w', new RankFile(2,'b'), board, this);
			board.position[6][2] = new Pawn('w', new RankFile(2,'c'), board, this);
			board.position[6][3] = new Pawn('w', new RankFile(2,'d'), board, this);
			board.position[6][4] = new Pawn('w', new RankFile(2,'e'), board, this);
			board.position[6][5] = new Pawn('w', new RankFile(2,'f'), board, this);
			board.position[6][6] = new Pawn('w', new RankFile(2,'g'), board, this);
			board.position[6][7] = new Pawn('w', new RankFile(2,'h'), board, this);
			board.position[7][0] = new Rook('w', new RankFile(1, 'a'), board, this);
			board.position[7][1] = new Knight('w', new RankFile(1,'b'), board, this);
			board.position[7][2] = new Bishop('w', new RankFile(1,'c'), board, this);
			board.position[7][3] = new Queen('w', new RankFile(1,'d'), board, this);
			board.position[7][4] = new King('w', new RankFile(1,'e'), board, this);
			board.position[7][5] = new Bishop('w', new RankFile(1,'f'), board, this);
			board.position[7][6] = new Knight('w', new RankFile(1,'g'), board, this);
			board.position[7][7] = new Rook('w', new RankFile(1,'h'), board, this);
		//add them to white's pieces arraylist
			this.pieces.add(board.position[6][0]);
			this.pieces.add(board.position[6][1]);
			this.pieces.add(board.position[6][2]);
			this.pieces.add(board.position[6][3]);
			this.pieces.add(board.position[6][4]);
			this.pieces.add(board.position[6][5]);
			this.pieces.add(board.position[6][6]);
			this.pieces.add(board.position[6][7]);
			this.pieces.add(board.position[7][0]);
			this.pieces.add(board.position[7][1]);
			this.pieces.add(board.position[7][2]);
			this.pieces.add(board.position[7][3]);
			this.pieces.add(board.position[7][4]);
			this.pieces.add(board.position[7][5]);
			this.pieces.add(board.position[7][6]);
			this.pieces.add(board.position[7][7]);
		}
		
		
		
	}
	
	public String toString(){
		String color = "";
		if ( this.color == 'w') {
			color = "white";
		} else if (this.color == 'b') {
			color = "black";
		}
		return color + " player";
	}
}
