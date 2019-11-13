package com.ag.multiple;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ag.multiple.adapters.SingleAdapter;
import com.ag.multiple.models.Employees;

import java.util.ArrayList;

public class SingleSelection extends AppCompatActivity {
    private Button btnGetSelected;
    private RecyclerView recyclerView;
    private ArrayList<Employees> employees = new ArrayList<>();
    private SingleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_selection);
        this.btnGetSelected = findViewById(R.id.btnGetSelected);
        this.recyclerView = findViewById(R.id.recyclerVieww);

        getSupportActionBar().setTitle("Single Selection");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new SingleAdapter(this, employees);
        recyclerView.setAdapter(adapter);
        createList();

        btnGetSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapter.getSelected() != null) {
                    Toast.makeText(SingleSelection.this, adapter.getSelected().getName(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SingleSelection.this, "No selection", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void createList() {
        employees = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Employees employe = new Employees();
            employe.setName("Employe " + (i + 1));
            employees.add(employe);
        }
        adapter.setEmployees(employees);
    }
}
