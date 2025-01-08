package task1;
public class EasyGameElementFactory implements GameElementFactory {
    @Override
    public Weapon createWeapon() {
        return new EasyWeapon();
    }
    @Override
    public PowerUp createPowerUp() {
        return new EasyPowerUp();
    }
 }