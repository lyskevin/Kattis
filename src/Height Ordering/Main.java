import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int p = fio.nextInt();
        for (int i = 0; i < p; i++) {
            int dataset = fio.nextInt();
            int[] data = new int[20];
            for (int j = 0; j < 20; j++) {
                data[j] = fio.nextInt();
            }
            fio.println(dataset + " " + countSteps(data));
        }
        fio.close();
    }

    // Simulate insertion sort and count the number of steps taken
    private static int countSteps(int[] data) {
        int numberOfSteps = 0;
        for (int i = 1; i < 20; i++) {
            int index = 0;
            int number = data[i];
            while (index < i && number >= data[index]) {
                index++;
            }
            for (int j = i; j > index; j--) {
                data[j] = data[j - 1];
            }
            numberOfSteps += (i - index);
            data[index] = number;
        }
        return numberOfSteps;
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

