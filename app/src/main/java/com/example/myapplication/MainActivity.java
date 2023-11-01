package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> notes = new ArrayList<String>();
    static ArrayList<String> notes2 = new ArrayList<String>();

    static ArrayAdapter<String> arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

// определяем строковый массив
        final ArrayList<String> list = new ArrayList<>();

// используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        ImageButton button;
        button = (ImageButton) findViewById(R.id.button);
        listView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                notes.add("Заголовок");
                notes2.add("Текст");
                recreate();
            }

        });
        ImageButton button1;
        button1 = (ImageButton) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                notes.clear();
                recreate();
            }

        });
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapter);









        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(getApplicationContext(), NoteEditorActivity.class);
                intent.putExtra("noteID", position);            //to tell us which row of listView was tapped
                intent.putExtra("noteID2", position);
                startActivity(intent);
            }
        });





    }



}