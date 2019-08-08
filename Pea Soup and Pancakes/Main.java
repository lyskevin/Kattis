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
        int numberOfRestaurants = fr.nextInt();
        for (int i = 0; i < numberOfRestaurants; i++) {
            int numberOfItems = fr.nextInt();
            String name = fr.nextLine();
            boolean hasPeaSoup = false;
            boolean hasPancakes = false;
            for (int j = 0; j < numberOfItems; j++) {
                String item = fr.nextLine();
                if (item.equals("pea soup")) {
                    hasPeaSoup = true;
                }
                if (item.equals("pancakes")) {
                    hasPancakes = true;
                }
            }
            if (hasPeaSoup && hasPancakes) {
                System.out.println(name);
                return;
            }
        }
        System.out.println("Anywhere is fine I guess");
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

