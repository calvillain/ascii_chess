package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

public class King extends Piece {
	boolean unmoved;

	public King(char color, RankFile position, Board board) {
		super(color, position, board);
		this.type = 'K';
		this.unmoved = true;
	}

	@Override
	ArrayList<RankFile> getValidMoves() {
		int r = this.position.rank;
		char f = this.position.file;
		RankFile square = new RankFile(r, (char) (f));
		char t = board.getPiece(square).color;
		ArrayList<RankFile> ans = new ArrayList<RankFile>();

		// castling-left-rook-incomplete
		if(unmoved){
			RankFile leftSquare = new RankFile(r , (char) (f-1));
			RankFile leftLeftSquare= new RankFile(r, (char) (f-2));
			RankFile leftRook= new RankFile(r, (char) (f-3)); // have to check if its unmoved, not implemented
			if(board.getPiece(leftSquare) == null&&board.getPiece(leftLeftSquare)==null){
	
			}
		}
		// castling-right-rook-incomplete

		// up
		square = new RankFile(r + 1, (char) (f));
		if (r + 1 > 0 && r + 1 < 9 && f >= 'a' && f <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r + 1, (char) (f)));
		}
		// up-left
		square = new RankFile(r + 1, (char) (f - 1));
		if (r + 1 > 0 && r + 1 < 9 && f - 1 >= 'a' && f - 1 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r + 1, (char) (f - 1)));
		}
		// up-right
		square = new RankFile(r + 1, (char) (f + 1));
		if (r + 1 > 0 && r + 1 < 9 && f + 1 >= 'a' && f + 1 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r + 1, (char) (f + 1)));
		}
		// left
		square = new RankFile(r, (char) (f - 1));
		if (r > 0 && r < 9 && f - 1 >= 'a' && f - 1 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r, (char) (f - 1)));
		}
		// right
		square = new RankFile(r, (char) (f + 1));
		if (r > 0 && r < 9 && f + 1 >= 'a' && f + 1 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r, (char) (f + 1)));
		}
		// down
		square = new RankFile(r - 1, (char) (f));
		if (r - 1 > 0 && r - 1 < 9 && f >= 'a' && f <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r - 1, (char) (f)));
		}
		// down-right
		square = new RankFile(r - 1, (char) (f + 1));
		if (r - 1 > 0 && r - 1 < 9 && f + 1 >= 'a' && f + 1 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r - 1, (char) (f + 1)));
		}
		// down-left
		square = new RankFile(r - 1, (char) (f - 1));
		if (r - 1 > 0 && r - 1 < 9 && f - 1 >= 'a' && f - 1 <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != t)) {
			ans.add(new RankFile(r - 1, (char) (f - 1)));
		}

		return ans;
	}
}
