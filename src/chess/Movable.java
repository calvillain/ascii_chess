/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import chess.Chess.RankFile;

public interface Movable {
	//abstract method for moving a piece.
	boolean move(RankFile rf);
}
