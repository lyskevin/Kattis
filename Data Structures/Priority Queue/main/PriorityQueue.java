import java.util.Comparator;

/**
 * @author lyskevin
 * Mutable priority queue class which supports the update key operation.
 */
public class PriorityQueue<E> {

    private static final int DEFAULT_CAPACITY = 8;
    public static final String OFFER_NULL_MESSAGE = "Cannot offer null to the priority queue";

    private int size;

    /**
     * Constructs a {@code PriorityQueue} with the default initial capacity (8)
     * that orders elements according to their natural ordering.
     */
    public PriorityQueue() {
        size = DEFAULT_CAPACITY;
    }

    /**
     * Constructs a {@code PriorityQueue} with the default initial capacity (8)
     * that orders elements according to the specified comparator.
     * @param comparator
     */
    public PriorityQueue(Comparator<? super E> comparator) {

    }

    /**
     * Returns {@code true} if this priority queue contains no elements.
     * @return {@code true} if this priority queue contains no elements.
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * Inserts the specified element into this priority queue.
     * @param e The specified element.
     * @return {@code true}
     * @throws ClassCastException If the specified element cannot
     * be compared with elements currently in this priority queue
     * according to the priority queue's ordering.
     * @throws NullPointerException If the specified element is null.
     */
    public boolean offer(E e) throws ClassCastException, NullPointerException {
        return false;
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns null if this priority queue is empty.
     * @return The head of this priority queue.
     */
    public E peek() {
        return null;
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns null if this priority queue is empty.
     * @return The head of this priority queue.
     */
    public E poll() {
        return null;
    }

    /**
     * Returns the number of elements in this priority queue.
     * @return The number of elements in this priority queue.
     */
    public int size() {
        return size;
    }

}
