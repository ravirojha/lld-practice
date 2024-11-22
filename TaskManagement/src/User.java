import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String name;
    private String email;
    private final UUID id;
    private final List<Task> taskHistory;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.id = UUID.randomUUID();
        this.taskHistory = new ArrayList<>();
    }

    public List<Task> getTaskHistory() {
        return this.taskHistory;
    }

    public void addTaskToHistory(Task task) {
        this.taskHistory.add(task);
    }

    public String getName() {
        return this.name;
    }
}
