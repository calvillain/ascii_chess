/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import chess.Chess.RankFile;

/**********************************
blank board:
   0123456789012345678901234	index
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
   0123456789012345678901234	index

default board: 
   0123456789012345678901234	index
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
   0123456789012345678901234	index
************************************/

class Board {
	Piece[][] position;
	
	
	//default constructor for blank board
	public Board() {
		position = new Piece[8][8];
		for (int i=0 ; i<8 ; i++){
			for (int j=0 ; j<8; j++){
				position[i][j] = null;
			}
		}
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();	//the string we will return for the board.
		for (int i=0 ; i<8 ; i++){
			for (int j=0 ; j<8; j++){
				if (position[i][j] == null) {	//if this position is unoccupied
					if ( (i + j)%2 == 0 ) {
						s.append("  ");
					} else {
						s.append("##");
					}
					s.append(" ");
					
				} else {
					//if this position is occupied
					s.append("nn");
				}
				
			}
			s.append("\n");
		}
		s.append("done");
		
		return s.toString();
	}
}
