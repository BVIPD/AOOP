package task1;
public class MediumEnemyFactory extends EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new MediumEnemy();
    }
 }