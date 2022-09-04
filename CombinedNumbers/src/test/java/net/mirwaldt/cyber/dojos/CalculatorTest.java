package net.mirwaldt.cyber.dojos;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CalculatorTest {

    @Test
    void test_single_number() {
        assertEquals("42", Calculator.largestNumber(42));
    }

    @Test
    void test_two_digits_in_ascending_order() {
        assertEquals("21", Calculator.largestNumber(1, 2));
    }

    @Test
    void test_two_digits_in_descending_order() {
        assertEquals("21", Calculator.largestNumber(2, 1));
    }

    @Test
    void test_three_digits_in_ascending_order() {
        assertEquals("521", Calculator.largestNumber(1, 2, 5));
    }

    @Test
    void test_three_digits_in_wild_order() {
        assertEquals("521", Calculator.largestNumber(5, 1, 2));
    }

    @Test
    void test_two_numbers_in_descending_order() {
        assertEquals("210", Calculator.largestNumber(10, 2));
    }


    @Test
    void test_two_numbers_in_descending_order_starting_with_same_digit() {
        assertEquals("110", Calculator.largestNumber(10, 1));
    }

    @Test
    void test_two_numbers_in_descending_order_starting_with_same_digit2() {
        assertEquals("121", Calculator.largestNumber(12, 1));
    }

    @Test
    void test_two_numbers_in_descending_order_starting_with_same_digit3() {
        assertEquals("111", Calculator.largestNumber(11, 1));
    }

    // <42423420> but was: <42342420> ("423" + "42" + "420")
    // given [420, 42, 423] it returns "42423420" ("42" + "423" + "420")
    @Test
    void test_example_1() {
        assertEquals("42423420", Calculator.largestNumber(420, 42, 423));
    }

    // given [50, 2, 1, 9]  it returns "95021"    ("9" + "50" + "2" + "1")
    @Test
    void test_example_2() {
        assertEquals("95021", Calculator.largestNumber(50, 2, 1, 9));
    }

    // <56550> but was: <55650>
    // given [5, 50, 56]    it returns "56550"    ("56" + "5" + "50")
    @Test
    void test_example_3() {
        assertEquals("56550", Calculator.largestNumber(5, 50, 56));
    }

    @Test
    void test_two_numbers_in_descending_order_starting_with_same_digit4() {
        assertEquals("1211", Calculator.largestNumber(121, 1));
    }

    @Test
    void test_two_numbers_in_descending_order_starting_with_same_digit5() {
        assertEquals("1101", Calculator.largestNumber(101, 1));
    }

    @Test
    void test_two_numbers_in_descending_order_starting_with_same_digit6() {
        assertEquals("1231", Calculator.largestNumber(123, 1));
    }
}
