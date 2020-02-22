import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int a = fio.nextInt();
        int b = fio.nextInt();
        int c = fio.nextInt();
        int start1 = fio.nextInt();
        int end1 = fio.nextInt();
        int min = start1;
        int max = end1;
        int start2 = fio.nextInt();
        int end2 = fio.nextInt();
        min = Math.min(min, start2);
        max = Math.max(max, end2);
        int start3 = fio.nextInt();
        int end3 = fio.nextInt();
        min = Math.min(min, start3);
        max = Math.max(max, end3);
        int total = 0;
        for (int i = min; i < max; i++) {
            int count = 0;
            if (start1 <= i && end1 > i) {
                count++;
            }
            if (start2 <= i && end2 > i) {
                count++;
            }
            if (start3 <= i && end3 > i) {
                count++;
            }
            if (count == 1) {
                total += a;
            } else if (count == 2) {
                total += 2 * b;
            } else if (count == 3) {
                total += 3 * c;
            }
        }
        fio.println(total);
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

