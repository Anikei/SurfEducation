package com.surf.education.surfeducation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksHolder>{
    private static final int WHITE = 1;
    private static final int GRAY = 0;
    private List<Task> taskList;

    public TasksAdapter(LinkedList<Task> moviesList) {
        this.taskList = moviesList;
    }

    @Override
    public TasksHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_list_row, parent, false);
        return new TasksHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TasksHolder holder, int position) {
        Task task = taskList.get(position);
        holder.title.setText(task.getTitle());
        holder.progress.setText(task.getProgress());
        holder.deadline.setText(task.getDeadline());
        //TODO: сделать чередование стилей
        /*
        if (position % 2 == 0) {
            holder.
                    ="R.color.colorAccent"
        } else {
            android:background="@color/colorPrimary"
        }
        */
    }
    @Override
    public int getItemCount() {
        return taskList.size();
    }


    public class TasksHolder extends RecyclerView.ViewHolder {
        public TextView title, progress, deadline;

        public TasksHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            progress = (TextView) view.findViewById(R.id.progress);
            deadline = (TextView) view.findViewById(R.id.deadline);

        }
    }



}
