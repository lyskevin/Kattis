import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String input = fio.nextLine();
        while (input != null) {
            String[] numbers = input.split(" ");
            int r = Integer.parseInt(numbers[0]);
            int c = Integer.parseInt(numbers[1]);
            int gr = Integer.parseInt(numbers[2]) - 1;
            int gc = Integer.parseInt(numbers[3]) - 1;
            int lr = Integer.parseInt(numbers[4]) - 1;
            int lc = Integer.parseInt(numbers[5]) - 1;
            boolean[][] isVisited = new boolean[r][c];
            Queue<Coordinates> bfsQueue = new LinkedList<>();
            bfsQueue.offer(new Coordinates(gr, gc, 0));
            boolean isPossible = false;
            int numberOfSteps = 0;
            while (!bfsQueue.isEmpty()) {
                Coordinates current = bfsQueue.poll();
                int row = current.row;
                int col = current.col;
                if (row == lr && col == lc) {
                    isPossible = true;
                    numberOfSteps = current.numberOfSteps;
                    break;
                } else {
                    if (row - 2 >= 0 && col - 1 >= 0 && !isVisited[row - 2][col - 1]) {
                        isVisited[row - 2][col - 1] = true;
                        bfsQueue.offer(new Coordinates(row - 2, col - 1, current.numberOfSteps + 1));
                    }
                    if (row - 1 >= 0 && col - 2 >= 0 && !isVisited[row - 1][col - 2]) {
                        isVisited[row - 1][col - 2] = true;
                        bfsQueue.offer(new Coordinates(row - 1, col - 2, current.numberOfSteps + 1));
                    }
                    if (row + 1 < r && col - 2 >= 0 && !isVisited[row + 1][col - 2]) {
                        isVisited[row + 1][col - 2] = true;
                        bfsQueue.offer(new Coordinates(row + 1, col - 2, current.numberOfSteps + 1));
                    }
                    if (row + 2 < r && col - 1 >= 0 && !isVisited[row + 2][col - 1]) {
                        isVisited[row + 2][col - 1] = true;
                        bfsQueue.offer(new Coordinates(row + 2, col - 1, current.numberOfSteps + 1));
                    }
                    if (row + 2 < r && col + 1 < c && !isVisited[row + 2][col + 1]) {
                        isVisited[row + 2][col + 1] = true;
                        bfsQueue.offer(new Coordinates(row + 2, col + 1, current.numberOfSteps + 1));
                    }
                    if (row + 1 < r && col + 2 < c && !isVisited[row + 1][col + 2]) {
                        isVisited[row + 1][col + 2] = true;
                        bfsQueue.offer(new Coordinates(row + 1, col + 2, current.numberOfSteps + 1));
                    }
                    if (row - 1 >= 0 && col + 2 < c && !isVisited[row - 1][col + 2]) {
                        isVisited[row - 1][col + 2] = true;
                        bfsQueue.offer(new Coordinates(row - 1, col + 2, current.numberOfSteps + 1));
                    }
                    if (row - 2 >= 0 && col + 1 < c && !isVisited[row - 2][col + 1]) {
                        isVisited[row - 2][col + 1] = true;
                        bfsQueue.offer(new Coordinates(row - 2, col + 1, current.numberOfSteps + 1));
                    }
                }
            }
            if (isPossible) {
                fio.println(numberOfSteps);
            } else {
                fio.println("impossible");
            }
            input = fio.nextLine();
        }
        fio.close();
    }
}

class Coordinates {

    int row;
    int col;
    int numberOfSteps;

    Coordinates(int row, int col, int numberOfSteps) {
        this.row = row;
        this.col = col;
        this.numberOfSteps = numberOfSteps;
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
            } catch (NullPointerException e) {
                break;
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

