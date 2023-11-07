package com.duckrace;

import static com.duckrace.Reward.*;
 0
public class BoardTest {
    public static void main(String[] args) {
        Board board = new Board();
        // Board.dumpStudentIdMap();

        board.update(4, DEBIT);
        board.update(4, DEBIT);
        board.update(14, PRIZES);
        board.update(8, PRIZES);
        board.update(1, DEBIT);
        board.update(10, DEBIT);
        board.update(14, DEBIT);
        board.update(8, PRIZES);


        board.show();

    }

}
