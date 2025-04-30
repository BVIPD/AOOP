package Module1A;
import java.util.Iterator;
import java.util.ArrayList;

public class UserFeed implements Iterable<Post> {
    private ArrayList<Post> posts;

    // Constructor to initialize the feed
    public UserFeed() {
        this.posts = new ArrayList<>();
    }

    // Method to add a post to the feed
    public void addPost(Post post) {
        posts.add(post);
    }

    // Custom iterator for iterating through every second post
    @Override
    public Iterator<Post> iterator() {
        return new Iterator<Post>() {
            private int currentIndex = 0;  // Start from the first post

            @Override
            public boolean hasNext() {
                // Check if the current index is within bounds
                return currentIndex < posts.size();
            }

            @Override
            public Post next() {
                // Get the current post and move the index to skip one post
                if (!hasNext()) {
                    throw new IllegalStateException("No more posts.");
                }
                Post post = posts.get(currentIndex);
                currentIndex += 2;  // Skip the next post
                return post;
            }
        };
    }
}
