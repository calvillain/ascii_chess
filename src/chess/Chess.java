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
			if (!o.getClass().equals(this)){
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

		System.out.println("making a black pawn at 1a...\n");
		RankFile oneA = new RankFile(1, 'a');
		Piece bp = new Pawn('b', oneA, b);
		b.setPiece(bp, oneA);
		
		System.out.println(b);
		
		System.out.println("making a white Queen at 2b...\n");
		RankFile twoB = new RankFile(2, 'b');
		Piece wq = new Queen('w', twoB, b);
		b.setPiece(wq, twoB);
		
		System.out.println(b);
		/*****************************************************************************************/
		
		return;
	}
}
