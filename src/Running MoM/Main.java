import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static boolean[] isVisited;
    private static boolean[] hasCycle;
    private static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    private static HashMap<String, Integer> map = new HashMap<>();
    private static HashSet<Integer> predecessors = new HashSet<>();

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        // Number of flights <= 5000; number of cities <= 10000
        for (int i = 0; i < 10000; i++) {
            adjList.add(new ArrayList<>());
        }

        int count = 0;
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            String city1 = fio.next();
            String city2 = fio.next();
            if (!map.containsKey(city1)) {
                map.put(city1, count);
                count++;
            }
            if (!map.containsKey(city2)) {
                map.put(city2, count);
                count++;
            }
            adjList.get(map.get(city1)).add(map.get(city2));
        }

        isVisited = new boolean[count];
        hasCycle = new boolean[count];

        for (int i = 0; i < count; i++) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }

        while (true) {
            try {
                String city = fio.nextLine();
                if (hasCycle[map.get(city)]) {
                    fio.println(city + " safe");
                } else {
                    fio.println(city + " trapped");
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
    }

    private static boolean dfs(int node) {
        isVisited[node] = true;
        predecessors.add(node);
        boolean result = false;
        for (int next : adjList.get(node)) {
            if (!isVisited[next]) {
                result = dfs(next) || result;
            } else {
                result = result || hasCycle[next] || predecessors.contains(next);
            }
        }
        predecessors.remove(node);
        hasCycle[node] = result;
        return result;
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

