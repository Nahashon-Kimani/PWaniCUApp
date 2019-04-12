package com.peter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.peter.R;
import com.peter.model.SemesterProgramModel;

import java.util.ArrayList;

public class SemesterProgramAdapter extends RecyclerView.Adapter<SemesterProgramAdapter.MyHolder> {
     Context context;
     ArrayList<SemesterProgramModel> programModelArrayList;

    public SemesterProgramAdapter(Context context, ArrayList<SemesterProgramModel> programModelArrayList) {
        this.context = context;
        this.programModelArrayList = programModelArrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new MyHolder(inflater.inflate(R.layout.program_strip, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder,  int i) {
        myHolder.progTitle.setText(programModelArrayList.get(i).getTitle());
        myHolder.progDesc.setText(programModelArrayList.get(i).getDesc());
        myHolder.progDate.setText(programModelArrayList.get(i).getDate());

        myHolder.shareProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "More time required to share this event", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return programModelArrayList.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        ImageView shareProgram;
        TextView progTitle, progDesc, progDate;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            shareProgram = itemView.findViewById(R.id.share_program);
            progDate = itemView.findViewById(R.id.prog_date);
            progDesc = itemView.findViewById(R.id.prog_desc);
            progTitle = itemView.findViewById(R.id.prog_title);
        }
    }
}