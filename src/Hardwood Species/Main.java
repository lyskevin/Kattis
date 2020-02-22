import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        HashMap<String, Integer> treeCounts = new HashMap<>();
        int totalCount = 0;
        while (true) {
            String tree = fio.nextLine();
            if (tree == null) {
                break;
            }
            if (treeCounts.containsKey(tree)) {
                treeCounts.put(tree, treeCounts.get(tree) + 1);
            } else {
                treeCounts.put(tree, 1);
            }
            totalCount++;
        }
        ArrayList<String> treeNames = new ArrayList<>();
        for (String tree : treeCounts.keySet()) {
            treeNames.add(tree);
        }
        Collections.sort(treeNames);
        for (String tree : treeNames) {
            fio.println(tree + " " + (100.0 * treeCounts.get(tree) / totalCount));
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

