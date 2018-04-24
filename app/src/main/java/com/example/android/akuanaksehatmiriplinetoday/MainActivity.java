package com.example.android.akuanaksehatmiriplinetoday;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Penyakit> mAirData;
    private PenyakitAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Selamat Datang", Toast.LENGTH_SHORT).show();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        int gridColumn = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumn));

        mAirData = new ArrayList<>();

        mAdapter = new PenyakitAdapter(this, mAirData);
        mRecyclerView.setAdapter(mAdapter);

        initialiseData();

    }

    private void initialiseData() {
        String[] penyakitList = getResources().getStringArray(R.array.name_src);
        String[] penyakitInfo = getResources().getStringArray(R.array.info_src);
        TypedArray penyakitImageResource = getResources().obtainTypedArray(R.array.img_src);
        mAirData.clear();

        for (int i = 0; i < penyakitList.length; i++) {
            mAirData.add(new Penyakit(penyakitList[i], penyakitInfo[i], penyakitImageResource.getResourceId(i, 0)));
        }

        penyakitImageResource.recycle();

        mAdapter.notifyDataSetChanged();
    }
}
