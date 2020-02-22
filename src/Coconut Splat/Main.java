import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int s = fio.nextInt();
        int n = fio.nextInt();
        Deque<Player> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(new Player(i, 1));
        }
        while (deque.size() > 1) {
            for (int i = 0; i < s - 1; i++) {
                deque.addLast(deque.removeFirst());
            }
            Player player = deque.peek();
            if (player.state == 1) {
                // Split hands and extra hand to front of deque
                player.state++;
                deque.addFirst(new Player(player.id, 2));
            } else {
                player = deque.removeFirst();
                if (player.state == 2) {
                    player.state++;
                    // Only add hand back into deque if current state is a fist
                    deque.addLast(player);
                }
            }
        }
        fio.println(deque.peek().id);
        fio.close();
    }
}

class Player {
    
    int id;
    int state; // 1: folded, 2: fist, 3: palmed down

    Player(int id, int state) {
        this.id = id;
        this.state = state;
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

