package com.example.datalist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.myViewHolder>{


    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.student_card,parent,false);
        return new StudentAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.myViewHolder holder, int position) {

        Student student = studentList.get(position);

        holder.name.setText(student.name);
        holder.age.setText(student.age + " ");
        holder.grade.setText(student.grade + " ");
        holder.address.setText(student.address);
        holder.distance.setText(student.distance + " ");


    }

    @Override
    public int getItemCount() {

        return studentList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView  name,age,grade,address,distance;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.edt_name);
            age=itemView.findViewById(R.id.edt_age);
            grade=itemView.findViewById(R.id.edt_grade);
            address=itemView.findViewById(R.id.edt_address);
            distance=itemView.findViewById(R.id.edt_distance);


        }
    }
}
