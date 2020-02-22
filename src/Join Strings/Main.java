import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int numberOfStrings = fio.nextInt();
        String[] strings = new String[numberOfStrings];
        MyList[] myLists = new MyList[numberOfStrings];
        for (int i = 0; i < numberOfStrings; i++) {
            strings[i] = fio.next();
            ListNode listNode = new ListNode(i);
            MyList myList = new MyList(listNode, listNode);
            myLists[i] = myList;
        }
        int finalStart = 0;
        for (int j = 0; j < numberOfStrings - 1; j++) {
            int start = fio.nextInt() - 1;
            int end = fio.nextInt() - 1;
            MyList list1 = myLists[start];
            MyList list2 = myLists[end];
            list1.tail.next = list2.head;
            list1.tail = list2.tail;
            finalStart = start;
        }
        StringBuilder output = new StringBuilder();
        MyList finalList = myLists[finalStart];
        ListNode listNode = finalList.head;
        while (listNode != null) {
            fio.print(strings[listNode.index]);
            listNode = listNode.next;
        }
        fio.println();
        fio.close();
    }
}

class MyList {


    ListNode head;
    ListNode tail;

    MyList(ListNode head, ListNode tail) {
        this.head = head;
        this.tail = tail;
    }

} 

class ListNode {

    int index;
    ListNode next;

    ListNode(int index) {
        this.index = index;
        next = null;
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

