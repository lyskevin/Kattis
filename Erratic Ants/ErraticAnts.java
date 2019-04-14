import java.util.*;

public class ErraticAnts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numPaths = sc.nextInt();
        for (int i = 0; i < numPaths; i++) {
            tracePath(sc);
        }
        sc.close();
    }

    private static void tracePath(Scanner sc) {

        int numSteps = sc.nextInt();

        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();

        /* Initialise currentNeighbours and nextNeighbours (bidirectional) */
        int current = 10000; // Starting point
        int end = current; // Ending point
        for (int i = 0; i < numSteps; i++) {
            int next = current;
            String direction = sc.next();
            if (direction.equals("N")) {
                next -= 100;
            } else if (direction.equals("S")) {
                next += 100;
            } else if (direction.equals("W")) {
                next -= 1;
            } else if (direction.equals("E")) {
                next += 1;
            }
            /* Current neighbours */
            HashSet<Integer> currentNeighbours;
            if (adjList.containsKey(current)) {
                currentNeighbours = adjList.get(current);
            } else {
                currentNeighbours = new HashSet<>();
            }
            currentNeighbours.add(next);
            adjList.put(current, currentNeighbours);
            /* Next neighbours */
            HashSet<Integer> nextNeighbours;
            if (adjList.containsKey(next)) {
                nextNeighbours = adjList.get(next);
            } else {
                nextNeighbours = new HashSet<>();
            }
            nextNeighbours.add(current);
            adjList.put(next, nextNeighbours);
            current = next;
            if (i == numSteps - 1) {
                end = next;
            }
        }

        if (numSteps == 0) {
            System.out.println(0);
        } else {
            /* Perform BFS */
            int[] predecessors = new int[16001]; // Max is 16000
            bfs(adjList, predecessors);

            /* Output shortest path to food source (Path reconstruction) */
            int count = 0;
            for (int i = end; i != 10000; i = predecessors[i]) {
                count++;
            }
            System.out.println(count);
        }

    }

    private static void bfs(HashMap<Integer, HashSet<Integer>> adjList,
            int[] predecessors) {

        // Initialisation step
        boolean[] isVisited = new boolean[16001]; // Max is 16000

        Queue<Integer> bfsQueue = new LinkedList<>();

        // Set starting conditions
        isVisited[10000] = true;
        predecessors[10000] = 0;

        // Perform BFS
        bfsQueue.offer(10000);
        while (!bfsQueue.isEmpty()) {
            int current = bfsQueue.poll();
            if (adjList.containsKey(current)) {
                for (Integer neighbour : adjList.get(current)) {
                    int next = neighbour.intValue();
                    if (isVisited[next]) {
                        continue;
                    }
                    isVisited[next] = true;
                    predecessors[next] = current;
                    bfsQueue.add(next);
                }
            }
        }

    }

}

