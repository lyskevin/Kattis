import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.lang.StringBuilder;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String command = fio.next();
        HashMap<String, Integer> wordToNumber = new HashMap<>();
        HashMap<Integer, String> numberToWord = new HashMap<>();
        StringBuilder output = new StringBuilder();
        while (command != null) {
            if (command.equals("def")) {
                String word = fio.next();
                int number = fio.nextInt();
                if (wordToNumber.containsKey(word)) {
                    numberToWord.remove(wordToNumber.get(word));
                }
                wordToNumber.put(word, number);
                numberToWord.put(number, word);
            } else if (command.equals("calc")) {
                String operator;
                int result = 0;
                boolean isUnknown = false;
                String word = fio.next();
                output.append(word);
                if (wordToNumber.containsKey(word)) {
                    result = wordToNumber.get(word);
                } else {
                    isUnknown = true;
                }
                while (true) {
                    operator = fio.next();
                    output.append(" " + operator + " ");
                    if (operator.equals("=")) {
                        break;
                    } else {
                        word = fio.next();
                        output.append(word);
                    }
                    if (!wordToNumber.containsKey(word)) {
                        isUnknown = true;
                    } else {
                        if (operator.equals("+") ) {
                            result += wordToNumber.get(word);
                        } else if (operator.equals("-")) {
                            result -= wordToNumber.get(word);
                        }
                    }
                }
                if (!numberToWord.containsKey(result) || isUnknown) {
                    output.append("unknown\n");
                } else {
                    output.append(numberToWord.get(result) + "\n");
                }
            } else {
                wordToNumber = new HashMap<>();
                numberToWord = new HashMap<>();
            }
            command = fio.next();
        }
        System.out.print(output);
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
            } catch (NullPointerException e) {
                return null;
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

