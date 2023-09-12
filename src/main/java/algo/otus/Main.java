package algo.otus;

import algo.otus.algorithm.impl.Fibonacci;
import algo.otus.algorithm.impl.Power;
import algo.otus.algorithm.impl.SimpleDigit;
import algo.otus.tester.Tester;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Tester tester = new Tester("src/resources");
//        tester.testDoubleOutAndDoubleLongIn(Power::power);
//        tester.testDoubleOutAndDoubleLongIn(Power::powerBRecursive);
//        tester.testDoubleOutAndDoubleLongIn(Power::powerB);

//        tester.testLongInOut(Fibonacci::recourcive);
//        tester.testLongInOut(Fibonacci::iterative);
//        tester.testDoubleOutLongIn(Fibonacci::goldSection);
//        tester.testLongInOut(Fibonacci::matrix);

//        tester.testIntegerInOut(SimpleDigit::countSimpleDigit);
//        tester.testIntegerInOut(SimpleDigit::countSimpleEratosphene);
        tester.testIntegerInOut(SimpleDigit::countSimpleEratospheneQuick);
    }
}
