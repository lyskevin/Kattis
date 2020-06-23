import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static Sale[][] sales;
    private static int[][] memoTable;
    private static int n;
    private static int w;
    private static int salePrice = 0;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        n = fio.nextInt();
        w = fio.nextInt();
        sales = new Sale[w + 1][n];
        memoTable = new int[w + 1][n + 1];
        for (int i = 0; i < w + 1; i++) {
            int k = fio.nextInt();
            int[] prices = new int[k];
            for (int j = 0; j < k; j++) {
                prices[j] = fio.nextInt();
            }
            Sale[] weeklySales = new Sale[k];
            for (int j = 0; j < k; j++) {
                weeklySales[j] = new Sale(prices[j], fio.nextInt());
            }
            Arrays.sort(weeklySales); // Sort weekly prices in ascending order for convenience
            sales[i] = weeklySales;
        }
        fio.println(solve(0, n));
        fio.println(salePrice);
        fio.close();
    }

    private static int solve(int week, int remainingTickets) {

        if (week > w || remainingTickets == 0) { // Nothing left to process
            return 0;
        }

        if (memoTable[week][remainingTickets] > 0) { // State already memoized
            return memoTable[week][remainingTickets];
        }

        int max = 0;
        for (int i = 0; i < sales[week].length; i++) { // Try each ticket type
            int numberOfTicketsSold = Math.min(remainingTickets, sales[week][i].numberOfTickets);
            int newTotal = numberOfTicketsSold * sales[week][i].price
                    + solve(week + 1, remainingTickets - numberOfTicketsSold);
            if (newTotal > max) {
                max = newTotal;
                if (week == 0) {
                    salePrice = sales[0][i].price; // Record week w price if applicable
                }
            }
        }
        memoTable[week][remainingTickets] = max; // Memoize max revenue for this state
        return max;

    }

}

class Sale implements Comparable<Sale> {

    int price;
    int numberOfTickets;

    Sale(int price, int numberOfTickets) {
        this.price = price;
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public int compareTo(Sale other) {
        return this.price - other.price;
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

