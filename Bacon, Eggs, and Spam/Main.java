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
            try {
                TreeMap<String, ArrayList<String>> mappings = new TreeMap<>();
                for (int i = 0; i < n; i++) {
                    String[] input = fio.nextLine().split(" ");
                    String name = input[0];
                    for (int j = 1; j < input.length; j++) {
                        String item = input[j];
                        if (mappings.containsKey(item)) {
                            mappings.get(item).add(name);
                        } else {
                            ArrayList<String> names = new ArrayList<>();
                            names.add(name);
                            mappings.put(item, names);
                        }
                    }
                }
                while (!mappings.isEmpty()) {
                    String item = mappings.firstKey();
                    ArrayList<String> names = mappings.remove(item);
                    Collections.sort(names);
                    fio.print(item);
                    for (String name : names) {
                        fio.print(" " + name);
                    }
                    fio.println();
                }
                fio.println();
                n = fio.nextInt();
            } catch (NullPointerException e) {
                break;
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

