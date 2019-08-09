import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.Comparator;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfNames = fr.nextInt();
        StringBuilder output = new StringBuilder();
        while (numberOfNames > 0) {
            String[] names = new String[numberOfNames];
            for (int i = 0; i < numberOfNames; i++) {
                names[i] = fr.nextLine();
            }
            mergeSort(names);
            for (int i = 0; i < numberOfNames; i++) {
                output.append(names[i]);
                output.append("\n");
            }
            numberOfNames = fr.nextInt();
            if (numberOfNames > 0) {
                output.append("\n");
            }
        }
        System.out.print(output);
    }

    private static void mergeSort(String[] names) {
        if (names.length > 1) {
            String[] leftHalf = new String[names.length / 2];
            String[] rightHalf = new String[names.length - (names.length / 2)];
            System.arraycopy(names, 0, leftHalf, 0, names.length / 2);
            System.arraycopy(names, names.length / 2, rightHalf, 0,
                    names.length - (names.length / 2));
            mergeSort(leftHalf);
            mergeSort(rightHalf);
            int leftIndex = 0;
            int rightIndex = 0;
            int nameIndex = 0;
            while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
                String name1 = leftHalf[leftIndex];
                String name2 = rightHalf[rightIndex];
                int nameComparison = compare(name1, name2);
                if (nameComparison <= 0) {
                    names[nameIndex] = name1;
                    leftIndex++;
                } else {
                    names[nameIndex] = name2;
                    rightIndex++;
                }
                nameIndex++;
            }
            while (leftIndex < leftHalf.length) {
                names[nameIndex] = leftHalf[leftIndex];
                leftIndex++;
                nameIndex++;
            }
            while (rightIndex < rightHalf.length) {
                names[nameIndex] = rightHalf[rightIndex];
                rightIndex++;
                nameIndex++;
            }
        }
    }

    private static int compare(String name1, String name2) {
        if (name1.charAt(0) != name2.charAt(0)) {
            return name1.charAt(0) - name2.charAt(0);
        } else if (name1.charAt(1) != name2.charAt(1)) {
            return name1.charAt(1) - name2.charAt(1);
        } else {
            return 0;
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

