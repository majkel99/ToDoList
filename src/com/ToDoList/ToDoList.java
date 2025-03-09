package com.ToDoList;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<Task> tasks;

    public ToDoList(){
        tasks = new ArrayList<>();
    }

    public void addTask(String description){
        Task task = new Task(description);
        tasks.add(task);
    }

    public void viewTasks(){
        if(tasks.isEmpty()){
            System.out.println("There are no tasks on your to-do list.");
        }
        else{
            for (int i=0; i<tasks.size(); i++){
                System.out.println((i+1) + ". " + tasks.get(i).toString());
            }
        }
    }

    public void markTaskAsCompleted(int index){
        if(index>=0 && index< tasks.size()){
            tasks.get(index).setCompleted(true);
            System.out.println("Task marked as completed.");
        }
        else {
            System.out.println("Invalid task index.");
        }
    }

    public void deleteTask(int index) {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks on your to-do list.");
        } else {
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                System.out.println("Task deleted.");
            } else {
                System.out.println("Invalid task index.");
            }
        }
    }

    public List<Task> getTasks(){
            return tasks;
    }


}
