import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int day = fio.nextInt();
            String month = fio.next();
            
            if (month.equals("Mar") && day >= 21 || month.equals("Apr") && day <= 20) {
                fio.println("Aries");
            } else if (month.equals("Apr") && day >= 21 || month.equals("May") && day <= 20) {
                fio.println("Taurus");
            } else if (month.equals("May") && day >= 21 || month.equals("Jun") && day <= 21) {
                fio.println("Gemini");
            } else if (month.equals("Jun") && day >= 22 || month.equals("Jul") && day <= 22) {
                fio.println("Cancer");
            } else if (month.equals("Jul") && day >= 23 || month.equals("Aug") && day <= 22) {
                fio.println("Leo");
            } else if (month.equals("Aug") && day >= 23 || month.equals("Sep") && day <= 21) {
                fio.println("Virgo");
            } else if (month.equals("Sep") && day >= 22 || month.equals("Oct") && day <= 22) {
                fio.println("Libra");
            } else if (month.equals("Oct") && day >= 23 || month.equals("Nov") && day <= 22) {
                fio.println("Scorpio");
            } else if (month.equals("Nov") && day >= 23 || month.equals("Dec") && day <= 21) {
                fio.println("Sagittarius");
            } else if (month.equals("Dec") && day >= 22 || month.equals("Jan") && day <= 20) {
                fio.println("Capricorn");
            } else if (month.equals("Jan") && day >= 21 || month.equals("Feb") && day <= 19) {
                fio.println("Aquarius");
            } else {
                fio.println("Pisces");
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

