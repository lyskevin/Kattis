import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.lang.StringBuilder;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfVertices = fr.nextInt();
        while (numberOfVertices > 0) {
            int[][] graph = new int[numberOfVertices][numberOfVertices];
            for (int i = 0; i < numberOfVertices; i++) {
                for (int j = 0; j < numberOfVertices; j++) {
                    graph[i][j] = fr.nextInt();
                }
            }
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < numberOfVertices; i++) {
                boolean isWeakVertex = true;
                for (int j = 0; j < numberOfVertices && isWeakVertex; j++) {
                    if (graph[i][j] == 1) {
                        for (int k = 0; k < numberOfVertices && isWeakVertex; k++) {
                            if (graph[j][k] == 1 && graph[i][k] == 1
                                && i != k && j != k) {
                                isWeakVertex = false;
                            }
                        }
                    }
                }
                if (isWeakVertex) {
                    if (output.length() > 0) {
                        output.append(" ");
                    }
                    output.append(i);
                }
            }
            System.out.println(output);
            numberOfVertices = fr.nextInt();
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


