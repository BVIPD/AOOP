package task1;

public class GameState {
    private static GameState instance;
    private int currentLevel;
    private String difficulty;
    private GameState() {
        this.currentLevel = 1;
        this.difficulty = "Easy";
    }
    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }
    public void setLevel(int level) {
        this.currentLevel = level;
    }
    public int getLevel() {
        return currentLevel;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void displayState() {
        System.out.println("Level: " + currentLevel + ", Difficulty: " + difficulty);
    }
 }
