package com.example.datalist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.datalist.R.id.input_wrapper;

public class MainActivity extends AppCompatActivity {

    private EditText edtName,edtAge,edtGrade,edtAdd,edtDis;
    private LinearLayout inputWrapper;
    private Button add,view;
    private RecyclerView studentRv;
    private List <Student> studentList = new ArrayList<>();
    private StudentAdapter studentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName= findViewById(R.id.edt_name);
        edtAge= findViewById(R.id.edt_age);
        edtGrade= findViewById(R.id.edt_grade);
        edtAdd= findViewById(R.id.edt_address);
        edtDis= findViewById(R.id.edt_distance);
        studentRv= findViewById(R.id.student_list_view);
        inputWrapper = findViewById(input_wrapper);

        view = findViewById(R.id.view);
        add = findViewById(R.id.add);

        inputWrapper.setVisibility(View.VISIBLE);
        studentRv.setVisibility(View.GONE);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student stu1 = new Student();
                stu1.name = edtName.getText().toString();
                stu1.age = Integer.parseInt(edtAge.getText().toString());
                stu1.grade = Integer.parseInt(edtGrade.getText().toString());
                stu1.address = edtAdd.getText().toString();
                stu1.distance = Integer.parseInt(edtDis.getText().toString());

                studentList.add(stu1);

            }
        });

        view.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                studentAdapter= new StudentAdapter(studentList);
                studentRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                studentRv.setAdapter(studentAdapter);

                inputWrapper.setVisibility(View.GONE);
                studentRv.setVisibility(View.VISIBLE);


            }
        });

    }
}