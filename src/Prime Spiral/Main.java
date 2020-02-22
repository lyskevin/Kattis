import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static final int GRID_SIZE = 101;
    private static final int[][] MOVES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final HashMap<Integer, Node> MAPPINGS = new HashMap<>();

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int[][] grid = generateGrid();
        int caseNumber = 1;
        while (true) {
            try {
                int number1 = fio.nextInt();
                int number2 = fio.nextInt();
                boolean[][] visited = new boolean[GRID_SIZE][GRID_SIZE];
                int[][] distances = new int[GRID_SIZE][GRID_SIZE];
                Queue<Node> bfsQueue = new LinkedList<>();
                Node node = MAPPINGS.get(number1);
                Node destinationNode = MAPPINGS.get(number2);
                bfsQueue.offer(node);
                visited[node.row][node.column] = true;
                while (!bfsQueue.isEmpty()) {
                    node = bfsQueue.poll();
                    int row = node.row;
                    int column = node.column;
                    for (int i = 0; i < 4; i++) {
                        int nextRow = row + MOVES[i][0];
                        int nextColumn = column + MOVES[i][1];
                        if (nextRow >= 0 && nextRow < GRID_SIZE && nextColumn >= 0 && nextColumn < GRID_SIZE
                                && !visited[nextRow][nextColumn] && !isPrime(grid[nextRow][nextColumn])) {
                            visited[nextRow][nextColumn] = true;
                            distances[nextRow][nextColumn] = distances[row][column] + 1;
                            bfsQueue.offer(new Node(nextRow, nextColumn));
                        }
                        if (visited[destinationNode.row][destinationNode.column]) {
                            break;
                        }
                    }
                }
                fio.print("Case " + caseNumber + ": ");
                if (visited[destinationNode.row][destinationNode.column]) {
                    fio.println(distances[destinationNode.row][destinationNode.column]);
                } else {
                    fio.println("impossible");
                }
                caseNumber++;
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
    }

    private static int[][] generateGrid() {
        int[][] grid = new int[GRID_SIZE][GRID_SIZE];
        grid[GRID_SIZE / 2][GRID_SIZE / 2] = 1;
        int x = GRID_SIZE / 2;
        int y = GRID_SIZE / 2;
        MAPPINGS.put(1, new Node(y, x));
        int currentLength = 3;
        int number = 2;
        while (currentLength <= GRID_SIZE) {
            x++;
            grid[y][x] = number;
            MAPPINGS.put(number, new Node(y, x));
            number++;
            for (int i = 0; i < currentLength - 2; i++) {
                y--;
                grid[y][x] = number;
                MAPPINGS.put(number, new Node(y, x));
                number++;
            }
            for (int i = 0; i < currentLength - 1; i++) {
                x--;
                grid[y][x] = number;
                MAPPINGS.put(number, new Node(y, x));
                number++;
            }
            for (int i = 0; i < currentLength - 1; i++) {
                y++;
                grid[y][x] = number;
                MAPPINGS.put(number, new Node(y, x));
                number++;
            }
            for (int i = 0; i < currentLength - 1; i++) {
                x++;
                grid[y][x] = number;
                MAPPINGS.put(number, new Node(y, x));
                number++;
            }
            currentLength += 2;
        }
        return grid;
    }

    private static boolean isPrime(int number) {
        if (number == 2) {
            return true;
        } else if (number % 2 == 0 || number == 1) {
            return false;
        } else {
            for (int i = 3, n = (int) Math.sqrt(number); i <= n; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}

class Node {

    int row;
    int column;

    Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public String toString() {
        return "row: " + row + ", col: " + column;
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

