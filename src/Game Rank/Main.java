import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        Player player = new Player();
        String s = fio.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'W') {
                player.addWin();
            } else {
                player.addLoss();
            }
        }

        if (player.rank == 0) {
            fio.println("Legend");
        } else {
            fio.println(player.rank);
        }
        fio.close();
    }
}

class Player {
    int rank;
    int numberOfStars;
    int numberOfConsecutiveWins;

    Player() {
        rank = 25;
        numberOfStars = 0;
        numberOfConsecutiveWins = 0;
    }

    void addWin() {

        // Legend rank
        if (rank == 0) {
            return;
        }

        numberOfConsecutiveWins++;
        numberOfStars++;

        if (numberOfConsecutiveWins >= 3 && rank >= 6) {
            numberOfStars++;
        }

        int numberOfStarsRequiredToRankUp = numberOfStarsRequiredToRankUp();

        // Check if player ranked up
        if (numberOfStars > numberOfStarsRequiredToRankUp) {
            numberOfStars = numberOfStars - numberOfStarsRequiredToRankUp;
            rank--;
        }
    }

    void addLoss() {
        numberOfConsecutiveWins = 0;

        // Legend rank
        if (rank == 0) {
            return;
        }

        if (numberOfStars == 0 && rank < 20) { // Drop one rank
            rank++;
            numberOfStars = numberOfStarsRequiredToRankUp() - 1;
        } else if (rank <= 20 && numberOfStars > 0) { // Lost one star
            numberOfStars--;
        }
    }

    int numberOfStarsRequiredToRankUp() {
        if (rank >= 21) {
            return 2;
        } else if (rank >= 16) {
            return 3;
        } else if (rank >= 11) {
            return 4;
        } else {
            return 5;
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

