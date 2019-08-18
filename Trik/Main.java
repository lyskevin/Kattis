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
        boolean[] hasBall = new boolean[3];
        hasBall[0] = true;
        String input = fr.next();
        for (int i = 0, n = input.length(); i < n; i++) {
            char move = input.charAt(i);
            int start, end;
            if (move == 'A') {
                start = 0;
                end = 1;
            } else if (move == 'B') {
                start = 1;
                end = 2;
            } else {
                start = 2;
                end = 0;
            }
            boolean temp = hasBall[start];
            hasBall[start] = hasBall[end];
            hasBall[end] = temp;
        }
        if (hasBall[0]) {
            System.out.println(1);
        } else if (hasBall[1]) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
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

