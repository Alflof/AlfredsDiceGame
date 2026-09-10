public class Player {

    private String firstName;
    private String lastName;
    private int score;

    //Konstruktor
    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    static void main() {
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int score) {
        //Uppdatera värdet för score här
        //Plussa på parameterns värde till this.score
        //Använd metoden varje gång en spelare slår tärningen
    }

    public String getFullName() {
        //Returnera hela namnet med strängkonkatenering
        //Metoden ska returnera spelarens förnamn och efterenamn som en sträng
    }
}
