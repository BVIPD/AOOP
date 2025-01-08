package task2;

public class RadioAdapter implements MusicPlayer {
    private RadioPlayer radioPlayer;
    public RadioAdapter(RadioPlayer radioPlayer) {
        this.radioPlayer = radioPlayer;
    }
    @Override
    public void play() {
        radioPlayer.playRadio();
    }
 }