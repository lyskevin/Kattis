import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            try {
                int n = fio.nextInt();
                int[] A = new int[n];
                for (int i = 0; i < n; i++) {
                    A[i] = fio.nextInt();
                }

                // Store predecessors to recontruct LIS
                int[] predecessors = new int[n];
                for (int i = 0; i < n; i++) {
                    predecessors[i] = -1;
                }
                ArrayList<Integer> L = new ArrayList<>();
                L.add(0);

                // Store the ending index of the most recently found LIS
                int lisIndex = 0;

                // Greedy algorithm to find LIS
                // L stores the indices of the best (lowest) possible ending number for an LIS of length (i + 1)
                // E.g. L[0] stores the index best possible ending number for LIS's of size 1
                for (int i = 1; i < n; i++) {
                    if (A[i] > A[L.get(L.size() - 1)]) {
                        lisIndex = i;
                        predecessors[i] = L.get(L.size() - 1);
                        L.add(i);
                    } else {

                        // Binary search used here because A[L[i]] < A[L[i + 1]] for all possible values of i
                        int index = binarySearch(A, i, L);
                        if (index == L.size() - 1) {
                            lisIndex = i;
                        }
                        if (index > -1) {
                            L.set(index, i);
                            if (index > 0) {
                                predecessors[i] = L.get(index - 1);
                            }
                        }
                    }
                }
                int[] lis = new int[L.size()];
                lis[L.size() - 1] = L.get(L.size() - 1);
                int count = L.size() - 2;

                // Reconstruct LIS (predecessors array gives reverse order)
                while (predecessors[lisIndex] > -1) {
                    lis[count] = predecessors[lisIndex];
                    lisIndex = predecessors[lisIndex];
                    count--;
                }
                fio.println(L.size());
                for (int i = 0; i < L.size(); i++) {
                    if (i > 0) {
                        fio.print(" ");
                    }
                    fio.print(lis[i]);
                }
                fio.println();
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
    }

    // Assumes that the specified number is within the range of numbers in the ArrayList
    // Returns -1 if the specified number is equal to any of the numbers in the ArrayList
    private static int binarySearch(int[] A, int i, ArrayList<Integer> L) {
        int number = A[i];
        int low = 0;
        int high = L.size() - 1;
        boolean isFound = false;
        int index = 0;
        while (!isFound) {
            int middle = (low + high) / 2;
            if (number == A[L.get(middle)]) {
                index = -1;
                isFound = true;
            } else {
                if ((middle == 0 && A[L.get(middle)] > number)
                        || (middle > 0 && A[L.get(middle - 1)] < number && A[L.get(middle)] > number)) {
                    index = middle;
                    isFound = true;
                } else if (A[L.get(middle)] > number) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
        return index;
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

