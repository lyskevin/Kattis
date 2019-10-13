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
        int n = fio.nextInt() - 1;
        int[] paperAmounts = new int[n];
        for (int i = 0; i < n; i++) {
            paperAmounts[i] = fio.nextInt();
        }
        
        double tapeRequired = tapeRequired(paperAmounts, 1073741824, 536870912, 0, 0.0);
        if (tapeRequired > 0.0) {
            fio.println(tapeRequired);
        } else {
            fio.println("impossible");
        }
        fio.close();
    }
    
    private static double tapeRequired(int[] paperAmounts, int remaining, int currentValue,
            int index, double tapeRequired) {
        if (remaining == 0) {
            return tapeRequired;
        } else if (index >= paperAmounts.length) {
            return -1.0;
        } else {
            int amountOfPaperUsed = Math.min(remaining / currentValue, paperAmounts[index]);
            double currentTapeRequired = 0.0;
            if (index % 2 == 0) {
                currentTapeRequired = (remaining / currentValue) / 2
                        * Math.pow(2, (-3.0 - 4 * (index / 2)) / 4);
            } else {
                currentTapeRequired = (remaining / currentValue) / 2
                        * Math.pow(2, (-5.0 - 4 * (index / 2)) / 4);
            }
            remaining -= currentValue * amountOfPaperUsed;
            return tapeRequired(paperAmounts, remaining, currentValue / 2, index + 1,
                    tapeRequired + currentTapeRequired);
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

