import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int l = fio.nextInt();
        int d = fio.nextInt();
        int n = fio.nextInt();
        ArrayList<Integer> birds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            birds.add(fio.nextInt());
        }
        Collections.sort(birds);
        int start = 6;
        int end = l - 6;
        if (n == 0) {
            fio.println(((end - start) / d) + 1);
        } else {
            int current = birds.get(0);
            int count = 0;
            int difference = current - start;
            count += difference / d;
            for (int i = 1; i < birds.size(); i++) {
                int next = birds.get(i);
                difference = next - current;
                count += (difference / d) - 1;
                current = next;
            }
            difference = end - current;
            count += (difference / d);
            fio.println(count);
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

