import java.util.Random;
import java.util.Scanner;

public class Minefield {
	int rowNumber , colNumber , size,success = 0;
	int[][] map;
	int [][] board;
    boolean game = true;	
	
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	
	public  Minefield(int rowNumber,int colNumber) {
		this.rowNumber = rowNumber;
		this.colNumber = colNumber;
		this.map = new int[rowNumber][colNumber];
		this.board = new int[rowNumber][colNumber];
		this.size = rowNumber*colNumber;
	}
	
	public void run() {
		int row,col;
		prepareGame();
		print(map);
		System.out.println("Game is started.");
		while(game) {
			print(board);
			System.out.print("Row : ");
			row = scan.nextInt();
			System.out.print("Column : ");
			col = scan.nextInt();
			if(row >= 0 || row >= rowNumber) {
				System.out.println("Invalid coordinate !");
				continue;
			}
			if(col >= 0 || col >= colNumber) {
				System.out.println("Invalid coordinate !");
				continue;
			}
			
			if(map[row][col] != -1) {
				check(row,col);
				success++;
				if(success == (size - (size/4))) {
					System.out.println("You are congrats.");
					break;
				}
			}
		}
		
	}
	public void check(int r,int c) {
		if(map[r][c] == 0) {
			if((c < colNumber -1) && (map[r][c + 1] == -1)) {
				board [r][c]++;
			}
			if(( r < rowNumber -1 ) && ( map[r+1][c] == -1)) {
				board [r][c]++;
			}
			if((r > 0) && (map[r - 1][c] == -1)) {
				board [r][c]++;
			}
			if((c > 0) && (map[r][c - 1] == -1)){
				board [r][c]++;
			}
			if(board[r][c] == 0) {
				board[r][c] = -2;
			}
		}
	}
	
	public void prepareGame() {//mine generate
		int randRow,randCol, mineCount = 0;
		while (mineCount != (size/4)) {
			randRow = random.nextInt(rowNumber);
			randCol = random.nextInt(colNumber);
			if(map[randRow][randCol] != -1) {
				map[randRow][randCol] = -1;
				mineCount++;
			}
		}
		
	}
	public void print(int[][] arr) {
		for( int i = 0; i<arr.length; i++) {
			for( int j =0; j< arr[0].length; j++) {
				if(arr[i][j] >= 0) 
					System.out.print(" ");
				System.out.print(arr[i][j]+ " ");
				
			} System.out.println();
		}
	}
	
	
}



 class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		 int row,column;
		 System.out.println("Welcome to MineField !");
		 System.out.println("Please enter the dimensions you want to play with !");
		 System.out.print("Row count : ");
		 row = scan.nextInt();
		 System.out.print("Column count : ");
		 column = scan.nextInt();
		 
		 Minefield mine = new Minefield(row,column);
		 mine.run();
		 
		 
		 
	}

}

