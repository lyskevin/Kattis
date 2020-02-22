import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.HashMap;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        String[] languages = fr.nextLine().split(" ");
        HashMap<Integer, Integer> previousPositions = new HashMap<>();
        HashMap<Integer, Integer> maxDistances = new HashMap<>();
        int awkwardnessLevel = n;
        for (int i = 0; i < n; i++) {
            Integer language = Integer.valueOf(languages[i]);
            if (previousPositions.containsKey(language)) {
                Integer previousPosition = previousPositions.get(language);
                awkwardnessLevel =
                    Math.min(awkwardnessLevel, i - previousPosition.intValue());
            }
            previousPositions.put(language, Integer.valueOf(i));
        }
        System.out.println(awkwardnessLevel);
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

