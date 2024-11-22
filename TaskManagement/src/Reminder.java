import java.time.LocalDateTime;

public class Reminder {
    private LocalDateTime dateTime;
    private final LocalDateTime createdAt;


    public Reminder(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.createdAt = LocalDateTime.now();
    }

    public void changeReminder(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
