package com.surf.education.surfeducation;

public class Task {
    String title;
    String progress;
    String deadline;

    Task(String title, String progress, String deadline){
        this.title = title;
        this.progress = progress;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getProgress() {
        return progress;
    }

    public String getDeadline() {
        return deadline;
    }
}
