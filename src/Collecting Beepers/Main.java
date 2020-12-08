import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static int rows;
    private static int columns;
    private static Coordinates[] beeperCoordinates;
    private static int[][] distances;
    private static final int[][] MOVES = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private static int min;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            rows = fio.nextInt();
            columns = fio.nextInt();

            Coordinates startingCoordinates = new Coordinates(fio.nextInt() - 1, fio.nextInt() - 1);
            int n = fio.nextInt();
            beeperCoordinates = new Coordinates[n + 1];
            beeperCoordinates[0] = startingCoordinates;
            for (int j = 1; j <= n; j++) {
                beeperCoordinates[j] = new Coordinates(fio.nextInt() - 1, fio.nextInt() - 1);
            }

            // BFS from source and all beeper locations
            distances = new int[n + 1][n + 1];
            for (int j = 0; j <= n; j++) {
                bfs(j);
            }

            // Try all permutations to solve small TSP instance using memoized distances
            min = 1000000;
            for (int j = 1; j <= n; j++) {
                boolean[] usedIndices = new boolean[n + 1];
                usedIndices[j] = true;
                findBestDistance(j, usedIndices, 1, distances[0][j]);
            }

            fio.println(min);
        }

        fio.close();
    }

    private static void findBestDistance(int index, boolean[] usedIndices, int count, int distance) {
        // Prune here
        if (distance >= min) {
            return;
        }

        // Reached the end
        if (count == usedIndices.length - 1) {
            min = Math.min(min, distance + distances[index][0]);
        }

        // Permute indices
        for (int i = 1; i < usedIndices.length; i++) {
            if (!usedIndices[i]) {
                usedIndices[i] = true;
                findBestDistance(i, usedIndices, count + 1, distance + distances[index][i]);
                usedIndices[i] = false;
            }
        }
    }

    private static void bfs(int index) {
        boolean[][] visited = new boolean[rows][columns];
        Coordinates source = beeperCoordinates[index];
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(source, 0));
        visited[source.x][source.y] = true;

        while (!queue.isEmpty()) {
            State state = queue.poll();

            // Check whether we have found a beeper location. If so, update memoized distances
            for (int i = 0; i < beeperCoordinates.length; i++) {
                if (state.coordinates.equals(beeperCoordinates[i])) {
                    distances[index][i] = state.distance;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextX = state.coordinates.x + MOVES[i][0];
                int nextY = state.coordinates.y + MOVES[i][1];
                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < columns
                        && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new State(new Coordinates(nextX, nextY), state.distance + 1));
                }
            }
        }
    }
}

class Coordinates {
    int x;
    int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        Coordinates otherCoordinates = (Coordinates) other;
        return this.x == otherCoordinates.x && this.y == otherCoordinates.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class State {
    Coordinates coordinates;
    int distance;

    State(Coordinates coordinates, int distance) {
        this.coordinates = coordinates;
        this.distance = distance;
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

