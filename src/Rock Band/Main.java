import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int m = fio.nextInt();
        int s = fio.nextInt();
        int[] songRanks = new int[s + 1];
        int[] firstList = new int[s];
        // Store the first input list (in order to get the output in sorted order later on)
        for (int i = 0; i < s; i++) {
            int song = fio.nextInt();
            firstList[i] = song;
            songRanks[song] = i;
        }
        // Store the maximum rank of each song
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < s; j++) {
                int song = fio.nextInt();
                songRanks[song] = Math.max(songRanks[song], j);
            }
        }
        int index = 0;
        int song = firstList[index];
        // Jump to the song whose maximum rank is less than or equal to its index in the input list.
        // We cannot use a song whose maximum rank is greater than its index in the first input list
        // since another singer has a higher rank for that song, so some songs will not be accounted for.
        while (songRanks[song] > index) {
            index = songRanks[song];
            song = firstList[index];
        }
        // Sort and print the required set of songs
        int[] sortedSongs = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            sortedSongs[i] = firstList[i];
        }
        fio.println(index + 1);
        Arrays.sort(sortedSongs);
        for (int i = 0; i < index + 1; i++) {
            if (i > 0) {
                fio.print(" ");
            }
            fio.print(sortedSongs[i]);
        }
        fio.println();
        fio.close();
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

