import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int k = fio.nextInt();
        Tuple[] attackStats = new Tuple[n];
        Tuple[] defenceStats = new Tuple[n];
        Tuple[] healthStats = new Tuple[n];
        for (int i = 0; i < n; i++) {
            attackStats[i] = new Tuple(i, fio.nextLong());
            defenceStats[i] = new Tuple(i, fio.nextLong());
            healthStats[i] = new Tuple(i, fio.nextLong());
        }
        Arrays.sort(attackStats);
        Arrays.sort(defenceStats);
        Arrays.sort(healthStats);
        HashSet<Integer> pokenoms = new HashSet<>();
        for (int i = 0; i < k; i++) {
            pokenoms.add(attackStats[i].id);
            pokenoms.add(defenceStats[i].id);
            pokenoms.add(healthStats[i].id);
        }
        fio.println(pokenoms.size());
        fio.close();
    }
}

class Tuple implements Comparable<Tuple> {

    int id;
    long stat;

    Tuple(int id, long stat) {
        this.id = id;
        this.stat = stat;
    }

    @Override
    public int compareTo(Tuple other) {
        return Long.compare(other.stat, this.stat);
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

