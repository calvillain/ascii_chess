package chess;

public class Chess {
	class Pos{
		int rank;
		char file;
	}
	public static void main(String[] args){
		System.out.println("lets chess!");
		
		Piece p = new Pawn();
		System.out.println(p);
		return;
		
	}
}
