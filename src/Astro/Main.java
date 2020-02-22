import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int firstStarFlash = timeToMinutes(fio.nextLine());
        int secondStarFlash = timeToMinutes(fio.nextLine());
        int firstStarDifference = timeToMinutes(fio.nextLine());
        int secondStarDifference = timeToMinutes(fio.nextLine());
        boolean[] firstStarFlashes = new boolean[10000000];
        int index = firstStarFlash;
        // Record first star's flash timings
        while (index < 10000000) {
            firstStarFlashes[index] = true;
            index += firstStarDifference;
        }
        index = secondStarFlash;
        boolean sameTimeFound = false;
        int sameFlashTime = 0;
        // Check if any of the second star's flash timings coincide with those of the first star
        while (index < 10000000 && !sameTimeFound) {
            if (firstStarFlashes[index]) {
                sameTimeFound = true;
                sameFlashTime = index;
            }
            index += secondStarDifference;
        }
        // Print flash time if one is found
        if (sameTimeFound) {
            int day = sameFlashTime / 1440 % 7;
            switch (day) {
                case 0:
                    fio.println("Saturday");
                    break;
                case 1:
                    fio.println("Sunday");
                    break;
                case 2:
                    fio.println("Monday");
                    break;
                case 3:
                    fio.println("Tuesday");
                    break;
                case 4:
                    fio.println("Wednesday");
                    break;
                case 5:
                    fio.println("Thursday");
                    break;
                default:
                    fio.println("Friday");
                    break;
            }
            fio.println(minutesToTime(sameFlashTime % 1440));
        } else {
            fio.println("Never");
        }
        fio.close();
    }

    private static int timeToMinutes(String time) {
        String[] hoursAndMinutes = time.split(":");
        return Integer.parseInt(hoursAndMinutes[0]) * 60 + Integer.parseInt(hoursAndMinutes[1]);
    }

    private static String minutesToTime(int minutes) {
        return String.format("%02d:%02d", minutes / 60, minutes % 60);
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

