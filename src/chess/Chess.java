/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
			return "" + this.rank + this.file;
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
		ArrayList<RankFile> ans = new ArrayList<RankFile>();
		int r1;
		char f1;
		int r2;
		char f2;
		
		
		if (Character.isDigit(input.charAt(0))){
			r1 = ((int)input.charAt(0) - 48);
			
			if (Character.isLetter(input.charAt(1))){
				f1 = (Character.toLowerCase(input.charAt(1)));
				
				if (Character.isSpaceChar(input.charAt(2))){
					
					if (Character.isDigit(input.charAt(3))){
						r2 = ((int)input.charAt(3) - 48);
						
						if (Character.isLetter(input.charAt(4))){
							f2 = (Character.toLowerCase(input.charAt(4)));
							
							ans.add(new RankFile(r1, f1));
							ans.add(new RankFile(r2, f2));
							
							System.out.println(ans); 
							return ans;
						}
					}
				}
			}
		}

		return null;
	}
	
	
	public static void main(String[] args){	
		System.out.println("lets chess!");
		System.out.println("*************************************************");
		System.out.println("instructions:");
		System.out.println("-------------------------------------------------");
		System.out.println("input format: rf rf (r = rank, f = file)");
		System.out.println("ex: Please Enter Move: 1a 2b");
		System.out.println("-------------------------------------------------");
		System.out.println("type 'draw' after input to offer a draw game");
		System.out.println("ex: Please Enter Move: 1a 2b draw");
		System.out.println("type 'draw' to accept offer");
		System.out.println("-------------------------------------------------");
		System.out.println("type 'quit' to exit game");
		System.out.println("*************************************************\n");
		
		
		//create a new game
		Chess game = new Chess();
		System.out.println(game.board);
		
		try{
			//input stream reader wrapped in buffered reader
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			//the output of the parsed move input string
			ArrayList<RankFile> rankFilePair = new ArrayList<RankFile>();
			//boolean for checking valid move
			boolean move;
			
			//while game is not over
			while(game.gameOver == false){
				//if this is an odd-numbered move (white's turn)
				if ( game.moveCount % 2 == 1 ) {
					System.out.println(game.white.toString() + "'s turn!");
					System.out.print("Please enter move: ");
				//if this is an even-numbered move (black's turn)
				} else {
					System.out.println(game.black.toString() + "'s turn!");
					System.out.print("Please enter move: ");
				}
				//read in input for this player's move 
				String moveInput = br.readLine();
				
				//check if gameover
				if (moveInput.equals("quit")){
					game.gameOver = true;
					System.out.println("game over!");
				//is the proper input length, with no draw offer
				}else if (moveInput.length() == 5){
				//parse input for correctness
					rankFilePair = parseInput( moveInput );
					if (rankFilePair == null) {
						System.out.println("Incorrect input! try again..");
					}else{
						move = game.board.getPiece(rankFilePair.get(0)).movePiece(rankFilePair.get(1));
						if (move) {
							System.out.println(game.board);
							game.moveCount++;
						} else {
							System.out.println("invalid move!");
						}
					}
					
				//proper input string length for draw offer	
				}else if (moveInput.length() == 10 ){
					//implement some way to offer draw, then accept it
				
				//incorrect input string length
				}else{
					System.out.println("Incorrect input! try again..");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		/*********test code*************************************************************
		Board b = game.board;
		boolean move;
		
		System.out.println("printing blank board...\n");
		System.out.println(b); 

		//2d 3d (white)
		move = b.getPiece(2, 'd').movePiece(3, 'd');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//7b 6b (black)
		move = b.getPiece(7,'b').movePiece(6,'b');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//2g 3g (white)
		move = b.getPiece(2,'g').movePiece(3,'g');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//8c 7b (black)
		move = b.getPiece(8,'c').movePiece(7,'b');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//2e 4e (white)
		move = b.getPiece(2,'e').movePiece(4,'e');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}

		//7b 5d (black)
		move = b.getPiece(7,'b').movePiece(6, 'c');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//1d 4g (white)
		move = b.getPiece(1,'d').movePiece(4, 'g');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//8g 6h (black)
		move = b.getPiece(8,'g').movePiece(6, 'h');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//4g 4f (white)
		move = b.getPiece(4,'g').movePiece(4, 'f');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//8b 6a (black)
		move = b.getPiece(8,'b').movePiece(6, 'a');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//3d 4d (white)
		move = b.getPiece(3,'d').movePiece(4, 'd');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//6a 4b (black)
		move = b.getPiece(6,'a').movePiece(4, 'b');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		//1f 4c (white)
		move = b.getPiece(1,'f').movePiece(4, 'c');
		if (move) {System.out.println(b);}
		else {System.out.println("invalid move!");}
		
		
		
		//*******************************************************************************/
		
		return;
	}
}
