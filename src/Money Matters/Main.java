import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        int[] amounts = new int[n];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            amounts[i] = fio.nextInt();
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = fio.nextInt();
            int y = fio.nextInt();
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }
        boolean[] visited = new boolean[n];
        boolean isPossible = true;
        for (int i = 0; i < n && isPossible; i++) {
            if (!visited[i]) {
                int amount = dfs(i, adjList, amounts, visited, 0);
                if (amount != 0) {
                    isPossible = false;
                }
            }
        }
        if (isPossible) {
            fio.println("POSSIBLE");
        } else {
            fio.println("IMPOSSIBLE");
        }
        fio.close();
    }

    private static int dfs(int source, ArrayList<ArrayList<Integer>> adjList,
            int[] amounts, boolean[] visited, int currentAmount) {
        visited[source] = true;
        currentAmount += amounts[source];
        for (Integer friend : adjList.get(source)) {
            int friendValue = friend.intValue();
            if (!visited[friendValue]) {
                currentAmount = dfs(friendValue, adjList, amounts, visited, currentAmount);
            }
        }
        return currentAmount;
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
