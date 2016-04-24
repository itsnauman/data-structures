import java.util.NoSuchElementException;

/**
 * This class implements a Queue using a Linked List
 *
 * @author Nauman Ahmad
 */
public class LinkedListQueue <T> {
    private Node <T> head;
    private Node <T> tail;
    private int size;

    /**
     * Push an element to queue. Add it to the start of the linked list
     * Time Complexity: O(1)
     * @param element The element to be added
     */
    public void enqueue(T element) {
        Node <T> tmp = new Node<>(element);

        if (head == null) {
            head = tmp;
            tail = tmp;
        } else {
            tmp.next = head;
            head.previous = tmp;
            head = tmp;
        }
        size++;
    }

    /**
     * Remove an element from the end of the list
     * Time Complexity: O(1)
     * @return
     */
    public T dequeue() {
        if (size == 0)
            throw new NoSuchElementException();

        T tmp = tail.data;
        tail = tail.previous;
        tail.next = null;
        return tmp;
    }

    /**
     * Get the element in front of the queue
     */
    public T peek() {
        if (size == 0)
            throw new NoSuchElementException();

        return tail.data;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Node <T> current = head; current != null; current = current.next)
            str.append(current.data).append("\t");

        return str.toString();
    }

    /**
     * Class to represent a Node for the doubly linked list.
     */
    private class Node <E> {
        public Node <E> next;
        public Node <E> previous;
        public E data;

        Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
