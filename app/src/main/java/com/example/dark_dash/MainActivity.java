package com.example.dark_dash;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase connection;
    private DataBaseHelper db_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //criando conexão com o banco
        createConection();

        Intent tela_criar_atv = new Intent(MainActivity.this, CreateTaskActivity.class);
        Button btn_adicionar_tarefa = findViewById(R.id.Adicionar);
        btn_adicionar_tarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(tela_criar_atv);
            }
        });
        //instanciando taskDAO
        TaskDAO taskDAO = new TaskDAO(connection);

        ListView listView = findViewById(R.id.listaAtv);
        List<Task> list_tasks = new ArrayList<>();

        for(Task task: taskDAO.taskLists()){
            Task temporary_task = new Task(task.getTitle(), task.getDescription());
            list_tasks.add(temporary_task);
        }
        ActivityAdapter adapter = new ActivityAdapter(this, list_tasks);
        listView.setAdapter(adapter);
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