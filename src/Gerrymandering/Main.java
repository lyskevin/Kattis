import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int P = fio.nextInt();
        int D = fio.nextInt();
        Tuple[] votes = new Tuple[D + 1];

        for (int i = 0; i < P; i++) {
            int d = fio.nextInt();
            int a = fio.nextInt();
            int b = fio.nextInt();

            if (votes[d] == null) {
                votes[d] = new Tuple(0, 0);
            }

            votes[d].a += a;
            votes[d].b += b;
        }

        int totalA = 0;
        int totalB = 0;
        int V = 0;

        for (int i = 1; i <= D; i++) {
            int wA, wB;

            if (votes[i].a > votes[i].b) {
                wA = votes[i].a - ((votes[i].a + votes[i].b) / 2 + 1);
                wB = votes[i].b;
                fio.println("A " + wA + " " + wB);
            } else {
                wA = votes[i].a;
                wB = votes[i].b - ((votes[i].a + votes[i].b) / 2 + 1);
                fio.println("B " + wA + " " + wB);
            }

            totalA += wA;
            totalB += wB; 
            V += votes[i].a + votes[i].b;
        }

        fio.println(1.0 * Math.abs(totalA - totalB) / V);
        fio.close();
    }
}

class Tuple {
    int a;
    int b;

    Tuple(int a, int b) {
        this.a = a;
        this.b = b;
    }

    String winner() {
        return a > b ? "A" : "B";
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

