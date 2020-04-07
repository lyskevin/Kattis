import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

/**
 * @author lyskevin
 * Mutable priority queue class which supports the update key operation.
 */
public class PriorityQueue<E> {

    private static final String OFFER_INCOMPARABLE_ELEMENT_MESSAGE = "%s cannot "
            + "be cast to class java.lang.Comparable";
    private static final String OFFER_NULL_MESSAGE = "Cannot offer null to the priority queue";
    private static final int ROOT_POSITION = 0;

    private ArrayList<E> binaryHeap;
    private Optional<Comparator<? super E>> comparator;
    private int size;

    /**
     * Constructs a {@code PriorityQueue} that orders elements according to their natural ordering.
     */
    public PriorityQueue() {
        binaryHeap = new ArrayList<>();
        comparator = Optional.empty();
        size = 0;
    }

    /**
     * Constructs a {@code PriorityQueue} that orders elements according to the specified comparator.
     * The natural ordering of elements will be used if the specified comparator is null.
     * @param comparator The specified comparator.
     */
    public PriorityQueue(Comparator<? super E> comparator) {
        binaryHeap = new ArrayList<>();
        this.comparator = Optional.of(comparator);
        size = 0;
    }

    /**
     * Returns {@code true} if this priority queue contains no elements.
     * @return {@code true} if this priority queue contains no elements.
     */
    public boolean isEmpty() {
        return size == 0;
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
        if (e == null) {
            throw new NullPointerException(OFFER_NULL_MESSAGE);
        } else if (comparator.isEmpty() && !(e instanceof Comparable)) {
            throw new ClassCastException(String.format(OFFER_INCOMPARABLE_ELEMENT_MESSAGE, e.getClass()));
        } else {
            size++;
            if (size > binaryHeap.size()) {
                binaryHeap.add(e);
            } else {
                binaryHeap.set(size - 1, e);
            }
            shiftUp(size - 1);
            return true;
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns null if this priority queue is empty.
     * @return The head of this priority queue.
     */
    public E peek() {
        return isEmpty() ? null : binaryHeap.get(0);
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns null if this priority queue is empty.
     * @return The head of this priority queue.
     */
    public E poll() {
        if (isEmpty()) {
            return null;
        } else {
            E element = binaryHeap.get(0);
            binaryHeap.set(0, binaryHeap.get(size - 1));
            size--;
            shiftDown(0);
            return element;
        }
    }

    /**
     * Returns the number of elements in this priority queue.
     * @return The number of elements in this priority queue.
     */
    public int size() {
        return size;
    }

    /****************************** Private helper methods ******************************/

    @SuppressWarnings("unchecked")
    private int compare(E element1, E element2) {
        return comparator.map(
                value -> value.compare(element1, element2))
                .orElseGet(() -> ((Comparable<E>) element1).compareTo(element2)
        );
    }

    private int left(int position) {
        return position * 2 + 1;
    }

    private int parent(int child) {
        return (child - 1) / 2;
    }

    private int right(int position) {
        return position * 2 + 2;
    }

    private void shiftUp(int position) {
        while (position > ROOT_POSITION
                && compare(binaryHeap.get(parent(position)), binaryHeap.get(position)) > 0) {
            swap(position, parent(position));
            position = parent(position);
        }
    }

    private void shiftDown(int position) {
        while (position < size) {
            int elementPosition = position;
            if (left(position) < size
                    && compare(binaryHeap.get(elementPosition), binaryHeap.get(left(position))) > 0) {
                elementPosition = left(position);
            }
            if (right(position) < size
                    && compare(binaryHeap.get(elementPosition), binaryHeap.get(right(position))) > 0) {
                elementPosition = right(position);
            }
            if (elementPosition != position) {
                swap(position, elementPosition);
                position = elementPosition;
            } else {
                break;
            }
        }
    }

    private void swap(int position1, int position2) {
        E temp = binaryHeap.get(position1);
        binaryHeap.set(position1, binaryHeap.get(position2));
        binaryHeap.set(position2, temp);
    }

}
