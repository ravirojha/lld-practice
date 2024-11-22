import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<User> users;
    private final List<Task> tasks;
    private static TaskManager instance;

    private TaskManager() {
        this.users = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public static synchronized TaskManager getInstance() {
        if(instance == null) {
            instance = new TaskManager();
        }

        return instance;
    }


    public User createUser(String name, String email) {
        User newuser = new User(name, email);
        users.add(newuser);
        return newuser;
    }

    public Task createTask(String title, String content, LocalDateTime dueDate, User user, Priority priority) {
        Task newtask = new Task(title, content,dueDate, user, priority);
        tasks.add(newtask);
        user.addTaskToHistory(newtask);
        return newtask;
    }
    public synchronized void deleteTask(Task task) {
        tasks.removeIf(taskItem -> taskItem.equals(task));
    }
    public synchronized void changeStatus(Task task, Status status) {
        task.changeStatus(status);
    }
    public synchronized void changePriority(Task task, Priority priority) {
        task.changePriority(priority);
    }
    public synchronized void changeAssignee(Task task, User user) {
        task.changeAssignee(user);
        user.addTaskToHistory(task);
    }
    public synchronized void assignTask(Task task, User user) {
        task.changeAssignee(user);
    }

    public synchronized void markTaskAsCompleted(User user, Task task) {
        if(task.getManager().equals(user) || task.getAssignee().equals(user)) {
            task.changeStatus(Status.COMPLETED);
        }
    }


    public List<Task> searchTask(String keyword) {
        List<Task> result = new ArrayList<>();
        for(Task task: tasks) {
            if(task.getContent().contains(keyword) || task.getTitle().contains(keyword)) {
                result.add(task);
            }
        }

        return result;
    }

    public List<Task> searchTask(User assignedUser) {
        List<Task> result = new ArrayList<>();
        for(Task task: tasks) {
            if(task.getAssignee().equals(assignedUser)) {
                result.add(task);
            }
        }

        return result;
    }

    public List<Task> searchTask(Priority priority) {
        List<Task> result = new ArrayList<>();
        for(Task task: tasks) {
            if(task.getPriority().equals(priority)) {
                result.add(task);
            }
        }

        return result;
    }

    public List<Task> searchTask(Status status) {
        List<Task> result = new ArrayList<>();
        for(Task task: tasks) {
            if(task.getStatus().equals(status)) {
                result.add(task);
            }
        }

        return result;
    }

    public List<Task> getTaskHistory(User user) {
        return user.getTaskHistory();
    }


}
