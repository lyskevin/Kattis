import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    // Add 1 or -1 to each digit
    private static int[][] MOVES = {{-1, 0, 0, 0}, {1, 0, 0, 0}, {0, -1, 0, 0}, {0, 1, 0, 0},
            {0, 0, -1, 0}, {0, 0, 1, 0}, {0, 0, 0, -1}, {0, 0, 0, 1}};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String start = fio.nextLine();
        String end = fio.nextLine();
        if (start.equals(end)) {
            fio.println(1);
            fio.println(start);
            fio.println(end);
            fio.close();
            return;
        }
        Time startTime = new Time(start.charAt(0) - '0', start.charAt(1) - '0', start.charAt(3) - '0', start.charAt(4) - '0');
        Time endTime = new Time(end.charAt(0) - '0', end.charAt(1) - '0', end.charAt(3) - '0', end.charAt(4) - '0');
        Time[] predecessors = new Time[1440];
        predecessors[startTime.getMinutes()] = startTime;
        Queue<Time> bfsQueue = new LinkedList<>();
        bfsQueue.add(startTime);
        boolean solutionFound = false;
        // BFS
        while (!bfsQueue.isEmpty() && !solutionFound) {
            Time time = bfsQueue.poll();
            for (int i = 0; i < 8; i++) {
                Time nextTime = new Time(time.h1 + MOVES[i][0], time.h2 + MOVES[i][1],
                        time.m1 + MOVES[i][2], time.m2 + MOVES[i][3]);
                if (Time.isValidTime(nextTime) && predecessors[nextTime.getMinutes()] == null) {
                    bfsQueue.add(nextTime);
                    predecessors[nextTime.getMinutes()] = time;
                    if (nextTime.getMinutes() == endTime.getMinutes()) {
                        solutionFound = true;
                    }
                }
            }
        }
        Time predecessor = predecessors[endTime.getMinutes()];
        ArrayList<Time> toPrint = new ArrayList<>();
        while (predecessor.getMinutes() != startTime.getMinutes()) {
            toPrint.add(predecessor);
            predecessor = predecessors[predecessor.getMinutes()];
        }
        fio.println(toPrint.size() + 2);
        fio.println(startTime);
        for (int i = toPrint.size() - 1; i >= 0; i--) {
            fio.println(toPrint.get(i));
        }
        fio.println(endTime);
        fio.close();
    }
}

class Time {

    int h1;
    int h2;
    int m1;
    int m2;

    // Loop the numbers around (10 becomes 0 and -1 becomes 9)
    Time(int h1, int h2, int m1, int m2) {
        this.h1 = h1 % 10;
        if (this.h1 < 0) {
            this.h1 = 9;
        }
        this.h2 = h2 % 10;
        if (this.h2 < 0) {
            this.h2 = 9;
        }
        this.m1 = m1 % 10;
        if (this.m1 < 0) {
            this.m1 = 9;
        }
        this.m2 = m2 % 10;
        if (this.m2 < 0) {
            this.m2 = 9;
        }
    }

    static boolean isValidTime(Time time) {
        int hour = 10 * time.h1 + time.h2;
        int minute = 10 * time.m1 + time.m2;
        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
    }

    int getMinutes() {
        return (10 * h1 + h2) * 60 + (10 * m1 + m2);
    }

    @Override
    public String toString() {
        return String.format("%d%d:%d%d", h1, h2, m1, m2);
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

