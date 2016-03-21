package chess;

import java.util.ArrayList;

import chess.Chess.RankFile;

public class Knight extends Piece {

	public Knight(char color, RankFile position, Board board, Player player) {
		super(color, position, board, player);
		this.type = 'N';
	}

	@Override
	ArrayList<RankFile> getValidMoves() {
		int r = this.position.rank;
		char f = this.position.file;
		
		ArrayList<RankFile> ans = new ArrayList<RankFile>();
		Piece piece;
		
		//up-up-left
		if (r <= 6 && f >= 'b'){
			RankFile uul = new RankFile(r+2, (char)(f-1));
			piece = this.board.getPiece(uul);
			if (piece == null || piece.color != this.color){
				ans.add(uul);
			}
			
		}
		
		//up-up-right
		if (r <= 6 && f <= 'g'){
			RankFile uur = new RankFile(r+2, (char)(f+1));
			piece = this.board.getPiece(uur);
			if (piece == null || piece.color != this.color){
				ans.add(uur);
			}
		}
		
		//up-left-left
		if (r <= 7 && f >= 'c'){
			RankFile ull = new RankFile(r+1, (char)(f-2));
			piece = this.board.getPiece(ull);
			if (piece == null || piece.color != this.color){
				ans.add(ull);
			}
		}
		
		//up-right-right
		if (r <= 7 && f <= 'f'){
			RankFile urr = new RankFile(r+1, (char)(f+2));
			piece = this.board.getPiece(urr);
			if (piece == null || piece.color != this.color){
				ans.add(urr);
			}
		}
		
		//down-left-left
		if (r >= 2 && f >= 'c'){
			RankFile dll = new RankFile(r-1, (char)(f-2));
			piece = this.board.getPiece(dll);
			if (piece == null || piece.color != this.color){
				ans.add(dll);
			}
		}
		
		//down-right-right
		if (r >= 2 && f <= 'f'){
			RankFile drr = new RankFile(r-1, (char)(f+2));
			piece = this.board.getPiece(drr);
			if (piece == null || piece.color != this.color){
				ans.add(drr);
			}
		}
		
		
		//down-down-left
		if (r >= 3 && f >= 'b'){
			RankFile ddl = new RankFile(r-2, (char)(f-1));
			piece = this.board.getPiece(ddl);
			if (piece == null || piece.color != this.color){
				ans.add(ddl);
			}
		}
		
		//down-down-right
		if (r >= 3 && f <= 'g'){
			RankFile ddr = new RankFile(r-2, (char)(f+1));
			piece = this.board.getPiece(ddr);
			if (piece == null || piece.color != this.color){
				ans.add(ddr);
			}
		}
		return ans;
	}
}
