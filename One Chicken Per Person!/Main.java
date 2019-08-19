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
        int leftoverPiecesOfChicken = -1 * (fr.nextInt() - fr.nextInt());
        if (leftoverPiecesOfChicken == 1) {
            System.out.println("Dr. Chaz will have 1 piece of chicken left over!");
        } else if (leftoverPiecesOfChicken >= 0) {
            System.out.format("Dr. Chaz will have %d pieces of chicken left over!\n",
                    leftoverPiecesOfChicken);
        } else if (leftoverPiecesOfChicken == -1) {
            System.out.format("Dr. Chaz needs %d more piece of chicken!\n",
                    Math.abs(leftoverPiecesOfChicken));
        } else {
            System.out.format("Dr. Chaz needs %d more pieces of chicken!\n",
                    Math.abs(leftoverPiecesOfChicken));
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

