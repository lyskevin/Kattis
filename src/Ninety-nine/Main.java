import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = 1;
        System.out.println(number);

        while (number < 99) {
            int response = sc.nextInt();
            // We win once number is a multiple of 3
            if (number % 3 == 0) {
                number += 3;
            } else {
                // If 1 or 2 is always played then adding twice the difference will
                // always end up resulting in a multiple of 3. This is almost guaranteed
                // if 1 or 2 is played with 50% probability
                number += 2 * (response - number);
            }
            System.out.println(number);
        }

        System.exit(0);
    }
}

// 1 --> 5 --> 8

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

