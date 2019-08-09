import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Arrays;
import java.lang.StringBuilder;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfFrosh = fr.nextInt();
        int maxPopularity = 0;
        HashMap<String, Integer> courseCombinations = new HashMap<>();
        int numberOfStudents = 0;
        for (int i = 0; i < numberOfFrosh; i++) {
            int[] courses = new int[5];
            for (int j = 0; j < 5; j++) {
                courses[j] = fr.nextInt();
            }
            Arrays.sort(courses);
            StringBuilder courseCombination = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                courseCombination.append(courses[j]);
                if (j < 4) {
                    courseCombination.append(" ");
                }
            }
            int popularity = 1;
            if (courseCombinations.containsKey(courseCombination.toString())) {
                popularity = courseCombinations.get(courseCombination.toString()) + 1;
            }
            courseCombinations.put(courseCombination.toString(), popularity);
            if (maxPopularity == popularity) {
                numberOfStudents += popularity;
            } else if (maxPopularity < popularity) {
                maxPopularity = popularity;
                numberOfStudents = popularity;
            }
        }
        System.out.println(numberOfStudents);
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

