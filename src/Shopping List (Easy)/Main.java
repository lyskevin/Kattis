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
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < m; i++) {
            result.add(fio.next());
        }

        for (int i = 0; i < n - 1; i++) {
            HashSet<String> next = new HashSet<>();
            HashSet<String> intersection = new HashSet<>();

            for (int j = 0; j < m; j++) {
                next.add(fio.next());
            }

            for (String item : result) {
                if (next.contains(item)) {
                    intersection.add(item);
                }
            }

            result = intersection;
        }

        ArrayList<String> sorted = new ArrayList<>(result);
        Collections.sort(sorted);

        fio.println(sorted.size());
        for (String item : sorted) {
            fio.println(item);
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

