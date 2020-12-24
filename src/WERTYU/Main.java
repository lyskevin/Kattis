import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        char[] map = new char[256];

        map['1'] = '`';
        map['2'] = '1';
        map['3'] = '2';
        map['4'] = '3';
        map['5'] = '4';
        map['6'] = '5';
        map['7'] = '6';
        map['8'] = '7';
        map['9'] = '8';
        map['0'] = '9';
        map['-'] = '0';
        map['='] = '-';

        map['W'] = 'Q';
        map['E'] = 'W';
        map['R'] = 'E';
        map['T'] = 'R';
        map['Y'] = 'T';
        map['U'] = 'Y';
        map['I'] = 'U';
        map['O'] = 'I';
        map['P'] = 'O';
        map['['] = 'P';
        map[']'] = '[';
        map['\\'] = ']';

        map['S'] = 'A';
        map['D'] = 'S';
        map['F'] = 'D';
        map['G'] = 'F';
        map['H'] = 'G';
        map['J'] = 'H';
        map['K'] = 'J';
        map['L'] = 'K';
        map[';'] = 'L';
        map['\''] = ';';

        map['X'] = 'Z';
        map['C'] = 'X';
        map['V'] = 'C';
        map['B'] = 'V';
        map['N'] = 'B';
        map['M'] = 'N';
        map[','] = 'M';
        map['.'] = ',';
        map['/'] = '.';

        while (true) {
            try {
                String s = fio.nextLine();
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == ' ') {
                        result.append(c);
                    } else {
                        result.append(map[c]);
                    }
                }
                fio.println(result);

            } catch (NullPointerException e) {
                break;
            }
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

