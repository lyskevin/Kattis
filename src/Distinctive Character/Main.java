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
        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean[] visited = new boolean[2000000];
        for (int i = 0; i < n; i++) {
            String s = fio.nextLine();
            int character = Integer.parseInt(s, 2);
            bfsQueue.add(character);
            visited[character] = true;
        }
        int result = 0;
        // Run BFS
        while (!bfsQueue.isEmpty()) {
            int character = bfsQueue.poll().intValue();
            result = character;
            for (int i = 0; i < k; i++) {
                // XOR with bitmask to flip i'th digit (from the right)
                int newCharacter = character ^ (1 << i);
                if (!visited[newCharacter]) {
                    visited[newCharacter] = true;
                    bfsQueue.add(Integer.valueOf(newCharacter));
                }
            }
        }
        String s = Integer.toBinaryString(result);
        for (int i = 0; i < k - s.length(); i++) {
            fio.print(0);
        }
        fio.println(s);
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

