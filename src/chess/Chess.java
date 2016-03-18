/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

public class Chess {
	public static class RankFile{
		int rank;
		char file;
		public RankFile(int rank, char file){
			this.rank = rank;
			this.file = file;
		}
		
		public String toString(){
			return "" + this.rank + this.file;
		}
	}
	public static void main(String[] args){
		System.out.println("lets chess!");
		System.out.println("making a black pawn...");
		Piece bp = new Pawn('b', new RankFile(1, 'a'));	//creates a black piece, that is also a Pawn.
		
		System.out.println(bp);
		System.out.println(bp.getPos());
		
		System.out.println("making a white Queen...");
		Piece wq = new Queen('w', new RankFile(2, 'b'));	//create white piece, that is a Queen.
		
		System.out.println(wq);
		System.out.println(wq.getPos());
		return;
	}
}
