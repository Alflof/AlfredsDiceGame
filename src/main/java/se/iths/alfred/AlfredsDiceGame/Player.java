package se.iths.alfred.AlfredsDiceGame;

public class Player {

    private String firstName;
    private String lastName;
    private int score;

    //Konstruktor
    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void addToScore(int score) {
        this.score += score;
    }
}
