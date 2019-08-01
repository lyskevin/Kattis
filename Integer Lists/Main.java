import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.lang.StringBuilder;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfTestCases = fr.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            String commands = fr.next();
            int listSize = fr.nextInt();
            String list = fr.next();
            String[] integers = list.substring(1, list.length() - 1).split(",");
            int listHead = 0;
            int listTail = listSize - 1;
            boolean isReversed = false;
            boolean isError = false;
            for (int j = 0; j < commands.length(); j++) {
                if (commands.charAt(j) == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (listTail < listHead) {
                        isError = true;
                        break;
                    } else if (isReversed) {
                        listTail--;
                    } else {
                        listHead++;
                    }
                }
            }
            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder output = new StringBuilder('[');
                System.out.print("[");
                if (isReversed) {
                    for (int k = listTail; k >= listHead; k--) {
                        if (k < listTail) {
                            output.append(',');
                        }
                        output.append(integers[k]);
                    } 
                } else {
                    for (int k = listHead; k <= listTail; k++) {
                        if (k > listHead) {
                            output.append(',');
                        }
                        output.append(integers[k]);
                    } 
                }
                output.append(']');
                System.out.println(output);
            }
        }
    }
}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
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

