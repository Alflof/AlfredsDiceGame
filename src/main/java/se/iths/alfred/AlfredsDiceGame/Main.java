package se.iths.alfred.AlfredsDiceGame;

public class Main {

    //Deklaration
    static Player player1;
    static Player player2;
    static String player1FirstName;
    static String player1LastName;
    static String player2FirstName;
    static String player2LastName;
    static Game gameManager = new Game();
    static boolean validInput = false;

    static void main() {
        IO.println("\nWelcome to Alfred's Dice Game!");
        IO.println("In this game, two players throw two dices each, and their total score determines the winner.");

        //Låt spelarna mata in sina namn, validera strängarna, och fånga IllegalArgumentException
        while (!validInput) {
            try {
                if (player1FirstName == null) {
                    player1FirstName = checkString(IO.readln("\nPlayer 1, enter your first name: "));
                }
                if (player1LastName == null) {
                    player1LastName = checkString(IO.readln("\nPlayer 1, enter your last name: "));
                }
                if (player2FirstName == null) {
                    player2FirstName = checkString(IO.readln("\nPlayer 2, enter your first name: "));
                }
                if (player2LastName == null) {
                    player2LastName = checkString(IO.readln("\nPlayer 2, enter your last name: "));
                }
                //Avsluta loopen om alla Strings är godkända
                validInput = true;
            } catch (IllegalArgumentException e) {
                IO.println(e.getMessage());
            }
        }

        //Initiera objekt för player 1 och 2 med de godkända strängarna
        player1 = new Player(player1FirstName, player1LastName);
        player2 = new Player(player2FirstName, player2LastName);

        //Starta spelet
        IO.println("\nLet's get started! ");
        gameManager.playGame(player1, player2);
    }

    //Metod för att kolla om strängar är tomma
    private static String checkString(String text) throws IllegalArgumentException {
        if (text.equals("")) {
            throw new IllegalArgumentException("ERROR: The text field can't be empty. Please enter some text.");
        } else {
            return text;
        }
    }
}
