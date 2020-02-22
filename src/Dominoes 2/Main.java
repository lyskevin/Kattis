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
        int numberOfTestCases = fr.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            countFallenDominoes(fr);
        }
    }

    private static void countFallenDominoes(FastReader fr) {
        int numberOfDominoes = fr.nextInt();
        int numberOfEdges = fr.nextInt();
        int numberOfSources = fr.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numberOfDominoes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < numberOfEdges; i++) {
            int start = fr.nextInt() - 1;
            int end = fr.nextInt() - 1;
            adjList.get(start).add(end);
        }
        boolean[] fallenDominoes = new boolean[numberOfDominoes];
        int numberOfFallenDominoes = 0;
        for (int i = 0; i < numberOfSources; i++) {
            numberOfFallenDominoes += dfs(fr.nextInt() - 1, fallenDominoes, adjList);
        }
        System.out.println(numberOfFallenDominoes);
    }

    private static int dfs(int source, boolean[] fallenDominoes,
        ArrayList<ArrayList<Integer>> adjList) {
        if (fallenDominoes[source]) {
            return 0;
        } else {
            fallenDominoes[source] = true;
            int numberOfFallenDominoes = 1;
            for (Integer connectedDomino : adjList.get(source)) {
                if (!fallenDominoes[connectedDomino]) {
                    numberOfFallenDominoes +=
                        dfs(connectedDomino, fallenDominoes, adjList);
                }
            }
            return numberOfFallenDominoes;
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

