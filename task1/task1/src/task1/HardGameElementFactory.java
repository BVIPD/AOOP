package task1;

public class HardGameElementFactory implements GameElementFactory {
    @Override
    public Weapon createWeapon() {
        return new HardWeapon();
    }
    @Override
    public PowerUp createPowerUp() {
        return new HardPowerUp();
    }
 }