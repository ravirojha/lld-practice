import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Answer {
    private List<Vote> votes;
    private String content;
    private final User author;
    private final LocalDateTime createdAt;
    private final UUID id;
    private List<Comment> comments;


    public Answer(String content, User author) {
        id = UUID.randomUUID();
        createdAt = LocalDateTime.now();
        this.author = author;
        this.content = content;
        comments = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public Comment addComment(String content, User user) {
        Comment newcomment = new Comment(content, user);
        comments.add(newcomment);
        user.increaseReputation();
        return newcomment;
    }

    public List<Comment> getComments() {
        return comments;
    }


    public void upvote(User user) {
        Vote newvote = new Vote(user);
        votes.add(newvote);
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public List<Vote> getVotes() {
        return this.votes;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UUID getId() {
        return id;
    }
}
