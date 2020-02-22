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
            int[] results = new int[n];
            int maxLength = 0;
            for (int i = 0; i < n; i++) {
                int number1 = fio.nextInt();
                char operand = fio.next().charAt(0);
                int number2 = fio.nextInt();
                int result;
                if (operand == '+') {
                    result = number1 + number2;
                } else if (operand == '-') {
                    result = number1 - number2;
                } else {
                    result = number1 * number2;
                }
                maxLength = Math.max(maxLength, (result + "").length());
                results[i] = result;
            }
            int currentLineLength = 0;
            for (int i = 0; i < n; i++) {
                fio.print(String.format("%" + maxLength + "d", results[i]));
                currentLineLength += maxLength;
                if (currentLineLength + 1 + maxLength <= 50 && i < n - 1) {
                    fio.print(" ");
                    currentLineLength++;
                } else {
                    fio.println();
                    currentLineLength = 0;
                }
            }
            if (currentLineLength > 0) {
                fio.println();
            }
            n = fio.nextInt();
            if (n > 0) {
                fio.println();
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

