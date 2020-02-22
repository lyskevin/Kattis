import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int l = fr.nextInt();
        int d = fr.nextInt();
        int x = fr.nextInt();
        for (int i = l; i <= d; i++) {
            if (getDigitSum(i) == x) {
                System.out.println(i);
                break;
            }
        }
        for (int i = d; i >= l; i--) {
            if (getDigitSum(i) == x) {
                System.out.println(i);
                break;
            }
        }
    }

    private static int getDigitSum(int number) {
        int digitSum = 0;
        while (number > 0) {
            digitSum += number % 10;
            number /= 10;
        }
        return digitSum;
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

