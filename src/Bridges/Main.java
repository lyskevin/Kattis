import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final int INF = 1000000000;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        int m = fio.nextInt();

        ArrayList<ArrayList<Tuple>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = fio.nextInt() - 1;
            int b = fio.nextInt() - 1;
            int c = fio.nextInt();
            adjList.get(a).add(new Tuple(b, c));
            adjList.get(b).add(new Tuple(a, c));
        }

        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = INF;
        }
        distances[0] = 0;

        Deque<Tuple> deque = new ArrayDeque<>();
        deque.offer(new Tuple(0, 0));
        
        while (!deque.isEmpty()) {
            Tuple t = deque.poll();

            for (Tuple next : adjList.get(t.a)) {
                if (next.b == 0) {
                    if (distances[next.a] > t.b) {
                        distances[next.a] = t.b;
                        deque.offerFirst(new Tuple(next.a, t.b));
                    }
                } else {
                    if (distances[next.a] > t.b + 1) {
                        distances[next.a] = t.b + 1;
                        deque.offer(new Tuple(next.a, t.b + 1));
                    }
                }
            }
        }

        fio.println(distances[n - 1]);
        fio.close();
    }
}

class Tuple {
    int a;
    int b;

    Tuple(int a, int b) {
        this.a = a;
        this.b = b;
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

