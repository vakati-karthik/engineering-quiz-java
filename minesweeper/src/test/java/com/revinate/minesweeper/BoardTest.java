package com.revinate.minesweeper;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void smallBoardTest() throws Exception {
        Board board = new Board("1,1 2,2");

        assertThat(board.reveal(0, 0), is(true));
        assertThat(board.isRevealed(0, 0), is(true));
        assertThat(board.getNumberOfSurroundingMines(0, 0), is(1));

        assertThat(board.isRevealed(1, 2), is(false));
        assertThat(board.reveal(1, 2), is(true));
        assertThat(board.isRevealed(1, 2), is(true));
        assertThat(board.getNumberOfSurroundingMines(1, 2), is(2));

        assertThat(board.reveal(1, 1), is(false));
    }

    @Test
    public void smallBoardTest1() throws Exception {
        Board board = new Board("2,2 3,4 5,6 7,4 11,0");

        assertThat(board.reveal(0, 0), is(true));
        assertThat(board.isRevealed(0, 0), is(true));
        assertThat(board.getNumberOfSurroundingMines(0, 0), is(0));

        assertThat(board.isRevealed(2, 2), is(false));
        assertThat(board.reveal(2, 2), is(false));
        assertThat(board.getNumberOfSurroundingMines(2, 2), is(-1));

        assertThat(board.getNumberOfSurroundingMines(3, 4), is(-1));
        assertThat(board.reveal(3, 4), is(false));
        assertThat(board.isRevealed(3, 4), is(false));

        assertThat(board.getNumberOfSurroundingMines(4, 4), is(1));
        assertThat(board.isRevealed(4, 4), is(false));
        assertThat(board.reveal(4, 4), is(true));
        assertThat(board.isRevealed(4, 4), is(true));
        assertThat(board.getNumberOfSurroundingMines(4, 4), is(1));
    }

    @Test
    public void testBoardCoordinatesOutOfBounds() throws Exception {
        Board board = new Board("-1,0");

        //Checking for no mines
        for (int i = 0; i < 30; i++)
            for (int j = 0; j < 30; j++)
                assertThat(board.reveal(i, j), is(true));

        board = null;
        board = new Board("-1,-1 -1,0 0,-1 30,30 60,60");
        //Checking for no mines
        for (int i = 0; i < 30; i++)
            for (int j = 0; j < 30; j++)
                assertThat(board.reveal(i, j), is(true));
    }

    @Test
    public void testRandomBoardCoordinateString() throws Exception {
        Board board = new Board("-1,0,2,3,100");

        //Checking for no mines
        for (int i = 0; i < 30; i++)
            for (int j = 0; j < 30; j++)
                assertThat(board.reveal(i, j), is(true));

        board = null;
        board = new Board("revinate");
        //Checking for no mines
        for (int i = 0; i < 30; i++)
            for (int j = 0; j < 30; j++)
                assertThat(board.reveal(i, j), is(true));
    }
}