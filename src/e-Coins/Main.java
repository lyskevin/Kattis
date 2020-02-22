import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            int m = fio.nextInt();
            int s = fio.nextInt();
            Vertex[] coins = new Vertex[m];
            for (int j = 0; j < m; j++) {
                coins[j] = new Vertex(fio.nextInt(), fio.nextInt(), 0);
            }
            Queue<Vertex> bfsQueue = new LinkedList<>();
            bfsQueue.add(new Vertex(0, 0, 0));
            boolean[][] visitedValues = new boolean[s + 1][s + 1];
            visitedValues[0][0] = true;
            boolean solutionFound = false;
            int numberOfCoins = 0;
            // Standard BFS
            while (!bfsQueue.isEmpty() && !solutionFound) {
                Vertex u = bfsQueue.poll();
                for (int j = 0; j < m; j++) {
                    Vertex v = new Vertex(u.conventional + coins[j].conventional,
                            u.it + coins[j].it, u.distance + 1);
                    if (v.getValue() == s) {
                        solutionFound = true;
                        numberOfCoins = v.distance;
                        break;
                    } else if (v.conventional <= s && v.it <= s && !visitedValues[v.conventional][v.it]) {
                        bfsQueue.add(v);
                        visitedValues[v.conventional][v.it] = true;
                    }
                }
            }
            if (solutionFound) {
                fio.println(numberOfCoins);
            } else {
                fio.println("not possible");
            }
        }
        fio.close();
    }
}

class Vertex {

    int conventional;
    int it;
    int distance;

    Vertex(int conventional, int it, int distance) {
        this.conventional = conventional;
        this.it = it;
        this.distance = distance;
    }

    double getValue() {
        return Math.sqrt(conventional * conventional + it * it);
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

