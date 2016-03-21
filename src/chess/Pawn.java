package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

/*
 *	Piece subclass for Pawn. inherited fields:
 *	RankFile position;	//position object. tuple of rank, file
 *	char color;	//'w' = white, 'b' = black
 *	char type;	//'p' = pawn, 'K' = King, etc.
 *	Board board;
 */
class Pawn extends Piece {
	boolean unmoved;

	public Pawn(char color, RankFile position, Board board) {
		super(color, position, board);
		this.type = 'p';
		this.unmoved = true;
	}
	

	// gets a list of valid moves for this specific piece.
	public ArrayList<RankFile> getValidMoves() {
		int r = this.position.rank;
		char f = this.position.file;

		ArrayList<RankFile> ans = new ArrayList<RankFile>();
		int forward; // determines which direction is forward
		if (color == 'w') {
			forward = 1; // white = "up is forward"
		} else {
			forward = -1; // black = "down is forward"
		}

		RankFile oneAhead = new RankFile(r + forward, f);
		RankFile twoAhead = new RankFile(r + (2 * forward), f);
		if (board.getPiece(oneAhead) == null) {
			if (board.getPiece(twoAhead) == null && this.unmoved) {
				ans.add(twoAhead);
			}

			ans.add(oneAhead);
		}

		RankFile rightDiag = new RankFile(r + forward, (char) (f + 1));
		Piece p = board.getPiece(rightDiag); // diagonal 1
		if (p != null) {
			if (p.color != this.color) {
				ans.add(rightDiag);
			}
		}
		RankFile leftDiag = new RankFile(r + forward, (char) (f - 1));
		p = board.getPiece(leftDiag); // diagonal 2
		if (p != null) {
			if (p.color != this.color) {
				ans.add(leftDiag);
			}
		}

		return ans;
	}

}