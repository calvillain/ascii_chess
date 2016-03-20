package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

//Piece subclass for Rook.
class Bishop extends Piece {
	public Bishop(char color, RankFile position, Board board) {
		super(color, position, board);
		this.type = 'B';
	}

	// returns true if this piece is successfully moved to this location.
	// returns false otherwise
	public boolean move(RankFile rf) {
		if (this.getValidMoves().contains(rf)) { // if this is one of the valid
			// moves
			RankFile oldrf = this.position;
			this.position = rf; // change this piece's position field
			board.setPiece(this, rf); // update the board by adding to new
			// position
			board.removePiece(oldrf); // and deleting from old position

			return true;
		}
		return false;

	}
	
	@Override
	boolean move(int rank, char file) {
		RankFile rf = new RankFile(rank, file);
		return this.move(rf);
	}

	// gets a list of valid moves for this specific type of piece
	public ArrayList<RankFile> getValidMoves() {
		int r = this.position.rank;
		char f = this.position.file;

		ArrayList<RankFile> ans = new ArrayList<RankFile>();

		// top-left
		int i = r + 1;
		char j = (char) (f - 1);
		while (i < 9 && j >= 'a') {
			RankFile square = new RankFile(i, j);
			if (board.getPiece(square) == null) {
				ans.add(square);
			} else {
				if (board.getPiece(square).color != this.color) {
					ans.add(square);
				}
				break;
			}
			i++;
			j--;
		}
		// top-right
		i = r + 1;
		j = (char) (f + 1);
		while (i < 9 && j <= 'h') {
			RankFile square = new RankFile(i, j);
			if (board.getPiece(square) == null) {
				ans.add(square);
			} else {
				if (board.getPiece(square).color != this.color) {
					ans.add(square);
				}
				break;
			}
			i++;
			j++;
		}
		// bottom-left
		i = r - 1;
		j = (char) (f - 1);
		while (i > 0 && j >= 'a') {
			RankFile square = new RankFile(i, j);
			if (board.getPiece(square) == null) {
				ans.add(square);
			} else {
				if (board.getPiece(square).color != this.color) {
					ans.add(square);
				}
				break;
			}
			i--;
			j--;
		}

		// bottom-right

		i = r - 1;
		j = (char) (f + 1);
		while (i > 0 && j <= 'h') {
			RankFile square = new RankFile(i, j);
			if (board.getPiece(square) == null) {
				ans.add(square);
			} else {
				if (board.getPiece(square).color != this.color) {
					ans.add(square);
				}
				break;
			}
			i--;
			j++;
		}

		return ans;

	}
}
