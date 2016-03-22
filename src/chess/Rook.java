package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

/**
 * Piece subclass for Rook.
 * @author Calvin Lee, Bartosz Kidacki
 *
 */
class Rook extends Piece {
	public Rook(char color, RankFile position, Board board, Player player) {
		super(color, position, board, player);
		this.type = 'R';
	}

	// gets a list of valid moves for this specific type of piece
	public ArrayList<RankFile> getValidMoves() {
		int r = this.position.rank;
		char f = this.position.file;

		ArrayList<RankFile> ans = new ArrayList<RankFile>();

		for (int i = r + 1; i <= 8; i++) { // check up direction
			RankFile square = new RankFile(i, f);
			if (board.getPiece(square) == null) {
				ans.add(square);
			} else {
				if (board.getPiece(square).color != this.color) {
					ans.add(square);
				}
				break;
			}
		}

		for (int i = r - 1; i >= 1; i--) { // check down direction
			RankFile square = new RankFile(i, f);
			if (board.getPiece(square) == null) {
				ans.add(square);
			} else {
				if (board.getPiece(square).color != this.color) {
					ans.add(square);
				}
				break;
			}
		}

		for (char j = (char) (f - 1); j >= 'a'; j--) { // check left direction
			RankFile square = new RankFile(r, j);
			if (board.getPiece(square) == null) {
				ans.add(square);
			} else {
				if (board.getPiece(square).color != this.color) {
					ans.add(square);
				}
				break;
			}
		}

		for (char j = (char) (f + 1); j <= 'h'; j++) { // check right direction
			RankFile square = new RankFile(r, j);
			if (board.getPiece(square) == null) {
				ans.add(square);
			} else {
				if (board.getPiece(square).color != this.color) {
					ans.add(square);
				}
				break;
			}
		}
		//System.out.println(ans);
		return ans;
	}
}
