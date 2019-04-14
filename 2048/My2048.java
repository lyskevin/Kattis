/**
 * @author: Kevin Lim
 */

import java.util.*;

public class My2048 {

    public static final int GRID_SIZE = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = readGrid(sc);
        int operation = sc.nextInt();
        switch(operation) {
            case 0:
                slideLeft(grid);
                break;
            case 1:
                slideUp(grid);
                break;
            case 2:
                slideRight(grid);
                break;
            case 3:
                slideDown(grid);
        }
        printGrid(grid);
    }

    /**
     * Reads integers into the given 2D array
     * @param sc An instance of the Scanner class
     */
    public static int[][] readGrid(Scanner sc) {
        int[][] grid = new int[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        return grid;
    }
    
    /**
     * Slides the given grid left
     * @param grid The grid to slide left
     */
    public static void slideLeft(int[][] grid) {
        stackLeft(grid);
        mergeLeft(grid);
        stackLeft(grid);
    }

    /**
     * Stacks numbers in the given grid toward the left
     * @param grid The given grid
     */
    private static void stackLeft(int[][] grid) {
        for (int i = 0; i < GRID_SIZE; i++) {
            int[] tempRow = new int[GRID_SIZE];
            int count = 0;
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] != 0) {
                    tempRow[count] = grid[i][j];
                    count++;
                }
            }
            grid[i] = tempRow;
        }
    }

    /**
     * Merges numbers in the given grid toward the left
     * @param grid The given grid
     */
    private static void mergeLeft(int[][] grid) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE - 1; j++) {
                if (grid[i][j] == grid[i][j + 1]) {
                    grid[i][j] *= 2;
                    grid[i][j + 1] = 0;
                }
            }
        }
    }

    /**
     * Slides the given grid up
     * @param grid The grid to slide up
     */
    public static void slideUp(int[][] grid) {
        
        int[][] tempGrid = new int[GRID_SIZE][GRID_SIZE];
        int count = 0;
        
        /* Change orientation of grid for sliding operation */
        for (int i = GRID_SIZE - 1; i >= 0; i--) {
            for (int j = 0; j < GRID_SIZE; j++) {
                tempGrid[count / GRID_SIZE][count % GRID_SIZE] = grid[j][i];
                count++;
            }
        }

        slideLeft(tempGrid);
        
        /* Return grid to correct orientation */
        count = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = GRID_SIZE - 1; j >= 0; j--) {
                grid[count / GRID_SIZE][count % GRID_SIZE] = tempGrid[j][i];
                count++;
            }
        }
            
    }

    /**
     * Slides the given grid right
     * @param grid The grid to slide right
     */
    public static void slideRight(int[][] grid) {

        int[][] tempGrid = new int[GRID_SIZE][GRID_SIZE];
        
        /* Change orientation of grid for sliding operation */
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                tempGrid[i][j] = grid[i][GRID_SIZE - 1 - j];
            }
        }

        slideLeft(tempGrid);
        
        /* Return grid to correct orientation */
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = tempGrid[i][GRID_SIZE - 1 - j];
            }
        }

    }

    /**
     * Slides the given grid down
     * @param grid The grid to slide down
     */
    public static void slideDown(int[][] grid) {

        int[][] tempGrid = new int[GRID_SIZE][GRID_SIZE];
        int count = 0;
        
        /* Change orientation of grid for sliding operation */
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = GRID_SIZE - 1; j >= 0; j--) {
               tempGrid[count / GRID_SIZE][count % GRID_SIZE] = grid[j][i];
                count++;
            }
        }

        slideLeft(tempGrid);
        
        /* Return grid to correct orientation */
        count = 0;
        for (int i = GRID_SIZE - 1; i >= 0; i--) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[count / GRID_SIZE][count % GRID_SIZE] = tempGrid[j][i];
                count++;
            }
        }

    }

    /**
     * Prints the given grid
     * @param grid The grid to print
     */
    public static void printGrid(int[][] grid) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j]);
                if (j < GRID_SIZE - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

} // End 2048 class
