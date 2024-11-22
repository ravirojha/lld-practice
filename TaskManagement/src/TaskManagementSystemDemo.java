
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TaskManagementSystemDemo {
    public static void run() {
        TaskManager taskManager = TaskManager.getInstance();

        // Create users
        User user1 = new User( "John Doe", "john@example.com");
        User user2 = new User("Jane Smith", "jane@example.com");

        // Add tasks to the task manager
        Task task1 = taskManager.createTask("Task 1", "Description 1", LocalDateTime.now().plusDays(2),  user1, Priority.ONE);
        Task task2 = taskManager.createTask("Task 2", "Description 2", LocalDateTime.now().plusDays(3),  user2, Priority.THREE);
        Task task3 = taskManager.createTask("Task 3", "Description 3", LocalDateTime.now().plusDays(5),  user1, Priority.FOUR);

        // Update a task
        task2.setContent("Updated description");

        // Search tasks
        List<Task> searchResults = taskManager.searchTask("Task");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }

        // Filter tasks
        List<Task> filteredTasks = taskManager.searchTask(Status.PENDING);
        System.out.println("Filtered Tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getTitle());
        }

        // Mark a task as completed
        taskManager.markTaskAsCompleted(user1, task1);

        // Get task history for a user
        List<Task> taskHistory = taskManager.getTaskHistory(user1);
        System.out.println("Task History for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTitle());
        }

        // Delete a task
        taskManager.deleteTask(task3);
    }
}