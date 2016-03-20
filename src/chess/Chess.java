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
		
		b.getPiece(2, 'd').move(3, 'd');
		System.out.println(b);
		
		b.getPiece(7,'b').move(6,'b');
		System.out.println(b);
		
		b.getPiece(2,'g').move(3,'g');
		System.out.println(b);

		b.getPiece(8,'c').move(7,'b');
		System.out.println(b);
		
		b.getPiece(2,'a').move(4,'a');
		System.out.println(b);
		
		b.getPiece(7,'b').move(1,'h');
		System.out.println(b);
		//*******************************************************************************
		
		return;
	}
}
