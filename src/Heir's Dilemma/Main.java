import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int low = fio.nextInt();
        int high = fio.nextInt();
        boolean[] usedDigits = new boolean[10];
        int count = 0;
        // Follow the constraints in the question
        for (int i = 1; i < 10; i++) {
            usedDigits[i] = true;
            for (int j = 1; j < 10; j++) {
                if (!usedDigits[j]) {
                    usedDigits[j] = true;
                    for (int k = 1; k < 10; k++) {
                        if (!usedDigits[k]) {
                            usedDigits[k] = true;
                            for (int l = 1; l < 10; l++) {
                                if (!usedDigits[l]) {
                                    usedDigits[l] = true;
                                    for (int m = 1; m < 10; m++) {
                                        if (!usedDigits[m]) {
                                            usedDigits[m] = true;
                                            for (int n = 1; n < 10; n++) {
                                                if (!usedDigits[n]) {
                                                    int number = i * 100000 + j * 10000 + k * 1000
                                                            + l * 100 + m * 10 + n;
                                                    if (number >= low && number <= high && number % i == 0
                                                            && number % j == 0 && number % k == 0
                                                            && number % l == 0 && number % m == 0
                                                            && number % n == 0) {
                                                        count++;
                                                    }
                                                }
                                            }
                                            usedDigits[m] = false;
                                        }
                                    }
                                    usedDigits[l] = false;
                                }
                            }
                            usedDigits[k] = false;
                        }
                    }
                    usedDigits[j] = false;
                }
            }
            usedDigits[i] = false;
        }
        fio.println(count);
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

