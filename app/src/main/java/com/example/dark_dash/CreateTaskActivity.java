package com.example.dark_dash;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class CreateTaskActivity extends AppCompatActivity {
    private EditText taskTitle;
    private EditText taskDescription;
    private Button saveButton;
    private SQLiteDatabase connection;
    private DataBaseHelper db_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        createConection();
        taskTitle = findViewById(R.id.taskTitle);
        taskDescription = findViewById(R.id.taskDescription);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> saveTask());
    }

    private void saveTask() {
        String title = taskTitle.getText().toString();
        String description = taskDescription.getText().toString();
        Intent voltar_main = new Intent(CreateTaskActivity.this, MainActivity.class);
        startActivity(voltar_main);
        TaskDAO taskDAO = new TaskDAO(connection);
        Task task = new Task(title, description);
        taskDAO.insert(task);
    }

    private void createConection(){
        try{
            Toast.makeText(this,R.string.sucess_conection,Toast.LENGTH_LONG).show();
            db_helper = new DataBaseHelper(this.getApplicationContext());
            connection = db_helper.getWritableDatabase();
            Toast.makeText(this,R.string.sucess_conection,Toast.LENGTH_LONG).show();
        }catch(SQLException e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}