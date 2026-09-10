package se.iths.alfred.AlfredsDiceGame;

public class Game {

    static boolean keepRunning = true;
    static Dice dice = new Dice();
    static int diceRoll;

    public static void playGame(Player player1, Player player2) {

        while (keepRunning) {

            //Player 1 tärningskast
            IO.readln(player1.getFullName() + ", press Enter to throw your first dice.");
            diceRoll = dice.rollDice();
            player1.addToScore(diceRoll);
            IO.readln("You rolled a " + diceRoll + "! Press Enter to throw your second dice.");
            diceRoll = dice.rollDice();
            player1.addToScore(diceRoll);
            IO.println("You rolled a " + diceRoll + "!");

            //Player 2 tärningskast
            IO.readln("\n" + player2.getFullName() + ", press Enter to throw your first dice.");
            diceRoll = dice.rollDice();
            player2.addToScore(diceRoll);
            IO.readln("You rolled a " + diceRoll + "! Press Enter to throw your second dice.");
            diceRoll = dice.rollDice();
            player2.addToScore(diceRoll);
            IO.println("You rolled a " + diceRoll + "!");

            //Poängredovisning
            IO.println("\nThe game is over, and the winner is...");

            if (player1.getScore() > player2.getScore()) {
                IO.println(player1.getFullName() + " with " + player1.getScore() + " points! Congratulations!");
                IO.println(player2.getFullName() + ", your " + player2.getScore() + " points were just not enough this time.");
            } else if (player1.getScore() < player2.getScore()) {
                IO.println(player2.getFullName() + " with " + player2.getScore() + " points! Congratulations!");
                IO.println(player1.getFullName() + ", your " + player1.getScore() + " points were just not enough this time.");
            } else {
                IO.println("Both of you - It's a tie! You both scored " + player1.getScore() + ".");
            }
            IO.println("(Debug: P1: " + player1.getScore() + " P2: " + player2.getScore() + ")");

            //Starta om eller avsluta
            String playAgain = IO.readln("\nEnter \"Y\" to play again, or \"N\" to quit. ");
            if (playAgain.equals("Y")) {
                IO.println("Great! Let's see who wins this time.");
            } else if (playAgain.equals("N")) {
                IO.println("\nThanks for playing Alfred's Dice Game! Welcome back again anytime.");
                keepRunning = false;
            }
        }

    }


}
