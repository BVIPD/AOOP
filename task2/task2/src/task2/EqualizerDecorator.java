package task2;

public class EqualizerDecorator extends MusicPlayerDecorator {
    public EqualizerDecorator(MusicPlayer decoratedPlayer) {
        super(decoratedPlayer);
    }
    @Override
    public void play() {
        decoratedPlayer.play();
        addEqualizer();
    }
    private void addEqualizer() {
        System.out.println("Applying equalizer settings.");
    }
 }