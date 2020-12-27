import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int arrive = convert(fio.next());
        int leave = convert(fio.next());
        int approach = convert(fio.next());

        if (Math.abs(arrive - leave) == 2 && (arrive + 4 - approach) % 4 == 1) { // Going straight
            fio.println("Yes");
        } else if ((leave + 4 - arrive) % 4 == 1
                && (Math.abs(arrive - approach) == 2 || (arrive + 4 - approach) % 4 == 1)) { // Going right
            fio.println("Yes");
        } else {
            fio.println("No");
        }

        fio.close();
    }

    private static int convert(String direction) {
        switch (direction) {
            case "North":
                return 0;
            case "East":
                return 1;
            case "South":
                return 2;
            default:
                return 3;
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

