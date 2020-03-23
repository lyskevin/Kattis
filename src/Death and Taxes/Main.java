import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int numberOfShares = 0;
        double averageCost = 0.0;
        double profit = 0.0;
        while (true) {
            try {
                String event = fio.next();
                if (event.equals("buy")) {
                    int x = fio.nextInt();
                    double y = fio.nextDouble();
                    averageCost = (numberOfShares * averageCost + x * y) / (numberOfShares + x);
                    numberOfShares += x;
                } else if (event.equals("sell")) {
                    int x = fio.nextInt();
                    double y = fio.nextDouble();
                    numberOfShares -= x;
                } else if (event.equals("split")) {
                    int x = fio.nextInt();
                    numberOfShares *= x;
                    averageCost /= x;
                } else if (event.equals("merge")) {
                    int x = fio.nextInt();
                    averageCost *= x;
                    numberOfShares /= x;
                } else {
                    double y = fio.nextDouble();
                    profit = numberOfShares * (y - averageCost * 0.3); 
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.println(profit);
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

