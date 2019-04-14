import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 

public class ReactivitySeries {

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int N = fr.nextInt();
        int K = fr.nextInt();

        // Initialise adjList
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> neighbours = new ArrayList<>();
            adjList.add(neighbours);
        }

        // Add vertex information to adjList
        for (int i = 0; i < K; i++) {
            int A = fr.nextInt(); // Higher reactivity
            int B = fr.nextInt(); // Lower reactivity
            adjList.get(A).add(B);
        }

        // Sort neighbours in increasing order
        Comparator<Integer> intComparator = new Comparator<>() {
            public int compare(Integer int1, Integer int2) {
                return int1.compareTo(int2);
            }
        };
        for (int i = 0; i < N; i++) {
            adjList.get(i).sort(intComparator);
        }

        // Perform BFS with Kahn's algorithm
        ArrayList<Integer> topoSort = new ArrayList<>();
        bfsKahn(adjList, topoSort);

        // Check for uniqueness, i.e. all pairs of consecutive vertices
        // in sorted order are connected by edges
        boolean isUnique = true;
        for (int i = 0; i < topoSort.size() - 1; i++) {
            Integer current = topoSort.get(i);
            Integer next = topoSort.get(i + 1);
            if (adjList.get(current.intValue()).indexOf(next) == -1) {
                isUnique = false;
                break;
            }
        }

        // Output reactivity series
        if (!isUnique || topoSort.size() < N) { // Not unique/missing elements
            System.out.println("back to the lab");
        } else {
            System.out.print(topoSort.remove(0));
            for (int i = 0; i < topoSort.size(); i++) {
                System.out.print(" " + topoSort.get(i));
            }
            System.out.println();
        }

    }

    private static void bfsKahn(ArrayList<ArrayList<Integer>> adjList,
            ArrayList<Integer> topoSort) {

        // Initialisation phase
        int N = adjList.size();
        int[] inDeg = new int[N];
        int[] predecessors = new int[N];
        for (int i = 0; i < N; i++) {
            inDeg[i] = 0;
            predecessors[i] = -1;
        }

        // Get in-degree of vertices
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> neighbours = adjList.get(i);
            for (int j = 0; j < neighbours.size(); j++) {
                Integer neighbour = neighbours.get(j);
                inDeg[neighbour.intValue()] += 1;
            }
        }

        // Enqueue vertices with in-degree of 0, i.e. starting vertices
        Queue<Integer> bfsQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDeg[i] == 0) {
                bfsQueue.add(i);
            }
        }

        // Search phase
        while (!bfsQueue.isEmpty()) {
            Integer vertex = bfsQueue.poll();
            topoSort.add(vertex);
            for (Integer neighbour : adjList.get(vertex.intValue())) {
                if (inDeg[neighbour.intValue()] > 0) {
                    inDeg[neighbour.intValue()] -= 1;
                }
                if (inDeg[neighbour.intValue()] == 0) {
                    predecessors[neighbour.intValue()] = vertex.intValue();
                    bfsQueue.offer(neighbour);
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

