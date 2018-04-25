package com.example.android.akuanaksehatmiriplinetoday;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Penyakit> mPenyakitData;
    private PenyakitAdapter mAdapter;
    private DatabaseReference mDatabaseRef;

    public MainActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Selamat Datang", Toast.LENGTH_SHORT).show();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("penyakit");
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

//        int gridColumn = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPenyakitData = new ArrayList<>();

        mAdapter = new PenyakitAdapter(this, mPenyakitData);
        mRecyclerView.setAdapter(mAdapter);

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot post : dataSnapshot.getChildren()){
                    Penyakit model = post.getValue(Penyakit.class);
                    mPenyakitData.add(model);
                }
                mAdapter = new PenyakitAdapter(MainActivity.this, mPenyakitData);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


}
