import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int price = fio.nextInt();
            int n = fio.nextInt();
            int[] denominations = new int[n];
            // Memoize number of coins for computed amounts
            // 20000 as max amount since max denomination is 10000
            int[] changeTable = new int[20001];
            for (int j = 0; j < 20001; j++) {
                // Initialize number of coins to a very large number
                changeTable[j] = 1000000;
            }
            for (int j = 0; j < n; j++) {
                denominations[j] = fio.nextInt();
            }
            boolean[] usedDenominations = new boolean[n];
            countChange(price, denominations, usedDenominations, changeTable, 0, 0);
            int index = price;
            // Find smallest possible price
            while (changeTable[index] == 1000000) {
                index++;
            }
            fio.println(index + " " + changeTable[index]);
        }
        fio.close();
    }

    private static void countChange(int price, int[] denominations, boolean[] usedDenominations,
            int[] changeTable, int numberOfCoins, int currentPrice) {
        // More optimal solution found prior to this
        if (changeTable[currentPrice] <= numberOfCoins) {
            return;
        } else {
            // Better solution found; minimize number of coins
            changeTable[currentPrice] = numberOfCoins;
            if (currentPrice >= price) {
                return;
            } else {
                for (int i = 0; i < denominations.length; i++) {
                    if (!usedDenominations[i]) {
                        // Use the current denomination if it has not been used before
                        // The true/false statements work since the method calls are recursive in nature
                        usedDenominations[i] = true;
                        countChange(price, denominations, usedDenominations, changeTable,
                                numberOfCoins + 1, currentPrice + denominations[i]);
                        usedDenominations[i] = false;
                    }
                }
            }
        }
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

