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
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = fio.nextInt();
        }
        switch (t) {
            case 1:
                fio.println(7);
                break;
            case 2:
                if (A[0] > A[1]) {
                    fio.println("Bigger");
                } else if (A[0] == A[1]) {
                    fio.println("Equal");
                } else {
                    fio.println("Smaller");
                }
                break;
            case 3:
                long a0 = A[0];
                long a1 = A[1];
                long a2 = A[2];
                fio.println(a0 + a1 + a2 - (Math.max(a0, Math.max(a1, a2))) - (Math.min(a0, Math.min(a1, a2))));
                break;
            case 4:
                long sum = 0l;
                for (int i = 0; i < n; i++) {
                    sum += A[i];
                }
                fio.println(sum);
                break;
            case 5:
                sum = 0l;
                for (int i = 0; i < n; i++) {
                    if (A[i] % 2 == 0) {
                        sum += A[i];
                    }
                }
                fio.println(sum);
                break;
            case 6:
                for (int i = 0; i < n; i++) {
                    fio.print((char) ('a' + A[i] % 26));
                }
                fio.println();
                break;
            default:
                boolean[] visited = new boolean[n];
                int i = 0;
                boolean isCyclic = false;
                for (; i < n - 1 && !isCyclic; i = A[i]) {
                    if (visited[i]) {
                        isCyclic = true;
                    } else {
                        visited[i] = true;
                    }
                }
                if (isCyclic) {
                    fio.println("Cyclic");
                } else if (i >= n) {
                    fio.println("Out");
                } else {
                    fio.println("Done");
                }
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

