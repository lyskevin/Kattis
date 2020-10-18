import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static ArrayList<Integer> primes = new ArrayList<>();
    private static int[] numberToIndexMap = new int[10000001]; // Number -> Index in array
    private static int[][] factorisedNumbers = new int[1000000][30]; // Index -> Prime factors of array[index]
    private static int[] left = new int[1000001]; // Minimum bounds for each prime factor
    private static int[] right = new int[1000001]; // Maximum bounds for each prime factor
    private static int[] result; // Answer to print
    private static int MAX = 1000000000;
    private static int MIN = -1;

    public static void main(String[] args) {

        // Pre-compute prime factors up to sqrt(100000000)
        primes.add(2);
        for (int i = 3; i <= ((int) Math.sqrt(100000000)); i += 2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        FastIO fio = new FastIO();

        int n = fio.nextInt();
        for (int i = 0; i < 1000001; i++) {
            left[i] = MIN;
            right[i] = MAX;
        }

        for (int i = 0; i < n; i++) {
            factorise(fio.nextInt(), i);
        }

        result = new int[n];
        boolean isPossible = generateTree(0, n - 1, 0);

        if (isPossible) {
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    fio.print(" ");
                }
                fio.print(result[i]);
            }
            fio.println();
        } else {
            fio.println("impossible");
        }

        fio.close();
    }

    private static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        } else if (n < 2 || n % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= (int) Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private static void factorise(int number, int index) {

        // Already factorised this number before
        if (numberToIndexMap[number] > 0) {
            factorisedNumbers[index] = factorisedNumbers[numberToIndexMap[number]];
            return;
        }

        // Standard prime factorisation algorithm
        //numberToIndexMap.put(number, index);
        int primesIndex = 0;
        int currentIndex = 0;
        int primeFactor = primes.get(primesIndex);
        while (primeFactor * primeFactor <= number) {
            if (number % primeFactor == 0) {
                factorisedNumbers[index][currentIndex] = primeFactor;
                currentIndex++;
                left[primeFactor] = Math.max(index, left[primeFactor]);
                right[primeFactor] = Math.min(index, right[primeFactor]);
            }
            while (number % primeFactor == 0) {
                number /= primeFactor;
            }
            primesIndex++;
            if (primesIndex == primes.size()) {
                break;
            }
            primeFactor = primes.get(primesIndex);
        }

        if (number > 1) {
            factorisedNumbers[index][currentIndex] = number;
            currentIndex++;
            primeFactor = number;
            left[primeFactor] = Math.max(index, left[primeFactor]);
            right[primeFactor] = Math.min(index, right[primeFactor]);
        }
    }

    private static boolean generateTree(int start, int end, int parent) {
        if (start >= end) {
            if (start == end) {
                result[start] = parent;
            }
            return true;
        }

        int low = start;
        int high = end;
        boolean isLow = true;

        while (low <= high) {
            int index;
            if (isLow) {
                index = low;
                low++;
            } else {
                index = high;
                high--;
            }
            isLow = !isLow;

            if (isCoPrime(index, start, end)) {
                result[index] = parent;
                return generateTree(start, index - 1, index + 1)
                        && generateTree(index + 1, end, index + 1);
            }
        }

        return false;
    }

    private static boolean isCoPrime(int index, int start, int end) {
        int[] primeFactors = factorisedNumbers[index];
        for (int i = 0; i < 30 && primeFactors[i] > 0; i++) {
            int primeFactor = primeFactors[i];
            if (left[primeFactor] > start || right[primeFactor] < end) {
                return false;
            }
        }
        return true;
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
