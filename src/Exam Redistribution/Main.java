import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        Room[] rooms = new Room[n];
        for (int i = 0; i < n; i++) {
            rooms[i] = new Room(i + 1, fio.nextInt());
        }
        Arrays.sort(rooms);
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += rooms[i].students;
        }
        // Impossible if first room contains more students than the rest of the rooms combined
        if (sum < rooms[0].students) {
            fio.println("impossible");
        } else {
            // Greedily pick rooms by non-increasing number of students
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    fio.print(" ");
                }
                fio.print(rooms[i].number);
            }
            fio.println();
        }
        fio.close();
    }
}

class Room implements Comparable<Room> {

    int number;
    int students;

    Room(int number, int students) {
        this.number = number;
        this.students = students;
    }

    @Override
        public int compareTo(Room other) {
            return other.students - this.students;
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
