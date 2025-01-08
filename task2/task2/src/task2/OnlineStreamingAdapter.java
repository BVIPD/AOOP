package task2;

public class OnlineStreamingAdapter implements MusicPlayer {
    private OnlineStreamingPlayer onlineStreamingPlayer;
    public OnlineStreamingAdapter(OnlineStreamingPlayer onlineStreamingPlayer) {
        this.onlineStreamingPlayer = onlineStreamingPlayer;
    }
    @Override
    public void play() {
        onlineStreamingPlayer.playOnlineStream();
    }
 }