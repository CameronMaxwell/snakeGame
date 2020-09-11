/**
 * @author Cameron Maxwell
 * class represents a doubly linked list of nodes of the class DoubleNode
 * @param <T>
 */

public class DoubleList<T> {

	// reference to first node in the list
	private DoubleNode<T> head;
	// reference to last node in the list
	private DoubleNode<T> rear;
	// number of nodes in the list
	private int numDataItems;
	
	
	public DoubleList() {
		
		head = null;
		rear = null;
		numDataItems = 0;
	}
	
	
	/**
	 * @param index
	 * @param newData
	 * @throws InvalidPositionException
	 */
	public void addData(int index, T newData) throws InvalidPositionException {
		
		// create newNode and CurrentDoubleNode
		DoubleNode<T> newNode = new DoubleNode<T>(newData);
		DoubleNode<T> currentDoubleNode = head;
		
		if (index > numDataItems || index < 0) {
			
			throw new InvalidPositionException("Invalid index");
		}
		
		// case 1: empty list and adds data
		if (head == null) {	
			
			// the head and rear must become new node
			head = newNode;
			rear = newNode;
			numDataItems ++;
			return;
		}
		
		// case 2: 1 item in list and adds data
		else if (index == 0) {
			
			// make the current node the next node 
			currentDoubleNode = head;
			// make the newNode the front
			head = newNode;
			head.setNext(currentDoubleNode);
			numDataItems ++;
			return;
		}
		
		// case 3: specified index is at the end of the list
		else if (index == numDataItems) {
	
			// make the rear the current node
			currentDoubleNode = rear;
			// make the newNode the rear
			rear = newNode;
			// set current's next to the newNode (rear)
			currentDoubleNode.setNext(rear);
			rear.setNext(head);
			// increment numDataItems count
			numDataItems ++;
			return;
		}
		
		// case 4: checks if index anywhere between and adds data
		for (int x = 0; x < numDataItems; x++) {
			
			// if list is empty, make the newNode the head and the rear as its only element in now
			if (index == 0 && numDataItems ==0) {
				
				head = newNode;
				rear = newNode;
			}
		
			// once it gets to the desired node specified by the index
			else if (index == x) {
				
				DoubleNode<T> previous = head;
				DoubleNode<T> successor = head.getNext();
				
				// set previous' next to the new node
				previous.setNext(newNode);
				// set (previous' next)'s next to the successor
				previous.getNext().setNext(successor);
				// increment numDataItems count
				numDataItems ++;
				return;
			}
			// iterate through by getting the next node if no return (specified index not reached yet)
			currentDoubleNode = currentDoubleNode.getNext();
			
		}  // for loop closes
		numDataItems ++;
	}  // method closes
	
	
	/**
	 * @param index
	 * @return
	 * @throws InvalidPositionException
	 */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException {
		
		if (index < 0 || index >= numDataItems) {
			
			throw new InvalidPositionException("Invalid position.");
		}
		
		// case 1: if front of list
		if (index == 0) {
			
			return head;
		}
		
		// case 2: if at end of list
		if (index == numDataItems - 1) {
			
			return rear;
		}
		
		// case 3: if somewhere between in list
		DoubleNode<T> currentNode = head;
		
		int ctr = 0;
		while (ctr != index) {
			// until reach index, get the next node in list
			currentNode = currentNode.getNext();
			ctr ++;
		}
		// return the node once it hits the given index
		return currentNode;
	}  // method ends
	
	
	/**
	 * @param index
	 * @throws InvalidPositionException
	 */
	public void removeData(int index) throws InvalidPositionException {
		
		if (index < 0 || index >= numDataItems) {
			
			throw new InvalidPositionException("Position is invalid.");
		}
		
		// case 1: if there are no nodes to delete
		if (head == null) {
			
			return;
		}
				
		// case 2: if node to delete is at front (remove the head)
		if (index == 0) {
		
			// removes the reference to the first link (head)
			head = head.getNext();
			
			return;
		} 
		
		// case 3: if node to delete is at end
		if (index == numDataItems - 1) {
		
			DoubleNode<T> previousNode = head;
			DoubleNode<T> nodeToDelete = head.getNext();

			while (nodeToDelete.getNext() != null) {
				
				// iterate through till the next is null which proves the end of the list
				previousNode = nodeToDelete;
				nodeToDelete = nodeToDelete.getNext();
			}
			// next must be null
			previousNode.setNext(null);
			return;
		}

		// case 4: otherwise where the node to delete is in the middle
		DoubleNode<T> previousNode = this.getNode(index -1);
		DoubleNode<T> nodeToDelete = this.getNode(index);
		previousNode.setNext(nodeToDelete.getNext());

		// reduce the count of data items
		numDataItems--;
	}  // method closes
		
	
	/**
	 * @param index
	 * @return
	 * @throws InvalidPositionException
	 */
	public T getData(int index) throws InvalidPositionException {
		
		if (index < 0 || index >= numDataItems) {
			
			throw new InvalidPositionException("Invalid index.");
		}
		
		// get the node given an index, and get it's data using getData() from DoubleNode
		return getNode(index).getData();
		
	}  // method ends
	
	
	/**
	 * @param index
	 * @param newData
	 * @throws InvalidPositionException
	 */
	public void setData(int index, T newData) throws InvalidPositionException{
		
		if (index < 0 || index >= numDataItems) {
			
			throw new InvalidPositionException("Invalid index.");
		}
		
		// create newNode which is the node at the given index in the list
		DoubleNode<T> newNode = getNode(index);
		// set the newNode's data given the new data 
		newNode.setData(newData);
	}  // method closes

}  // class closes
