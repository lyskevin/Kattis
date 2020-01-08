import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int p = fio.nextInt();
        for (int i = 0; i < p; i++) {
            int k = fio.nextInt();
            int n = fio.nextInt();
            int[] array = new int[n];
            int[] sortedArray = new int[n];
            for (int j = 0; j < n; j++) {
                int number = fio.nextInt();
                array[j] = number;
                sortedArray[j] = number;
            }
            Arrays.sort(sortedArray);
            int index = 0;
            int count = n;
            for (int j = 0; j < n; j++) {
                // Decrease number of DA operations required when we encounter the next number in the sorted array
                if (sortedArray[index] == array[j]) {
                    count--;
                    index++;
                }
            }
            fio.println(k + " " + count);
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

