import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.lang.Comparable;

/**
 * @author lyskevin
 */
public class Main {

    private static final int INF = 2000000000;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int length = fr.nextInt();
        int width = fr.nextInt();
        int[][] heights = new int[length][width];
        int distances[][] = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                heights[i][j] = fr.nextInt();
                distances[i][j] = INF;
            }
        }
        distances[0][0] = 0;
        PriorityQueue<Coordinates> coordinatesPQ = new PriorityQueue<>();
        coordinatesPQ.offer(new Coordinates(0, 0, 0));
        while (!coordinatesPQ.isEmpty()) {
            Coordinates coordinates = coordinatesPQ.poll();
            int row = coordinates.row;
            int column = coordinates.column;
            int distance = coordinates.distance;
            if (distance == distances[row][column]) {
                int top = row - 1;
                int bottom = row + 1;
                int left = column - 1;
                int right = column + 1;
                if (top >= 0 && (distances[top][column] > Math.max(distances[row][column]
                        , Math.max(0, heights[top][column] - heights[row][column])))) {
                    distances[top][column] = Math.max(distances[row][column], Math.max(0,
                            heights[top][column] - heights[row][column]));
                    coordinatesPQ.offer(new Coordinates(top, column, distances[top][column]));
                }
                if (bottom < length && (distances[bottom][column]
                        > Math.max(distances[row][column], Math.max(0,
                        heights[bottom][column] - heights[row][column])))) {
                    distances[bottom][column] = Math.max(distances[row][column],
                            Math.max(0, heights[bottom][column] - heights[row][column]));
                    coordinatesPQ.offer(new Coordinates(bottom, column,
                            distances[bottom][column]));
                }
                if (left >= 0 && (distances[row][left] > Math.max(distances[row][column]
                        , Math.max(0, heights[row][left] - heights[row][column])))) {
                    distances[row][left] = Math.max(distances[row][column], Math.max(0,
                            heights[row][left] - heights[row][column]));
                    coordinatesPQ.offer(new Coordinates(row, left, distances[row][left]));
                }
                if (right < width && (distances[row][right] > Math.max(distances[row][column]
                        , Math.max(0, heights[row][right] - heights[row][column])))) {
                    distances[row][right] = Math.max(distances[row][column], Math.max(0,
                            heights[row][right] - heights[row][column]));
                    coordinatesPQ.offer(new Coordinates(row, right, distances[row][right]));
                }
            }
        }
        System.out.println(distances[length - 1][width - 1]);
    }

    private static int rowColumnToPosition(int row, int column, int width) {
        return row * width + column;
    }

}

class Coordinates implements Comparable<Coordinates> {

    int row;
    int column;
    int distance;

    Coordinates(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
    }

    @Override
    public int compareTo(Coordinates other) {
        return this.distance - other.distance;
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

