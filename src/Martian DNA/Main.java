import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();
        int K = fio.nextInt();
        int R = fio.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = fio.nextInt();
        }

        int[] requirements = new int[K];
        for (int i = 0; i < R; i++) {
            int B = fio.nextInt();
            int Q = fio.nextInt();
            requirements[B] = Q;
        }

        for (int i = 0; i < K; i++) {
            if (requirements[i] == 0) {
                requirements[i] = Integer.MIN_VALUE;
            }
        }

        int min = Integer.MAX_VALUE;
        int endIndex = 0;
        int numberOfRequirements = R;
        for (int i = 0; i < N; i++) {
            while (endIndex < N && numberOfRequirements > 0) {
                int endNumber = numbers[endIndex];
                if (requirements[endNumber] > Integer.MIN_VALUE) {
                    if (requirements[endNumber] == 1) {
                        numberOfRequirements--;
                    }
                    requirements[endNumber]--;
                }
                endIndex++;
            }

            if (numberOfRequirements == 0) {
                min = Math.min(min, endIndex - i);
            }

            int number = numbers[i];
            if (requirements[number] > Integer.MIN_VALUE) {
                if (requirements[number] == 0) {
                    numberOfRequirements++;
                }
                requirements[number]++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            fio.println("impossible");
        } else {
            fio.println(min);
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

