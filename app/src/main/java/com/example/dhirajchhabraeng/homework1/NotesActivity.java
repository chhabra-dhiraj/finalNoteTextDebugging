package com.example.dhirajchhabraeng.homework1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton addTitleButton;
    private EditText addTitleEditText;
    private Button addNotesButton;
    private EditText addNoteEditText;
    private ArrayList<Note> notesList = new ArrayList<>();
    private EditText outputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getStringExtra("Intent").equals("MainActivity")) {
            setContentView(R.layout.activity_notes);

            addNotesButton = findViewById(R.id.addNotes_button);

            addNoteEditText = findViewById(R.id.notesEdit_text);

            final Note note = (Note)getIntent().getSerializableExtra("KEY2");
            addNotesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("NotesActivity", "onClick: " + addNoteEditText.getText().toString());
                    note.setNoteText(addNoteEditText.getText().toString());
                    Log.e("NotesActivity", "onClick: after" + note.getTitleText());
                    finish();
                }
            });
        } else {
            setContentView(R.layout.activity_output);

            String finalNotesContent = getIntent().getStringExtra("KEY4");
            outputEditText = findViewById(R.id.outputEdit_text);

            outputEditText.setText(finalNotesContent);
        }
    }
}
