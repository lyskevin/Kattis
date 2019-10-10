import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        Circle[] circles = new Circle[n];
        for (int i = 0; i < n; i++) {
            circles[i] = new Circle(fio.nextLine());
        }
        Arrays.sort(circles);
        for (int i = 0; i < n; i++) {
            fio.println(circles[i]);
        }
        fio.close();
    }
}

class Circle implements Comparable<Circle> {
    
    int diameter;
    String colour;

    Circle(String input) {
        String[] arguments = input.split(" ");
        if (arguments[0].charAt(0) - '0' < 10) {
            diameter = Integer.parseInt(arguments[0]);
            colour = arguments[1];
        } else {
            diameter = Integer.parseInt(arguments[1]) * 2;
            colour = arguments[0];
        }
    }

    public int compareTo(Circle other) {
        return this.diameter - other.diameter;
    }

    public String toString() {
        return colour;
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

