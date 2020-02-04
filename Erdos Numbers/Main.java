import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        // Use HashMap for the adjacency list
        HashMap<String, HashSet<String>> adjList = new HashMap<>();
        // Store authors in the order that they appear in the database
        ArrayList<String> orderedAuthors = new ArrayList<>();
        while (true) {
            try {
                String[] authors = fio.nextLine().split(" ");
                orderedAuthors.add(authors[0]);
                if (!adjList.containsKey(authors[0])) {
                    adjList.put(authors[0], new HashSet<>());
                }
                HashSet<String> coAuthors = adjList.get(authors[0]);
                for (int i = 1; i < authors.length; i++) {
                    coAuthors.add(authors[i]);
                    if (adjList.containsKey(authors[i])) {
                        adjList.get(authors[i]).add(authors[0]);
                    } else {
                        HashSet<String> otherCoAuthors = new HashSet<>();
                        otherCoAuthors.add(authors[0]);
                        adjList.put(authors[i], otherCoAuthors);
                    }
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        // Standard BFS
        Queue<Vertex> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new Vertex("PAUL_ERDOS", 0));
        HashMap<String, Integer> visitedAuthors = new HashMap<>();
        visitedAuthors.put("PAUL_ERDOS", 0);
        while (!bfsQueue.isEmpty()) {
            Vertex u = bfsQueue.poll();
            for (String coAuthor : adjList.get(u.author)) {
                if (!visitedAuthors.containsKey(coAuthor)) {
                    visitedAuthors.put(coAuthor, u.distance + 1);
                    bfsQueue.offer(new Vertex(coAuthor, u.distance + 1));
                }
            }
        }
        for (String author : orderedAuthors) {
            if (visitedAuthors.containsKey(author)) {
                fio.println(author + " " + visitedAuthors.get(author));
            } else {
                fio.println(author + " no-connection");
            }
        }
        fio.close();
    }
}

class Vertex {

    String author;
    int distance;

    Vertex(String author, int distance) {
        this.author = author;
        this.distance = distance;
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

