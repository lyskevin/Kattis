import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int c = fio.nextInt();
        for (int i = 0; i < c; i++) {
            int n = fio.nextInt();
            int t = fio.nextInt();
            int m = fio.nextInt();
            // Add cars to queues on both sides of the river bank
            Queue<Car> leftQueue = new LinkedList<>();
            Queue<Car> rightQueue = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                int arrivalTime = fio.nextInt();
                String side = fio.next();
                if (side.equals("left")) {
                    leftQueue.offer(new Car(j, arrivalTime));
                } else {
                    rightQueue.offer(new Car(j, arrivalTime));
                }
            }
            int time = 0;
            boolean isLeft = true;
            int[] times = new int[m];
            // Simulate ferry crossings while cars remain on either side
            while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
                // Wait for cars to arrive none are on either bank
                if (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
                    if (leftQueue.peek().arrivalTime > time && rightQueue.peek().arrivalTime > time) {
                        time = Math.min(leftQueue.peek().arrivalTime, rightQueue.peek().arrivalTime);
                    }
                } else if (!leftQueue.isEmpty()) {
                    if (leftQueue.peek().arrivalTime > time) {
                        time = leftQueue.peek().arrivalTime;
                    }
                } else if (!rightQueue.isEmpty()) {
                    if (rightQueue.peek().arrivalTime > time) {
                        time = rightQueue.peek().arrivalTime;
                    }
                }
                // Simulate the ferrying of up to n cars across the river
                int remaining = n;
                if (isLeft) {
                    while (!leftQueue.isEmpty() && leftQueue.peek().arrivalTime <= time
                            && remaining > 0) {
                        Car car = leftQueue.poll();
                        times[car.id] = time + t;
                        remaining--;
                    }
                } else {
                    while (!rightQueue.isEmpty() && rightQueue.peek().arrivalTime <= time
                            && remaining > 0) {
                        Car car = rightQueue.poll();
                        times[car.id] = time + t;
                        remaining--;
                    }
                }
                isLeft = !isLeft;
                time += t;
            }
            // Print car unloading times
            for (int j = 0; j < m; j++) {
                fio.println(times[j]);
            }
            if (i < c - 1) {
                fio.println();
            }
        }
        fio.close();
    }
}

class Car {

    int id;
    int arrivalTime;

    Car(int id, int arrivalTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
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

