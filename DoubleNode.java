/**
 * @author Cameron Maxwell 
 * represents the nodes in a doubly linked list
 * @param <T>
 */
public class DoubleNode<T> {

	// A reference to the next node in the list.
	private DoubleNode<T> next;
	// A reference to the previous node in the list.
	private DoubleNode<T> prev;
	// the data stored in the node
	private T data;
	
	
	public DoubleNode () {
		
		// set next, prev, and data to null
		next = null;
		prev = null;
        data = null;
	}  
	
	
	/**
	 * @param newData
	 */
	public DoubleNode (T newData) {
		
		data = newData;
		next = null;
		prev = null;
	}
	
	
	/**
	 * @return next
	 */
	public DoubleNode<T> getNext() {
		
		return next;
	}
	
	
	/**
	 * @return prev
	 */
	public DoubleNode<T> getPrev() {
		
		return prev;
	}
	
	
	/**
	 * @return data
	 */
	public T getData() {
		
		return data;
	}
	
	
	/**
	 * @param nextNode
	 */
	public void setNext(DoubleNode<T> nextNode) {
		
		next = nextNode;
	}
	
	
	/**
	 * @param prevNode
	 */
	public void setPrev(DoubleNode<T> prevNode) {
		
		prev = prevNode;
	}
	
	
	/**
	 * @param newData
	 */
	public void setData(T newData) {
		
		data = newData;
	}
	
}  // class closes

