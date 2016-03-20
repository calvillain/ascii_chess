package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

/*
 *	Piece subclass for Queen. inherited fields:
 *	RankFile position;	//position object. tuple of rank, file
 *	char color;	//'w' = white, 'b' = black
 *	char type;	//'p' = pawn, 'K' = King, etc.
 *	Board board;
 */
class Queen extends Piece {
	public Queen(char color, RankFile position, Board board) {
		super(color, position, board);
		this.type = 'Q';
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
	
	//same method, different signature
	@Override
	boolean move(int rank, char file) {
		RankFile rf = new RankFile(rank, file);
		return this.move(rf);
	}

	// gets a list of valid moves for this specific type of piece, regardless of
	// obstruction
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
