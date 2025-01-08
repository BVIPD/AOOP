package task1;

public class MediumGameElementFactory implements GameElementFactory {
    @Override
    public Weapon createWeapon() {
        return new MediumWeapon();
    }
    @Override
    public PowerUp createPowerUp() {
        return new MediumPowerUp();
    }
 }