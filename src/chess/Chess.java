/*
 * Calvin Lee & Bartosz Kidacki
 * Software Methodology (CS213), Rutgers Univ.
 * Chess 84
 */

package chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
		this.moveCount = 0;
		
		//initialize game over boolean
		this.gameOver = false;
	}
	
	
	public static void main(String[] args){
		
		
		System.out.println("lets chess!");
		System.out.println("*************************************************");
		System.out.println("instructions:");
		System.out.println("-------------------------------------------------");
		System.out.println("input format: rf rf (r = rank, f = file)");
		System.out.println("ex: Please Enter Move: 1a 2b\n");
		System.out.println("-------------------------------------------------");
		System.out.println("type 'draw' after input to offer a draw game");
		System.out.println("ex: Please Enter Move: 1a 2b draw");
		System.out.println("type 'draw' to accept offer");
		System.out.println("-------------------------------------------------");
		System.out.println("type 'quit' to exit game");
		System.out.println("*************************************************");
		
		//create a new game
		Chess game = new Chess();
		
		try{
			//input stream reader wrapped in buffered reader
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			//while game is not over
			while(game.gameOver == false){
				game.moveCount++;
				//if this is an odd numbered move (white's turn)
				if ( game.moveCount % 2 == 1 ) {
					System.out.println(game.white.toString() + "'s turn!");
					System.out.print("Please enter move: ");
					
					//read in input for this player's move 
					String moveInput = br.readLine();
					
					//check if gameover
					if (moveInput.equals("quit")){
						game.gameOver = true;
					}else{
					
					//parse input for correctness
					}
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
		
		//2a 4a (white)
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
