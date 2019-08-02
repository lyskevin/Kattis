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
        int numberOfStrings = fr.nextInt();
        String[] strings = new String[numberOfStrings];
        MyList[] myLists = new MyList[numberOfStrings];
        for (int i = 0; i < numberOfStrings; i++) {
            strings[i] = fr.next();
            ListNode listNode = new ListNode(i);
            MyList myList = new MyList(listNode, listNode);
            myLists[i] = myList;
        }
        int finalStart = 0;
        for (int j = 0; j < numberOfStrings - 1; j++) {
            int start = fr.nextInt() - 1;
            int end = fr.nextInt() - 1;
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
            output.append(strings[listNode.index]);
            listNode = listNode.next;
        }
        System.out.println(output);
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
