import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.lang.StringBuilder;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfTrips = fr.nextInt();
        HashMap<String, Integer> countryIndices = new HashMap<>();
        ArrayList<ArrayList<Integer>> trips = new ArrayList<>();
        int countryIndex = 0;
        for (int i = 0; i < numberOfTrips; i++) {
            String country = fr.next();
            int year = fr.nextInt();
            if (!countryIndices.containsKey(country)) {
                countryIndices.put(country, countryIndex);
                countryIndex++;
                trips.add(new ArrayList<>());
            }
            trips.get(countryIndices.get(country)).add(year);
        }
        for (int j = 0, n = trips.size(); j < n; j++) {
            Collections.sort(trips.get(j));
        }
        int numberOfQueries = fr.nextInt();
        StringBuilder output = new StringBuilder();
        for (int k = 0; k < numberOfQueries; k++) {
            String country = fr.next();
            int tripNumber = fr.nextInt();
            output.append(trips.get(countryIndices.get(country)).get(tripNumber - 1));
            output.append('\n');
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

