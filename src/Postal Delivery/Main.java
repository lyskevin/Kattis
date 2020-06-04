import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int k = fio.nextInt();
        Address[] addresses = new Address[n];
        for (int i = 0; i < n; i++) {
            addresses[i] = new Address(fio.nextInt(), fio.nextInt());
        }
        Arrays.sort(addresses);
        Deque<Address> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.add(addresses[i]);
        }
        long distance = 0l;
        // Greedily pick addresses with negative locations (lowest first)
        while (!deque.isEmpty() && deque.peek().location < 0) {
            int letters = k;
            distance += Math.abs(deque.peek().location) * 2;
            // Deliver letters on the way back if possible
            while (!deque.isEmpty() && deque.peek().location < 0 && letters > 0) {
                int delivered = Math.min(letters, deque.peek().letters);
                letters -= delivered;
                deque.peek().letters -= delivered;
                if (deque.peek().letters == 0) {
                    deque.poll();
                }
            }
        }
        // Greedily pick addresses with positive locations (highest first)
        while (!deque.isEmpty()) {
            int letters = k;
            distance += deque.peekLast().location * 2;
            // Deliver letters on the way back if possible
            while (!deque.isEmpty() && letters > 0) {
                int delivered = Math.min(letters, deque.peekLast().letters);
                letters -= delivered;
                deque.peekLast().letters -= delivered;
                if (deque.peekLast().letters == 0) {
                    deque.pollLast();
                }
            }
        }
        fio.println(distance);
        fio.close();
    }
}

class Address implements Comparable<Address> {

    int location;
    int letters;

    Address(int location, int letters) {
        this.location = location;
        this.letters = letters;
    }

    @Override
    public int compareTo(Address other) {
        return this.location - other.location;
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

