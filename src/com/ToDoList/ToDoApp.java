package com.ToDoList;

import java.util.List;
import java.util.Scanner;

public class ToDoApp {
    private ToDoList toDoList;
    private UserInputHandler userInputHandler;
    private FileHandler fileHandler;

    public ToDoApp(){
        toDoList = new ToDoList();
        userInputHandler = new UserInputHandler();
        fileHandler = new FileHandler();
    }
    public void run(){
        boolean exit = false;

        while(!exit){
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. View tasks");
            System.out.println("2. Add task");
            System.out.println("3. Remove task");
            System.out.println("4. Mark task as completed");
            System.out.println("5. Save list of tasks to a file");
            System.out.println("6. Load list of tasks from a file");
            System.out.println("7. Exit");

            System.out.print("Enter number from the list: ");
            int choice = userInputHandler.getNumber();

            switch (choice){
                case 1:
                    toDoList.viewTasks();
                    break;
                case 2:
                    System.out.print("Enter task description: ");
                    String taskDescription = userInputHandler.getString();
                    toDoList.addTask(taskDescription);
                    break;
                case 3:
                    System.out.print("Enter task index: ");
                    int deleteIndex = userInputHandler.getNumber();
                    toDoList.deleteTask(deleteIndex-1);
                    break;
                case 4:
                    System.out.print("Enter task index: ");
                    int completeIndex = userInputHandler.getNumber();
                    toDoList.markTaskAsCompleted(completeIndex-1);
                    break;
                case 5:
                    System.out.println("Enter file name: ");
                    String saveFilename = userInputHandler.getString();
                    fileHandler.saveTaskToFile(toDoList.getTasks(), saveFilename);
                    break;
                case 6:
                    System.out.println("Enter file name: ");
                    String loadFilename = userInputHandler.getString();
                    List <Task> loadedTasks = fileHandler.loadTasksFromFile(loadFilename);
                    toDoList = new ToDoList();
                    toDoList.getTasks().addAll(loadedTasks);
                    break;
                case 7:
                    exit=true;
                    System.out.println("Exiting the application.");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }

        }

    }
}
