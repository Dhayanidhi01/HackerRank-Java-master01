package genericLinkedList;

public class GenericLinkedList<inputType> {

	/* Instance Variables */
	Node<inputType> head; /*
							 * First node of the linked list, or null (if empty)
							 */
	int count; /* Count of the nodes in the list */
	
	/* Constructors */
	/* Constructor for a list with no new head */
	public GenericLinkedList() {
		/* Initialize the head as null (empty list) */
		head = null;
		/* Empty list; so count = 0 */
		count = 0;
	}
	/* Constructor for a list with a new head */
	public GenericLinkedList(Node<inputType> newHead) {
		/* Initialize the head as the new linked list head */
		head = newHead;
		/* Initialize the count to 1 */
		count = 1;
	}
	
	/* Methods */
	/* add to the list */
	public void add(inputType newData) {
		/* Create a new node with the new data */
		Node<inputType> newNode = new Node<inputType>(newData);
		
		/* Is the list empty? */
		if (head == null) {
			/* The new node is the list */
			head = newNode;
			count = 1;
			return;
		}
		
		/* Store the current head */
		Node<inputType> current = head;
		
		/* Loop thru the list to the end */
		while(current.getNext() != null) {
			current = current.getNext();
		}
		
		/* Add the new node to the end of the list */
		current.setNext(newNode);
		
		/* Increment the node counter */
		count++;
	}
	
	/* Get data from a specific index within the list */
	public inputType get(int index) {
		/* See if the index is within range of the list */
		if ((index <=0) || (count < index)) {
			throw new IndexOutOfBoundsException();
		}
		
		/* Start with the head of the list */
		Node<inputType> current = head;
		
		/* Loop thru nodes until just before the index th node */
		for (int i=1; i<index; i++) {
			current = current.getNext();
		}
		/* Return the index th node */
		return current.getData();
	}
	
	/* Return the size of the linked list */
	public int size() {
		/* Return the count */
		return count;
	}
	
	/* Return true if the list is empty */
	public boolean isEmpty() {
		/* Return true if the head is null */
		return head == null;
	}
	
	/* Remove the node from the back of the list */
	public void remove() {
		/* Do we only have one node? */
		if (head.next == null) {
			/* Make the list empty */
			head = null;
			count = 0;
			return;
		}
		
		/* Start at the head of the list */
		Node<inputType> current = head;
		/* Scan thru list while two nodes ahead is not the end */
		while(current.getNext().getNext() != null) {
			/* Go to the next node */
			current = current.getNext();
		}
		/* Drop the last node of the list */
		current.setNext(null);
		count--;
	}
	
	/* Print out the linked list */
	public void print() {
		/* Print a square bracket at the beginning */
		System.out.print("[");
		
		/* Start at the head */
		Node<inputType> current = head;
		
		/* Loop thru the list printing nodes */
		while (current != null) {
			/* Print this nodes data */
			System.out.print(current.getData());
			/* Is there more data? */
			if (current.getNext() != null) {
				/* Print a comma after the data */
				System.out.print(", ");
			}
			/* Go to the next node */
			current = current.getNext();
		}
		
		/* Print the closing square bracket */
		System.out.println("]");
	}

	public static void main(String[] args) {
		/* Testing generic linked list */
		System.out.println("Testing generic linked list");
		
		/* Testing a list of Integers */
		System.out.println("**************************");
		System.out.println("Testing a list of Integers");
		System.out.println("**************************");
		GenericLinkedList<Integer> intList = new GenericLinkedList<Integer>();
		if (intList.isEmpty()) {
			System.out.println("The list is empty");
		}
		intList.print();
	
		intList.add(1);
		intList.print();
		intList.add(3);
		intList.print();
		intList.add(5);
		intList.print();
		
		System.out.println("The size of the list is: " + intList.size());
		System.out.println("Getting element 2 is " + intList.get(2));
		
		intList.remove();
		intList.print();
		
		System.out.println("The size of the list is: " + intList.size());
		System.out.println("Getting element 2 is " + intList.get(2));

		/* Testing a list of Strings */
		System.out.println("*************************");
		System.out.println("Testing a list of Strings");
		System.out.println("*************************");
		GenericLinkedList<String> stringList = new GenericLinkedList<String>();
		if (stringList.isEmpty()) {
			System.out.println("The list is empty");
		}
		stringList.print();
	
		stringList.add("Hi");
		stringList.print();
		stringList.add("There");
		stringList.print();
		stringList.add("Scott");
		stringList.print();
		
		System.out.println("The size of the list is: " + stringList.size());
		System.out.println("Getting element 2 is " + stringList.get(2));
		
		stringList.remove();
		stringList.print();
		
		System.out.println("The size of the list is: " + stringList.size());
		System.out.println("Getting element 2 is " + stringList.get(2));

	}

}
