import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {
    private String content;
    private final UUID id;
    private final LocalDateTime createdAt;
    private final User author;

    public Comment(String content, User user) {
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.id = UUID.randomUUID();
        this.author = user;
    }

    public String getContent() {
        return this.content;
    }

    public User getAuthor() {
        return this.author;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
