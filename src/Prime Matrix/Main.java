import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        Reader r = new Reader();
        try {
            int n = r.nextInt();
            long b = r.nextLong();
            int smallestSum = n * (n + 1) / 2;
            int toAdd = 0;
            // Find smallest possible prime number that can be generated from
            // n distinct numbers given the bound b
            while (!isPrime(smallestSum + toAdd)) {
                toAdd++;
            }
            // Can add up to (b - n) to each number to get to the smallest prime
            if (toAdd > (b - n) * n) {
                r.println("impossible");
            } else {
                // Generate valid row
                int[] row = new int[n];
                for (int i = n - 1; i >= 0; i--) {
                    row[i] = i + 1;
                    // Add to each number if necessary
                    row[i] += toAdd > b - n ? b - n : toAdd;
                    toAdd -= toAdd > b - n ? b - n : toAdd;
                }
                // Print prime matrix by rotating valid row
                // by one position at each iteration
                for (int i = 0; i < n; i++) {
                    boolean isFirstEntry = true;
                    for (int j = i; j < n; j++) {
                        if (isFirstEntry) {
                            isFirstEntry = false;
                        } else {
                            r.print(" ");
                        }
                        r.print(row[j]);
                    }
                    for (int j = 0; j < i; j++) {
                        if (isFirstEntry) {
                            isFirstEntry = false;
                        } else {
                            r.print(" ");
                        }
                        r.print(row[j]);
                    }
                    r.println();
                }
            }
        } catch (IOException e) {
        }
        r.close();
    }

    private static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        } else if (n < 2 || n % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= (int) Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class Reader extends PrintWriter 
{ 
    final private int BUFFER_SIZE = 1 << 16; 
    private DataInputStream din; 
    private byte[] buffer; 
    private int bufferPointer, bytesRead; 

    public Reader() 
    { 
        super(new BufferedOutputStream(System.out));
        din = new DataInputStream(System.in); 
        buffer = new byte[BUFFER_SIZE]; 
        bufferPointer = bytesRead = 0;
    } 

    public Reader(String file_name) throws IOException 
    { 
        super(new BufferedOutputStream(System.out));
        din = new DataInputStream(new FileInputStream(file_name)); 
        buffer = new byte[BUFFER_SIZE]; 
        bufferPointer = bytesRead = 0; 
    } 

    public String readLine() throws IOException 
    { 
        byte[] buf = new byte[64]; // line length 
        int cnt = 0, c; 
        while ((c = read()) != -1) 
        { 
            if (c == '\n') 
                break; 
            buf[cnt++] = (byte) c; 
        } 
        return new String(buf, 0, cnt); 
    } 

    public int nextInt() throws IOException 
    { 
        int ret = 0; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 
        do
        { 
            ret = ret * 10 + c - '0'; 
        }  while ((c = read()) >= '0' && c <= '9'); 

        if (neg) 
            return -ret; 
        return ret; 
    } 

    public long nextLong() throws IOException 
    { 
        long ret = 0; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 
        do { 
            ret = ret * 10 + c - '0'; 
        } 
        while ((c = read()) >= '0' && c <= '9'); 
        if (neg) 
            return -ret; 
        return ret; 
    } 

    public double nextDouble() throws IOException 
    { 
        double ret = 0, div = 1; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 

        do { 
            ret = ret * 10 + c - '0'; 
        } 
        while ((c = read()) >= '0' && c <= '9'); 

        if (c == '.') 
        { 
            while ((c = read()) >= '0' && c <= '9') 
            { 
                ret += (c - '0') / (div *= 10); 
            } 
        } 

        if (neg) 
            return -ret; 
        return ret; 
    } 

    private void fillBuffer() throws IOException 
    { 
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
        if (bytesRead == -1) 
            buffer[0] = -1; 
    } 

    private byte read() throws IOException 
    { 
        if (bufferPointer == bytesRead) 
            fillBuffer(); 
        return buffer[bufferPointer++]; 
    } 

}

