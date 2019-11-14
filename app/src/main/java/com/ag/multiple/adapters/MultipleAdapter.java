package com.ag.multiple.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ag.multiple.R;
import com.ag.multiple.models.Students;

import java.util.ArrayList;

public class MultipleAdapter extends RecyclerView.Adapter<MultipleAdapter.MultipleViewHolder> {
    private Context context;
    private ArrayList<Students> students;

    public MultipleAdapter(Context context, ArrayList<Students> students) {
        this.context = context;
        this.students = students;
    }

    public void setStudents(ArrayList<Students> students) {
        this.students = new ArrayList<>();
        this.students = students;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MultipleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employe, parent, false);
        return new MultipleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultipleViewHolder holder, int position) {
        holder.bind(students.get(position));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class MultipleViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        MultipleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(final Students students) {
            imageView.setVisibility(students.isChecked() ? View.VISIBLE : View.GONE);
            textView.setText(students.getName());

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    students.setChecked(!students.isChecked());
                    imageView.setVisibility(students.isChecked() ? View.VISIBLE : View.GONE);
                }
            });
        }

        public ArrayList<Students> getAll() {
            return students;
        }

        public ArrayList<Students> getSelected() {
            ArrayList<Students> selected = new ArrayList<>();
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).isChecked()) {
                    selected.add(students.get(i));
                }
            }
            return selected;
        }
    }
}
