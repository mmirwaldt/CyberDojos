package net.mirwaldt.cyber.dojos;

import java.util.*;

import static net.mirwaldt.cyber.dojos.IntransitiveRelationInTreeSet.Hand.ROCK;

/**
 * Output:
 * Simsalabim! [PAPER, SCISSORS, ROCK]
 * Abracadabra! [ROCK, PAPER, SCISSORS]
 * <p>
 * Once again, an intransitive comparator causes different sort orders.
 */
@SuppressWarnings("DuplicatedCode")
public class IntransitiveRelationInTreeSet {
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
        SortedSet<Hand> sortedSet = new TreeSet<>(IntransitiveRelationInTreeSet::compareTo);

        sortedSet.add(Hand.SCISSORS);
        sortedSet.add(ROCK);
        sortedSet.add(Hand.PAPER);
        System.out.println("Simsalabim! " + sortedSet);

        sortedSet.clear();
        sortedSet.add(Hand.PAPER);
        sortedSet.add(Hand.SCISSORS);
        sortedSet.add(ROCK);
        System.out.println("Abracadabra! " + sortedSet);
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
