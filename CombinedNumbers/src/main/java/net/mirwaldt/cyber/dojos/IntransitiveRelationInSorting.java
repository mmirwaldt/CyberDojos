package net.mirwaldt.cyber.dojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This example shows you what happens in sorting if your relation is intransitive.
 *
 * Output:
 * Before sorting: [PAPER, PAPER, PAPER, SCISSORS, PAPER, SCISSORS, ROCK, ROCK, SCISSORS, ROCK, ROCK, PAPER]
 * After sorting: [ROCK, ROCK, ROCK, ROCK, PAPER, PAPER, PAPER, PAPER, PAPER, SCISSORS, SCISSORS, SCISSORS]
 * --------------------------------------------------------------------------------------------------------------
 * Before sorting: [ROCK, ROCK, SCISSORS, SCISSORS, ROCK, ROCK, ROCK, SCISSORS, ROCK, SCISSORS, PAPER, SCISSORS]
 * After sorting: [SCISSORS, SCISSORS, SCISSORS, SCISSORS, SCISSORS, ROCK, ROCK, ROCK, ROCK, ROCK, ROCK, PAPER]
 *
 * The sort order is different, although it must be the same!
 * That's the effect of an intransitive relation.
 * E.g. "SCISSORS wins against PAPER" and "PAPER wins against ROCK" => "SCISSORS wins against ROCK" (wrong!)
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
        sortAndPrintOut(12345);
    }

    private static void sortAndPrintOut(int SEED) {
        List<Hand> hands = new ArrayList<>();
        Random random = new Random(SEED);
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
