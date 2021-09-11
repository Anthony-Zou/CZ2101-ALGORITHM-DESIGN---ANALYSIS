package dijkstra;// Java program to demonstrate the
// working of PriorityQueue
import java.util.*;

class PriorityQueueDemo {

    // Main Method
    public static void main(String args[])
    {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());

        // Printing the top element again
        System.out.println(pQueue.peek());
        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");

        System.out.println(pq);
        System.out.println();System.out.println();
        PriorityQueue<String> pqr = new PriorityQueue<>();

        pqr.add("PriorityQueue");
        pqr.add("For");
        pqr.add("Dijkstra");

        System.out.println("Initial PriorityQueue " + pqr);

        // using the method
        pqr.remove("PriorityQueue");

        System.out.println("After Remove - " + pqr);

        System.out.println("Poll Method - " + pqr.poll());

        System.out.println("Final PriorityQueue - " + pqr);
        System.out.println();System.out.println();
        // Creating a priority queue
        PriorityQueue<String> pq3= new PriorityQueue<>();
        pq3.add("Geeks");
        pq3.add("For");
        pq3.add("Geeks");
        System.out.println("PriorityQueue: " + pq3);

        // Using the peek() method
        String element = pq3.peek();
        System.out.println("Accessed Element: " + element);

        System.out.println();System.out.println();


        PriorityQueue<String> pq4 = new PriorityQueue<>();

        pq4.add("Geeks");
        pq4.add("For");
        pq4.add("Geeks");

        Iterator iterator = pq4.iterator();
        System.out.println("PriorityQueue: " + pq4);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
