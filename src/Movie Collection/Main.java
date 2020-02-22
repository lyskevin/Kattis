import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            int m = fio.nextInt();
            int r = fio.nextInt();
            int[] moviePositions = new int[m + 1];
            BST avlTree = new BST();
            for (int j = 1; j <= m; j++) {
                moviePositions[j] = 200000 + j;
                avlTree.insert(200000 + j);
            }
            int counter = 200000;
            for (int j = 0; j < r; j++) {
                if (j > 0) {
                    fio.print(" ");
                }
                int movie = fio.nextInt();
                fio.print(avlTree.getRank(moviePositions[movie]) - 1);
                avlTree.delete(moviePositions[movie]);
                moviePositions[movie] = counter;
                avlTree.insert(counter);
                counter--;
            }
            fio.println();
        }
        fio.close();
    }
}

class BSTVertex {
    BSTVertex(int v) {
        key = v; parent = left = right = null; height = 0; size = 1;
    }
    // all these attributes remain public to slightly simplify the code
    public BSTVertex parent, left, right;
    public int key;
    public int height; // will be used in lecture on AVL
    public int size;
}

// AVL Tree
class BST {
    public BSTVertex root;

    public BST() { root = null; }

    // public method called to search for a value v. 
    // Return v if it is found in the BST otherwise return -1000000.
    // Here the assumption is that -1000000 is never a valid key value.
    public int search(int v) {
        BSTVertex res = search(root, v);
        return res == null ? -1000000 : res.key;
    }

    // helper method to perform search
    private BSTVertex search(BSTVertex T, int v) {
        if (T == null)  return null;                     // not found
        else if (T.key == v) return T;                        // found
        else if (T.key < v)  return search(T.right, v);       // search to the right
        else                 return search(T.left, v);        // search to the left
    }

    // public method called to find Minimum key value in BST
    public int findMin() { return findMin(root); }

    // helper method to perform findMin
    // Question: What happens if BST is empty?
    private int findMin(BSTVertex T) {
        if (T.left == null) return T.key;                    // this is the min
        else                return findMin(T.left);           // go to the left
    }

    // public method called to find Maximum key value in BST
    public int findMax() { return findMax(root); }

    // helper method to perform findMax
    // Question: Again, what happens if BST is empty?
    private int findMax(BSTVertex T) {
        if (T.right == null) return T.key;                   // this is the max
        else                 return findMax(T.right);        // go to the right
    }

    // public method to find successor to given value v in BST.
    public int successor(int v) { 
        BSTVertex vPos = search(root, v);
        return vPos == null ? -1000000 : successor(vPos);
    }

    // helper recursive method to find successor to for a given vertex T in BST
    private int successor(BSTVertex T) {
        if (T.right != null)                       // this subtree has right subtree
            return findMin(T.right);  // the successor is the minimum of right subtree
        else {
            BSTVertex par = T.parent;
            BSTVertex cur = T;
            // if par(ent) is not root and cur(rent) is its right children
            while ((par != null) && (cur == par.right)) {
                cur = par;                                         // continue moving up
                par = cur.parent;
            }
            return par == null ? -1000000 : par.key;           // this is the successor of T
        }
    }

    // public method to find predecessor to given value v in BST
    public int predecessor(int v) { 
        BSTVertex vPos = search(root, v);
        return vPos == null ? -1000000 : predecessor(vPos);
    }

    // helper recursive method to find predecessor to for a given vertex T in BST
    private int predecessor(BSTVertex T) {
        if (T.left != null)                         // this subtree has left subtree
            return findMax(T.left);  // the predecessor is the maximum of left subtree
        else {
            BSTVertex par = T.parent;
            BSTVertex cur = T;
            // if par(ent) is not root and cur(rent) is its left children
            while ((par != null) && (cur == par.left)) { 
                cur = par;                                         // continue moving up
                par = cur.parent;
            }
            return par == null ? -1000000 : par.key;           // this is the successor of T
        }
    }

    // public method called to perform inorder traversal
    public void inorder() { 
        inorder(root);
        System.out.println();
    }

    // helper method to perform inorder traversal
    private void inorder(BSTVertex T) {
        if (T == null) return;
        inorder(T.left);                               // recursively go to the left
        System.out.printf(" %d", T.key);                      // visit this BST node
        inorder(T.right);                             // recursively go to the right
    }

    // public method called to insert a new key with value v into BST
    public void insert(int v) { root = insert(root, v); }

    // helper recursive method to perform insertion of new vertex into BST
    private BSTVertex insert(BSTVertex T, int v) {

        if (T == null) {
            return new BSTVertex(v);          // insertion point is found
        }

        if (T.key < v) {                                      // search to the right
            T.right = insert(T.right, v);
            T.right.parent = T;
        }
        else {                                                 // search to the left
            T.left = insert(T.left, v);
            T.left.parent = T;
        }

        // Increase height along insertion path
        T.height = Math.max(getHeight(T.left), getHeight(T.right)) + 1;

        int balanceFactor = balanceFactor(T);
        if (balanceFactor == 2) {
            if (balanceFactor(T.left) >= 0 && balanceFactor(T.left) <= 1) { // LL
                T = rotateRight(T);
            } else if (balanceFactor(T.left) == -1) { // LR
                T.left = rotateLeft(T.left);
                T = rotateRight(T);
            }
        } else if (balanceFactor == -2) {
            if (balanceFactor(T.right) <= 0 && balanceFactor(T.right) >= -1) { // RR
                T = rotateLeft(T);
            } else if (balanceFactor(T.right) == 1) { // RL
                T.right = rotateRight(T.right);
                T = rotateLeft(T);
            }
        }

        // Update size attribute
        T.size = getSize(T.left) + getSize(T.right) + 1;

        return T;
        // return the updated BST
    }

    // helper recursive method to check balance factor
    private int balanceFactor(BSTVertex T) {
        return getHeight(T.left) - getHeight(T.right);
    }

    // public method to delete a vertex containing key with value v from BST
    public void delete(int v) { root = delete(root, v); }

    // helper recursive method to perform deletion 
    private BSTVertex delete(BSTVertex T, int v) {
        if (T == null)  return T;              // cannot find the item to be deleted

        if (T.key < v)                                    // search to the right
            T.right = delete(T.right, v);
        else if (T.key > v)                               // search to the left
            T.left = delete(T.left, v);
        else {                                            // this is the node to be deleted
            if (T.left == null && T.right == null)                   // this is a leaf
                T = null;                                      // simply erase this node
            else if (T.left == null && T.right != null) {   // only one child at right        
                T.right.parent = T.parent;
                T = T.right;                                                 // bypass T        
            }
            else if (T.left != null && T.right == null) {    // only one child at left        
                T.left.parent = T.parent;
                T = T.left;                                                  // bypass T        
            }
            else {                                 // has two children, find successor
                int successorV = successor(v);
                T.key = successorV;         // replace this key with the successor's key
                T.right = delete(T.right, successorV);      // delete the old successorV
            }
        }

        if (T != null) {

            // update height along deletion path
            T.height = Math.max(getHeight(T.left), getHeight(T.right)) + 1;

            // perform rotations if necessary
            int balanceFactor = balanceFactor(T);
            if (balanceFactor == 2) {
                if (balanceFactor(T.left) >= 0 && balanceFactor(T.left) <= 1) { // ll rotation
                    T = rotateRight(T);
                } else if (balanceFactor(T.left) == -1) { // lr rotation
                    T.left = rotateLeft(T.left);
                    T = rotateRight(T);
                }
            } else if (balanceFactor == -2) {
                if (balanceFactor(T.right) <= 0 && balanceFactor(T.right) >= -1) { // rr rotation
                    T = rotateLeft(T);
                } else if (balanceFactor(T.right) == 1) { // rl rotation
                    T.right = rotateRight(T.right);
                    T = rotateLeft(T);
                }
            }

            // update size attribute
            T.size = getSize(T.left) + getSize(T.right);
        }

        return T;    // return the updated tree

    }

    // will be used in AVL lecture
    private int getHeight(BSTVertex T) {
        if (T == null) return -1;
        else return T.height;
    }

    public int getHeight() { return getHeight(root); }

    private BSTVertex rotateLeft(BSTVertex T) {
        BSTVertex w = T.right;
        w.parent = T.parent;
        T.parent = w;
        T.right = w.left;
        if (w.left != null) w.left.parent = T;
        w.left = T;
        T.height -= 1;
        w.height += 1;
        T.size = getSize(T.left) + getSize(T.right) + 1;
        w.size = getSize(w.left) + getSize(w.right) + 1;
        return w;
    }

    private BSTVertex rotateRight(BSTVertex T) {
        BSTVertex w = T.left;
        w.parent = T.parent;
        T.parent = w;
        T.left = w.right;
        if (w.right != null) w.right.parent = T;
        w.right = T;
        T.height -= 1;
        w.height += 1;
        T.size = getSize(T.left) + getSize(T.right) + 1;
        w.size = getSize(w.left) + getSize(w.right) + 1;
        return w;
    }

    private int getSize(BSTVertex T) {
        if (T == null) return 0;
        else return T.size;
    }

    public int getRank(int v) {
        return getRank(v, root, 0);
    }

    private int getRank(int v, BSTVertex T, int carry) {
        if (T == null) {
            return -1;
        } else if (T.key == v) {
            return carry + getSize(T.left) + 1;
        } else if (T.key > v) {
            return getRank(v, T.left, carry);
        } else {
            return getRank(v, T.right, carry + getSize(T.left) + 1);
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

