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
		//test code 
		/*****************************************************************************************/
		Board b = new Board();	//board comes before any pieces
		System.out.println("printing blank board...\n");
		System.out.println(b);

		System.out.println("making a black pawn at 7a...\n");
		RankFile sevenA = new RankFile(7, 'a');	//creating '1a' rankfile object
		Piece bp = new Pawn('b', sevenA, b);		//creating new piece, that is a black pawn
		b.setPiece(bp, sevenA);					//placing it on the board
		
		System.out.println(b);
		
		System.out.println("making a white Queen at 1d...\n");
		RankFile oneD = new RankFile(1, 'd');	//creating '2b' rankfile object
		Piece wq = new Queen('w', oneD, b);		//creating new piece, that is a white queen
		b.setPiece(wq, oneD);					//placing it on the board
		
		System.out.println(b);
		
		System.out.println("moving black pawn to 6a....");
		RankFile sixA = new RankFile(6, 'a');
		bp.move(sixA);
				
		System.out.println(b);
		
		/*****************************************************************************************/
		
		return;
	}
}
