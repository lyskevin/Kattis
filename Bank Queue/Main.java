import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int t = fio.nextInt();
        // Sort people according to time; largest time value in front
        Comparator<Person> timeComparator = (p1, p2) -> p2.time - p1.time;
        PriorityQueue<Person> timePQ = new PriorityQueue<>(timeComparator);
        for (int i = 0; i < n; i++) {
            timePQ.offer(new Person(fio.nextInt(), fio.nextInt()));
        }
        // Sort people according to cash
        Comparator<Person> cashComparator = (p1, p2) -> p2.cash - p1.cash;
        PriorityQueue<Person> cashPQ = new PriorityQueue<>(cashComparator);
        // Start from the back (t - 1) 
        int time = t - 1;
        int total = 0;
        while (time >= 0) {
            // Put all eligible people into the cash PQ
            while (!timePQ.isEmpty() && timePQ.peek().time == time) {
                cashPQ.offer(timePQ.poll());
            }
            // Serve person with highest cash value (greedy algorithm)
            if (!cashPQ.isEmpty()) {
                total += cashPQ.poll().cash;
            }
            time--;
        }
        fio.println(total);
        fio.close();
    }
}

class Person {

    int cash;
    int time;

    Person(int cash, int time) {
        this.cash = cash;
        this.time = time;
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

