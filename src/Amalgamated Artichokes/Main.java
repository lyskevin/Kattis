import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int p = fio.nextInt();
        int a = fio.nextInt();
        int b = fio.nextInt();
        int c = fio.nextInt();
        int d = fio.nextInt();
        int n = fio.nextInt();
        double largestDecline = 0.0;
        double currentPrice = p * (Math.sin(a * 1 + b) + Math.cos(c * 1 + d) + 2);
        for (int i = 2; i <= n; i++) {
            double newPrice = p * (Math.sin(a * i + b) + Math.cos(c * i + d) + 2);
            if (currentPrice > newPrice) {
                largestDecline = Math.max(largestDecline, currentPrice - newPrice);
            } else {
                currentPrice = newPrice;
            } 
        }
        fio.println(largestDecline);
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

