import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            try {
                int n = fio.nextInt();
                int l = fio.nextInt();
                int w = fio.nextInt();
                Sprinkler[] sprinklers = new Sprinkler[n];
                for (int i = 0; i < n; i++) {
                    sprinklers[i] = new Sprinkler(fio.nextInt(), fio.nextInt(), w);
                }
                Arrays.sort(sprinklers);
                double rightBoundary = 0.0;
                double oldRightBoundary = -10000.0;
                boolean canWaterEntireStrip = true;
                int count = 0;
                for (int i = 0; i < n && canWaterEntireStrip; i++) {
                    Sprinkler sprinkler = sprinklers[i];
                    if (rightBoundary >= l) {
                        break;
                    } else if (sprinkler.leftEndpoint > rightBoundary) {
                        canWaterEntireStrip = false;
                    } else if (sprinkler.leftEndpoint <= rightBoundary) {
                        if (sprinkler.leftEndpoint > oldRightBoundary) {
                            count++;
                            oldRightBoundary = rightBoundary;
                        }
                        rightBoundary = Math.max(rightBoundary, sprinkler.rightEndpoint);
                    }
                }
                if (rightBoundary < l) {
                    canWaterEntireStrip = false;
                }
                if (canWaterEntireStrip) {
                    fio.println(count);
                } else {
                    fio.println(-1);
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
    }
}

class Sprinkler implements Comparable<Sprinkler> {

    static int w;

    int x;
    int r;
    double dx;
    double leftEndpoint;
    double rightEndpoint;

    Sprinkler(int x, int r, int w) {
        this.x = x;
        this.r = r;
        dx = Math.sqrt(r * r - Math.pow(1.0 * w / 2, 2));
        leftEndpoint = x - dx;
        rightEndpoint = x + dx;
    }

    @Override
    public int compareTo(Sprinkler other) {
        if (Double.compare(this.leftEndpoint, other.leftEndpoint) != 0) {
            return Double.compare(this.leftEndpoint, other.leftEndpoint);
        } else {
            return Double.compare(other.rightEndpoint, this.rightEndpoint);
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

