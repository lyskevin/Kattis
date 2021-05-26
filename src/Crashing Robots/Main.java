import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int K = fio.nextInt();

        for (int i = 0; i < K; i++) {
            int A = fio.nextInt();
            int B = fio.nextInt();
            int[][] grid = new int[B][A];
            int N = fio.nextInt();
            int M = fio.nextInt();
            HashMap<Integer, Robot> robots = new HashMap<>();

            for (int j = 0; j < N; j++) {
                int X = fio.nextInt() - 1;
                int Y = fio.nextInt() - 1;
                String direction = fio.next();
                grid[Y][X] = j + 1;
                int directionNumber;

                if (direction.equals("N")) {
                    directionNumber = 0;
                } else if (direction.equals("E")) {
                    directionNumber = 1;
                } else if (direction.equals("S")) {
                    directionNumber = 2;
                } else {
                    directionNumber = 3;
                }

                robots.put(j + 1, new Robot(j + 1, X, Y, directionNumber));
            }

            boolean hasCrash = false;

            for (int j = 0; j < M; j++) {
                int number = fio.nextInt();
                String action = fio.next();
                int repeat = fio.nextInt();

                for (int k = 0; k < repeat && !hasCrash; k++) {
                    Robot robot = robots.get(number);
                    Robot newRobot = robot.execute(action);
                    int x = newRobot.x;
                    int y = newRobot.y;

                    if (x < 0 || x >= A || y < 0 || y >= B) {
                        hasCrash = true;
                        fio.println("Robot " + robot.number + " crashes into the wall");
                    } else if (grid[y][x] > 0 && grid[y][x] != newRobot.number) {
                        hasCrash = true;
                        fio.println("Robot " + robot.number + " crashes into robot " + grid[y][x]);
                    } else {
                        grid[robot.y][robot.x] = 0;
                        grid[y][x] = newRobot.number;
                        robots.put(number, newRobot);
                    }
                }
            }

            if (!hasCrash) {
                fio.println("OK");
            }
        }

        fio.close();
    }
}

class Robot {
    int number;
    int x;
    int y;
    int direction;

    Robot(int number, int x, int y, int direction) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    Robot execute(String action) {
        if (action.equals("L")) {
            return new Robot(number, x, y, (direction + 3) % 4);
        } else if (action.equals("R")) {
            return new Robot(number, x, y, (direction + 1) % 4);
        } else {
            switch (direction) {
                case 0:
                    return new Robot(number, x, y + 1, direction);
                case 1:
                    return new Robot(number, x + 1, y, direction);
                case 2:
                    return new Robot(number, x, y - 1, direction);
                default:
                    return new Robot(number, x - 1, y, direction);
            }
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

