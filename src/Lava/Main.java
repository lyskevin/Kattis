import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static final int INF = 1000000000;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int A = fio.nextInt();
        int F = fio.nextInt();
        int L = fio.nextInt();
        int W = fio.nextInt();
        
        int[][] elsaDistances = new int[L][W];
        int[][] dadDistances = new int[L][W];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                elsaDistances[i][j] = INF;
                dadDistances[i][j] = INF;
            }
        }

        ArrayList<Position> positions = new ArrayList<>();
        Queue<State> queue = new LinkedList<>();
        Position end = null;
        int index = 0;
        char[][] grid = new char[L][W];
        for (int i = 0; i < L; i++) {
            String row = fio.nextLine();
            for (int j = 0; j < W; j++) {
                char c = row.charAt(j);
                grid[i][j] = c;
                if (c == 'B') {
                    continue;
                }
                Position position = new Position(index, i, j);
                positions.add(position);
                index++;
                if (c == 'S') {
                    queue.offer(new State(position, true, 0)); 
                    queue.offer(new State(position, false, 0));
                    elsaDistances[i][j] = 0;
                    dadDistances[i][j] = 0;
                } else if (c == 'G') {
                    end = position;
                }
            }
        }

        ArrayList<ArrayList<Integer>> elsaAdjList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> dadAdjList = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            elsaAdjList.add(new ArrayList<>());
            dadAdjList.add(new ArrayList<>());
        }

        for (int i = 0; i < positions.size() - 1; i++) {
            for (int j = i + 1; j < positions.size(); j++) {
                Position first = positions.get(i);
                Position second = positions.get(j);
                if (canReach(first, second, A)) {
                    elsaAdjList.get(i).add(j);
                    elsaAdjList.get(j).add(i);
                }
                if (first.row == second.row && Math.abs(first.column - second.column) <= F
                        || first.column == second.column && Math.abs(first.row - second.row) <= F) {
                    dadAdjList.get(i).add(j);
                    dadAdjList.get(j).add(i);
                }
            }
        }

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.isElsa) {
                for (int neighbourIndex : elsaAdjList.get(state.position.index)) {
                    Position neighbour = positions.get(neighbourIndex);
                    if (elsaDistances[neighbour.row][neighbour.column] > state.distance + 1) {
                        elsaDistances[neighbour.row][neighbour.column] = state.distance + 1;
                        queue.offer(new State(new Position(neighbourIndex, neighbour.row, neighbour.column), true, state.distance + 1));
                    }
                }
            } else {
                for (int neighbourIndex : dadAdjList.get(state.position.index)) {
                    Position neighbour = positions.get(neighbourIndex);
                    if (dadDistances[neighbour.row][neighbour.column] > state.distance + 1) {
                        dadDistances[neighbour.row][neighbour.column] = state.distance + 1;
                        queue.offer(new State(new Position(neighbourIndex, neighbour.row, neighbour.column), false, state.distance + 1));
                    }
                }
            }
        }

        if (elsaDistances[end.row][end.column] == INF && dadDistances[end.row][end.column] == INF) {
            fio.println("NO WAY");
        } else if (elsaDistances[end.row][end.column] < dadDistances[end.row][end.column]) {
            fio.println("GO FOR IT");
        } else if (elsaDistances[end.row][end.column] > dadDistances[end.row][end.column]) {
            fio.println("NO CHANCE");
        } else {
            fio.println("SUCCESS");
        }

        fio.close();
    }

    private static boolean canReach(Position start, Position end, int d) {
        return (start.row - end.row) * (start.row - end.row) + (start.column - end.column) * (start.column - end.column) <= d * d;
    }
}

class Position {
    int index;
    int row;
    int column;
    
    Position(int index, int row, int column) {
        this.index = index;
        this.row = row;
        this.column = column;
    }
}

class State {
    Position position;
    boolean isElsa;
    int distance;
    
    State(Position position, boolean isElsa, int distance) {
        this.position = position;
        this.isElsa = isElsa;
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

