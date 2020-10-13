import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        
        double circumference = Math.PI * 60;
        int N = fio.nextInt();
        for (int i = 0; i < N; i++) {
            String s = fio.nextLine();
            double totalTime = 1.0;
            for (int j = 1; j < s.length(); j++) {
                int position1 = getPosition(s.charAt(j - 1));
                int position2 = getPosition(s.charAt(j));
                int difference = Math.abs(position1 - position2);
                totalTime += ((Math.min(difference, 28 - difference) / 28.0) * circumference / 15.0) + 1.0;
            }
            fio.println(totalTime);
        }

        fio.close();
    }

    private static int getPosition(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        } else if (c == ' ') {
            return 26;
        } else {
            return 27;
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

