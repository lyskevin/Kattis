import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        while (n > 0) {
            int[] sales = new int[1440];
            for (int i = 0; i < 1440; i++) {
                sales[i] = -8;
            }
            for (int i = 0; i < n; i++) {
                int time = fio.nextInt();
                // Typecasting to int without rounding will result in Wrong Answer verdict
                int profit = (int) Math.round(fio.nextDouble() * 100);
                sales[time] += profit;
            }
            int maxProfit = 0;
            int currentProfit = 0;
            int start = 0;
            TreeSet<Period> periods = new TreeSet<>();
            for (int i = 0; i < 1440; i++) {
                currentProfit += sales[i];
                if (currentProfit > maxProfit) { // Most profit seen so far
                    maxProfit = currentProfit;
                    periods = new TreeSet<>();
                    periods.add(new Period(start, i));
                } else if (currentProfit == maxProfit) { // Period with max profit
                    periods.add(new Period(start, i));
                }
                if (currentProfit <= 0) { // Reset window
                    currentProfit = 0;
                    start = i + 1;
                }
            }
            if (maxProfit <= 0) {
                fio.println("no profit");
            } else {
                Period period = periods.first();
                fio.println(String.format("%.2f %d %d", (0.01 * maxProfit),
                        period.start, period.end));
            }
            n = fio.nextInt();
        }
        fio.close();
    }
}

class Period implements Comparable<Period> {

    int start;
    int end;

    Period(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Period other) {
        return this.end - this.start == other.end - other.start ?
                this.start - other.start :
                (this.end - this.start) - (other.end - other.start);
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

