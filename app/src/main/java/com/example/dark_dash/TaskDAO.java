package com.example.dark_dash;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    SQLiteDatabase connection;
    public TaskDAO(SQLiteDatabase connection){
        this.connection = connection;
    }

    public void insert(Task task){
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", task.getTitle());
        contentValues.put("description", task.getDescription());
        connection.insertOrThrow("TaskList",null, contentValues);
    }

    public List<Task> taskLists(){
        List<Task> taskList = new ArrayList<>();
        Cursor result = connection.rawQuery(DDL_db.getAllTasks(), null);
        if(result.getCount()>0){
            result.moveToFirst();
            do{
                Task task = new Task();
                task.setTitle(result.getString(result.getColumnIndexOrThrow("title")));
                task.setDescription(result.getString(result.getColumnIndexOrThrow("description")));
                int resposta_status = result.getInt(result.getColumnIndexOrThrow("status"));
                if(resposta_status==1){
                    task.setStatus(true);
                }else{
                    task.setStatus(false);
                }
                taskList.add(task);
            }while(result.moveToNext());
        }
        result.close();
        return taskList;
    }
}
