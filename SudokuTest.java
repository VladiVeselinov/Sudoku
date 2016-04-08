import java.awt.Point;

/**
 * Sudoku driver class
 * 
 * @author Vladi
 */
public class SudokuTest
{
    public static void main(String[] args)
    {
	Sudoku game = new Sudoku();
	// http://www.telegraph.co.uk/news/science/science-news/9359579/Worlds-hardest-sudoku-can-you-crack-it.html
	game.makeMove(new Point(0,0), 8);
	game.makeMove(new Point(1,2), 3);
	game.makeMove(new Point(1,3), 6);
	game.makeMove(new Point(2,1), 7);
	game.makeMove(new Point(2,4), 9);
	game.makeMove(new Point(2,6), 2);
	game.makeMove(new Point(3,1), 5);
	game.makeMove(new Point(3,5), 7);
	game.makeMove(new Point(4,4), 4);
	game.makeMove(new Point(4,5), 5);
	game.makeMove(new Point(4,6), 7);
	game.makeMove(new Point(5,3), 1);
	game.makeMove(new Point(5,7), 3);
	game.makeMove(new Point(6,2), 1);
	game.makeMove(new Point(6,7), 6);
	game.makeMove(new Point(6,8), 8);
	game.makeMove(new Point(7,2), 8);
	game.makeMove(new Point(7,3), 5);
	game.makeMove(new Point(7,7), 1);
	game.makeMove(new Point(8,1), 9);
	game.makeMove(new Point(8,6), 4);
	SudokuSolver.solve(game);
	int[][] a = game.getBoard();
	for(int i = 0; i < 9; i++)
	{
	    for(int j = 0; j < 9; j++)
		System.out.print(a[i][j] + " ");
	    System.out.print("\n");
	}
    }
}
