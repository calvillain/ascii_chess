package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

/**
 * Piece subclass for Pawn.
 * @author Calvin Lee, Bartosz Kidacki
 *
 */
class Pawn extends Piece {
	boolean unmoved;

	public boolean isEnpassantPossible() {
		return enpassantPossible;
	}

	public void setEnpassantPossible(boolean enpassantPossible) {
		this.enpassantPossible = enpassantPossible;
	}

	boolean enpassantPossible;
	

	public Pawn(char color, RankFile position, Board board, Player player) {
		super(color, position, board, player);
		this.type = 'p';
		this.unmoved = true;
	}
	

	@Override
	boolean movePiece(RankFile rf) {
		RankFile oldRF = this.position;
		boolean moved = super.movePiece(rf);

		if (moved) {
			unmoved = false;
		
		if (Math.abs(oldRF.rank - rf.rank) == 2) {
			enpassantPossible = true;
		}
	    if(this.color== 'b') {
    		RankFile pawnAbove = new RankFile(rf.rank + 1, rf.file);
			Piece d = board.getPiece(pawnAbove);

			if (d instanceof Pawn && ((Pawn) d).isEnpassantPossible()) {
				board.removePiece(pawnAbove);
			}
    }
    else {
    		RankFile pawnBelow = new RankFile(rf.rank - 1, rf.file);
			Piece d = board.getPiece(pawnBelow);
			if (d instanceof Pawn && ((Pawn) d).isEnpassantPossible()) {
				board.removePiece(pawnBelow);
			}
	
		}
		}
		return moved;
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
			ans.add(oneAhead);
			if (board.getPiece(twoAhead) == null && this.unmoved) {
				ans.add(twoAhead);
			}	
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
		RankFile enpassantRight = new RankFile(r + forward, (char) (f + 1));
		RankFile pawnRight = new RankFile(r, (char) (f + 1));
		p = board.getPiece(enpassantRight);
		Piece d = board.getPiece(pawnRight);
		if (p == null && d instanceof Pawn && ((Pawn) d).isEnpassantPossible()) {
			ans.add(enpassantRight);
		}
		RankFile enpassantLeft = new RankFile(r + forward, (char) (f - 1));
		RankFile pawnLeft = new RankFile(r, (char) (f - 1));
		p = board.getPiece(enpassantLeft);
		d = board.getPiece(pawnLeft);
		if (p == null && d instanceof Pawn && ((Pawn) d).isEnpassantPossible()) {
			ans.add(enpassantLeft);
		}
		return ans;
	}

}