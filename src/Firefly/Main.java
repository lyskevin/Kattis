import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int h = fio.nextInt();
        int[] stalagmites = new int[n / 2];
        int[] stalactites = new int[n / 2];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                stalagmites[i / 2] = fio.nextInt();
            } else {
                stalactites[i / 2] = fio.nextInt();
            }
        }
        Arrays.sort(stalagmites);
        Arrays.sort(stalactites);
        int minimum = n;
        int count = 0;
        // Brute force all possible heights
        for (int i = 1; i <= h; i++) {
            // Binary search through both sorted arrays to find the number of obstacles
            int numberOfObstacles = binarySearch(i, stalagmites, 0, (n / 2) - 1);
            numberOfObstacles += binarySearch(h - i + 1, stalactites, 0, (n / 2) - 1);
            if (numberOfObstacles == minimum) {
                count++;
            } else if (numberOfObstacles < minimum) {
                minimum = numberOfObstacles;
                count = 1;
            }
        }
        fio.println(minimum + " " + count);
        fio.close();
    }

    public static int binarySearch(int height, int[] obstacles, int low, int high) {
        if (height <= obstacles[0]) {
            return obstacles.length;
        } else if (height > obstacles[obstacles.length - 1]) {
            return 0;
        } else {
            int middle = (low + high) / 2;
            if (middle == obstacles.length - 1) {
                return middle + 1;
            } else if (middle < obstacles.length - 1 && obstacles[middle] < height &&
                    obstacles[middle + 1] >= height) {
                return obstacles.length - middle - 1;
            } else if (obstacles[middle] < height) {
                return binarySearch(height, obstacles, middle + 1, high);
            } else {
                return binarySearch(height, obstacles, low, middle - 1);
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

