import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int F = fio.nextInt();
        int B = fio.nextInt();
        List<Gear> gears = new ArrayList<>();

        int[] frontSprockets = new int[F];
        for (int i = 0; i < F; i++) {
            frontSprockets[i] = fio.nextInt();
        }
        
        int[] backSprockets = new int[B];
        for (int i = 0; i < B; i++) {
            backSprockets[i] = fio.nextInt();
        }

        for (int i = 0; i < F; i++) {
            for (int j = 0; j < B; j++) {
                gears.add(new Gear(frontSprockets[i], backSprockets[j]));
            }
        }

        Collections.sort(gears);
        
        for (Gear gear : gears) {
            fio.println(gear);
        }

        fio.close();
    }
}

class Gear implements Comparable<Gear> {
    long f;
    long b;

    Gear(int f, int b) {
        this.f = f;
        this.b = b;
    }

    @Override
    public int compareTo(Gear other) {
        long value1 = this.f * other.b;
        long value2 = other.f * this.b;
        if (value1 != value2) {
            return Long.compare(value1, value2);
        }
        return (int) (this.f - other.f);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", this.f, this.b);
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

