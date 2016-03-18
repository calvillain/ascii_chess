/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import java.util.ArrayList;
import chess.Chess.RankFile;

public interface Movable {
	//abstract method for moving a piece.
	boolean move(int rank, char file);
	//abstract method for getting a list of valid places to move a piece.
	ArrayList<RankFile> getValidMoves();
}
