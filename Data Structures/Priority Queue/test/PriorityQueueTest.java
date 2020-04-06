import static org.junit.Assert.assertEquals;

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
        assertEquals(new ClassCastException(), pq.offer(new Object()));
    }

    @Test
    public void offer_null_throwsNullPointerException() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertEquals(new NullPointerException(PriorityQueue.OFFER_NULL_MESSAGE), pq.offer(null));
    }

    @Test
    public void peek_nonEmptyPriorityQueue_returnsHeadElement() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(2);
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

}
