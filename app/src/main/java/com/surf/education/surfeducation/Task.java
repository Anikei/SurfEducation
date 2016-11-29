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

/*
MODEL
	TASK
		-String(fix) name
		-int startPoint (default = 0)
		-int endPoint (default = 100)
		-int currentPoint (default = startPoint)
		-date startDate (default = today)
		-date deadlineDate (default = today)

		calc int percent = (currentPoint - startPoint) / endPoint
		calc date estimateDate =

	RECORD
		-*Task
		-date Date
		-date Duration
		-currentPoint

	Journal
		несортированный list[]<Record>

*/