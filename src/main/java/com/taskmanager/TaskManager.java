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
    public boolean removeTask(String title){
        Task currentTask;
        for (int i = 0; i < tasks.size(); i++){
            currentTask = tasks.get(i);
            if (currentTask.getTitle().equals(title)){
                tasks.remove(i);
                return true;
            }
        }
        return false; 
    }

    @Override 
    public List<Task> getTasks(){
        return tasks;
    }

    @Override 
    public boolean completeTask(String title){
        Task currentTask;
        for (int i = 0; i < tasks.size(); i++){
            currentTask = tasks.get(i);
            if (currentTask.getTitle().equals(title)){
                currentTask.markCompleted();
                return true;
            }
        }
        return false;
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
