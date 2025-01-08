package task1;

public class Main {
    public static void main(String[] args) {
        GameState gameState = GameState.getInstance();
        gameState.setLevel(1);
        gameState.setDifficulty("Medium");
        gameState.displayState();
        // Create enemies based on difficulty
        EnemyFactory enemyFactory;
        GameElementFactory gameElementFactory;
        switch (gameState.getDifficulty()) {
            case "Easy":
                enemyFactory = new EasyEnemyFactory();
                gameElementFactory = new EasyGameElementFactory();
                break;
            case "Medium":
                enemyFactory = new MediumEnemyFactory();
                gameElementFactory = new MediumGameElementFactory();
                break;
            case "Hard":
                enemyFactory = new HardEnemyFactory();
                gameElementFactory = new HardGameElementFactory();
                break;
            default:
                throw new IllegalArgumentException("Unknown difficulty level");
        }
        // Create and display enemy
        Enemy enemy = enemyFactory.createEnemy();
        enemy.display();
        // Create and display weapon
        Weapon weapon = gameElementFactory.createWeapon();
        weapon.display();
        // Create and display power-up
        PowerUp powerUp = gameElementFactory.createPowerUp();
        powerUp.display();
    }
 }
