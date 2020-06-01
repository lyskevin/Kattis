import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int s = fio.nextInt();
        int c = fio.nextInt();
        int k = fio.nextInt();
        int[] socks = new int[s];
        for (int i = 0; i < s; i++) {
            socks[i] = fio.nextInt();
        }
        Arrays.sort(socks);
        int currentCount = 1;
        int lowestSock = socks[0];
        int numberOfMachines = 1;
        for (int i = 1; i < s; i++) {
            if (Math.abs(socks[i] - lowestSock) > k || currentCount == c) { // Buy additional machine
                currentCount = 1;
                lowestSock = socks[i];
                numberOfMachines++;
            } else {
                currentCount++;
            }
        }
        fio.println(numberOfMachines);
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

