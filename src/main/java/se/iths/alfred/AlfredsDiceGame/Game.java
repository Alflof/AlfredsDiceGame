package se.iths.alfred.AlfredsDiceGame;

public class Game {

    static boolean keepRunning = true;
    static Dice dice = new Dice();
    static int diceRoll;

    public static void playGame(Player player1, Player player2) {
        while (keepRunning) {
            //Player 1 tärningskast
            playTurn(player1);

            //Player 2 tärningskast
            playTurn(player2);

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

            //Starta om eller avsluta
            String playAgain = IO.readln("\nPress Enter to play again, or enter \"Q\" to quit. ");
            if (playAgain.equals("Q") || playAgain.equals("q")) {
                IO.println("Thank you for playing Alfred's Dice Game! Welcome back any time.");
                keepRunning = false;
            } else {
                IO.println("\nGreat! Let's see who wins this time.");
                player1.resetScore();
                player2.resetScore();
            }
        }

    }

    //Tärningskast i egen metod för bättre DRY
    static void playTurn(Player player) {
        IO.readln(player.getFullName() + ", press Enter to throw your first dice.");
        diceRoll = dice.rollDice();
        player.addToScore(diceRoll);
        IO.readln("You rolled a " + diceRoll + "! Press Enter to throw your second dice.");
        diceRoll = dice.rollDice();
        player.addToScore(diceRoll);
        IO.println("You rolled a " + diceRoll + "!");
    }
}
