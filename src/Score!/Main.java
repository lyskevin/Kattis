import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        Data[] data = new Data[n];

        for (int i = 0; i < n; i++) {
            data[i] = new Data(fio.nextLine());
        }

        int awayTime = 0;
        int homeTime = 0;
        int difference = 0;

        for (int i = 0; i < n; i++) {
            int nextTime = i == n - 1 ? 32 * 60 : data[i + 1].time;
            difference += data[i].team == 'H' ? data[i].points : -1 * data[i].points;
            if (difference > 0) {
                homeTime += nextTime - data[i].time;
            } else if (difference < 0) {
                awayTime += nextTime - data[i].time;
            }
        }

        String winner = difference > 0 ? "H" : "A";
        int awayMins = awayTime / 60;
        int awaySeconds = awayTime % 60;
        int homeMins = homeTime / 60;
        int homeSeconds = homeTime % 60;

        fio.println(String.format("%s %d:%02d %d:%02d", winner, homeMins, homeSeconds, awayMins, awaySeconds));

        fio.close();
    }
}

class Data {
    char team;
    int points;
    int time;

    Data(String input) {
        String[] data = input.split(" ");
        team = data[0].charAt(0);
        points = Integer.parseInt(data[1]);
        String[] timeData = data[2].split(":");
        time = Integer.parseInt(timeData[0]) * 60 + Integer.parseInt(timeData[1]);
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

