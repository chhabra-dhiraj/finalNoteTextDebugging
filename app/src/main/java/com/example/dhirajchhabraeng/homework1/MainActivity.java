package com.example.dhirajchhabraeng.homework1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton addTitleButton;
    private EditText addTitleEditText;
    ArrayList<Note> notesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        addTitleButton = findViewById(R.id.addTitle_button);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        StaggeredGridLayoutManager slm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        final NotesAdapter notesAdapter = new NotesAdapter(MainActivity.this, notesList);
        recyclerView.setAdapter(notesAdapter);

        addTitleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Enter Title");

                addTitleEditText = new EditText(MainActivity.this);

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                addTitleEditText.setLayoutParams(lp);

                alertDialogBuilder.setView(addTitleEditText);

                alertDialogBuilder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Note note = new Note("" + Calendar.getInstance().getTime().toString(),
                                "" + addTitleEditText.getText().toString());

                        Intent intent = new Intent(MainActivity.this, NotesActivity.class);
                        intent.putExtra("KEY1", addTitleEditText.getText().toString());
                        intent.putExtra("KEY2", (Serializable) note);
                        intent.putExtra("Intent", "MainActivity");
                        startActivity(intent);

                        notesList.add(note);

                        notesAdapter.notifyDataSetChanged();
                    }
                });

                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alertDialogBuilder.show();
            }
        });
    }
}
