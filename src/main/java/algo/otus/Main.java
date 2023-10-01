package algo.otus;

import algo.otus.algorithm.BitChessOperation;
import algo.otus.tester.Tester;

public class Main {
    public static void main(String[] args) {
        Tester tester = new Tester("src/resources");
//        tester.testLongInOut(position -> (long) BitChessOperation.bitCntArray(BitChessOperation.kingsMoveVar(position)), 0);
//        tester.testLongInOut(BitChessOperation::kingsMoveVar, 1);
        tester.testLongInOut(position -> (long) BitChessOperation.bitCntArray(BitChessOperation.horseMoveVar(position)), 0);
        tester.testLongInOut(BitChessOperation::horseMoveVar, 1);
    }
}
