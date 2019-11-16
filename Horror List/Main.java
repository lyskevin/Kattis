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
        int l = fio.nextInt();
        ArrayList<Integer> horrorList = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            horrorList.add(fio.nextInt());
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] ratings = new int[n];
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            ratings[i] = 1000000000;
        }
        for (int i = 0; i < l; i++) {
            int movie1 = fio.nextInt();
            int movie2 = fio.nextInt();
            adjList.get(movie1).add(movie2);
            adjList.get(movie2).add(movie1);
        }
        for (int i = 0; i < h; i++) {
            int sourceMovie = horrorList.get(i);
            ratings[sourceMovie] = 0;
            Queue<Movie> bfsQueue = new LinkedList<>();
            bfsQueue.add(new Movie(sourceMovie, 0));
            while (!bfsQueue.isEmpty()) {
                Movie movie = bfsQueue.poll();
                for (int similarMovie : adjList.get(movie.id)) {
                    if (ratings[similarMovie] > movie.rating + 1) {
                        ratings[similarMovie] = movie.rating + 1;
                        bfsQueue.add(new Movie(similarMovie, movie.rating + 1));
                    }
                }
            }
        }
        int maxRating = 0;
        for (int i = 0; i < n; i++) {
            maxRating = Math.max(maxRating, ratings[i]);
        }
        for (int i = 0; i < n; i++) {
            if (ratings[i] == maxRating) {
                fio.println(i);
                break;
            }
        }
        fio.close();
    }
}

class Movie {

    int id;
    int rating;

    Movie(int id, int rating) {
        this.id = id;
        this.rating = rating;
    }
    
    public String toString() {
        return "id: " + id + ", rating: " + rating;
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
