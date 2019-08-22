import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.HashMap;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        while (n > 0) {
            int[] list1 = new int[n];
            int[] list1Copy = new int[n];
            for (int i = 0; i < n; i++) {
                int number = fr.nextInt();
                list1[i] = number;
                list1Copy[i] = number;
            }
            int[] list2 = new int[n];
            for (int i = 0; i < n; i++) {
                list2[i] = fr.nextInt();
            }
            Arrays.sort(list1);
            Arrays.sort(list2);
            HashMap<Integer, Integer> mappings = new HashMap<>();
            for (int i = 0; i < n; i++) {
                mappings.put(list1[i], list2[i]);
            }
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++) {
                output.append(mappings.get(list1Copy[i]) + "\n");
            }
            n = fr.nextInt();
            if (n > 0) {
                output.append("\n");
            }
            System.out.print(output);
        }
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

