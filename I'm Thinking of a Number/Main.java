import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        while (n > 0) {
            int min = 1;
            int max = 1000000;
            ArrayList<Integer> divisors = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String rule = fio.next();
                fio.next();
                int number = fio.nextInt();
                if (rule.equals("greater")) {
                    min = Math.max(min, number + 1);
                } else if (rule.equals("less")) {
                    max = Math.min(max, number - 1);
                } else {
                    divisors.add(number);
                }
            }
            boolean hasPriorSolution = false;
            // Finite number of solutions if max is bounded
            if (max < 1000000) {
                for (int i = min; i <= max; i++) {
                    boolean isDivisible = true;
                    // Perform divisibility tests
                    for (Integer divisor : divisors) {
                        if (i % divisor != 0) {
                            isDivisible = false;
                            break;
                        }
                    }
                    if (isDivisible) {
                        if (hasPriorSolution) {
                            fio.print(" ");
                        }
                        hasPriorSolution = true;
                        fio.print(i);
                    }
                }
            }
            if (hasPriorSolution) {
                fio.println();
            } else if (max == 1000000) {
                fio.println("infinite");
            } else {
                fio.println("none");
            }
            n = fio.nextInt();
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

