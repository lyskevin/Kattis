import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fio.nextInt();
            String[] numbers = new String[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = fio.nextLine();
            }
            Arrays.sort(numbers);
            boolean isConsistent = true;
            // Check if each number is a substring of the next one
            for (int j = 0; j < n - 1 && isConsistent; j++) {
                if (numbers[j].length() <= numbers[j + 1].length()) {
                    for (int k = 0; k < numbers[j].length(); k++) {
                        if (numbers[j].charAt(k) != numbers[j + 1].charAt(k)) {
                            break;
                        }
                        if (k == numbers[j].length() - 1) {
                            isConsistent = false;
                        }
                    }
                }
            }
            if (isConsistent) {
                fio.println("YES");
            } else {
                fio.println("NO");
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

