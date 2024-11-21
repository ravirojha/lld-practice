import java.time.LocalDateTime;
import java.util.UUID;

public class Tag {
    private String tagContent;
    private final UUID id;
    private final LocalDateTime createdAt;

    public Tag(String content) {
        this.tagContent = content;
        createdAt = LocalDateTime.now();
        id = UUID.randomUUID();
    }

    public void modifyTag(String content) {
        this.tagContent = content;
    }

    public String getTagContent() {
        return this.tagContent;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public UUID getId() {
        return this.id;
    }
}
