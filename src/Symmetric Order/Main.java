import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int setNumber = 1;
        int numberOfNames = fio.nextInt();
        while (numberOfNames > 0) {
            String[] names = new String[numberOfNames];
            String[] sortedNames = new String[numberOfNames];
            for (int i = 0; i < numberOfNames; i++) {
                names[i] = fio.next();
            }
            for (int i = 0, n = numberOfNames / 2; i < n; i++) {
                sortedNames[i] = names[2 * i];
                sortedNames[numberOfNames - 1 - i] = names[2 * i + 1];
            }
            if (numberOfNames % 2 != 0) {
                sortedNames[numberOfNames / 2] = names[numberOfNames - 1];
            }
            fio.println("SET " + setNumber);
            for (int i = 0; i < numberOfNames; i++) {
                fio.println(sortedNames[i]);
            }
            setNumber++;
            numberOfNames = fio.nextInt();
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

