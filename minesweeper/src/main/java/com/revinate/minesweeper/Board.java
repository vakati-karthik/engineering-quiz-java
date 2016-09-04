package com.revinate.minesweeper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Board {

    int m = 30;//number of rows on board
    int n = 30;//number of columns on board
    boolean[][] revealMatrix = new boolean[m][n];
    int[][] mineMatrix = new int[m][n];

    /**
     * Creates a game board with a input with the following format
     * <p>
     * x1,y1 x2,y2 x3,y3
     * <p>
     * Example: 2,2 4,3 6,4
     */
    public Board(String coordinates) {
        initialize(coordinates);
    }

    /**
     * Reveals a specific point.
     *
     * @param x The x position
     * @param y The y position
     * @return false if the point contains a mine
     */
    public boolean reveal(int x, int y) {
        if (mineMatrix[x][y] == 0)
            revealMatrix[x][y] = true;
        return revealMatrix[x][y];
    }

    /**
     * Checks if the current point has been revealed already.
     *
     * @param x The x position
     * @param y The y position
     * @return true if the point has been revealed
     */
    public boolean isRevealed(int x, int y) {
        return revealMatrix[x][y];
    }

    /**
     * Gets the number of mines surrounding this specific coordinate.
     *
     * @param x The x position
     * @param y The y position
     * @return The number of mines in this position or -1 if the position itself is a mine
     */
    public int getNumberOfSurroundingMines(int x, int y) {
        if (mineMatrix[x][y] == 1)
            return -1;
        int numMines = 0;
        boolean minusX = (x-1 >= 0);
        boolean plusX = (x+1 <= m);
        boolean minusY = (y-1 >= 0);
        boolean plusY = (y+1 <= n);
        if (minusX) {
            if (minusY)
                numMines += mineMatrix[x-1][y-1];
            numMines += mineMatrix[x-1][y];
            if (plusY)
                numMines += mineMatrix[x-1][y+1];
        }
        if (plusX) {
            if (minusY)
                numMines += mineMatrix[x+1][y-1];
            numMines += mineMatrix[x+1][y];
            if (plusY)
                numMines += mineMatrix[x+1][y+1];
        }
        if (minusY)
            numMines += mineMatrix[x][y-1];
        if (plusY)
            numMines += mineMatrix[x][y+1];
        return numMines;
    }

    private final void initialize(String coordinates) {
        boolean isValidString = checkForValidString(coordinates);
        if (isValidString) {
            String[] pairs = coordinates.split(" ");
            for (String pair: pairs) {
                String[] coords = pair.split(",");
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);
                if (x >= 0 && x < m && y >=0 && y < n)
                mineMatrix[x][y] =  1;
            }
        }
    }

    private boolean checkForValidString(String coordinates) {
        if (!coordinates.equals("")){
            /*
            * If the user passes a String that doesn't match the described pattern, it just does nothing.
            * Since this constructor already checks for null string (in which case it does nothing),
            * the pattern should consist of atleast one pair of coordinates
            * The pattern is as follows
            * one or more pairs of coordinates followed by space followed by one pair of coordinates again i.e.,
            * one or more occurances of (1 or 2 digits followed by comma followed by 1 or 2 digits followed by space)
            * followed by (1 or 2 digits followed by comma followed by 1 or 2 digits)
            */
            String pattern = "(\\d{1,2},\\d{1,2} )*(\\d{1,2},\\d{1,2})";
            Pattern r = Pattern.compile(pattern);
            Matcher matcher = r.matcher(coordinates);
            return matcher.find();
        }
        return false;
    }
}
