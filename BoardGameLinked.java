/**
 * @author Cameron Maxwell
 * class represents the board game where the snake moves around eating apples
 */

public class BoardGameLinked {

	private int boardLength;
	private int boardWidth;
	private SnakeLinked theSnake;
	private DoubleList<String>[] board;
	
	
	/**
	 * constructor designed to take in a file with dimensions of the board length (which vary),
	 * the snakes initial position, and the objects' positions 
	 * @param boardFile
	 */
	public BoardGameLinked(String boardFile) {
		
		// create object info of type MyFileReader
		MyFileReader info = new MyFileReader(boardFile);
		
		info.readInt();
		info.readInt();
		boardLength = info.readInt();
		boardWidth = info.readInt();
		
		// create initialization for the row and col using inputs 4 and 5
		int initialRow;
		int initialColumn;
		initialRow = info.readInt();
		initialColumn = info.readInt();
		
		// create object snake using initial row and column given in file that was read
		theSnake = new SnakeLinked(initialRow, initialColumn);
		
		board =  new DoubleList[boardWidth];	
		
		// for loop goes through board width and length inside array and doubly linked list
		// setting each doubleList String equal to "empty"
		for (int a = 0; a < boardWidth; a++) {  
			board[a] = new DoubleList<String>();
			for (int b = 0; b < boardLength; b++) {
				board[a].addData(b, "empty");
			}
			
		}
		
		int firstNum = 0;
		int secondNum = 0;
		String stringName;
		
		// while not done reading through the end of the file..
		while (info.endOfFile() != true) {
			
			firstNum = info.readInt();
			secondNum = info.readInt();
			
			stringName = info.readString();
			board[firstNum].setData(secondNum, stringName);
			
		}  // while loop closes
	}  // method closes
	
	
	/**
	 * @param row
	 * @param col
	 * @return returnString
	 * @throws InvalidPositionException
	 */
	public String getObject(int row, int col) throws InvalidPositionException {
		
		if (row >= boardWidth || col >= boardLength) {
			
			throw new InvalidPositionException("The row or column are invalid positions.");
		}
		
		// return a string stored in the node based on row and col specified
		String returnString;
		returnString = board[row].getData(col);
		
		return returnString;
	}
	
	
	/**
	 * @param row
	 * @param col
	 * @param newObject
	 * @throws InvalidPositionException
	 */
	public void setObject(int row, int col, String newObject) throws InvalidPositionException {
		
		if (row >= boardWidth || col >= boardLength) {
			
			throw new InvalidPositionException("The row or column are invalid positions.");
		}
		// set the data given the row and column, and the new object
		board[row].setData(col, newObject);	
		
	}
	
	/**
	 * @return theSnake
	 */
	public SnakeLinked getSnakeLinked() {
		
		return theSnake;
	}
	
	
	/**
	 * @param newSnake
	 */
	public void setSnakeLinked(SnakeLinked newSnake) {
		
		theSnake = newSnake;
	}
	
	
	/**
	 * @return boardLength
	 */
	public int getLength() {
		
		return boardLength;
	}
	
	
	/**
	 * @return boardWidth
	 */
	public int getWidth() {
		
		return boardWidth;
	}
	
}  // class closes
