package com.peter.homeFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.peter.R;
import com.peter.adapter.SemesterProgramAdapter;
import com.peter.model.SemesterProgramModel;

import java.util.ArrayList;

public class Program extends Fragment {
    View view;
    RecyclerView progRecyclerView;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    SemesterProgramModel semesterProgramModel;
    ArrayList<SemesterProgramModel> programModelArrayList = new ArrayList<>();

    public Program() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.program_fragment, container, false);
        progRecyclerView = view.findViewById(R.id.prog_recycler_view);
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("Semester Program");

        /*semesterProgramModel = new SemesterProgramModel("Today", "This is today and not tomorrow", "23/9/2019");
        mRef.push().setValue(semesterProgramModel);*/

        loadProgram();
        return view;
    }


    public void loadProgram() {
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    programModelArrayList.add(snapshot.getValue(SemesterProgramModel.class));
                }
                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                progRecyclerView.setLayoutManager(manager);
                progRecyclerView.setAdapter(new SemesterProgramAdapter(getContext(), programModelArrayList));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
