package com.example.lap07_sqlite1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ToDoApdapter extends RecyclerView.Adapter<ToDoApdapter.ToDoViewHolder>{

    private Context context;
    private List<ToDo> toDoList;

    public ToDoApdapter(Context context, List<ToDo> toDoList){
        this.context = context;
        this.toDoList = toDoList;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cardview,parent,false);
        return  new ToDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDo toDo= toDoList.get(position);
        holder.Title.setText(toDo.getTitle());
        holder.Content.setText(toDo.getContent());
        holder.Type.setText(toDo.getType());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }

    public class ToDoViewHolder extends RecyclerView.ViewHolder{
        TextView Title;
        TextView Content;
        TextView Type;


        public ToDoViewHolder(View itemView){
            super(itemView);
            Title = itemView.findViewById(R.id.txtTitleCard);
            Content = itemView.findViewById(R.id.txtContentCard);
            Type = itemView.findViewById(R.id.txtTypeCard);
        }
    }
}
