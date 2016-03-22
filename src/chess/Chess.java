/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Chess class.
 * @author Calvin Lee, Bartosz Kidacki
 *
 */


public class Chess {
	public Board board;	//the board object we'replaying on
	Player white;	//the white player object in this chess game
	Player black;	//the black player object in this chess game
	int moveCount;
	boolean gameOver;

	//static object for position of pieces.
	public static class RankFile{	
		int rank;
		char file;
		public RankFile(int rank, char file){
			//To Do: make conditionals for checking valid rank and file values,
			//throw a 'invalid rank' exception if input has bad values for rank/file
			this.rank = rank;
			this.file = file;
		}
		
		public boolean equals(Object o){
			if (!(o.getClass().equals(this.getClass()))){
				return false;
			}
			RankFile rf = (RankFile) o;
			return ( ( this.rank == rf.rank ) && ( this.file == rf.file ) );			 
		}
		
		public String toString(){
			return "" + this.file + this.rank;
		}
	}
	//constructor for a game of chess
	public Chess(){
		//make a new board
		Board board = new Board();
		this.board = board;
		
		//make two players
		white = new Player('w', board);
		black = new Player('b', board);
		
		//set opponents
		white.opponent = black;
		black.opponent = white;
		
		//initialize move counter
		this.moveCount = 1;
		
		//initialize game over boolean
		this.gameOver = false;
	}
	
	//static helper method for parsing input string of "rf rf" into a pair of RankFile objects
	//first rankfile object is the location of the piece to be moved,
	//second rankfile object is the location to move that piece
	//returns null if incorrect input
	public static ArrayList<RankFile> parseInput(String input){
		System.out.println(input);
		ArrayList<RankFile> ans = new ArrayList<RankFile>();
		
		int r1;
		char f1;
		
		int r2;
		char f2;
		
		if (Character.isLetter(input.charAt(0))){
			f1 = (Character.toLowerCase(input.charAt(0)));
			
			if (Character.isDigit(input.charAt(1))){
				r1 = ((int)input.charAt(1) - 48);
				
				if (Character.isSpaceChar(input.charAt(2))){
					
					if (Character.isLetter(input.charAt(3))){
						f2 = (Character.toLowerCase(input.charAt(3)));
						
						if (Character.isDigit(input.charAt(4))){
							r2 = ((int)input.charAt(4) - 48);
							
							if (r1 >= 1 && r1 <= 8 && f1 >= 'a' && f1 <= 'h'){
								ans.add(new RankFile(r1, f1));
								
								if (r2 >= 1 && r2 <= 8 && f2 >= 'a' && f2 <= 'h'){
									ans.add(new RankFile(r2, f2));
									//System.out.println(ans); 
									return ans;
								}
							}
						}
					}
				}
			}
		}

		return null;
	}
	
	
	public static void helpMessage(){
		System.out.println("*************************************************");
		System.out.println("instructions:");
		System.out.println("-------------------------------------------------");
		System.out.println("input format: 'fr fr' (f = file, r = rank)");
		System.out.println("ex: Please Enter Move: a1 b2");
		System.out.println("-------------------------------------------------");
		System.out.println("type 'draw' after input to offer a draw game");
		System.out.println("ex: Please Enter Move: a1 b2 draw");
		System.out.println("type 'draw' in response to accept offer");
		System.out.println("-------------------------------------------------");
		System.out.println("type 'help' to display this message");
		System.out.println("-------------------------------------------------");
		System.out.println("type 'resign' to exit game");
		System.out.println("*************************************************\n");
	}
	
	public static void main(String[] args){	
		System.out.println("lets chess!");
		helpMessage();
		
		
		//create a new game
		Chess game = new Chess();
		
		
		
		try{
			
			//input stream reader wrapped in buffered reader
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			//the output of the parsed move input string
			ArrayList<RankFile> rankFilePair = new ArrayList<RankFile>();
			//boolean for checking valid move
			boolean move;
			//char for determining whose turn it is..
			char turn;
	
			//for promoting pawns
			boolean promote = false;
			
			//while game is not over
			while(game.gameOver == false){
				//print the board
				System.out.println(game.board);
				
				//if this is an odd-numbered move (white's turn)
				if ( game.moveCount % 2 == 1 ) {
					System.out.println(game.white.toString() + "'s turn!");
					turn = 'w';
					System.out.print("Please enter move: ");
				//if this is an even-numbered move (black's turn)
				} else {
					System.out.println(game.black.toString() + "'s turn!");
					turn = 'b';
					System.out.print("Please enter move: ");
				}
				//read in input for this player's move 
				String moveInput = br.readLine();
				
				//check if gameover
				if (moveInput.equals("resign")){
					game.gameOver = true;
					System.out.println("game over!");
				}else if (moveInput.equals("help")){
					helpMessage();
				//is the proper input length, with no draw offer
				}else if (moveInput.length() == 5){
				//parse input for correctness
					rankFilePair = parseInput( moveInput );
					if (rankFilePair == null || game.board.getPiece(rankFilePair.get(0)) == null) {	//invalid rank/file
						System.out.println("Incorrect input! try again..");	
					}else{
						//input is correct. now determine if it's a valid move.
						
						
						//**********************************************************************************
						//in this block, check for special cases!
						
						Piece movedPiece = game.board.getPiece(rankFilePair.get(1));
						
						//castles
						String sub = moveInput.substring(0,5);
						if (sub.equals("e1 c1") || sub.equals("e1 g1") 
						|| sub.equals("e8 c8") || sub.equals("e8 g8")){
							King king = (King) game.board.getPiece(rankFilePair.get(0));
							move = king.movePiece(rankFilePair.get(1), true);
						
						}else if (game.board.getPiece(rankFilePair.get(0)).color == turn){
							move = game.board.getPiece(rankFilePair.get(0)).movePiece(rankFilePair.get(1));
							
							//if move was successful
							if (move) {
								game.moveCount++;//increment move counter
							} else {
								System.out.println("invalid move!");
							}
						} else {
							System.out.println("invalid move!");
						}
					}
					
				//proper input length for promoting pawn
				}else if (moveInput.length() == 7){
					rankFilePair = parseInput( moveInput.substring(0, 5));
					
					if (rankFilePair == null) {	//invalid rank/file
						System.out.println("Incorrect input! try again..");
					}else{
						
						
						//check for valid promotion char
						char p = moveInput.charAt(6);
						//System.out.println("promoting to: " + p);
						
						if (p == 'R' || p == 'N' || p == 'B' || p == 'Q'){
						//input is correct. now determine if it's a valid move.
						
							//if the selected piece is the correct color for this turn
							if (game.board.getPiece(rankFilePair.get(0)).color == turn){
							
								//check color
								if (turn == 'w'											//if this is white player
								&& game.board.getPiece(rankFilePair.get(0)).type == 'p'	//moving a pawn
								&& rankFilePair.get(1).rank == 8){					//to the end of the board
									
									
									move = game.board.getPiece(rankFilePair.get(0)).movePiece(rankFilePair.get(1));
									if (move) {
										game.moveCount++;//increment move counter
										//game.board.getPiece(rankFilePair.get(1)).type = p;
	
									} else {	//move was unsuccessful
										System.out.println("invalid move!");
									}
								}else if (turn == 'b'											//if this is white player
								&& game.board.getPiece(rankFilePair.get(0)).type == 'p'	//moving a pawn
								&& rankFilePair.get(1).rank == 1){					//to the end of the board
									
									move = game.board.getPiece(rankFilePair.get(0)).movePiece(rankFilePair.get(1));
									if (move) {
										game.moveCount++;//increment move counter
										//game.board.getPiece(rankFilePair.get(1)).type = p;
									} else {	//move was unsuccessful
										System.out.println("Invalid move!");
									}
	
								//if it's not a valid promotion move
								} else {
									System.out.println("Invalid input!");
								}
							}
						//if it's not a valid char for promotion
						} else {
							System.out.println("Invalid input!");
						}
						
					}
				//proper input string length for draw offer
				}else if (moveInput.length() == 10 ){
					//implement some way to offer draw, then accept it
				
				//incorrect input string length
				}else{
					System.out.println("Incorrect input! try again..");
				}
				/*
				//unpromoted white pawns
			}else if (turn == 'w'&& movedPiece.type == 'p' && movedPiece.position.rank == 8){
				
			//unpromoted black pawns
			}else if (turn == 'b' && movedPiece.type == 'p' && movedPiece.position.rank == 1){
			
			
			*/
				
				//check for check and checkmate
				if (game.white.check || game.black.check){
					Player checkedPlayer;
					if (game.white.check){
						System.out.println("white is checked!");
						checkedPlayer = game.white;
					}else{
						System.out.println("black is checked!");
						checkedPlayer = game.black;
					}
					
					//find out if it's checkmate
					ArrayList<Piece> checkPieces = checkedPlayer.pieces;
					ArrayList<RankFile> possibleMoves;
					RankFile newMove;
					
					RankFile oldRF;
					RankFile newRF;
					Piece oldPiece = null;
					
					boolean checkMove;
					boolean isCheckmate = true; 
					
					int i=0;
					int j=0;
					
					System.out.println("checkpieces: "+ checkPieces);
					while (i<checkPieces.size()){
						possibleMoves = checkPieces.get(i).getValidMoves();
						System.out.println("possible moves: "+possibleMoves);
						
						while (j < possibleMoves.size()){
							newMove = possibleMoves.get(j);
							
							
							oldRF = checkPieces.get(i).position;
							
							System.out.print("old: "+oldRF);
							newRF = possibleMoves.get(j);
							System.out.println(" new: "+newRF);
							oldPiece = game.board.getPiece(newRF);
							
							
							checkMove = checkPieces.get(i).movePiece(newMove); 
							
							if ( checkMove == true ){//if there exists a move that will uncheck
								//revert changes
								System.out.println("this move works!");
								game.board.setPiece(checkPieces.get(i), oldRF);
								game.board.removePiece(newRF);
								if (oldPiece != null){
									game.board.setPiece(oldPiece, newRF);
								}
								checkedPlayer.check = true;
								isCheckmate = false;
							}
							
							
							j++;
						}
						i++;
						j = 0;
					}
					
					if (isCheckmate == true){
						checkedPlayer.checkmate = true;
						System.out.println("checkmate!");
						game.gameOver = true;
						System.out.println(game.board);
						System.out.println(checkedPlayer.opponent.toString() + " wins!");
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return;
	}
}
