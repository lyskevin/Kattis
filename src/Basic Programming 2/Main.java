import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int t = fio.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = fio.nextInt();
        }
        Arrays.sort(A);
        if (t == 1) {
            int left = 0;
            int right = n - 1;
            boolean isFound = false;
            while (A[left] != A[right] && !isFound) {
                if (A[left] + A[right] < 7777) {
                    left++;
                } else if (A[left] + A[right] > 7777) {
                    right--;
                } else {
                    isFound = true;
                }
            }
            if (isFound) {
                fio.println("Yes");
            } else {
                fio.println("No");
            }
        } else if (t == 2) {
            boolean containsDuplicate = false;
            for (int i = 0; i < n - 1 && !containsDuplicate; i++) {
                if (A[i] == A[i + 1]) {
                    containsDuplicate = true;
                }
            }
            if (containsDuplicate) {
                fio.println("Contains duplicate");
            } else {
                fio.println("Unique");
            }
        } else if (t == 3) {
            int count = 1;
            boolean isFound = false;
            for (int i = 1; i < n && !isFound; i++) {
                if (A[i] == A[i - 1]) {
                    count++;
                    if (count > n / 2) {
                        fio.println(A[i]);
                        isFound = true;
                    }
                } else {
                    count = 1;
                }
            }
            if (!isFound) {
                fio.println(-1);
            }
        } else if (t == 4) {
            if (n % 2 == 0) {
                fio.println(A[(n / 2) - 1] + " " + A[n / 2]);
            } else {
                fio.println(A[n / 2]);
            }
        } else {
            boolean isFirstNumber = true;
            for (int i = 0; i < n && A[i] <= 999; i++) {
                if (A[i] >= 100) {
                    if (isFirstNumber) {
                        isFirstNumber = false;
                    } else {
                        fio.print(" ");
                    }
                    fio.print(A[i]);
                }
            }
            fio.println();
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


