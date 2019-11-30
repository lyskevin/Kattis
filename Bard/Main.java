import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int e = fio.nextInt();
        HashSet[] songs = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) {
            songs[i] = new HashSet<>();
        }
        int songCounter = 0;
        for (int i = 0; i < e; i++) {
            int k = fio.nextInt();
            boolean[] villagers = new boolean[n + 1];
            for (int j = 0; j < k; j++) {
                villagers[fio.nextInt()] = true;
            }
            if (villagers[1]) {
                songCounter++;
                for (int j = 1; j <= n; j++) {
                    if (villagers[j]) {
                        songs[j].add(songCounter);
                    }
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    if (villagers[j]) {
                        for (int m = 1; m <= n; m++) {
                            if (villagers[m] && m != j) {
                                songs[m].addAll(songs[j]);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (songs[i].size() == songCounter) {
                fio.println(i);
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

