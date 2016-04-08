import java.awt.Point;

/**
 * Sudoku game class
 * 
 * @author Vladi
 */
public class Sudoku
{
    private int[][] board;
    private int movesLeft;
    public Sudoku()
    {
	board = new int[9][9];
	for(int i = 0; i < 9; i++)
	    for(int j = 0; j < 9; j++)
		board[i][j] = 0;
	movesLeft = 81;
    }
    public Sudoku(Sudoku game)
    {
	int[][] oldBoard = game.getBoard();
	board = new int[9][9];
	for(int i = 0; i < 9; i++)
	    for(int j = 0; j < 9; j++)
		board[i][j] = oldBoard[i][j];
	movesLeft = game.getMovesLeft();
    }
    public boolean makeMove(Point p, int a)
    {
	int x = p.x;
	int y = p.y;
	if(board[x][y] != 0)
	    return false;
	board[x][y] = a;
	if(check(board))
	{
	    movesLeft--;
	    return true;
	}
	board[x][y] = 0;
	return false;
    }
    public boolean delete(Point p)
    {
	if(board[p.x][p.y] != 0)
	{
	    board[p.x][p.y] = 0;
	    movesLeft++;
	    return true;
	}
	return false;
    }
    // checks if the board is legal
    private static boolean check(int[][] b) 
    {
	int row, col, i, j;
	// Row check
	for(row = 0; row < 9; row++)
	    for(col = 0; col < 8; col++)
		for(i = col+1; i < 9; i++)
		    if(b[row][i] != 0 && b[row][i] == b[row][col])
			return false;
	
	// Column check
	for(col = 0; col < 9; col++)
	    for(row = 0; row < 8; row++)
		for(i = row+1; i < 9; i++)
		    if(b[i][col] != 0 && b[i][col] == b[row][col])
			return false;
	
	// Square check
	String s;
	int n;
	for(row = 0; row < 9; row+=3)
	    for(col = 0; col < 9; col+=3)
	    {
		s = "";
		for(i = row; i < row+3; i++)
		    for(j = col; j < col+3; j++)
			if(b[i][j] > 0)
			    s += Integer.toString(b[i][j]);
		n = s.length();
		while(n > 1)
		{
		    s = s.replace(s.substring(0,1), "");
		    if(n - s.length() > 1)
			return false;
		    n = s.length();
		}
	    }
	
	return true;
    }
    public Point getFirstEmpty()
    {
	Point p = new Point(-1, -1);
	for(p.x = 0; p.x < 9; p.x++)
	    for(p.y = 0; p.y < 9; p.y++)
		if(board[p.x][p.y] == 0)
		    return p;
	return p;
    }
    public int[][] getBoard()
    {
	int[][] b = new int[9][9];
	for(int i = 0; i < 9; i++)
	    for(int j = 0; j < 9; j++)
		b[i][j] = board[i][j];
	return b;
    }
    public int getMovesLeft()
    {
	return movesLeft;
    }
}
