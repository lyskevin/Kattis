import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfCommands = fr.nextInt();
        ArrayDeque frontHalf = new ArrayDeque();
        ArrayDeque backHalf = new ArrayDeque();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numberOfCommands; i++) {
            String command = fr.next();
            int number = fr.nextInt();
            if (command.equals("push_front")) {
                frontHalf.addFirst(number);
                if (frontHalf.size() > backHalf.size() + 1) {
                    backHalf.addFirst(frontHalf.removeLast());
                }
            } else if (command.equals("push_middle")) {
                if (frontHalf.size() == backHalf.size()) {
                    frontHalf.addLast(number);
                } else {
                    backHalf.addFirst(number);
                }
            } else if (command.equals("push_back")) {
                backHalf.addLast(number);
                if (backHalf.size() > frontHalf.size()) {
                    frontHalf.addLast(backHalf.removeFirst());
                }
            } else {
                if (number < frontHalf.size()) {
                    output.append(frontHalf.get(number));
                } else {
                    output.append(backHalf.get(number - frontHalf.size()));
                }
                output.append("\n");
            }
        }
        System.out.print(output);
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

/**
 * Implements a deque using arrays (This is a modified version
 * of some code which I wrote for UC Berkeley's CS61B course)
 */
class ArrayDeque {

    private int[] array;
    private int nextFirst, nextLast;
    private int size;

    // Creates an deque (default size is 8)
    // Front and back pointers arbitrarily start from the middle
    ArrayDeque() {
        array = new int[8];
        nextFirst = 3;
        nextLast = 4;
        size = 0;
    } // End ArrayDeque constructor

    // Adds an number of type int to the front of the deque
    void addFirst(int number) {
        if (size == array.length) {
            resize(size * 2);
        }
        array[nextFirst] = number;
        nextFirst = checkLoop(nextFirst - 1);
        size++;
    } // End addFirst

    // Adds an number of type int to the back of the deque
    void addLast(int number) {
        if (size == array.length) {
            resize(size * 2);
        }
        array[nextLast] = number;
        nextLast = checkLoop(nextLast + 1);
        size++;
    } // End addLast

    // Returns true if the deque is empty, else false
    boolean isEmpty() {
        return size == 0;
    } // End isEmpty

    // Returns the number of items in the deque
    int size() {
        return size;
    } // End size

    // Removes and returns the item at the front of the deque.
    public int removeFirst() {
        int halfCapacity = array.length / 2;
        if (size < halfCapacity && halfCapacity >= 8) {
            resize(array.length / 2);
        }
        nextFirst = checkLoop(nextFirst + 1);
        size--;
        return array[nextFirst];
    } // End removeFirst

    // Removes and returns the item at the back of the deque.
    public int removeLast() {
        int halfCapacity = array.length / 2;
        if (size < halfCapacity && halfCapacity >= 8) {
            resize(array.length / 2);
        }
        nextLast = checkLoop(nextLast - 1);
        size--;
        return array[nextLast];
    } // End removeLast

    // Gets the number at the given index, where 0 is the front,
    // 1 is the next number, and so forth.
    int get(int index) {
        index = checkLoop(nextFirst + 1 + index);
        return array[index];
    } // End get

    // Sets the number at the specified index to the specified number
    void set(int index, int number) {
        index = checkLoop(nextFirst + 1 + index);
        array[index] = number;
    }

    // Resizes the array to the given capacity
    // Limits the minimum array size to 8
    private void resize(int capacity) {

        int[] newArray = new int[capacity];
        int first = checkLoop(nextFirst + 1);
        int last = checkLoop(nextLast - 1);

        if (first <= last) { // Array does not loop around
            System.arraycopy(array, first, newArray, 0, size);
        } else { // Array loops around
            System.arraycopy(array, first, newArray, 0, array.length - first);
            System.arraycopy(array, 0, newArray, array.length - first, nextLast);
        }

        // Reset front and back pointers
        array = newArray;
        nextFirst = array.length - 1;
        nextLast = size;

    } // End resize

    // Loops the given pointer around the array if necessary
    private int checkLoop(int pointer) {
        if (pointer < 0) {
            return array.length + pointer;
        } else if (pointer >= array.length) {
            return pointer - array.length;
        } else {
            return pointer;
        }
    } // End checkLoop

} // End ArrayDeque class

