import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 * @author lyskevin
 * 0 normal, 1 transpose, 2 complement, 3 both
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int V = fio.nextInt();
        int E = fio.nextInt();
        int Q = fio.nextInt();
        boolean[][][] matrix = new boolean[4][2000][2000];
        boolean isTranspose = false;
        boolean isComplement = false;
        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j < 2000; j++) {
                if (i != j) {
                    matrix[2][i][j] = true;
                    matrix[3][j][i] = true;
                }
            }
        }
        for (int i = 0; i < E; i++) {
            int a = fio.nextInt();
            int b = fio.nextInt();
            matrix[0][a][b] = true;
            matrix[1][b][a] = true;
            matrix[2][a][b] = false;
            matrix[3][b][a] = false;
        }
        for (int i = 0; i < Q;i++) {
            int queryType = fio.nextInt();
            if (queryType == 1) {
                V++;
            } else if (queryType == 2) {
                int x = fio.nextInt();
                int y = fio.nextInt();
                if (!isTranspose && !isComplement) {
                    matrix[0][x][y] = true;
                    matrix[1][y][x] = true;
                    matrix[2][x][y] = false;
                    matrix[3][y][x] = false;
                } else if (isTranspose && !isComplement) {
                    matrix[0][y][x] = true;
                    matrix[1][x][y] = true;
                    matrix[2][y][x] = false;
                    matrix[3][x][y] = false;
                } else if (!isTranspose && isComplement) {
                    matrix[0][x][y] = false;
                    matrix[1][y][x] = false;
                    matrix[2][x][y] = true;
                    matrix[3][y][x] = true;
                } else {
                    matrix[0][y][x] = false;
                    matrix[1][x][y] = false;
                    matrix[2][y][x] = true;
                    matrix[3][x][y] = true;
                }
            } else if (queryType == 3) {
                int vertex = fio.nextInt();
                if (!isComplement) {
                    for (int j = 0; j < V; j++) {
                        if (j != vertex) {
                            matrix[0][vertex][j] = false;
                            matrix[0][j][vertex] = false;
                            matrix[1][j][vertex] = false;
                            matrix[1][vertex][j] = false;
                            matrix[2][vertex][j] = true;
                            matrix[2][j][vertex] = true;
                            matrix[3][j][vertex] = true;
                            matrix[3][vertex][j] = true;
                        }
                    }
                } else {
                    for (int j = 0; j < V; j++) {
                        if (j != vertex) {
                            matrix[0][vertex][j] = true;
                            matrix[0][j][vertex] = true;
                            matrix[1][j][vertex] = true;
                            matrix[1][vertex][j] = true;
                            matrix[2][vertex][j] = false;
                            matrix[2][j][vertex] = false;
                            matrix[3][j][vertex] = false;
                            matrix[3][vertex][j] = false;
                        }
                    }
                }
            } else if (queryType == 4) {
                int x = fio.nextInt();
                int y = fio.nextInt();
                if (!isTranspose && !isComplement) {
                    matrix[0][x][y] = false;
                    matrix[1][y][x] = false;
                    matrix[2][x][y] = true;
                    matrix[3][y][x] = true;
                } else if (isTranspose && !isComplement) {
                    matrix[0][y][x] = false;
                    matrix[1][x][y] = false;
                    matrix[2][y][x] = true;
                    matrix[3][x][y] = true;
                } else if (!isTranspose && isComplement) {
                    matrix[0][x][y] = true;
                    matrix[1][y][x] = true;
                    matrix[2][x][y] = false;
                    matrix[3][y][x] = false;
                } else {
                    matrix[0][y][x] = true;
                    matrix[1][x][y] = true;
                    matrix[2][y][x] = false;
                    matrix[3][x][y] = false;
                }
            } else if (queryType == 5) {
                isTranspose = !isTranspose;
            } else {
                isComplement = !isComplement;
            }
        }
        fio.println(V);
        for (int i = 0; i < V; i++) {
            int outDegree = 0;
            BigInteger hash = new BigInteger("0");
            BigInteger coefficient = new BigInteger("1");
            if (!isTranspose && !isComplement) {
                for (int j = 0; j < V; j++) {
                    if (i != j && matrix[0][i][j]) {
                        outDegree++;
                        hash = hash.add(coefficient.multiply(BigInteger.valueOf(j)));
                        coefficient = coefficient.multiply(BigInteger.valueOf(7));
                    }
                }
            } else if (isTranspose && !isComplement) {
                for (int j = 0; j < V; j++) {
                    if (i != j && matrix[1][i][j]) {
                        outDegree++;
                        hash = hash.add(coefficient.multiply(BigInteger.valueOf(j)));
                        coefficient = coefficient.multiply(BigInteger.valueOf(7));
                    }
                }
            } else if (!isTranspose && isComplement) {
                for (int j = 0; j < V; j++) {
                    if (i != j && matrix[2][i][j]) {
                        outDegree++;
                        hash = hash.add(coefficient.multiply(BigInteger.valueOf(j)));
                        coefficient = coefficient.multiply(BigInteger.valueOf(7));
                    }
                }
            } else {
                for (int j = 0; j < V; j++) {
                    if (i != j && matrix[3][i][j]) {
                        outDegree++;
                        hash = hash.add(coefficient.multiply(BigInteger.valueOf(j)));
                        coefficient = coefficient.multiply(BigInteger.valueOf(7));
                    }
                }
            }
            fio.println(outDegree + " " + hash.remainder(new BigInteger("1000000007")));
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

