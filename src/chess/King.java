package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

public class King extends Piece {

	public King(char color, RankFile position, Board board) {
		super(color, position, board);
		this.type = 'K';
	}

	@Override
	ArrayList<RankFile> getValidMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean move(RankFile rf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean move(int rank, char file) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
