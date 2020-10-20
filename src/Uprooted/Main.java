import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int n;
    private static int m;
    private static int s;
    private static ArrayList<ArrayList<Triple>> adjList;
    private static int[][] map; // map[i][j] = index of node j in pi
    private static int[][] permutations; // permutations[i][j] = pi,j
    private static PriorityQueue[] processedEdges; // Node -> PQ of edges that can be used in Prim's
    private static boolean[] processedNodes;

    // 0-indexed
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        n = fio.nextInt();
        m = fio.nextInt();
        s = fio.nextInt();
        
        // Initialise adjacency list
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = fio.nextInt() - 1;
            int b = fio.nextInt() - 1;
            long c = -1 * fio.nextLong(); // Invert the weights for maximum spanning tree
            adjList.get(a).add(new Triple(b, c, i + 1));
            adjList.get(b).add(new Triple(a, c, i + 1));
        }

        // Initialise map and permutations
        map = new int[s][n];
        permutations = new int[s][n];
        for (int i = 0; i < s; i++) {
            map[i][0] = 0;
            permutations[i][0] = 0;
            for (int j = 1; j < n; j++) {
                int p = fio.nextInt() - 1;
                map[i][p] = j;
                permutations[i][j] = p;
            }
        }

        // Initialise processedNodes and processedEdges to use in Prim's
        processedNodes = new boolean[n];
        processedEdges = new PriorityQueue[n];
        for (Triple triple : adjList.get(0)) {
            PriorityQueue<Triple> pq = new PriorityQueue<>();
            pq.offer(new Triple(0, triple.distance, triple.branchNumber));
            processedEdges[triple.node] = pq;
        }
        processedNodes[0] = true;

        // Run modified Prim's algorithm on first permutation
        int[] result = new int[n];
        int count = 0;
        boolean isPossible = true;
        for (int i = 1; i < n && isPossible; i++) {
            int nextNode = permutations[0][i];
            
            // Cannot reach the next node from the current connected component
            if (processedEdges[nextNode] == null) {
                isPossible = false;
                break;
            }
            
            PriorityQueue<Triple> pq = processedEdges[nextNode];
            boolean hasValidEdge = false;
            while (!pq.isEmpty() && !hasValidEdge) {
                Triple triple = pq.poll();
                int previousNode = triple.node;

                // Check that this edge is compatible with all other growth permutations
                hasValidEdge = true;
                for (int j = 1; j < s && hasValidEdge; j++) {
                    if (map[j][previousNode] > map[j][nextNode]) {
                        hasValidEdge = false;
                    }
                }

                // Connect this edge (and thus add all of its other edges to the relevant PQs) if it is valid
                if (hasValidEdge) {
                    result[count] = triple.branchNumber;
                    count++;
                    processedNodes[nextNode] = true;
                    
                    for (Triple neighbour : adjList.get(nextNode)) {
                        if (!processedNodes[neighbour.node]) {
                            Triple edge = new Triple(nextNode, neighbour.distance, neighbour.branchNumber);
                            if (processedEdges[neighbour.node] == null) {
                                processedEdges[neighbour.node] = new PriorityQueue<Triple>();
                            }
                            processedEdges[neighbour.node].offer(edge);
                        }
                    }
                }
            }

            isPossible = hasValidEdge;
        }

        // Print the result if possible
        if (isPossible) {
            fio.println(count);
            for (int i = 0; i < count; i++) {
                if (i > 0) {
                    fio.print(" ");
                }
                fio.print(result[i]);
            }
            fio.println();
        } else {
            fio.println("IMPOSSIBLE");
        }

        fio.close();
    }
}

class Triple implements Comparable<Triple> {
    int node;
    long distance;
    int branchNumber;

    Triple(int node, long distance, int branchNumber) {
        this.node = node;
        this.distance = distance;
        this.branchNumber = branchNumber;
    }

    @Override
    public int compareTo(Triple other) {
        if (this.distance != other.distance) {
            return Long.compare(this.distance, other.distance); // ascending order because of negative weights
        } else if (this.node != other.node) {
            return this.node - other.node;
        } else {
            return this.branchNumber - other.branchNumber;
        }
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

