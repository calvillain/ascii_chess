/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

public class Player {
	char color;
	Board board;
	boolean check;
	boolean checkmate;
	public Player(char color, Board board){
		this.color = color;
		this.board = board;
		this.check = false;
		this.checkmate = false;
	}
	
	
}
