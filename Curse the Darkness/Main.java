import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.lang.StringBuilder;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        int numberOfTestCases = fastIO.nextInt();
        if (numberOfTestCases == 0) {
            return;
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numberOfTestCases; i++) {
            double bookX = fastIO.nextDouble();
            double bookY = fastIO.nextDouble();
            int numberOfCandles = fastIO.nextInt();
            boolean candleFound = false;
            for (int j = 0; j < numberOfCandles; j++) {
                double candleX = fastIO.nextDouble();
                double candleY = fastIO.nextDouble();
                if (withinRadius(bookX, bookY, candleX, candleY)) {
                    candleFound = true;
                }
            }
            if (candleFound) {
                output.append("light a candle\n");
            } else {
                output.append("curse the darkness\n");
            }
        }
        System.out.print(output); 
    }

    private static boolean withinRadius(double x1, double y1, double x2, double y2) {
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) <= 64.0;
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

