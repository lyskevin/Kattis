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
        ArrayList<HashSet<Integer>> notesToInstruments = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            notesToInstruments.add(new HashSet<>());
        }

        // Map each note to all of the instruments that can play it
        for (int i = 0; i < n; i++) {
            int k = fio.nextInt();
            for (int j = 0; j < k; j++) {
                notesToInstruments.get(fio.nextInt()).add(i);
            }
        }

        // Read tune
        int[] tune = new int[m];
        for (int i = 0; i < m; i++) {
            tune[i] = fio.nextInt();
        }
        int min = 0;
        int index = 0;

        // Go through tune
        while (index < m) {
            int max = 0;
            for (Integer instrument : notesToInstruments.get(tune[index])) {
                int count = 0;
                while (index + count < m
                        && notesToInstruments.get(tune[index + count]).contains(instrument)) {
                    count++;
                }
                // Greedily pick the instrument to play
                // (the one that can play most notes from this point onwards)
                max = Math.max(max, count); 
            }
            index += max;
            min++;
        }

        // Number of switches = Number of instruments used - 1
        fio.println(min - 1);
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

