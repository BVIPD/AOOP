package Module1A;
public class Post {
    private String content;
    private String username;
    
    // Constructor
    public Post(String username, String content) {
        this.username = username;
        this.content = content;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }
    
    @Override
    public String toString() {
        return username + ": " + content;
    }
}
