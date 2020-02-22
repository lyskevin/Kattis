import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfCities = fr.nextInt();
        for (int i = 0; i < numberOfCities; i++) {
            int numberOfEndpoints = fr.nextInt();
            ArrayList<ArrayList<Integer>> connectedEndpoints = new ArrayList<>();
            for (int j = 0; j < numberOfEndpoints; j++) {
                connectedEndpoints.add(new ArrayList<>());
            }
            int numberOfConnections = fr.nextInt();
            for (int j = 0; j < numberOfConnections; j++) {
                int endpoint1 = fr.nextInt();
                int endpoint2 = fr.nextInt();
                connectedEndpoints.get(endpoint1).add(endpoint2);
                connectedEndpoints.get(endpoint2).add(endpoint1);
            }
            boolean[] isVisited = new boolean[numberOfEndpoints];
            int numberOfConnectedComponents = 0;
            for (int j = 0; j < numberOfEndpoints; j++) {
                if (!isVisited[j]) {
                    dfs(connectedEndpoints, isVisited, j);
                    numberOfConnectedComponents++;
                }
            }
            System.out.println(numberOfConnectedComponents - 1);
        }
    }
    
    private static void dfs(ArrayList<ArrayList<Integer>> connectedEndpoints,
        boolean[] isVisited, int source) {
        isVisited[source] = true;
        for (Integer endpoint : connectedEndpoints.get(source)) {
            if (!isVisited[endpoint]) {
                dfs(connectedEndpoints, isVisited, endpoint);
            }
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

