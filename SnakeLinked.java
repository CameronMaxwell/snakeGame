/**
 * @author Cameron Maxwell
 * class stores the information about the snake as it moves around the board
 */

public class SnakeLinked {

	private int snakeLength;
	private DoubleList<Position> snakeBody;
	
	
	/**
	 * @param row
	 * @param col
	 */
	public SnakeLinked(int row, int col) {
		
		// snakeLength set initially to 1
		snakeLength = 1;
		// snakeBody initialized so it contains a DoubleList of nodes containing 'Position' objects
		snakeBody = new DoubleList<Position>();
		// create object of class 'Position' storing row and col 
		Position pos = new Position(row,col);
		// now store the position object 'pos' into the first index of the snakeBody (first node in list)
		snakeBody.addData(0, pos);
	}  // method closes
	
	
	/**
	 * @return snakeLength
	 */
	public int getLength() {
		
		return snakeLength;
	}  	
	
	
	/**
	 * @param index
	 * @return position
	 */
	public Position getPosition(int index) {
		
		if (index < 0 || index >= snakeLength) {
			
			return null;
		
		} else {
			
			// return the position object stored in the index (using getData method)
			return snakeBody.getData(index);
		}
	}  // method closes
	
	
	/**
	 * @param pos
	 * @return boolean true/false
	 */
	public boolean snakePosition(Position pos) {
		
		// create currentNode
		DoubleNode<Position> currentNode = new DoubleNode();
		currentNode = snakeBody.getNode(0);
		
		for (int i = 0; i < snakeLength; i++) {
			
			//Position currentData = currentNode.getData();
			if (currentNode.getData().equals(pos)) {
				// return true
				return true;
				
			} else {
				// otherwise iterate and get the next node and that is the new current
				currentNode = currentNode.getNext();
			} 
		}
		// return false otherwise
		return false;
	}  // method closes
	
	
	/**
	 * @param direction
	 * @return pos
	 */
	public Position newHeadPosition(String direction) {
		
		// row or column change at the snakeBody[0] which is the head, and get the row or column
		// values of this change
		int row = snakeBody.getData(0).getRow();
		int col = snakeBody.getData(0).getCol();
		
		// interpret the given string and change the new 'pos' snake head position accordingly
		
		if (direction == "right") {
			// increase the column by 1
			col = col + 1;
		}
		
		else if (direction == "left") {
			// decrease the column by 1
			col = col - 1;
		}
		
		else if (direction == "up") {
			// decrease the row by 1
			row = row - 1;
		}
		
		else if (direction == "down") {
			// increase row by 1
			row = row + 1;
		}
			
		// create a new 'pos' of the snakeHead location with new row and column coordinates
		Position pos = new Position(row,col);
		// @return this snake head 'pos'
		
		return pos;
	}  // method closes
	
	
	/**
	 * @param direction
	 */
	public void moveSnakeLinked(String direction) {
		
		// cover case where all the snake contains is a head
		if (snakeLength == 1) {
			// data must be set at index 0 
			snakeBody.setData(0,  newHeadPosition(direction));
			return;
		}
		
		for (int ctr = snakeLength - 1; ctr >= 1; ctr --) {

			// at each increment through the snakeBody, at that given value as you go through
			// the snake, decrease it by one (the index of 'Snakebody' changes).
			snakeBody.getNode(ctr).setData(snakeBody.getNode(ctr -1).getData());
		}
		// set the data of newHeadPosition given the direction at the node at index 0
		snakeBody.getNode(0).setData(newHeadPosition(direction));
	}  // method closes
	
	
	/**
	 * decreases snakeLength by 1
	 */
	public void shrink() {
		// decrease snakeLength by 1
		snakeLength = snakeLength - 1;
	}  
	
	
	/**
	 * @param direction
	 */
	public void grow(String direction) {
		
		//Position newHeadInfo = newHeadPosition(direction);
		snakeBody.addData(0, newHeadPosition(direction));
		
		// increase snakeLength as the snake grows by one
		snakeLength = snakeLength + 1;	
	}  // method closes
}  // class closes
