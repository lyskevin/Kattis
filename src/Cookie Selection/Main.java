import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        PriorityQueue<Integer> firstHalf = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> secondHalf = new PriorityQueue<>();
        String input = fio.next();
        while (!input.equals("")) {
            if (input.equals("#")) {
                fio.println(secondHalf.poll());
            } else {
                firstHalf.offer(Integer.parseInt(input));
            }
            if (!firstHalf.isEmpty() && !secondHalf.isEmpty()
                && firstHalf.peek() > secondHalf.peek()) {
                Integer first = firstHalf.poll();
                Integer second = secondHalf.poll();
                firstHalf.offer(second);
                secondHalf.offer(first);
            }
            if (firstHalf.size() > secondHalf.size()) {
                secondHalf.offer(firstHalf.poll());
            }
            input = fio.next();
        }
        fio.close();
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
            catch (NullPointerException e) {
                return "";
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

