import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String s = fio.nextLine();
        String[] input = s.split("/");
        int[] numbers = {Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])};
        MyDate date = null;
        // Try all 6 date permutations
        if (MyDate.isValidDate(numbers[0], numbers[1], numbers[2])) {
            date = new MyDate(numbers[0], numbers[1], numbers[2]);
        }
        if (MyDate.isValidDate(numbers[0], numbers[2], numbers[1])) {
            MyDate newDate = new MyDate(numbers[0], numbers[2], numbers[1]);
            if (date == null || newDate.compareTo(date) < 0) {
                date = newDate;
            }
        }
        if (MyDate.isValidDate(numbers[1], numbers[0], numbers[2])) {
            MyDate newDate = new MyDate(numbers[1], numbers[0], numbers[2]);
            if (date == null || newDate.compareTo(date) < 0) {
                date = newDate;
            }
        }
        if (MyDate.isValidDate(numbers[1], numbers[2], numbers[0])) {
            MyDate newDate = new MyDate(numbers[1], numbers[2], numbers[0]);
            if (date == null || newDate.compareTo(date) < 0) {
                date = newDate;
            }
        }
        if (MyDate.isValidDate(numbers[2], numbers[0], numbers[1])) {
            MyDate newDate = new MyDate(numbers[2], numbers[0], numbers[1]);
            if (date == null || newDate.compareTo(date) < 0) {
                date = newDate;
            }
        }
        if (MyDate.isValidDate(numbers[2], numbers[1], numbers[0])) {
            MyDate newDate = new MyDate(numbers[2], numbers[1], numbers[0]);
            if (date == null || newDate.compareTo(date) < 0) {
                date = newDate;
            }
        }
        if (date == null) {
            fio.println(s + " is illegal");
        } else {
            fio.println(date);
        }
        fio.close();
    }
}

class MyDate implements Comparable<MyDate> {

    private static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int day;
    int month;
    int year;

    MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        if (year < 1000) {
            this.year = year + 2000;
        } else {
            this.year = year;
        }
    }

    static boolean isValidDate(int day, int month, int year) {

        // Check if year is valid
        if (year < 1000) {
            year += 2000;
        }
        if (year < 2000 || year > 2999) {
            return false;
        }

        // Check if month is valid
        if (month < 1 || month > 12) {
            return false;
        }

        // Check if day is valid
        if (isLeapYear(year)) {
            return day >= 1 && day <= LEAP_DAYS[month - 1];
        } else {
            return day >= 1 && day <= DAYS[month - 1];
        }
        
    }

    static boolean isLeapYear(int year) {
        if (year % 100 == 0 && year % 400 != 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }

    @Override
    public int compareTo(MyDate other) {
        if (this.year != other.year) {
            return this.year - other.year;
        } else if (this.month != other.month) {
            return this.month - other.month;
        } else {
            return this.day - other.day;
        }
    }
    
    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
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

