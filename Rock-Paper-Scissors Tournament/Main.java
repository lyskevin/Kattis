import java.io.*;
import java.util.*;
import java.text.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        while (n > 0) {
            int k = fio.nextInt();
            Player[] players = new Player[n];
            for (int i = 0; i < n; i++) {
                players[i] = new Player();
            }
            for (int i = 0, t = k * n * (n - 1) / 2; i < t; i++) {
                int player1 = fio.nextInt() - 1;
                String player1Move = fio.next();
                int player2 = fio.nextInt() - 1;
                String player2Move = fio.next();
                if (player1Move.equals("rock") && player2Move.equals("scissors")
                        || player1Move.equals("scissors") && player2Move.equals("paper")
                        || player1Move.equals("paper") && player2Move.equals("rock")) {
                    players[player1].wins += 1;
                    players[player2].losses += 1;
                } else if (player1Move.equals("rock") && player2Move.equals("paper")
                        || player1Move.equals("scissors") && player2Move.equals("rock")
                        || player1Move.equals("paper") && player2Move.equals("scissors")) {
                    players[player1].losses += 1;
                    players[player2].wins += 1;
                }          
            }
            for (int i = 0; i < n; i++) {
                fio.println(players[i].getScore());
            }
            n = fio.nextInt();
            if (n > 0) {
                fio.println();
            }
        }
        fio.close();
    }
}

class Player {

    static DecimalFormat df = new DecimalFormat("0.000");

    int wins;
    int losses;

    Player() {
        wins = 0;
        losses = 0;
    }

    String getScore() {
        if (wins + losses == 0) {
            return "-";
        } else {
            return df.format((1.0 * wins / (wins + losses))) + "";
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

