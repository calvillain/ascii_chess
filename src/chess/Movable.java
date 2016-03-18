package chess;

import java.util.ArrayList;
import chess.Chess.Pos;

public interface Movable {
	//takes as input a position, and returns whether move was successful or not.
	boolean move(int rank, char file);
	//gets a list of valid moves for this specific piece
	ArrayList<Pos> getValidMoves();
}
