package com.example.lap07_sqlite1;

public class ToDo {
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public ToDo(String title, String type, String content) {
        Title = title;
        Type = type;
        Content = content;
    }
    public ToDo(int Id, String title, String type, String content,int Status) {
        this.Id = Id;
        Title = title;
        Type = type;
        Content = content;
        this.Status = Status;
    }
    int Id;
    int Status;
    String Title;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    String Type;
    String Content;

}
