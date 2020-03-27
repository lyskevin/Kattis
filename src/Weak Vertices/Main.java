import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int numberOfVertices = fio.nextInt();
        while (numberOfVertices > 0) {
            // Initialise adjacency matrix
            int[][] graph = new int[numberOfVertices][numberOfVertices];
            for (int i = 0; i < numberOfVertices; i++) {
                for (int j = 0; j < numberOfVertices; j++) {
                    graph[i][j] = fio.nextInt();
                }
            }
            boolean isFirstOutput = true;
            for (int i = 0; i < numberOfVertices; i++) {
                boolean isWeakVertex = true;
                for (int j = 0; j < numberOfVertices && isWeakVertex; j++) {
                    if (graph[i][j] == 1) {
                        for (int k = 0; k < numberOfVertices && isWeakVertex; k++) {
                            if (graph[j][k] == 1 && graph[i][k] == 1
                                && i != k && j != k) { // Not weak if triangle formed by 3 distinct vertices
                                isWeakVertex = false;
                            }
                        }
                    }
                }
                if (isWeakVertex) {
                    if (isFirstOutput) {
                        isFirstOutput = false;
                    } else {
                        fio.print(" ");
                    }
                    fio.print(i);
                }
            }
            fio.println();
            numberOfVertices = fio.nextInt();
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

