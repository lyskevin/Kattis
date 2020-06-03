import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int c = fio.nextInt();
        for (int i = 0; i < c; i++) {
            int n = fio.nextInt();
            int t = fio.nextInt() - 1;
            int e = fio.nextInt();
            Employee[] employees = new Employee[e];
            int[] towns = new int[n];
            for (int j = 0; j < e; j++) {
                int town = fio.nextInt() - 1;
                employees[j] = new Employee(town, fio.nextInt());
                towns[town]++;
            }
            Arrays.sort(employees);
            boolean isPossible = true;
            int[] cars = new int[n];
            int index = 0;
            for (int j = 0; j < n && isPossible; j++) {
                if (j != t) {
                    int count = 0;
                    int passengers = 0;
                    // Greedily use cars while there are still more passengers to be fetched
                    for (int k = index; k < index + towns[j] && passengers < towns[j]; k++) {
                        passengers += employees[k].passengers;
                        count++;
                    }
                    if (passengers < towns[j]) { // Insufficient cars in the current town
                        isPossible = false;
                    } else { // Track the number of cars used in this town
                        cars[j] = count;
                    }
                }
                index += towns[j];
            }
            fio.print("Case #" + (i + 1) + ":");
            if (isPossible) {
                for (int j = 0; j < n; j++) {
                    fio.print(" " + cars[j]);
                }
            } else {
                fio.print(" IMPOSSIBLE");
            }
            fio.println();
        }
        fio.close();
    }
}

class Employee implements Comparable<Employee> {

    int town;
    int passengers;

    Employee(int town, int passengers) {
        this.town = town;
        this.passengers = passengers;
    }

    // Sort by increasing town number, then by decreasing passenger count
    @Override
        public int compareTo(Employee other) {
            if (this.town != other.town) {
                return this.town - other.town;
            } else {
                return other.passengers - this.passengers;
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

