import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        int m = fio.nextInt();

        PriorityQueue<Long> weights = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            weights.offer(fio.nextLong());
        }

        PriorityQueue<Tuple> offers = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            offers.offer(new Tuple(fio.nextInt(), fio.nextLong()));
        }

        long totalPrice = 0l;
        while (!weights.isEmpty() && !offers.isEmpty()) {
            long weight = weights.poll();
            Tuple offer = offers.poll();
            totalPrice += weight * offer.price;
            if (offer.quantity > 1) {
                offers.offer(new Tuple(offer.quantity - 1, offer.price));
            }
        }

        fio.println(totalPrice);
        fio.close();
    }
}

class Tuple implements Comparable<Tuple> {
    int quantity;
    long price;

    Tuple(int quantity, long price) {
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public int compareTo(Tuple other) {
        return Long.compare(other.price, this.price);
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

