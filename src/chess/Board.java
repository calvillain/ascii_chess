/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import chess.Chess.RankFile;

/**********************************
blank board:
    0  1  2  3  4  5  6  7	index
  ---------------------------
0|    ##    ##    ##    ## 8 |0
1| ##    ##    ##    ##    7 |1
2|    ##    ##    ##    ## 6 |2
3| ##    ##    ##    ##    5 |3
4|    ##    ##    ##    ## 4 |4
5| ##    ##    ##    ##    3 |5
6|    ##    ##    ##    ## 2 |6
7| ##    ##    ##    ##    1 |7
8|  a  b  c  d  e  f  g  h   |8
  ---------------------------
    0  1  2  3  4  5  6  7	index

default board:
   0  1  2  3  4  5  6  7	index
  ---------------------------
0| bR bN bB bQ bK bB bN bR 8 |0
1| bp bp bp bp bp bp bp bp 7 |1
2|    ##    ##    ##    ## 6 |2
3| ##    ##    ##    ##    5 |3
4|    ##    ##    ##    ## 4 |4
5| ##    ##    ##    ##    3 |5
6| wp wp wp wp wp wp wp wp 2 |6
7| wR wN wB wQ wK wB wN wR 1 |7
8|  a  b  c  d  e  f  g  h   |8
  ---------------------------
   0  1  2  3  4  5  6  7	index
************************************/

/**
 * Board object.
 * @author Calvin Lee, Bartosz Kidacki
 *
 */
class Board {
	Piece[][] position;


	//default constructor for blank board
	public Board() {
		position = new Piece[8][8];
	}


	//returns piece in this rank/file. returns null if empty.
	public Piece getPiece(int rank, char file) {
		if ( (rank < 1 || rank > 8) || (file < 'a' || file > 'h') ) {
			return null;
		}
		int i = 8 - rank;
		int j = ((int)file - 'a');

		if (position[i][j] == null) {
			return null;
		} else {
			return position[i][j];
		}
	}
	
	//same thing, different signature.
	public Piece getPiece(RankFile rf)	{
		int rank = rf.rank;
		char file = rf.file;
		return getPiece(rank, file);

	}
	
	//returns true if this piece is successfully placed in this position.
	//returns false if incorrect input.
	public boolean setPiece(Piece p, RankFile rf) {
		int rank = rf.rank;
		char file = rf.file;
		if ( (rank < 1 || rank > 8) || (file < 'a' || file > 'h') ) {
			return false;
		}
		int i = 8 - rank;
		int j = ((int)file - 'a');

		position[i][j] = p;

		return true;
	}
	
	//same thing, different signature.
	public boolean setPiece(Piece p, int rank, char file){
		return setPiece(p, new RankFile(rank, file));
	}
	
	//returns true if a piece is successfully removed from this position.
	//returns false if incorrect input.
	public boolean removePiece(RankFile rf) {
		int rank = rf.rank;
		char file = rf.file;
		if ( (rank < 1 || rank > 8) || (file < 'a' || file > 'h') ) {
			return false;
		}
		int i = 8 - rf.rank;
		int j = ((int)rf.file - 'a');
		position[i][j] = null;
		return true;
	}
	
	//same thing, different signature.
	public boolean removePiece(int rank, char file){
		return removePiece(new RankFile(rank, file));
	}
	
	//custom toString method for printing a board according to required layout specifications.
	public String toString(){
		StringBuilder s = new StringBuilder();	//the string we will return for the board.
		int i;
		int j;
		for (i=0 ; i<8 ; i++){
			for (j=0 ; j<8; j++){
				if (position[i][j] == null) {	//if this position is unoccupied
					if ( (i + j)%2 == 0 ) {
						s.append("  ");
					} else {
						s.append("##");
					}

				} else {
					//if this position is occupied
					s.append(position[i][j].toString());
				}
				s.append(" ");

			}

			s.append("" + (8 - i));
			s.append("\n");
		}
		s.append(" a  b  c  d  e  f  g  h\n");

		return s.toString();
	}
}
