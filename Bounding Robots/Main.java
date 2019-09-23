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
        int w = fio.nextInt();
        int l = fio.nextInt();
        while (w > 0 || l > 0) {
            w -= 1;
            l -= 1;
            int actualX = 0;
            int actualY = 0;
            int simulatedX = 0;
            int simulatedY = 0;
            int n = fio.nextInt();
            for (int i = 0; i < n; i++) {
                String direction = fio.next();
                int distance = fio.nextInt();
                if (direction.equals("u")) {
                    simulatedY += distance;
                    actualY = Math.min(l, actualY + distance);
                } else if (direction.equals("d")) {
                    simulatedY -= distance;
                    actualY = Math.max(0, actualY - distance);
                } else if (direction.equals("r")) {
                    simulatedX += distance;
                    actualX = Math.min(w, actualX + distance);
                } else {
                    simulatedX -= distance;
                    actualX = Math.max(0, actualX - distance);
                }
            }
            fio.println("Robot thinks " + simulatedX + " " + simulatedY);
            fio.println("Actually at " + actualX + " " + actualY);
            w = fio.nextInt();
            l = fio.nextInt();
            if (w > 0 || l > 0) {
                fio.println();
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

