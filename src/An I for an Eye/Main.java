import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        HashMap<String, String> map = new HashMap<>();

        // Lowercase
        map.put("at", "@");
        map.put("and", "&");
        map.put("one", "1");
        map.put("won", "1");
        map.put("to", "2");
        map.put("too", "2");
        map.put("two", "2");
        map.put("for", "4");
        map.put("four", "4");
        map.put("bea", "b");
        map.put("be", "b");
        map.put("bee", "b");
        map.put("sea", "c");
        map.put("see", "c");
        map.put("eye", "i");
        map.put("oh", "o");
        map.put("owe", "o");
        map.put("are", "r");
        map.put("you", "u");
        map.put("why", "y");
        
        // Uppercase
        map.put("At", "@");
        map.put("And", "&");
        map.put("One", "1");
        map.put("Won", "1");
        map.put("To", "2");
        map.put("Too", "2");
        map.put("Two", "2");
        map.put("For", "4");
        map.put("Four", "4");
        map.put("Bea", "B");
        map.put("Be", "B");
        map.put("Bee", "B");
        map.put("Sea", "C");
        map.put("See", "C");
        map.put("Eye", "I");
        map.put("Oh", "O");
        map.put("Owe", "O");
        map.put("Are", "R");
        map.put("You", "U");
        map.put("Why", "Y");

        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            String s = fio.nextLine();
            int index = 0;
            StringBuilder result = new StringBuilder();

            while (index < s.length()) {
                boolean isWordFound = false;
                for (String word : map.keySet()) {
                    if (index + word.length() <= s.length() && s.substring(index, index + word.length()).equals(word)) {
                        index += word.length();
                        result.append(map.get(word));

                        // be or Be -> bee/bea or Bee/Bea
                        if ((word.equals("be") || word.equals("Be")) && index < s.length()
                                && (s.charAt(index) == 'e' || s.charAt(index) == 'a')) {
                            index++;
                        }

                        // to or To -> too or Too
                        if ((word.equals("to") || word.equals("To")) && index < s.length()
                                && s.charAt(index) == 'o') {
                            index++;
                        }
                        isWordFound = true;
                        break;
                    }
                }

                if (!isWordFound) {
                    result.append(s.charAt(index));
                    index++;
                }
            }

            fio.println(result);
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

