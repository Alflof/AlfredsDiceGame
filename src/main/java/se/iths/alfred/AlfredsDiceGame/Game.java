package se.iths.alfred.AlfredsDiceGame;

public class Game {

    boolean keepRunning = true;

    //Loops until players decide to quit
    public void playGame(Player player1, Player player2) {
        while (keepRunning) {

            playTurn(player1);
            playTurn(player2);

            IO.println("\nThe game is over, and the winner is...");
            if (player1.getScore() > player2.getScore()) {
                printWinner(player1, player2);
            } else if (player1.getScore() < player2.getScore()) {
                printWinner(player2, player1);
            } else {
                IO.println("Neither of you - It's a tie! You both scored " + player1.getScore() + ".");
            }

            //Reset player scores and restart, or quit game
            String playAgain = IO.readln("\nPress Enter to play again, or enter \"Q\" to quit. ");
            if (playAgain.equalsIgnoreCase("Q")) {
                IO.println("Thank you for playing Alfred's Dice Game! Welcome back any time.");
                keepRunning = false;
            } else {
                IO.println("Great, let's see who wins this time!\n");
                player1.resetScore();
                player2.resetScore();
            }
        }
    }

    static void playTurn(Player player) {
        IO.readln(player.getFullName() + ", press Enter to roll your first die.");
        int diceRoll = Dice.rollDice();
        player.addToScore(diceRoll);
        IO.readln("You rolled a " + diceRoll + "! Press Enter to roll your second die.");
        diceRoll = Dice.rollDice();
        player.addToScore(diceRoll);
        IO.println("You rolled a " + diceRoll + "!");
    }

    static void printWinner(Player winner, Player loser) {
        IO.println("***** " + winner.getFullName() + " with " + winner.getScore() + " points! Congratulations! *****");
        IO.println(loser.getFullName() + ", your " + loser.getScore() + " points were just not enough this time.");
    }
}
