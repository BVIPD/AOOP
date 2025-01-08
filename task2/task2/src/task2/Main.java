package task2;

public class Main {
    public static void main(String[] args) {
        // Create different music source objects
        LocalFilePlayer localFilePlayer = new LocalFilePlayer();
        OnlineStreamingPlayer onlineStreamingPlayer = new OnlineStreamingPlayer();
        RadioPlayer radioPlayer = new RadioPlayer();
        // Wrap them with adapters
        MusicPlayer localPlayer = new LocalFileAdapter(localFilePlayer);
        MusicPlayer onlinePlayer = new OnlineStreamingAdapter(onlineStreamingPlayer);
        MusicPlayer radio = new RadioAdapter(radioPlayer);
        //Add decorators
        MusicPlayer equalizedLocalPlayer = new EqualizerDecorator(localPlayer);
        MusicPlayer volumeControlledOnlinePlayer = new VolumeControlDecorator(onlinePlayer);
        MusicPlayer fullFeaturedRadio = new EqualizerDecorator(new 
VolumeControlDecorator(radio));
        // Play music
        System.out.println("Playing music from local file:");
        equalizedLocalPlayer.play();
        System.out.println("\nPlaying music from online streaming:");
        volumeControlledOnlinePlayer.play();
        System.out.println("\nPlaying music from radio:");
        fullFeaturedRadio.play();
    }
 }