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
            long[] primes = new long[n];
            for (int i = 0; i < n; i++) {
                primes[i] = fio.nextLong();
            }
            long x = fio.nextLong();
            long y = fio.nextLong();
            HashSet<Long> numbers = new HashSet<>();
            // Generate numbers using the specified prime factors
            generateNumbers(x, y, primes, numbers, 1, 0);
            if (numbers.size() == 0) {
                // No numbers can be generated
                fio.println("none");
            } else {
                // Sort and print numbers
                Long[] numbersArray = new Long[numbers.size()];
                numbersArray = numbers.toArray(numbersArray);
                Arrays.sort(numbersArray);
                for (int i = 0; i < numbersArray.length; i++) {
                    if (i > 0) {
                        fio.print(",");
                    }
                    fio.print(numbersArray[i]);
                }
                fio.println();
            }
            n = fio.nextInt();
        }
        fio.close();
    }

    private static void generateNumbers(long x, long y, long[] primes,
            HashSet<Long> numbers, long current, int index) {
        if (current > y) {
            return;
        } else {
            if (current >= x && current <= y) {
                numbers.add(current);
            }
            if (index >= primes.length) {
                return;
            }
            long primeFactor = primes[index];
            int limit = limit(y / current, primeFactor);
            for (int i = 1; i <= limit; i++) {
                // Use powers of the prime factor until current is just less than or equal to y
                generateNumbers(x, y, primes, numbers, current * pow(primeFactor, i), index + 1);
            }
            // Do not use prime factor
            generateNumbers(x, y, primes, numbers, current, index + 1);
        }
    }

    private static long pow(long multiplicand, int power) {
        long result = 1l;
        for (int i = 0; i < power; i++) {
            result *= multiplicand;
        }
        return result;
    }

    private static int limit(long limit, long primeFactor) {
        int count = 0;
        long result = 1l;
        while (result <= limit) {
            result*= primeFactor;
            count++;
        }
        return count - 1;
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

