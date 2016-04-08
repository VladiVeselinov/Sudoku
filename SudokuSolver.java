import java.awt.Point;

/**
 * Sudoku solver class
 * 
 * @author Vladi
 */
public class SudokuSolver
{
    public static boolean solve(Sudoku game)
    {
	if(game.getMovesLeft() == 0)
	    return true;
	Point p = game.getFirstEmpty();
	for(int n = 1; n <= 9; n++)
	{
	    if(game.makeMove(p, n))
	    {
		if(solve(game))
		    return true;
		game.delete(p);
	    }
	}
	return false;
    }
}
