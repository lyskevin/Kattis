import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            try {
                String[] input = fio.nextLine().split(" ");
                int[] numbers = new int[input.length];
                for (int i = 0; i < input.length; i++) {
                    numbers[i] = Integer.parseInt(input[i]);
                }
                Arrays.sort(numbers);
                boolean[] marks = new boolean[2001];
                boolean isRuler = true;
                int max = 0;
                // Count marks
                for (int i = 0; i < input.length - 1 && isRuler; i++) {
                    for (int j = i + 1; j < input.length && isRuler; j++) {
                        int mark = numbers[j] - numbers[i];
                        max = Math.max(max, mark);
                        if (!marks[mark]) {
                            marks[mark] = true;
                        } else {
                            isRuler = false;
                        }
                    }
                }
                // Check for relevant properties
                if (isRuler) {
                    boolean isPerfect = true;
                    for (int i = 1; i <= max; i++) {
                        if (!marks[i]) {
                            if (isPerfect) {
                                fio.print("missing " + i);
                                isPerfect = false;
                            } else {
                                fio.print(" " + i);
                            }
                        }
                    }
                    if (isPerfect) {
                        fio.println("perfect");
                    } else {
                        fio.println();
                    }
                } else {
                    fio.println("not a ruler");
                }
            } catch (NullPointerException npe) {
                break;
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

