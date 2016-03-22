package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

/**
 * Piece subclass for King object.
 * @author Calvin Lee, Bartosz Kidacki
 *
 */
public class King extends Piece {
	boolean unmoved;

	public King(char color, RankFile position, Board board, Player player) {
		super(color, position, board, player);
		this.type = 'K';
		this.unmoved = true;
	}

	// returns true if this piece is successfully moved to this location.
	// returns false otherwise
	// added boolean in signature for castling
	boolean movePiece(RankFile rf, boolean castle) {
		if (castle){
			boolean move = movePiece(rf);
			//white left castle
			if (move && rf.equals(new RankFile(1, 'a'))){
				RankFile oldrf = new RankFile(1, 'a');
				Piece rook = board.getPiece(1, 'a');
				RankFile newrf = new RankFile(1, 'd');
				rook.position = rf; // change this piece's position field
				board.setPiece(rook, newrf); // update the board by adding to new
				board.removePiece(oldrf); // and deleting from old position
				this.unmoved = false;
				rook.unmoved = false;
				
				return true;

			//white right castle
			}else if (move && rf.equals(new RankFile(1, 'g'))){
				//board.getPiece(1, 'h').movePiece(1, 'f');
				RankFile oldrf = new RankFile(1, 'h');
				Piece rook = board.getPiece(1, 'h');
				RankFile newrf = new RankFile(1, 'f');
				rook.position = rf; // change this piece's position field
				board.setPiece(rook, newrf); // update the board by adding to new
				board.removePiece(oldrf); // and deleting from old position
				this.unmoved = false;
				rook.unmoved = false;
				return true;
			}

			//black left castle
			if (move && rf.equals(new RankFile(8, 'b'))){
				//board.getPiece(8, 'a').movePiece(8, 'd');
				RankFile oldrf = new RankFile(8, 'a');
				Piece rook = board.getPiece(8, 'a');
				RankFile newrf = new RankFile(8, 'd');
				rook.position = rf; // change this piece's position field
				board.setPiece(rook, newrf); // update the board by adding to new
				board.removePiece(oldrf); // and deleting from old position
				this.unmoved = false;
				rook.unmoved = false;
				return true;
			}
			//black right castle
			if (move && rf.equals(new RankFile(8, 'g'))){
				//board.getPiece(8, 'h').movePiece(8, 'f');
				RankFile oldrf = new RankFile(8, 'h');
				Piece rook = board.getPiece(8, 'h');
				RankFile newrf = new RankFile(8, 'f');
				rook.position = rf; // change this piece's position field
				board.setPiece(rook, newrf); // update the board by adding to new
				board.removePiece(oldrf); // and deleting from old position
				this.unmoved = false;
				rook.unmoved = false;
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	ArrayList<RankFile> getValidMoves() {
		int r = this.position.rank;
		char f = this.position.file;
		RankFile square = new RankFile(r, (char) (f));

			
		ArrayList<RankFile> ans = new ArrayList<RankFile>();

		//checking for castle is a possible move
		Piece rook;
		if (unmoved) {
		//white castling

			if ( this.color == 'w') {
				//with left rook

				rook = board.getPiece(1, 'a');
				if (rook != null && rook.unmoved) {
					if (board.getPiece(1, 'd')==null
					&& board.getPiece(1, 'c')==null
					&& board.getPiece(1,'b')==null){
						ans.add(new RankFile(1, 'b'));
					}
				}
				//with right rook
				rook = board.getPiece(1, 'h');
				if (rook != null && rook.unmoved){
					if (board.getPiece(1, 'f')==null
					&& board.getPiece(1, 'g') == null){
						ans.add(new RankFile(1, 'g'));
					}
				}

			//black castling
			} else {

				//with left rook
				rook = board.getPiece(8, 'a');
				if (rook != null && rook.unmoved){
					if (board.getPiece(8, 'd')==null
					&& board.getPiece(8, 'c')==null
					&& board.getPiece(8, 'b')==null){
						ans.add(new RankFile(8, 'b'));
					}
				}

				//with right rook
				rook = board.getPiece(8, 'h');
				if (rook != null && rook.unmoved){
					if (board.getPiece(8, 'f')==null
					&& board.getPiece(8, 'g')==null){
						ans.add(new RankFile(8, 'g'));
					}
				}
			}
		}

		// up
		square = new RankFile(r + 1, (char) (f));
		if (r + 1 > 0 && r + 1 < 9 && f >= 'a' && f <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != this.color)) {
			ans.add(new RankFile(r + 1, (char) (f)));
		}
		// up-left
		square = new RankFile(r + 1, (char) (f - 1));
		if (r + 1 > 0 && r + 1 < 9 && (char) (f - 1) >= 'a' && (char) (f - 1) <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != this.color)) {
			ans.add(new RankFile(r + 1, (char) (f - 1)));
		}
		// up-right
		square = new RankFile(r + 1, (char) (f + 1));
		if (r + 1 > 0 && r + 1 < 9 && (char) (f + 1) >= 'a' && (char) (f + 1) <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != this.color)) {
			ans.add(new RankFile(r + 1, (char) (f + 1)));
		}
		// left
		square = new RankFile(r, (char) (f - 1));
		if (r > 0 && r < 9 && (char) (f - 1)>= 'a' && (char) (f - 1) <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != this.color)) {
			ans.add(new RankFile(r, (char) (f - 1)));
		}
		// right
		square = new RankFile(r, (char) (f + 1));
		if (r > 0 && r < 9 && (char) (f + 1)>= 'a' && (char) (f + 1) <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != this.color)) {
			ans.add(new RankFile(r, (char) (f + 1)));
		}
		// down
		square = new RankFile(r - 1, (char) (f));
		if (r - 1 > 0 && r - 1 < 9 && f >= 'a' && f <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != this.color)) {
			ans.add(new RankFile(r - 1, (char) (f)));
		}
		// down-right
		square = new RankFile(r - 1, (char) (f + 1));
		if (r - 1 > 0 && r - 1 < 9 && (char) (f + 1) >= 'a' && (char) (f + 1) <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != this.color)) {
			ans.add(new RankFile(r - 1, (char) (f + 1)));
		}
		// down-left
		square = new RankFile(r - 1, (char) (f - 1));
		if (r - 1 > 0 && r - 1 < 9 && (char) (f - 1)>= 'a' && (char) (f - 1) <= 'h'
				&& (board.getPiece(square) == null || board.getPiece(square).color != this.color)) {
			ans.add(new RankFile(r - 1, (char) (f - 1)));
		}

		return ans;
	}
}