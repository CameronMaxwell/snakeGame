/** 
* @author Cameron Maxwell
* This class deals with positions of rows and columns on the board for which the game is being
* played.  The class Position contains a method "Position" which creates an object of this type and
* it takes 2 integers (row/column) which store the values of the position of each square on the grid.  
*/
public class Position {
	
	private int positionRow;
	private int positionColumn;
	
	// constructor method of position type taking in a row and column
	public Position(int row, int col) {
		
		this.positionRow = row;
		this.positionColumn = col;		
	}

	// @return method to return the row position 
	public int getRow() {
		
		return this.positionRow;
	}
		
	// @return method to return the column position
	public int getCol() {
		
		return this.positionColumn;
	}
		
	// void method with no return as it sets the row to the parameter specified
	public void setRow(int newRow) {
		
		this.positionRow = newRow;
	}
	
	// void method with no return as it sets the column to the parameter specified
	public void setCol(int newCol) {
		
		this.positionColumn = newCol;
	}
	
	// @return this boolean tests if the position parameter entered equals the existing position and 
	// returns it as a boolean true or false
	public boolean equals(Position other) {
		
		if (this.positionRow == other.positionRow && this.positionColumn == other.positionColumn){
			
			return true;
		
		} else {
			
			return false;
		}
	}
	
}  // class closes
