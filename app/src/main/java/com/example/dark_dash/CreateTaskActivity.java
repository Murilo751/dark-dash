package com.example.dark_dash;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateTaskActivity extends AppCompatActivity {
    private EditText taskTitle;
    private EditText taskDescription;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        taskTitle = findViewById(R.id.taskTitle);
        taskDescription = findViewById(R.id.taskDescription);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> saveTask());
    }

    private void saveTask() {
        String title = taskTitle.getText().toString();
        String description = taskDescription.getText().toString();

        // Aqui você pode salvar os dados, seja em um banco de dados local ou enviando para uma API
    }
}