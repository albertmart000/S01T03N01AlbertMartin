package S01T03N01Ex03AlbertMartin;

public class User {

    private String name;
    private int score = 0;

    public User(String name) {
        this.name = name;
        }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {this.score = score; }

}
