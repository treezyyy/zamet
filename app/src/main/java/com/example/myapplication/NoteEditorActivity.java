package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class NoteEditorActivity extends AppCompatActivity {

    int noteID;

    int noteID2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);


        EditText editText = (EditText)findViewById(R.id.editText);
        Intent intent = getIntent();
        noteID = intent.getIntExtra("noteID", -1);

        EditText editText2 = (EditText)findViewById(R.id.editText2);
        Intent intent2 = getIntent();
        noteID2 = intent2.getIntExtra("noteID2", -1);


        if(noteID != -1)
        {
            editText.setText(MainActivity.notes.get(noteID));
        }

        editText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                MainActivity.notes.set(noteID, String.valueOf(s));
                MainActivity.arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        if(noteID2 != -1)
        {
            editText2.setText(MainActivity.notes2.get(noteID2));
        }

        editText2.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                MainActivity.notes2.set(noteID2, String.valueOf(s));
                MainActivity.arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });




// определяем строковый массив

// используем адаптер данных

        ImageButton button;
        button = (ImageButton) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }

        });



    }
}