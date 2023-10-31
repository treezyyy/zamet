package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // код пишется в методе onCreate()

// получаем экземпляр элемента ListView
        ListView listView = findViewById(R.id.listView);

// определяем строковый массив
        final ArrayList<String> list = new ArrayList<>();

// используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        Button button;
        button = (Button) findViewById(R.id.button);
        listView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));

            }

        });


    }
}