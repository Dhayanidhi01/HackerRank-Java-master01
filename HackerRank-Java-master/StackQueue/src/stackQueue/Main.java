package stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	
	/* Java Stack Class practice */
	public static void stackPractice() {
		/* Create an instance of a Stack object */
		Stack stack = new Stack();
		
		/* Print out a header */
		System.out.println("****************************");
		System.out.println("* Testing Java Stack Class *");
		System.out.println("****************************");
		
		/* See if the stack is empty */
		if (stack.isEmpty()) {
			System.out.println("The stack is empty");
		}
		/* Print the contents of the stack */
		System.out.println(stack);
		/* Push some data on the stack */
		stack.push("One");
		System.out.println(stack);
		stack.push("Two");
		System.out.println(stack);
		stack.push("Three");
		System.out.println(stack);
		
		/* Peek at the top of the stack */
		System.out.println("The top of the stack contains=" + stack.peek());
		
		/* Search the stack for Two */
		System.out.println("The index of the string Two is=" + stack.search("Two"));
		
		/* Pop data off the stack */
		String getData;
		getData = (String) stack.pop();
		System.out.println("Popped data=" + getData);
		System.out.println(stack);
		getData = (String) stack.pop();
		System.out.println("Popped data=" + getData);
		System.out.println(stack);
		getData = (String) stack.pop();
		System.out.println("Popped data=" + getData);
		System.out.println(stack);
		
	}

	/* Practice with the Java Queue Class */
	public static void queuePractice() {
		/* Create an instance of the Queue class */
		Queue queue = new LinkedList();
		
		/* Print out a header */
		System.out.println("****************************");
		System.out.println("* Testing Java Queue Class *");
		System.out.println("****************************");
		
		/* Test to see if the queue is empty */
		if (queue.isEmpty()) {
			System.out.println("The queue is empty");
		}
		/* Print out the queue */
		System.out.println(queue);
		
		/* Add elements to the queue */
		queue.add(2);
		System.out.println(queue);
		queue.add(4);
		System.out.println(queue);
		queue.add(6);
		System.out.println(queue);
		
		/* Peek at the head of the queue */
		System.out.println("The head of the queue contains=" + queue.element());
		System.out.println(queue);
		
		/* Print the queue size */
		System.out.println("The size of the queue is=" + queue.size());
		
		/* Remove elements from the queue */
		int getData;
		getData = (int) queue.remove();
		System.out.println("Removed " + getData + " from the queue.");
		System.out.println(queue);
		getData = (int) queue.remove();
		System.out.println("Removed " + getData + " from the queue.");
		System.out.println(queue);
		getData = (int) queue.remove();
		System.out.println("Removed " + getData + " from the queue.");
		System.out.println(queue);
		
	}
	
	public static void myStackPractice() {
		/* Create an instance of a StackInt object */
		StackInt myStack = new StackInt();
		
		/* Print out a header */
		System.out.println("**************************");
		System.out.println("* Testing my Stack Class *");
		System.out.println("**************************");
		
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
		QueueInt myQueue = new QueueInt();
		
		/* Print out a header */
		System.out.println("**************************");
		System.out.println("* Testing my Queue Class *");
		System.out.println("**************************");
		
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
		/* Practice with Java Stack Class */
		stackPractice();
		
		/* Practice with Java Queue Class */
		queuePractice();
		
		/* Practice with my StackInt Class */
		myStackPractice();
		
		/* Practice with my QueueInt Class */
		myQueuePractice();

	}

}
