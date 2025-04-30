package Module1A;

public class Main {
    public static void main(String[] args) {
        // Create some posts
        Post post1 = new Post("Alice", "Having a great day!");
        Post post2 = new Post("Bob", "Just learned Java iterators.");
        Post post3 = new Post("Charlie", "Loving this coffee shop vibe.");

        // Create a user feed and add posts
        UserFeed feed = new UserFeed();
        feed.addPost(post1);
        feed.addPost(post2);
        feed.addPost(post3);

        // Iterate through the feed using custom iterator
        System.out.println("User Feed:");
        for (Post post : feed) {
            System.out.println(post);
        }
    }
}
