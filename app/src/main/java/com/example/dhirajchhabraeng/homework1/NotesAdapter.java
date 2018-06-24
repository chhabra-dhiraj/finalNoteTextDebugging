package com.example.dhirajchhabraeng.homework1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter {

    private Context ctx;
    private ArrayList<Note> notesList;

    public NotesAdapter(Context ctx, ArrayList<Note> notesList) {
        this.ctx = ctx;
        this.notesList = notesList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView timeTextView, titleTextView;

        public ViewHolder(final View itemView) {
            super(itemView);

            timeTextView = itemView.findViewById(R.id.time_view);
            titleTextView = itemView.findViewById(R.id.title_view);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = getAdapterPosition();

                    notesList.remove(position);

                    notifyDataSetChanged();

                    return false;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    Log.e("NotesAdapter", "onClick: " + position);

                    Intent intent = new Intent(ctx, NotesActivity.class);
                    intent.putExtra("KEY4", notesList.get(position).getNoteText());
                    Log.e("NotesAdapter", "onClick: " + notesList.get(position).getNoteText());
                    intent.putExtra("Intent", "NotesAdapter");
                    ctx.startActivity(intent);

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(ctx).inflate(R.layout.list_item, parent, false);

        ViewHolder holder = new ViewHolder(inflatedView);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Note currentNote = notesList.get(position);

        ViewHolder nHolder = (ViewHolder) holder;

        nHolder.timeTextView.setText(currentNote.getTimeText());
        nHolder.titleTextView.setText(currentNote.getTitleText());
    }


    @Override
    public int getItemCount() {
        return notesList.size();
    }
}
