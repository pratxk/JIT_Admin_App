package com.example.jitadminapp.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jitadminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView cseDepartment, etcDepartment, eeDepartment, meDepartment;
    private LinearLayout cseNoData, etcNoData, eeNoData, meNoData;
    private List<TeacherData> list1, list2, list3, list4;
    private DatabaseReference reference, dbRef;
    private TeacherAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cseDepartment = findViewById(R.id.cseDepartment);
        etcDepartment = findViewById(R.id.etcDepartment);
        eeDepartment = findViewById(R.id.eeDepartment);
        meDepartment = findViewById(R.id.meDepartment);


        meNoData = findViewById(R.id.meNoData);
        eeNoData = findViewById(R.id.eeNoData);
        etcNoData = findViewById(R.id.etcNoData);
        cseNoData = findViewById(R.id.cseNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");


        cseDepartment();
        meDepartment();
        etcDepartment();
        eeDepartment();

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateFaculty.this,AddTeachers.class));
            }
        });
    }

    private void cseDepartment() {
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if(!snapshot.exists()){
                    cseNoData.setVisibility(View.VISIBLE);
                    cseDepartment.setVisibility(View.GONE);
                }else {

                    cseNoData.setVisibility(View.GONE);
                    cseDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1: snapshot.getChildren() ){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    cseDepartment.setHasFixedSize(true);
                    cseDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1,UpdateFaculty.this);
                    cseDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void etcDepartment() {
        dbRef = reference.child("Electronics & Telecommunication");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if(!snapshot.exists()){
                    etcNoData.setVisibility(View.VISIBLE);
                    etcDepartment.setVisibility(View.GONE);
                }else {

                    etcNoData.setVisibility(View.GONE);
                    etcDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1: snapshot.getChildren() ){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    etcDepartment.setHasFixedSize(true);
                    etcDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2,UpdateFaculty.this);
                    etcDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void eeDepartment() {
        dbRef = reference.child("Electrical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if(!snapshot.exists()){
                    eeNoData.setVisibility(View.VISIBLE);
                    eeDepartment.setVisibility(View.GONE);
                }else {

                    eeNoData.setVisibility(View.GONE);
                    eeDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1: snapshot.getChildren() ){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    eeDepartment.setHasFixedSize(true);
                    eeDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3,UpdateFaculty.this);
                    eeDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void meDepartment() {
        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if(!snapshot.exists()){
                    meNoData.setVisibility(View.VISIBLE);
                    meDepartment.setVisibility(View.GONE);
                }else {

                    meNoData.setVisibility(View.GONE);
                    meDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1: snapshot.getChildren() ){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    meDepartment.setHasFixedSize(true);
                    meDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4,UpdateFaculty.this);
                    meDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}