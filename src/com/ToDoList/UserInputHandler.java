package com.ToDoList;

import java.util.Scanner;

public class UserInputHandler {
    private Scanner scanner;

    public UserInputHandler(){
        scanner = new Scanner(System.in);
    }

    public int getNumber(){
        while (!scanner.hasNextInt()){
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String getString(){
        scanner.nextLine();
        return scanner.nextLine();
    }

}
