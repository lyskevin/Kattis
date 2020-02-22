import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.lang.StringBuilder;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfInputs = fr.nextInt();
        TreeMap<Integer, Integer> bst = new TreeMap<>();
        int input = fr.nextInt();
        bst.put(input, 0);
        long totalDepth = 0;
        StringBuilder output = new StringBuilder("0\n");
        for (int i = 0, n = numberOfInputs - 1; i < n; i++) {
            input = fr.nextInt();
            Integer ceilingKey = bst.ceilingKey(input);
            Integer floorKey = bst.floorKey(input);
            int depth = 0;
            if (ceilingKey == null) {
                depth = bst.get(floorKey) + 1;
            } else if (floorKey == null) {
                depth = bst.get(ceilingKey) + 1;
            } else {
                depth = Math.max(bst.get(ceilingKey), bst.get(floorKey)) + 1;
            }
            bst.put(input, depth);
            totalDepth += depth;
            output.append(totalDepth);
            output.append("\n");
        }
        System.out.print(output);
    }
}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
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

