import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        String s = fio.next();
        int[] A = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            A[i] = s.charAt(i) - '0';
        }

        fio.println(countInversions(A));
        fio.close();
    }

    private static long countInversions(int[] A) {
        if (A.length == 1) {
            return 0l;
        }

        long inversions = 0l;

        int[] left = new int[A.length / 2];
        int[] right = new int[A.length - left.length];

        System.arraycopy(A, 0, left, 0, left.length);
        System.arraycopy(A, left.length, right, 0, right.length);
        
        inversions += countInversions(left);
        inversions += countInversions(right);

        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        // Merge routine
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                A[index] = left[leftIndex];
                leftIndex++;
            } else {
                inversions += left.length - leftIndex; // Count inversions here
                A[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }

        while (leftIndex < left.length) { 
            A[index] = left[leftIndex];
            leftIndex++;
            index++;
        }
        
        while (rightIndex < right.length) { 
            A[index] = right[rightIndex];
            rightIndex++;
            index++;
        }

        return inversions;
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

