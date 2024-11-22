import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private Priority priority;
    private Reminder reminder;
    private final UUID id;
    private String title;
    private String content;
    private User manager;
    private User assignee;
    private Status status;
    private final LocalDateTime createdAt;
    private LocalDateTime dueDate;

    public Task(String title, String content, LocalDateTime dueDate, User assignee, Priority priority) {
        this.title = title;
        this.content = content;
        this.dueDate = dueDate;
        this.manager = manager;
        this.id = UUID.randomUUID();
        this.priority = priority;
        this.status = Status.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public Task(String title, String content,LocalDateTime dueDate, User assignee, Priority priority, User manager) {
        this.title = title;
        this.content = content;
        this.dueDate = dueDate;
        this.manager = manager;
        this.assignee = assignee;
        this.id = UUID.randomUUID();
        this.priority = priority;
        this.status = Status.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public void changeStatus(Status status) {
        this.status = status;
    }
    public void changePriority(Priority priority) {
        this.priority = priority;
    }
    public void changeAssignee(User assignee) {
        this.assignee = assignee;
    }

    public User getManager() {
        return this.manager;
    }

    public User getAssignee() {
        return this.assignee;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public Status getStatus() {
        return this.status;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setContent(String content) {
        this.content =content;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
