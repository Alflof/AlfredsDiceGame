package se.iths.alfred.AlfredsDiceGame;

import java.util.random.RandomGenerator;

public class Dice {

    static int rollDice() {
        int diceRoll = RandomGenerator.getDefault().nextInt(1, 7);
        return diceRoll;
    }
}