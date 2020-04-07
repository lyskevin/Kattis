import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Comparator;

import org.junit.Test;

/**
 * @author lyskevin
 * Priority queue test cases.
 */
public class PriorityQueueTest {

    @Test
    public void isEmpty_nonEmptyPriorityQueue_returnsTrue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertEquals(true, pq.isEmpty());
    }

    @Test
    public void isEmpty_nonEmptyPriorityQueue_returnsFalse() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        assertEquals(false, pq.isEmpty());
    }

    @Test
    public void offer_validElement_returnsTrue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertEquals(true, pq.offer(1));
    }

    @Test
    public void offer_elementWithNoOrdering_throwsClassCastException() {
        PriorityQueue<Object> pq = new PriorityQueue<>();
        assertThrows(ClassCastException.class, () -> pq.offer(new Object()));
    }

    @Test
    public void offer_null_throwsNullPointerException() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertThrows(NullPointerException.class, () -> pq.offer(null));
    }

    @Test
    public void peek_nonEmptyPriorityQueue_returnsHeadElement() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(2);
        pq.offer(1);
        assertEquals(Integer.valueOf(1), pq.peek());
    }

    @Test
    public void peek_emptyPriorityQueue_returnsNull() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertEquals(null, pq.peek());
    }

    @Test
    public void poll_nonEmptyPriorityQueue_returnsHeadElement() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(2);
        assertEquals(Integer.valueOf(1), pq.poll());
        assertEquals(1, pq.size());
        assertEquals(Integer.valueOf(2), pq.peek());
    }

    @Test
    public void poll_emptyPriorityQueue_returnsNull() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertEquals(null, pq.poll());
    }

    @Test
    public void poll_sequenceOfElements_returnsCorrectOrdering() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(1);
        pq.offer(2);
        assertEquals(Integer.valueOf(1), pq.poll());
        pq.offer(0);
        pq.offer(4);
        assertEquals(Integer.valueOf(0), pq.poll());
    }

    @Test
    public void poll_customComparator_returnsCorrectOrdering() {
        Comparator<Integer> customComparator = (x, y) -> y - x;
        PriorityQueue<Integer> pq = new PriorityQueue<>(customComparator);
        pq.offer(3);
        pq.offer(1);
        pq.offer(2);
        assertEquals(Integer.valueOf(3), pq.poll());
        pq.offer(0);
        pq.offer(4);
        assertEquals(Integer.valueOf(4), pq.poll());
    }

}
