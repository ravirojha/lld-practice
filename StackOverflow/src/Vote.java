import java.time.LocalDateTime;
import java.util.UUID;

public class Vote {
    private final User owner;
    private final UUID id;
    private final LocalDateTime createdAt;

    public Vote(User user) {
        this.owner = user;
        this.createdAt = LocalDateTime.now();
        this.id = UUID.randomUUID();
    }

    public User getVoteOwner() {
        return this.owner;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public UUID getId() {
        return this.id;
    }

}
