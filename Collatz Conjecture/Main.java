import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static HashMap<Long, Integer> aSteps;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        long a = fio.nextLong();
        long b = fio.nextLong();
        while (!(a == 0 && b == 0)) {
            generateASteps(a);
            Tuple tuple = generateBTuple(b);
            fio.println(String.format("%d needs %d steps, %d needs %d steps, they meet at %d",
                    a, aSteps.get(tuple.number), b, tuple.numberOfSteps, tuple.number));
            a = fio.nextInt();
            b = fio.nextInt();
        }
        fio.close();
    }

    private static void generateASteps(long a) {
        aSteps = new HashMap<>();
        aSteps.put(a, 0);
        int numberOfSteps = 0;
        while (a > 1) {
            numberOfSteps++;
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a = 3 * a + 1;
            }
            if (!aSteps.containsKey(a)) {
                aSteps.put(a, numberOfSteps);
            }
        }
    }

    private static Tuple generateBTuple(long b) {
        if (aSteps.containsKey(b)) {
            return new Tuple(b, 0);
        } else {
            int numberOfSteps = 0;
            while (b > 1) {
                numberOfSteps++;
                if (b % 2 == 0) {
                    b /= 2;
                } else {
                    b = 3 * b + 1;
                }
                if (aSteps.containsKey(b)) {
                    return new Tuple(b, numberOfSteps);
                }
            }
            return new Tuple(b, numberOfSteps);
        }
    }

}

class Tuple {

    long number;
    int numberOfSteps;

    Tuple(long number, int numberOfSteps) {
        this.number = number;
        this.numberOfSteps = numberOfSteps;
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

