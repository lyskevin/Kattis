import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        // Simulate all possible scores
        for (int i = 1; i <= 20; i++) {
            for (int a = 0; a <= 3; a++) {
                for (int j = 1; j <= 20; j++) {
                    for (int b = 0; b <= 3; b++) {
                        for (int k = 1; k <= 20; k++) {
                            for (int c = 0; c <= 3; c++) {
                                if (a * i + b * j + c * k == n) {
                                    if (a > 0) {
                                        if (a == 1) {
                                            fio.print("single ");
                                        } else if (a == 2) {
                                            fio.print("double ");
                                        } else if (a == 3) {
                                            fio.print("triple ");
                                        }
                                        fio.println(i);
                                    }
                                    if (b > 0) {
                                        if (b == 1) {
                                            fio.print("single ");
                                        } else if (b == 2) {
                                            fio.print("double ");
                                        } else {
                                            fio.print("triple ");
                                        }
                                        fio.println(j);
                                    }
                                    if (c > 0) {
                                        if (c == 1) {
                                            fio.print("single ");
                                        } else if (c == 2) {
                                            fio.print("double ");
                                        } else {
                                            fio.print("triple ");
                                        }
                                        fio.println(k);
                                    }
                                    fio.close();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        fio.println("impossible");
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

