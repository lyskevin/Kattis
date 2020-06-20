import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            try {
                // Interval to cover
                long A = convertToLong(fio.nextDouble());
                long B = convertToLong(fio.nextDouble());
                int n = fio.nextInt();
                PriorityQueue<Interval> pq = new PriorityQueue<>();
                for (int i = 0; i < n; i++) {
                    pq.offer(new Interval(convertToLong(fio.nextDouble()),
                                convertToLong(fio.nextDouble()), i));
                }
                boolean isCovered = false;
                HashSet<Interval> usedIntervals = new HashSet<>();

                if (A == B) { // Same start and end point
                    while (!pq.isEmpty() && !isCovered) {
                        Interval interval = pq.poll();
                        if (interval.start <= A && interval.end >= B) {
                            usedIntervals.add(interval);
                            isCovered = true;
                        }
                    }
                } else {

                // Iterate over all numeric intervals
                long currentEnd = A;
                while (!isCovered && !pq.isEmpty()) {

                    // Discard all numeric intervals which end before the current end
                    while (!pq.isEmpty() && pq.peek().end < currentEnd) {
                        pq.poll();
                    }

                    // Greedily find the next numeric interval to use
                    Interval toUse = null;
                    long maxEnd = currentEnd;
                    while (!pq.isEmpty() && pq.peek().start <= currentEnd) {
                        Interval nextInterval = pq.poll();
                        if (nextInterval.end > maxEnd) {
                            maxEnd = nextInterval.end;
                            toUse = nextInterval;
                        }
                    }

                    // Check whether a suitable numeric interval has been found
                    if (toUse != null) {
                        usedIntervals.add(toUse);
                        currentEnd = maxEnd;
                        if (currentEnd >= B) {
                            isCovered = true; // [A, B] fully covered
                        }
                    } else {
                        break; // Gap between [A, B] which cannot be covered
                    }
                }
                }

                // Format and print output
                if (isCovered) {
                    fio.println(usedIntervals.size());
                    boolean isFirst = true;
                    for (Interval interval : usedIntervals) {
                        if (isFirst) {
                            isFirst = false;
                        } else {
                            fio.print(" ");
                        }
                        fio.print(interval.index);
                    }
                    fio.println();
                } else {
                    fio.println("impossible");
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
    }

    private static long convertToLong(double d) {
        return Math.round(d * 1000000l);
    }

}

class Interval implements Comparable<Interval> {

    long start;
    long end;
    int index;

    Interval(long start, long end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
        public int compareTo(Interval other) {
            int compareStarts = Long.compare(this.start, other.start);
            if (compareStarts != 0) {
                return compareStarts; // Sort by increasing start times
            } else {
                return Long.compare(other.end, this.end); // Then by decreasing end times
            }
        }

    @Override
        public boolean equals(Object other) {
            return this.index == ((Interval) other).index; // Index is unique
        }

    @Override
        public int hashCode() {
            return Objects.hash(start, end, index);
        }

}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
        br = new BufferedReader(new
                InputStreamReader(System.in));
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}

