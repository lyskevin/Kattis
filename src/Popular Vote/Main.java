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
            int n = fio.nextInt();
            int[] votes = new int[n];
            int totalVotes = 0;
            for (int j = 0; j < n; j++) {
                votes[j] = fio.nextInt();
                totalVotes += votes[j];
            }
            boolean hasWinner = true;
            // Calculate percentage of votes for 1st candidate
            double maxPercentage = votes[0] * 1.0 / totalVotes;
            int winner = 1;
            // Calculate all subsequent percentages
            for (int j = 1; j < n; j++) {
                double percentage = votes[j] * 1.0 / totalVotes;
                if (percentage > maxPercentage) {
                    maxPercentage = percentage;
                    winner = j + 1;
                    hasWinner = true;
                } else if (percentage == maxPercentage) {
                    hasWinner = false;
                }
            }
            if (!hasWinner) {
                fio.println("no winner");
            } else if (maxPercentage <= 0.50) {
                fio.println("minority winner " + winner);
            } else {
                fio.println("majority winner " + winner);
            }
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

