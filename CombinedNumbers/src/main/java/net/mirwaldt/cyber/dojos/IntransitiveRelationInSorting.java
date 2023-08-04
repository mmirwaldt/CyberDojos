package net.mirwaldt.cyber.dojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This example shows you what can happen with sorting if your relation is intransitive.
 * <p/>
 * Output:
 * Before sorting: [PAPER, PAPER, PAPER, SCISSORS, PAPER, SCISSORS, ROCK, ROCK, SCISSORS, ROCK, ROCK, PAPER]
 * After sorting: [ROCK, ROCK, ROCK, ROCK, PAPER, PAPER, PAPER, PAPER, PAPER, SCISSORS, SCISSORS, SCISSORS]
 --------------------------------------------------------------------------------------------------------------
 * Before sorting: [ROCK, ROCK, SCISSORS, SCISSORS, ROCK, SCISSORS, PAPER, ROCK, PAPER, SCISSORS, ROCK, SCISSORS]
 * After sorting: [SCISSORS, SCISSORS, SCISSORS, SCISSORS, SCISSORS, ROCK, ROCK, ROCK, ROCK, ROCK, PAPER, PAPER]
 * <p/>
 * The sort orders are different, although they must be the same! What happened?!
 * That's the effect of an intransitive relation.
 * E.g. "SCISSORS wins against PAPER" and "PAPER wins against ROCK" => "SCISSORS wins against ROCK" (wrong!)
 * <p/>
 * Why do we get many sort orders instead of only one with an intransitive relation?
 * E.g. let's assume the "<"-relation is intransitive.
 * What does that mean?
 * If a < b and b < c, then a < c OR even c < a !
 * This, however, leads to three different sort orders: c < a < b and b < c < a and a < b < c.
 * It is somehow "cyclic" producing all these different sort orders.
 * It does not contradict itself so that you will never face an IllegalArgumentException from e.g. Collections.sort(...).
 * If you now replace "a" by ROCK, "b" by PAPER and "c" by SCISSORS, then the output of the outputs make sense.
 * <p/>
 * An intransitive relation can even lead to contradictions.
 * E.g. let's assume the equals() method is intransitive but symmetric (a.equals(b) implies b.equals(a)).
 * What does that mean?
 * If a.equals(b) and b.equals(c), then a.equals(c) OR even !a.equals(c) !
 * However, if !a.equals(c) and a.equals(b), then !b.equals(c) but didn't we assume b.equals(c) before?! Ouch!
 */
public class IntransitiveRelationInSorting {
    enum Hand {
        SCISSORS() {
            @Override
            Hand winsAgainst() {
                return PAPER;
            }
        },
        ROCK() {
            @Override
            Hand winsAgainst() {
                return SCISSORS;
            }
        },
        PAPER() {
            @Override
            Hand winsAgainst() {
                return ROCK;
            }
        };

        abstract Hand winsAgainst();
    }

    public static void main(String[] args) {
        sortAndPrintOut(1234);
        System.out.println("-".repeat(110));
        sortAndPrintOut(1239); // we use a different seed
    }

    private static void sortAndPrintOut(int seed) {
        List<Hand> hands = new ArrayList<>();
        Random random = new Random(seed);
        for (int i = 0; i < 12; i++) {
            hands.add(Hand.values()[random.nextInt(3)]);
        }
        System.out.println("Before sorting: " + hands);
        hands.sort(IntransitiveRelationInSorting::compareTo);
        System.out.println("After sorting: " + hands);
    }

    public static int compareTo(Hand left, Hand right) {
        if(left == right) {
            return 0;
        } else if(left.winsAgainst() == right) {
            return 1;
        } else if(right.winsAgainst() == left) {
            return -1;
        } else {
            throw new IllegalStateException("Cannot compare '" + left.name() + "' with '" + right.name() + "'.");
        }
    }
}
