
public class KnightsTourImplementation {

	static int N=8;
	
	public static void printSolution(int[][] chessBoard){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(chessBoard[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static boolean checkPlaceable(int x,int y,int[][] chessBoard){
		return (x>=0 && x<N && y>=0 && y<N && chessBoard[x][y]==-1);
	}
	
	public static boolean FindSolution(int x,int y,int position,int[] x_move,int[] y_move,int[][] chessBoard){
		int i,xNext,yNext;
		
		if(position==N*N){
			return true;
		}
		
		for (i = 0; i < N; i++) {
			xNext=x_move[i]+x;
			yNext=y_move[i]+y;

			if(checkPlaceable(xNext, yNext, chessBoard)==true){
				chessBoard[xNext][yNext]=position;
				if(FindSolution(xNext, yNext, position+1, x_move, y_move, chessBoard)==true)
					return true;
				
				chessBoard[xNext][yNext]=-1;
			}
		}
		return false;
	}
	
	public static boolean knight_tour(){
		int[][] chessBoard={{-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1}};
		
		int[] x_move={2, 1, -1, -2, -2, -1, 1, 2};
		int[] y_move={1, 2, 2, 1, -1, -2, -2, -1};
	
		chessBoard[0][0]=0;
		
		if (FindSolution(0, 0, 1, x_move, y_move,chessBoard)==false) {
			System.out.println("Solution does not exists");
		}
		printSolution(chessBoard);
		return true;
	}
	
	public static void main(String[] args) {
		knight_tour();
	}

}
