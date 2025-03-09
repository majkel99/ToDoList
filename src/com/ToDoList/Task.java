package com.ToDoList;

public class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description){
        this.description = description;
        isCompleted = false;
    }

    public String getDescription(){
        return description;
    }

    public boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed){
        isCompleted = completed;
    }

    @Override
    public String toString(){
        String status = isCompleted ? "[X]" : "[]";
        return status + " " + description;
    }

}
