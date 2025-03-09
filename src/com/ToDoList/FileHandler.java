package com.ToDoList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public void saveTaskToFile(List<Task> tasks, String filename){
        try (FileWriter fileWriter = new FileWriter(filename);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);){
            for(Task task: tasks){
                bufferedWriter.write(task.getDescription() + "," + task.getCompleted());
                bufferedWriter.newLine();
            }
            System.out.println("Tasks saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    public List<Task> loadTasksFromFile(String filename){
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line=reader.readLine())!=null){
                String [] parts = line.split(",");
                String description = parts[0];
                boolean isCompleted = Boolean.parseBoolean(parts[1]);
                Task task = new Task(description);
                task.setCompleted(isCompleted);
                tasks.add(task);
            }
            System.out.println("Tasks loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading tasks from file: " + e.getMessage());
        }
        return tasks;
    }

}
