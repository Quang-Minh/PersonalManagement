package com.example.personalmanagement.model;

public class Note {
    private int id;
    private String title;
    private int folderID;
    private String date;
    private String time;
    private String content;
    private int isDelete;

    public Note() {
    }


    public Note(int id, String title, int folderID, String date, String time, String content, int isDelete) {
        this.id = id;
        this.title = title;
        this.folderID = folderID;
        this.date = date;
        this.time = time;
        this.content = content;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFolderID() {
        return folderID;
    }

    public void setFolderID(int folderID) {
        this.folderID = folderID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
