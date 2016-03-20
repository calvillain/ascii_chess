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
		int r = this.position.rank;
		char f = this.position.file;
		
		ArrayList<RankFile> ans = new ArrayList<RankFile>();
		
		//top row
		if (r != 8){
			//top-left
			if (f != 'a'){
				ans.add(new RankFile(r+1, (char)(f-1)));
			}
			//top
			ans.add(new RankFile(r+1, f));
			//top-left
			if (f != 'h'){
				ans.add(new RankFile(r+1, (char)(f+1)));
			}
		}
		//left
		if (f != 'a'){
			ans.add(new RankFile(r, (char)(f-1)));
		}
		//right
		if (f != 'h'){
			ans.add(new RankFile(r, (char)(f+1)));
		}
		//bottom row
		if (r != 1) {
			//bottom-left
			if (f != 'a'){
				ans.add(new RankFile(r-1, (char)(f-1)));
			}
			//bottom
			ans.add(new RankFile(r-1, f));
			//bottom-right
			if (f != 'h'){
				ans.add(new RankFile(r-1, (char)(f+1)));
			}
		}
		return ans;
	}
}
