import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();
        int[] A = new int[N];
        HashMap<Integer, HashSet<Integer>> mappings = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int spots = fio.nextInt();
            A[i] = spots;

            // Jump forward to reach this pebble
            int key1 = i - spots;
            if (!mappings.containsKey(key1)) {
                mappings.put(key1, new HashSet<>());
            }
            mappings.get(key1).add(i);

            // Jump backward to reach this pebble
            int key2 = i + spots;
            if (!mappings.containsKey(key2)) {
                mappings.put(key2, new HashSet<>());
            }
            mappings.get(key2).add(i);
        }

        boolean[] visited = new boolean[N];
        visited[0] = true;
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(0);
        int max = 0;

        // BFS
        while (!bfsQueue.isEmpty()) {
            Integer index = bfsQueue.poll();
            max = Math.max(max, index); // Keep track of the highest index

            // Jump forward to all possible pebbles
            int key1 = index + A[index];
            if (mappings.containsKey(key1)) {
                for (Integer nextIndex : mappings.get(key1)) {
                    if (!visited[nextIndex] && (index + nextIndex + A[index] + A[nextIndex]) == 2 * nextIndex) {
                        visited[nextIndex] = true;
                        bfsQueue.add(nextIndex);
                    }
                }
            }

            // Jump backwards to all possible pebbles
            int key2 = index - A[index];
            if (mappings.containsKey(key2)) {
                for (Integer nextIndex : mappings.get(key2)) {
                    if (!visited[nextIndex] && (nextIndex + index + A[nextIndex] + A[index]) == 2 * index) {
                        visited[nextIndex] = true;
                        bfsQueue.add(nextIndex);
                    }
                }
            }
        }

        fio.println(max);
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

