import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 

public class ReactivitySeries {

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int N = fr.nextInt();
        int K = fr.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < K; i++) {
            int current = fr.nextInt();
            int next = fr.nextInt();
            adjList.get(current).add(next);
        }

        Comparator<Integer> intComparator = new Comparator<>() {
            public int compare(Integer int1, Integer int2) {
                return int1.compareTo(int2);
            }
        };

        for (int i = 0; i < N; i++) {
            adjList.get(i).sort(intComparator);
        }

        ArrayList<Integer> topoSort = new ArrayList<>();
        dfsKahn(adjList, topoSort);

        // Check for uniqueness
        boolean isUnique = true;
        for (int i = 0; i < topoSort.size() - 1; i++) {
            Integer current = topoSort.get(i);
            Integer next = topoSort.get(i + 1);
            if (adjList.get(current.intValue()).indexOf(next) == -1) {
                isUnique = false;
                break;
            }
        }

        // Print output
        if (!isUnique || topoSort.size() < N) {
            System.out.println("back to the lab");
        } else {
            System.out.print(topoSort.remove(0));
            for (int i = 0; i < topoSort.size(); i++) {
                System.out.print(" " + topoSort.get(i));
            }
            System.out.println();
        }

    }

    private static void dfsKahn(ArrayList<ArrayList<Integer>> adjList,
            ArrayList<Integer> topoSort) {      
        int N = adjList.size();
        boolean[] isVisited = new boolean[N];
        int[] predecessors = new int[N];
        for (int i = 0; i < N; i++) {
            isVisited[i] = false;
            predecessors[i] = -1;
        }
        ArrayList<Integer> topoSortTemp = new ArrayList<>(); // Clear toposort
        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                dfsRec(i, adjList, isVisited, predecessors, topoSortTemp);
            }
        }
        // Reverse toposort (and output it)
        for (int i = topoSortTemp.size() - 1; i >= 0; i--) {
            topoSort.add(topoSortTemp.get(i));
        }
    }

    private static void dfsRec(int start, ArrayList<ArrayList<Integer>>adjList,
            boolean[] isVisited, int[] predecessors,
            ArrayList<Integer> topoSortTemp) {
        isVisited[start] = true;
        for (Integer neighbour : adjList.get(start)) {
            if (!isVisited[neighbour.intValue()]) {
                predecessors[neighbour.intValue()] = start;
                dfsRec(neighbour.intValue(), adjList, isVisited, predecessors,
                        topoSortTemp);
            }
        }
        topoSortTemp.add(start);
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

