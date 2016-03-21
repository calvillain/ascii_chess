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
	
	//constructor for player object
	public Player(char color, Board board){
		this.color = color;
		this.board = board;
		this.check = false;
		this.checkmate = false;
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
