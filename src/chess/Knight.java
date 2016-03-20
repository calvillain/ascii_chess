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
