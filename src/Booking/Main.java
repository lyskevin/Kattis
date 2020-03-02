import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_YEAR_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int b = fio.nextInt();
            int c = fio.nextInt();
            int[] bookingStarts = new int[b];
            int[] bookingEnds = new int[b];
            for (int j = 0; j < b; j++) {
                String id = fio.next();
                String startDate = fio.next();
                String startTime = fio.next();
                String endDate = fio.next();
                String endTime = fio.next();
                bookingStarts[j] = getTimeInMinutes(startDate, startTime);
                bookingEnds[j] = getTimeInMinutes(endDate, endTime) + c;
            }
            Arrays.sort(bookingStarts);
            Arrays.sort(bookingEnds);
            // Merge routine to count maximum number of overlaps = minimum number of rooms needed
            int startIndex = 0;
            int endIndex = 0;
            int current = 0;
            int max = 0;
            while (startIndex < b && endIndex < b) {
                if (bookingStarts[startIndex] < bookingEnds[endIndex]) {
                    current++;
                    max = Math.max(max, current);
                    startIndex++;
                } else {
                    current--;
                    endIndex++;
                }
            }
            fio.println(max);
        }
        fio.close();
    }

    private static int getTimeInMinutes(String date, String time) {
        String[] dateInformation = date.split("-");
        String[] timeInformation = time.split(":");
        int year = Integer.parseInt(dateInformation[0]);
        int month = Integer.parseInt(dateInformation[1]);
        int day = Integer.parseInt(dateInformation[2]);
        int hour = Integer.parseInt(timeInformation[0]);
        int minutes = Integer.parseInt(timeInformation[1]);
        int result = 0;
        result += (year - 2013) * 365 * 1440; // Add years
        // Add months
        for (int i = 0; i < month - 1; i++) {
            if (year == 2016) {
                result += LEAP_YEAR_DAYS[i] * 1440;
            } else {
                result += DAYS[i] * 1440;
            }
        }
        result += (day - 1) * 1440; // Add days
        result += hour * 60 + minutes; // Add hours and minutes
        return result;
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

