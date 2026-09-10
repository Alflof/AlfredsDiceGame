package se.iths.alfred.AlfredsDiceGame;

public class Main {

    //Deklaration
    static Player player1;
    static Player player2;
    static Game gameManager = new Game();

    static void main() {
        IO.println("\nWelcome to Alfred's Dice Game!");
        IO.println("In this game, two players throw two dices each, and their total score determines the winner.");

        //Skapa objekt för player 1 och 2
        String player1FirstName = IO.readln("\nPlayer 1, enter your first name: ");
        String player1LastName = IO.readln("Player 1, enter your last name: ");
        player1 = new Player(player1FirstName, player1LastName);
        String player2FirstName = IO.readln("\nPlayer 2, enter your first name: ");
        String player2LastName = IO.readln("Player 2, enter your last name: ");
        player2 = new Player(player2FirstName, player2LastName);

        //Starta spelet
        IO.println("\nLet's get started! ");
        gameManager.playGame(player1, player2);
    }
}
