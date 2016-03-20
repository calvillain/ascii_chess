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
		
		//up-up-left
		RankFile uul = new RankFile(r + 2, (char)(f-1));
		
		//up-up-right
		RankFile uur = new RankFile(r + 2, (char)(f+1));
		
		//up-left-left
		RankFile ull = new RankFile(r+1, (char)(f-2));
		
		//incomplete
		
		return null;
	}
}
