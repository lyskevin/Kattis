import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int numberOfTestCases = fio.nextInt();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numberOfTestCases; i++) {
            int shipLength = fio.nextInt() * 100;
            int numberOfCars = fio.nextInt();
            Queue<Integer> leftQueue = new LinkedList<>();
            Queue<Integer> rightQueue = new LinkedList<>();
            for (int j = 0; j < numberOfCars; j++) {
                int carLength = fio.nextInt();
                String side = fio.next();
                if (side.equals("left")) {
                    leftQueue.offer(carLength);
                } else {
                    rightQueue.offer(carLength);
                }
            }
            boolean isLeft = true;
            int numberOfTrips = 0;
            while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
                int remainingLength = shipLength;
                if (isLeft) {
                    while (!leftQueue.isEmpty() && remainingLength >= leftQueue.peek()) {
                        remainingLength -= leftQueue.poll();
                    }
                } else {
                    while (!rightQueue.isEmpty() && remainingLength >= rightQueue.peek()) {
                        remainingLength -= rightQueue.poll();
                    }
                }
                numberOfTrips++;
                isLeft = !isLeft;
            }
            output.append(numberOfTrips + "\n");
        }
        System.out.print(output);
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

