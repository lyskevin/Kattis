import java.io.*;
import java.util.*;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        int m = fio.nextInt();
        int[] people = new int[n];
        int[] trees = new int[m];

        for (int i = 0; i < n; i++) {
            people[i] = fio.nextInt();
        }

        for (int i = 0; i < m; i++) {
            trees[i] = fio.nextInt();
        }

        Arrays.sort(people);
        Arrays.sort(trees);

        boolean[] takenTrees = new boolean[1001];
        int treeIndex = 0;
        int count = 0;

        for (int person : people) {
            while (treeIndex < m - 1 && Math.abs(person - trees[treeIndex]) > Math.abs(person - trees[treeIndex + 1])) {
                treeIndex++;
            }

            if (!takenTrees[treeIndex]) {
                count++;
                takenTrees[treeIndex] = true;
            }
        }

        fio.println(n - count); 

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

