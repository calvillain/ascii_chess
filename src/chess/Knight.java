package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

public class Knight extends Piece {

	public Knight(char color, RankFile position, Board board) {
		super(color, position, board);
		this.type = 'N';

	}

	@Override
	ArrayList<RankFile> getValidMoves() {
		int r = this.position.rank;
		char f = this.position.file;

		ArrayList<RankFile> ans = new ArrayList<RankFile>();
		// up-up-left
		RankFile square = new RankFile(r, (char) (f));
		char t = board.getPiece(square).color; // to get the type of the knight
												// which will be used to
												// determine if a move is valid
		square = new RankFile(r + 2, (char) (f - 1));
		if (r + 2 > 0 && r + 2 < 9 && f - 1 >= 'a' && f - 1 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r + 2, (char) (f - 1)));
		}

		// up-up-right
		square = new RankFile(r + 2, (char) (f + 1));
		if (r + 2 > 0 && r + 2 < 9 && f + 1 >= 'a' && f + 1 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r + 2, (char) (f + 1)));
		}

		// down-down-left
		square = new RankFile(r - 2, (char) (f - 1));
		if (r - 2 > 0 && r - 2 < 9 && f - 1 >= 'a' && f - 1 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r - 2, (char) (f - 1)));
		}
		// down-down-right
		square = new RankFile(r - 2, (char) (f + 1));
		if (r - 2 > 0 && r - 2 < 9 && f + 1 >= 'a' && f + 1 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r - 2, (char) (f + 1)));
		}
		// left-left-up
		square = new RankFile(r + 1, (char) (f - 2));
		if (r + 1 > 0 && r + 1 < 9 && f - 2 >= 'a' && f - 2 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r + 1, (char) (f - 2)));
		}
		// left-left-down
		square = new RankFile(r - 1, (char) (f - 2));
		if (r - 1 > 0 && r - 1 < 9 && f - 2 >= 'a' && f - 2 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r - 1, (char) (f - 2)));
		}
		// right-right-up
		square = new RankFile(r + 1, (char) (f + 2));
		if (r + 1 > 0 && r + 1 < 9 && f + 2 >= 'a' && f + 2 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r + 1, (char) (f + 2)));
		}
		// right-right-down
		square = new RankFile(r - 1, (char) (f + 2));
		if (r - 1 > 0 && r - 1 < 9 && f + 2 >= 'a' && f + 2 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r - 1, (char) (f + 2)));
		}


		return ans;
	}
}
