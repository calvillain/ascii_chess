/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

public class Chess {
	//static member for position of pieces.
	public static class RankFile{	
		int rank;
		char file;
		public RankFile(int rank, char file){
			//To Do: make conditionals for checking valid rank and file values,
			//throw a 'invalid rank' exception if input has bad values for rank/file
			this.rank = rank;
			this.file = file;
		}
		
		public boolean equals(Object o){
			if (!(o.getClass().equals(this.getClass()))){
				return false;
			}
			RankFile rf = (RankFile) o;
			return ( ( this.rank == rf.rank ) && ( this.file == rf.file ) );			 
		}
		
		public String toString(){
			return "" + this.rank + this.file;
		}
	}
	public static void main(String[] args){
		System.out.println("lets chess!");
		
		Board b = new Board();	//board comes before any pieces
		System.out.println("printing blank board...\n");
		System.out.println(b);

		
		//*********test code************************************************************* 
		boolean move;
		//2d 3d (white)
		move = b.getPiece(2, 'd').move(3, 'd');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//7b 6b (black)
		move = b.getPiece(7,'b').move(6,'b');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//2g 3g (white)
		move = b.getPiece(2,'g').move(3,'g');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//8c 7b (black)
		move = b.getPiece(8,'c').move(7,'b');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//2a 4a (white)
		move = b.getPiece(2,'e').move(4,'e');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}

		//7b 5d (black)
		move = b.getPiece(7,'b').move(6, 'c');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//1d 4g (white)
		move = b.getPiece(1,'d').move(4, 'g');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//8g 6h (black)
		move = b.getPiece(8,'g').move(6, 'h');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//4g 4f (white)
		move = b.getPiece(4,'g').move(4, 'f');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//6h 4g (black)
		move = b.getPiece(6,'h').move(4, 'g');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//*******************************************************************************
		
		return;
	}
}
