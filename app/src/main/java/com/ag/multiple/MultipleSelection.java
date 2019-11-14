package com.ag.multiple;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ag.multiple.adapters.MultipleAdapter;
import com.ag.multiple.models.Students;

import java.util.ArrayList;

public class MultipleSelection extends AppCompatActivity {
    private Button btnGetSelected;
    private MultipleAdapter adapter;
    private ArrayList<Students> students = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_selection);
        this.btnGetSelected = findViewById(R.id.btn2GetSelected);
        recyclerView = findViewById(R.id.recyclerVieww2);
        getSupportActionBar().setTitle("Multiple Selection");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        adapter = new MultipleAdapter(this, students);
        recyclerView.setAdapter(adapter);

        createList();
    }

    public void createList() {
        students = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Students student = new Students();
            student.setName("Students " + (i + 1));
            if (i == 0) {
                student.setChecked(true);
            }
            students.add(student);
        }
        adapter.setStudents(students);
    }
}
