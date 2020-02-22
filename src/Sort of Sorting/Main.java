import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfNames = fr.nextInt();
        StringBuilder output = new StringBuilder();
        while (numberOfNames > 0) {
            String[] names = new String[numberOfNames];
            for (int i = 0; i < numberOfNames; i++) {
                names[i] = fr.nextLine();
            }
            Comparator<String> nameComparator = new Comparator<>() {
                @Override
                public int compare(String name1, String name2) {
                    return name1.substring(0, 2).compareTo(name2.substring(0, 2));
                }
            };
            Arrays.sort(names, nameComparator);
            for (int i = 0; i < numberOfNames; i++) {
                output.append(names[i]);
                output.append("\n");
            }
            numberOfNames = fr.nextInt();
            if (numberOfNames > 0) {
                output.append("\n");
            }
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

