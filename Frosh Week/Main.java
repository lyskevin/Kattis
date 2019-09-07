import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static long numberOfInversions;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        numberOfInversions = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = fio.nextInt();
        }
        mergeSort(array);
        System.out.println(numberOfInversions);
    }

    private static void mergeSort(int[] array) {
        if (array.length > 1) {
            int halfLength = array.length / 2;
            int[] leftArray = new int[halfLength];
            int[] rightArray = new int[array.length - halfLength];
            System.arraycopy(array, 0, leftArray, 0, halfLength);
            System.arraycopy(array, halfLength, rightArray, 0, array.length - halfLength);
            mergeSort(leftArray);
            mergeSort(rightArray);
            int leftIndex = 0;
            int rightIndex = 0;
            int index = 0;
            while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                    array[index] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[index] = rightArray[rightIndex];
                    rightIndex++;
                    numberOfInversions += leftArray.length - leftIndex;
                }
                index++;
            }
            while (leftIndex < leftArray.length) {
                array[index] = leftArray[leftIndex];
                leftIndex++;
                index++;
            }
            while (rightIndex < rightArray.length) {
                array[index] = rightArray[rightIndex];
                rightIndex++;
                index++;
            }
        }
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

