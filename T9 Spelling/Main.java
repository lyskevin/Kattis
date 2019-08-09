import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.lang.StringBuilder;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfTestCases = fr.nextInt();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numberOfTestCases; i++) {
            String input = fr.nextLine();
            output.append("Case #" + (i + 1) + ": ");
            for (int j = 0, n = input.length(); j < n; j++) {
                output.append(keyPresses(input.charAt(j)));
                if ((j < n - 1) && hasSameKey(input.charAt(j), input.charAt(j + 1))) {
                    output.append( " ");
                }
            }
            output.append("\n");
        }
        System.out.print(output);
    }

    private static String keyPresses(char character) {
        switch(character) {
            case 'a':
                return "2";
            case 'b':
                return "22";
            case 'c':
                return "222";
            case 'd':
                return "3";
            case 'e':
                return "33";
            case 'f':
                return "333";
            case 'g':
                return "4";
            case 'h':
                return "44";
            case 'i':
                return "444";
            case 'j':
                return "5";
            case 'k':
                return "55";
            case 'l':
                return "555";
            case 'm':
                return "6";
            case 'n':
                return "66";
            case 'o':
                return "666";
            case 'p':
                return "7";
            case 'q':
                return "77";
            case 'r':
                return "777";
            case 's':
                return "7777";
            case 't':
                return "8";
            case 'u':
                return "88";
            case 'v':
                return "888";
            case 'w':
                return "9";
            case 'x':
                return "99";
            case 'y':
                return "999";
            case 'z':
                return "9999";
            default:
                return "0";
        }
    }

    private static boolean hasSameKey(char character1, char character2) {
        if (character1 == ' ' && character2 == ' ') {
            return true;
        }
        int characterNumber1 = character1 - 'a';
        int characterNumber2 = character2 - 'a';
        if (characterNumber1 < 15 && characterNumber2 < 15) {
            return characterNumber1 / 3 == characterNumber2 / 3;
        } else if (characterNumber1 >= 15 && characterNumber1 <= 18
                   && characterNumber2 >= 15 && characterNumber2 <= 18) {
            return true;
        } else if (characterNumber1 >= 19 && characterNumber1 <= 21
                   && characterNumber2 >= 19 && characterNumber2 <= 21) {
            return true;
        } else if (characterNumber1 >= 22 && characterNumber1 <= 25
                   && characterNumber2 >= 22 && characterNumber2 <= 25) {
            return true;
        }
        return false;
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

