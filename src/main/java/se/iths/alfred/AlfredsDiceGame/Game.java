package se.iths.alfred.AlfredsDiceGame;

public class Game {

    boolean keepRunning = true;

    public void playGame(Player player1, Player player2) {
        while (keepRunning) {

            playTurn(player1);
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
                IO.println("Neither of you - It's a tie! You both scored " + player1.getScore() + ".");
            }

            //Starta om eller avsluta
            String playAgain = IO.readln("\nPress Enter to play again, or enter \"Q\" to quit. ");
            if (playAgain.equalsIgnoreCase("Q")) {
                IO.println("Thank you for playing Alfred's Dice Game! Welcome back any time.");
                keepRunning = false;
            } else {
                IO.println("\nGreat! Let's see who wins this time.");
                player1.resetScore();
                player2.resetScore();
            }
        }
    }

    void playTurn(Player player) {
        IO.readln(player.getFullName() + ", press Enter to roll your first die.");
        int diceRoll = Dice.rollDice();
        player.addToScore(diceRoll);
        IO.readln("You rolled a " + diceRoll + "! Press Enter to roll your second die.");
        diceRoll = Dice.rollDice();
        player.addToScore(diceRoll);
        IO.println("You rolled a " + diceRoll + "!");
    }
}
