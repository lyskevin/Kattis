import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int p = fio.nextInt();
        int m = fio.nextInt();
        String[] players = new String[m];
        HashMap<String, Integer> scores = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = fio.next();
            players[i] = name;
            scores.put(name, 0);
        }
        for (int i = 0; i < m; i++) {
            String name = fio.next();
            int score = fio.nextInt();
            scores.put(name, scores.get(name) + score);
        }
        int numberOfWinners = 0;
        for (int i = 0; i < n; i++) {
            if (scores.get(players[i]) >= p) {
                fio.println(players[i] + " wins!");
                numberOfWinners++;
            }
        }
        if (numberOfWinners == 0) {
            fio.println("No winner!");
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

