package Module1A;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class UserFeedTest {

    @Test
    public void testIterateEverySecondPost() {
        // Creating some posts
        Post post1 = new Post("Alice", "Post 1");
        Post post2 = new Post("Bob", "Post 2");
        Post post3 = new Post("Charlie", "Post 3");
        Post post4 = new Post("Dave", "Post 4");

        // Create a UserFeed instance
        UserFeed feed = new UserFeed();

        // Add posts to feed
        feed.addPost(post1);
        feed.addPost(post2);
        feed.addPost(post3);
        feed.addPost(post4);

        // Expected posts (every second post)
        List<String> expectedPosts = Arrays.asList("Post 1", "Post 3");

        // Test the iteration behavior
        int index = 0;
        for (Post post : feed) {
            assertEquals(expectedPosts.get(index++), post.getContent());
        }
    }
}
