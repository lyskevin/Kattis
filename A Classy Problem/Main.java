import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int numberOfTestCases = fio.nextInt();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numberOfTestCases; i++) {
            int numberOfPeople = fio.nextInt();
            Person[] people = new Person[numberOfPeople];
            for (int j = 0; j < numberOfPeople; j++) {
                String name = fio.next();
                name = name.substring(0, name.length() - 1);
                String[] statuses = fio.next().split("-");
                fio.next();
                List<Integer> statusList = new ArrayList<>();
                for (int k = statuses.length - 1; k >= 0; k--) {
                    statusList.add(statusToInteger(statuses[k]));
                }
                while (statusList.size() < 10) {
                    statusList.add(2);
                }
                people[j] = new Person(name, statusList);
            }
            Arrays.sort(people);
            for (int j = 0; j < numberOfPeople; j++) {
                output.append(people[j].name + "\n");
            }
            output.append("==============================\n");
        }
        System.out.print(output);
    }

    private static int statusToInteger(String status) {
        if (status.equals("upper")) {
            return 1;
        } else if (status.equals("middle")) {
            return 2;
        } else {
            return 3;
        }
    }

}

class Person implements Comparable<Person> {
    
    String name;
    List<Integer> statusList;

    Person(String name, List<Integer> statusList) {
        this.name = name;
        this.statusList = statusList;
    }

    @Override
    public int compareTo(Person other) {
        for (int i = 0; i < 10; i++) {
            int difference = this.statusList.get(i).compareTo(other.statusList.get(i));
            if (difference != 0) {
                return difference;
            }
        }
        return this.name.compareTo(other.name);
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

