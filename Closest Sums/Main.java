import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int caseNumber = 1;
        while (true) {
            try {
                int n = fio.nextInt();
                int[] numbers = new int[n];
                for (int i = 0; i < n; i++) {
                    numbers[i] = fio.nextInt();
                }
                Arrays.sort(numbers);
                TreeSet<Integer> pairings = new TreeSet<>();
                // Generate pairings
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        pairings.add(numbers[i] + numbers[j]);
                    }
                }
                fio.println("Case " + caseNumber + ":");
                int m = fio.nextInt();
                // Find closest numbers
                for (int i = 0; i < m; i++) {
                    int number = fio.nextInt();
                    Integer floor = pairings.floor(number);
                    Integer ceiling = pairings.ceiling(number);
                    int toPrint = 0;
                    if (floor == null) {
                        toPrint = ceiling.intValue();
                    } else if (ceiling == null) {
                        toPrint = floor.intValue();
                    } else {
                        if (number - floor.intValue() <= ceiling.intValue() - number) {
                            toPrint = floor.intValue();
                        } else {
                            toPrint = ceiling.intValue();
                        }
                    }
                    fio.println("Closest sum to " + number + " is " + toPrint + ".");
                }
                caseNumber++;
            } catch (NullPointerException e) {
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

