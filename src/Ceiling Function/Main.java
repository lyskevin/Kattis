import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int k = fio.nextInt();
        BST[] bsts = new BST[n];
        for (int i = 0; i < n; i++) {
            BST bst = new BST();
            for (int j = 0; j < k; j++) {
                bst.insert(fio.nextInt());
            }
            bsts[i] = bst;
        }
        ArrayList<BST> bstStructures = new ArrayList<>();
        int count = 0;
        for (BST bst : bsts) {
            boolean hasSameStructure = false;
            for (BST bstStructure : bstStructures) {
                if (bst.hasSameStructure(bstStructure)) {
                    hasSameStructure = true;
                    break;
                }
            }
            if (!hasSameStructure) {
                bstStructures.add(bst);
                count++;
            }
        }
        fio.println(count);
        fio.close();
    }
}

class BST {

    BSTVertex root;
    
    BST() {
        root = null;
    }

    void insert(int number) {
        root = insert(root, number);
    }

    BSTVertex insert(BSTVertex node, int number) {
        if (node == null) {
            return new BSTVertex(number);
        } else if (node.key < number) { // Go to the right
            node.right = insert(node.right, number);
            return node;
        } else { // Go to the left
            node.left = insert(node.left, number);
            return node;
        }
    }

    boolean hasSameStructure(BST other) {
        return hasSameStructure(root, other.root);
    }

    boolean hasSameStructure(BSTVertex node1, BSTVertex node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            return hasSameStructure(node1.left, node2.left)
                    && hasSameStructure(node1.right, node2.right);
        } else {
            return false;
        }
    }

}

class BSTVertex {

    BSTVertex left;
    BSTVertex right;
    int key;

    BSTVertex(int key) {
        left = right = null;
        this.key = key;
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

