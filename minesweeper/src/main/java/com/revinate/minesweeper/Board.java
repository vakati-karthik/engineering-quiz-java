package com.revinate.minesweeper;

public class Board {

    /**
     * Creates a game board with a input with the following format
     * <p>
     * x1,y1 x2,y2 x3,y3
     * <p>
     * Example: 2,2 4,3 6,4
     */
    public Board(String coordinates) {
    }

    /**
     * Reveals a specific point.
     *
     * @param x The x position
     * @param y The y position
     * @return false if the point contains a mine
     */
    public boolean reveal(int x, int y) {
        return false;
    }

    /**
     * Checks if the current point has been revealed already.
     *
     * @param x The x position
     * @param y The y position
     * @return true if the point has been revealed
     */
    public boolean isRevealed(int x, int y) {
        return false;
    }

    /**
     * Gets the number of mines surrounding this specific coordinate.
     *
     * @param x The x position
     * @param y The y position
     * @return The number of mines in this position or -1 if the position itself is a mine
     */
    public int getNumberOfSurroundingMines(int x, int y) {
        return 0;
    }
}
