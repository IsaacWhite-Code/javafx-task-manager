package com.taskmanager;
import java.util.List;
public interface TaskInterface {

    // Adds a new task to the manager
    void addTask(Task task);

    // removes a task by its title a returns whether
    // it was found
    boolean removeTask(Task task);

    // Returns the list of all tasks
    List<Task> getTasks();

    // Marks a task as completed and reports
    // whether it was found
    boolean completeTask(Task task);

    // Returns only tasks that aren't completed
    List<Task> getIncompleteTasks();
}
