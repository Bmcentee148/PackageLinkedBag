// This will implement the BagInterface using a linked node implementation

public class LinkedBag<T> implements BagInterface<T> {
	private Node head;
	private int numOfEntries;

	public LinkedBag(){
		head = null;
		numOfEntries = 0;
	}

	public boolean add(T Entry) {
		boolean status = false;
		if(Entry != null) {
			if(!isFull()) {
				Node newNode = new Node(Entry);
				newNode.setNext(this.head);
				this.head = newNode;
				this.numOfEntries ++;
				status = true;
			}
		}
		return status;
	}

	public int getCurrentSize() {
		return this.numOfEntries;
	}

	public boolean isFull() {
		return false;
	}

	public boolean isEmpty() {
		return this.numOfEntries == 0;
	}

	public T remove() {
		T r_Entry = null;
		if( !isEmpty() ) {
			r_Entry = this.head.getData();
			this.head = this.head.getNext();
			numOfEntries--;
		}
		return r_Entry;
	}

	public T remove (T anEntry) {
		boolean isFound = false;
		T r_Entry = null;
		Node currNode = this.head;
		Node prevNode = null;
		while( (!isFound) && (currNode != null) ) {
			if(anEntry.equals(currNode.getData())) {
				isFound = true;
				r_Entry = currNode.data;
				prevNode.setNext(currNode.getNext());
				numOfEntries --;
			}
			prevNode = currNode;
			currNode = currNode.getNext();
		}
		return r_Entry;
	}

	public void clear() {
		this.numOfEntries = 0;
		head = null;
	}

	public int getFrequencyOf(T anEntry) {
		int freq = 0;
		Node currNode = head;
		while( (currNode != null) ) {
			if(anEntry.equals(currNode.getData())) {
				freq ++;
			}
			currNode = currNode.getNext();
		}
		return freq;
	}

	public boolean contains(T anEntry) {
		Node currentNode = head;
		boolean isFound = false;
		while( (currentNode != null) && (!isFound)) {
			if(anEntry.equals(currentNode.getData())){
				isFound = true;
			}
			currentNode = currentNode.getNext();
		}
		return isFound;
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numOfEntries];

		int index = 0;
		Node currentNode = head;
		while((index < numOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			index++;
			currentNode = currentNode.getNext();
		}
		return result;
	}

	private class Node {
		private T data; //entry in bag
		private Node next; //link to next node

		private Node(T dataPortion) {
			this(dataPortion,null);
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		private T getData() {
			return this.data;
		}

		private void setData(T dataPortion) {
			this.data = dataPortion;
		}

		private void setNext(Node nextNode) {
			this.next = nextNode;
		}

		private Node getNext() {
			return this.next;
		}
	}//end Node         
}