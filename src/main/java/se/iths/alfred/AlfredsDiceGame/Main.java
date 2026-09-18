package se.iths.alfred.AlfredsDiceGame;

public class Main {

    static Player player1;
    static Player player2;
    static String player1FirstName;
    static String player1LastName;
    static String player2FirstName;
    static String player2LastName;
    static Game gameManager = new Game();

    static void main() {
        IO.println("\nWelcome to Alfred's Dice Game!");
        IO.println("In this game, two players roll two dice each, and their total score determines the winner.\n");

        player1FirstName = getName("Player 1, enter your first name: ");
        player1LastName = getName("Player 1, enter your last name: ");
        player2FirstName = getName("Player 2, enter your first name: ");
        player2LastName = getName("Player 2, enter your last name: ");

        startGame();
    }

    //Loops until valid input is given
    private static String getName(String promptText) {
        String name = null;
        while (name == null) {
            try {
                name = validateString(IO.readln(promptText));
            } catch (IllegalArgumentException e) {
                IO.println(e.getMessage());
            }
        }
        return name;
    }

    //Validates non-empty string and character limit
    private static String validateString(String userText) throws IllegalArgumentException {
        if (userText.equals("") || userText.length() > 40) {
            throw new IllegalArgumentException("ERROR: The text field can't be empty or longer than 40 characters.");
        } else {
            return userText;
        }
    }

    static void startGame() {
        IO.println("\nLet's get started! ");
        player1 = new Player(player1FirstName, player1LastName);
        player2 = new Player(player2FirstName, player2LastName);
        gameManager.playGame(player1, player2);
    }
}
