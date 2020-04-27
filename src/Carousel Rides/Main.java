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
        while (n > 0 || m > 0) {
            boolean discountFound = false;
            double lowestPrice = Double.MAX_VALUE;
            int numberOfTickets = 0;
            int pricePerTicket = 0;
            for (int i = 0; i < n; i++) {
                int a = fio.nextInt();
                int b = fio.nextInt();
                if (a > 0 && a <= m) {
                    double currentPrice = 1.0 * b / a;
                    if (currentPrice < lowestPrice || (currentPrice == lowestPrice && a > numberOfTickets)) {
                        numberOfTickets = a;
                        pricePerTicket = b;
                        lowestPrice = currentPrice;
                        discountFound = true;
                    }
                }
            }
            if (discountFound) {
                fio.println("Buy " + numberOfTickets + " tickets for $" + pricePerTicket);
            } else {
                fio.println("No suitable tickets offered");
            }
            n = fio.nextInt();
            m = fio.nextInt();
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

