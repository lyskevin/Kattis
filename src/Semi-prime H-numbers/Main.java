import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int[] numbers = new int[1000002];
        for (int i = 5; i <= 997; i += 4) {
            for (int j = i; i * j <= 1000001; j+= 4) {
                if (numbers[i] == 0 && numbers[j] == 0) {
                    numbers[i * j] = 1;
                } else {
                    numbers[i * j] = 2;
                }
            }
        }
        int[] rangeSum = new int[1000002];
        int count = 0;
        for (int i = 1; i <= 1000002; i += 4) {
            if (numbers[i] == 1) {
                count++;
            }
            rangeSum[i] = count;
        }
        int n = fio.nextInt();
        while (n > 0) {
            fio.println(n + " " + rangeSum[n]);
            n = fio.nextInt();
        }
        fio.close();
    }
}

// prime and prime -> semi prime
// at least one not prime -> composite

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

