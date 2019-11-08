package com.ag.multiple.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ag.multiple.R;
import com.ag.multiple.models.Employees;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Employees> employees;
    private Context context;
    private static int TYPE_CALL = 1;
    private static int TYPE_EMAIL = 2;

    public EmployeeAdapter(ArrayList<Employees> employees, Context context) {
        this.employees = employees;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_CALL) {
            view = LayoutInflater.from(context).inflate(R.layout.item_call, parent, false);
            return new CallViewHolder(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_email, parent, false);
            return new CallViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_CALL) {
            ((CallViewHolder) holder).setCallDetails(employees.get(position));
        } else {
            ((EmailViewHolder) holder).setEmailDetails(employees.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(employees.get(position).getEmail())) {
            return TYPE_CALL;
        }
        return TYPE_EMAIL;
    }

    class CallViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private TextView txtAddress;

         CallViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.call_tvn);
            txtAddress = itemView.findViewById(R.id.call_tv_add);
        }

        private void setCallDetails(Employees employee) {
            txtName.setText(employee.getName());
            txtAddress.setText(employee.getAddress());
        }
    }

    class EmailViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private TextView txtAddress;

        EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.call_tvn);
            txtAddress = itemView.findViewById(R.id.call_tv_add);
        }

        private void setEmailDetails(Employees employee) {
            txtName.setText(employee.getName());
            txtAddress.setText(employee.getAddress());
        }
    }
}
