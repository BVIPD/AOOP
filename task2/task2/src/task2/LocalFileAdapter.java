package task2;

public class LocalFileAdapter implements MusicPlayer {
    private LocalFilePlayer localFilePlayer;
    public LocalFileAdapter(LocalFilePlayer localFilePlayer) {
        this.localFilePlayer = localFilePlayer;
    }
    @Override
    public void play() {
        localFilePlayer.playLocalFile();
    }
 }

