import java.util.*;
import java.io.*;

/**
 * @author lyskevin
 */
public class Main {

    private static long numberOfInversions = 0;   
 
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int numberOfCamels = fio.nextInt();
        int[] bets1 = new int[numberOfCamels];
        int[] bets2 = new int[numberOfCamels];
        int[] bets3 = new int[numberOfCamels];
        for (int i = 0; i < numberOfCamels; i++) {
            bets1[i] = fio.nextInt() - 1;
        }
        for (int i = 0; i < numberOfCamels; i++) {
            bets2[i] = fio.nextInt() - 1;
        }
        for (int i = 0; i < numberOfCamels; i++) {
            bets3[i] = fio.nextInt() - 1;
        }
        int[] arr1 = prepare(bets1, bets2);
        mergeSort(arr1);
        int[] arr2 = prepare(bets1, bets3);
        mergeSort(arr2);
        int[] arr3 = prepare(bets2, bets3);
        mergeSort(arr3);
        fio.println(((long) numberOfCamels) * (numberOfCamels - 1) / 2 - (numberOfInversions / 2));
        fio.close();
    }

    private static int[] prepare(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[arr1[i]] = i;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = indices[arr2[i]];
        }
        return arr;
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

