import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        PriorityQueue<Song> songs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            songs.offer(new Song(fio.nextLong(), fio.next(), i));
        }
        for (int i = 0; i < m; i++) {
            fio.println(songs.poll().name);
        }
        fio.close();
    }
}

class Song implements Comparable<Song> {
    
    long frequency;
    String name;
    int position;

    Song(long frequency, String name, int position) {
        this.frequency = frequency;
        this.name = name;
        this.position = position + 1;
    }

    long getQuality() {
        return frequency * position;
    }

    @Override
    public int compareTo(Song other) {
        if (Long.compare(this.getQuality(), other.getQuality()) != 0) {
            return -1 * Long.compare(this.getQuality(), other.getQuality());
        } else {
            return this.position - other.position;
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

