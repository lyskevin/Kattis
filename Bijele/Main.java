import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int[] correctNumberOfPieces = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < 6; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(correctNumberOfPieces[i] - fr.nextInt());
        }
        System.out.println();
    }
}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
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

