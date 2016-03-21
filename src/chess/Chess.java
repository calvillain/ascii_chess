/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import java.util.Scanner;

import chess.Chess.RankFile;

public class Chess {
	// static member for position of pieces.
	public static class RankFile {
		int rank;
		char file;

		public RankFile(int rank, char file) {
			// To Do: make conditionals for checking valid rank and file values,
			// throw a 'invalid rank' exception if input has bad values for
			// rank/file
			this.rank = rank;
			this.file = file;
		}

		public boolean equals(Object o) {
			if (!(o.getClass().equals(this.getClass()))) {
				return false;
			}
			RankFile rf = (RankFile) o;
			return ((this.rank == rf.rank) && (this.file == rf.file));
		}

		public String toString() {
			return "" + this.rank + this.file;
		}
	}

	public static void main(String[] args) {
		System.out.println("lets chess!");

		Board b = new Board(); // board comes before any pieces
		System.out.println("printing blank board...\n");
		System.out.println(b);

		// //*********test
		// code*************************************************************
		// //2d 3d
		// b.getPiece(2, 'd').move(3, 'd');
		// System.out.println(b);
		// //7b 6b
		// b.getPiece(7,'b').move(6,'b');
		// System.out.println(b);
		// //2g 3g
		// b.getPiece(2,'g').move(3,'g');
		// System.out.println(b);
		// //8c 7b
		// b.getPiece(8,'c').move(7,'b');
		// System.out.println(b);
		// //2a 4a
		// b.getPiece(2,'a').move(4,'a');
		// System.out.println(b);
		// //7b 1h
		// b.getPiece(7,'b').move(1,'h');
		// System.out.println(b);
		//
		//
		//
		// //*******************************************************************************
		//
		Scanner sc = new Scanner(System.in);
		boolean gameIsOver = false;
		boolean player1 = true;
		while (!gameIsOver) {

			System.out.println(player1 ? "Player1" : "Player2");
			System.out.println("Please enter move");
			String c = sc.nextLine();
			String[] str = c.split(" ");
			while (str.length < 2 || str.length > 4) {
				System.out.println("invalid input");

				c = sc.nextLine();
				System.out.println("Please enter move");
				str = c.split(" ");
			}

			char startFile = str[0].charAt(0);
			int startRank = str[0].charAt(1);
			char finFile = str[1].charAt(0);
			int finRank = str[1].charAt(1);
	 System.out.println(startFile + "," + startRank + "," + finFile +
	 "," + finRank);
System.out.println((finRank-48)+ ""+(finFile));
			// the -48 is there to transform from ascii form to int

//System.out.println(b.getPiece(6,'a').getValidMoves()); // error at this line couldnt figure out why
			while (b.getPiece(startRank - 48, startFile).getValidMoves().toString().indexOf((finRank-48)+ ""+(finFile))==-1) {
				System.out.println("invalid input");
				System.out.println("Please enter move2");
				c = sc.nextLine();
				str = c.split(" ");
				startFile = str[0].charAt(0);
				startRank = str[0].charAt(1);
				finFile = str[1].charAt(0);
				finRank = str[1].charAt(1);
			}

			b.getPiece(startRank - 48, startFile).move(finRank - 48, finFile);

			System.out.println(b);
			player1 = !player1;
		}
		// incomplete
		return;

	}
}
