package org.example;

public class TodoItem{
    String title;
    String description;
    enum Status {
        pending,completed;
    }
    Status status;
    TodoItem(String title,String description, Status status){
        this.description=description;
        this.title=title;
        this.status=status;
    }
    //getters
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public Status getStatus(){
        return this.status;
    }

    //setters
    public void setTitle(String title){
        this.title=title;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setStatus(Status status){
        this.status=status;
    }

}