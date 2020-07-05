package com.example.instantgroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;

    RecyclerView jRecyclerView;
    FirebaseDatabase jFirebaseDatabase;
    DatabaseReference jRef;
    RecyclerView qRecyclerView;
    FirebaseDatabase qFirebaseDatabase;
    DatabaseReference qRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton=findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Uploadinstant.class);
                startActivity(intent);
            }
        });



        jRecyclerView = findViewById(R.id.mainpic);
        jRecyclerView.setHasFixedSize(true);
        jRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        jFirebaseDatabase = FirebaseDatabase.getInstance();
        jRef = jFirebaseDatabase.getReference("instant");

        qRecyclerView = findViewById(R.id.instatag);
        qRecyclerView.setHasFixedSize(true);
        qRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        qFirebaseDatabase = FirebaseDatabase.getInstance();
        qRef = qFirebaseDatabase.getReference("usertags");

    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model, ViewHolder2> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder2>(
                        Model.class,
                        R.layout.mainpic,
                        ViewHolder2.class,
                        jRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder2 viewHolder, Model model, int position) {
                        viewHolder.setDetails(getApplicationContext(), model.getName(),  model.getImageUrl());
                    }
                };

        jRecyclerView.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder2>(
                Model.class,
                R.layout.instatag,
                ViewHolder2.class,
                qRef
        ) {
            @Override
            protected void populateViewHolder(ViewHolder2 viewHolder, Model model, int position) {
                viewHolder.setDetails( getApplicationContext(), model.getName(),  model.getImageUrl() );
            }
        };
        qRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
