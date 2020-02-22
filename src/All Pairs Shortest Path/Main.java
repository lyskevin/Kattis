import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.HashSet;

/**
 * @author lyskevin
 */
public class Main {

    private static final int INF = 1000000000;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        String[] input = fr.nextLine().split(" ");
        int numberOfNodes = Integer.parseInt(input[0]);
        int numberOfEdges = Integer.parseInt(input[1]);
        int numberOfQueries = Integer.parseInt(input[2]);
        StringBuilder output = new StringBuilder();
        while (!(numberOfNodes == 0 && numberOfEdges == 0 && numberOfQueries == 0)) {
            int[][] distances = new int[numberOfNodes][numberOfNodes];
            for (int i = 0; i < numberOfNodes; i++) {
                for (int j = 0; j < numberOfNodes; j++) {
                    if (i != j) {
                        distances[i][j] = INF;
                    } else {
                        distances[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < numberOfEdges; i++) {
                int start = fr.nextInt();
                int end = fr.nextInt();
                int distance = fr.nextInt();
                distances[start][end] = Math.min(distance, distances[start][end]);
            }
            floydWarshalls(distances);
            checkNegativeCycles(distances);
            for (int i = 0; i < numberOfQueries; i++) {
                int start = fr.nextInt();
                int end = fr.nextInt();
                if (distances[start][end] == -INF) {
                    output.append("-Infinity\n");
                } else if (distances[start][end] == INF) {
                    output.append("Impossible\n");
                } else {
                    output.append(distances[start][end]);
                    output.append("\n");
                }
            }
            input = fr.nextLine().split(" ");
            numberOfNodes = Integer.parseInt(input[0]);
            numberOfEdges = Integer.parseInt(input[1]);
            numberOfQueries = Integer.parseInt(input[2]);
            if (!(numberOfNodes == 0 && numberOfEdges == 0 && numberOfQueries == 0)) {
                output.append("\n");
            }
        }
        System.out.print(output);
    }

    private static void floydWarshalls(int[][] distances) {
        int numberOfNodes = distances.length;
        for (int k = 0; k < numberOfNodes; k++) {
            for (int i = 0; i < numberOfNodes; i++) {
                for (int j = 0; j < numberOfNodes; j++) {
                    if (distances[i][k] < INF && distances[k][j] < INF) {
                        distances[i][j] = Math.min(distances[i][j],
                                distances[i][k] + distances[k][j]);
                    }
                }
            }
        }
    }

    private static void checkNegativeCycles(int[][] distances) {
        int numberOfNodes = distances.length;
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                for (int k = 0; k < numberOfNodes; k++) {
                    if (distances[i][k] != INF && distances[k][j] != INF
                            && distances[k][k] < 0) {
                        distances[i][j] = -INF;
                    }
                }
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

