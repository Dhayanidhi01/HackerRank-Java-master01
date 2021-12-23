package genericStackQueue;

public class Main {

	public static void myStackPractice() {
		/* Create an instance of a StackInt object */
		GenericStack <Integer> myStack = new GenericStack <Integer>();
		
		/* Print out a header */
		System.out.println("*************************************");
		System.out.println("* Testing Generic <int> Stack Class *");
		System.out.println("*************************************");
		
		/* See if the stack is empty */
		if (myStack.isEmpty()) {
			System.out.println("The stack is empty");
		}
		/* Print the contents of the stack */
		myStack.print();
		
		/* Push some data on the stack */
		myStack.push(1);
		myStack.print();
		myStack.push(3);
		myStack.print();
		myStack.push(25);
		myStack.print();
		
		/* Peek at the top of the stack */
		System.out.println("The top of the stack contains=" + myStack.peek());
		
		
		///* Search the stack for Two */
		System.out.println("The index of 3 is=" + myStack.search(3));
		
		/* Pop data off the stack */
		int getData;
		getData = myStack.pop();
		System.out.println("Popped data=" + getData);
		myStack.print();
		getData = myStack.pop();
		System.out.println("Popped data=" + getData);
		myStack.print();
		getData = myStack.pop();
		System.out.println("Popped data=" + getData);
		myStack.print();
	}
	
	/* Practice with the my QueueInt Class */
	public static void myQueuePractice() {
		/* Create an instance of the Queue class */
		GenericQueue <Integer> myQueue = new GenericQueue <Integer>();
		
		/* Print out a header */
		System.out.println("*************************************");
		System.out.println("* Testing Generic <int> Queue Class *");
		System.out.println("*************************************");
		
		/* Test to see if the queue is empty */
		if (myQueue.isEmpty()) {
			System.out.println("The queue is empty");
		}
		/* Print out the queue */
		myQueue.print();
		
		/* Add elements to the queue */
		myQueue.add(2);
		myQueue.print();
		myQueue.add(4);
		myQueue.print();
		myQueue.add(6);
		myQueue.print();
		
		/* Peek at the head of the queue */
		System.out.println("The head of the queue contains=" + myQueue.peek());
		myQueue.print();
		
		/* Print the queue size */
		System.out.println("The size of the queue is=" + myQueue.size());
		
		/* Remove elements from the queue */
		int getData;
		getData = myQueue.remove();
		System.out.println("Removed " + getData + " from the queue.");
		myQueue.print();
		getData = myQueue.remove();
		System.out.println("Removed " + getData + " from the queue.");
		myQueue.print();
		getData = myQueue.remove();
		System.out.println("Removed " + getData + " from the queue.");
		myQueue.print();
		
	}
	
	public static void main(String[] args) {
		/* Practice with my StackInt Class */
		myStackPractice();
		
		/* Practice with my QueueInt Class */
		myQueuePractice();

	}

}
