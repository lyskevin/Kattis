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
        int numberOfOperations = fio.nextInt();
        int[] teque = new int[6000000];
        int leftFront = 2000000;
        int leftBack = 2000001;
        int rightFront = 4000000;
        int rightBack = 4000001;
        for (int i = 0; i < numberOfOperations; i++) {
            String operation = fio.next();
            int number = fio.nextInt();
            if (operation.equals("push_front")) {
                teque[leftFront] = number;
                leftFront--;
            } else if (operation.equals("push_back")) {
                teque[rightBack] = number;
                rightBack++;
            } else if (operation.equals("push_middle")) {
                teque[rightFront] = number;
                rightFront--;
            } else {
                if (leftBack - leftFront - 2 >= number) {
                    fio.println(teque[leftFront + 1 + number]);
                } else {
                    fio.println(teque[rightFront + 1 + number - (leftBack - leftFront - 1)]);
                }
            }
            if (leftBack - leftFront < rightBack - rightFront) {
                teque[leftBack] = teque[rightFront + 1];
                leftBack++;
                rightFront++;
            } else if (leftBack - leftFront > rightBack - rightFront + 1) {
                teque[rightFront] = teque[leftBack - 1];
                leftBack--;
                rightFront--;
            }
        }
        fio.close();
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

