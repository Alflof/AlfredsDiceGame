package se.iths.alfred.AlfredsDiceGame;

import java.util.random.RandomGenerator;

public class Dice {

    static int rollDice() {
        return (RandomGenerator.getDefault().nextInt(1, 7));
    }
}