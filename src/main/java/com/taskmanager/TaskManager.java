package com.taskmanager;
import java.util.ArrayList;
import java.util.List;
public class TaskManager implements TaskInterface {
    private List<Task> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
    }

    @Override
    public void addTask(Task task){
        tasks.add(task);
    }

    @Override 
    public boolean removeTask(Task task){
        return tasks.remove(task);
    }

    @Override 
    public List<Task> getTasks(){
        return new ArrayList<>(tasks);
    }

    @Override 
    public boolean completeTask(Task task){
        if (task == null || !tasks.contains(task)){
            return false;
        }
        task.markCompleted();
        return true;
    }

    @Override 
    public List<Task> getIncompleteTasks(){
        List<Task> temp = new ArrayList<>();
        Task currentTask;
        for (int i = 0; i < tasks.size(); i++){
            currentTask = tasks.get(i);
            if (!currentTask.isCompleted()){
                temp.add(currentTask);
            }
        }
        return temp;
    }
}
