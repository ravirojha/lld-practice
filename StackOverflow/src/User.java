import java.util.UUID;

public class User {
    private String name;
    private final UUID id;
    private String email;
    private int reputation;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.id = UUID.randomUUID();
        this.reputation = 0;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void increaseReputation() {
        reputation++;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UUID getId() {
        return id;
    }

    public int getReputation() {
        return reputation;
    }
}
