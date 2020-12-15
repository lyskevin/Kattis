import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        // Time zone --> Difference in minutes from UTC
        HashMap<String, Integer> map = new HashMap<>();
        map.put("UTC", 0);
        map.put("GMT", 0);
        map.put("BST", 60);
        map.put("IST", 60);
        map.put("WET", 0);
        map.put("WEST", 60);
        map.put("CET", 60);
        map.put("CEST", 120);
        map.put("EET", 120);
        map.put("EEST", 180);
        map.put("MSK", 180);
        map.put("MSD", 240);
        map.put("AST", -240);
        map.put("ADT", -180);
        map.put("NST", -210);
        map.put("NDT", -150);
        map.put("EST", -300);
        map.put("EDT", -240);
        map.put("CST", -360);
        map.put("CDT", -300);
        map.put("MST", -420);
        map.put("MDT", -360);
        map.put("PST", -480);
        map.put("PDT", -420);
        map.put("HST", -600);
        map.put("AKST", -540);
        map.put("AKDT", -480);
        map.put("AEST", 600);
        map.put("AEDT", 660);
        map.put("ACST", 570);
        map.put("ACDT", 630);
        map.put("AWST", 480);

        int N = fio.nextInt();
        for (int i = 0; i < N; i++) {
            String[] input = fio.nextLine().split(" ");
            String tz1 = input[input.length - 2];
            String tz2 = input[input.length - 1];
            int time;
            if (input.length == 4) {
                String[] timeDetails = input[0].split(":");
                // 12th hour contributes 0 hours of time (ignoring AM/PM)
                int hours = Integer.parseInt(timeDetails[0]) % 12;
                int minutes = Integer.parseInt(timeDetails[1]);
                time =  hours * 60 + minutes;
                // PM contributes 12 hours
                if (input[1].equals("p.m.")) {
                    time += 720;
                }
            } else {
                if (input[0].equals("noon")) {
                    time = 720;
                } else {
                    time = 0;
                }
            }
            int tzDifference = map.get(tz2) - map.get(tz1);
            // + 1440 to handle cases where time zone difference < 0 and the sum becomes < 0
            int newTime = (time + 1440 + tzDifference) % 1440;
            if (newTime == 0) {
                fio.println("midnight");
            } else if (newTime == 720) {
                fio.println("noon");
            } else {
                boolean isAm = newTime < 720;
                int hours = (newTime % 720) / 60;
                int minutes = newTime % 60;
                // Turn 0 hours back into 12th hour
                if (hours == 0) {
                    hours = 12;
                }
                // Minutes have to be formatted with 2 digits and 0-padding
                fio.print(String.format("%d:%02d ", hours, minutes));
                if (isAm) {
                    fio.println("a.m.");
                } else {
                    fio.println("p.m.");
                }
            }
        }

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

