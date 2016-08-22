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
}