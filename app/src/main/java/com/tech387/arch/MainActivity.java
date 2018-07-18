package com.tech387.arch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.tech387.arch.data.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;

    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        //Finding views
        mToolbar = findViewById(R.id.toolbar);
        mRecyclerView = findViewById(R.id.list);

        //Setup
        setupToolbar();
        setupList();
    }

    /**
     * Setting up the toolbar, toolbar actions & title
     */
    private void setupToolbar() {
        //toolbar setup
        setSupportActionBar(mToolbar);
        //setting the toolbar title
        getSupportActionBar().setTitle(R.string.app_name);
        //setting up the back button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * OnClickListener for the toolbar back button
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**
     * Setting up the listView & its adapter
     */
    private void setupList() {
        //Mocking the data
        ArrayList<Movie> arrayList = new ArrayList<>();
        arrayList.add(new Movie("Title 1", "Des 1", R.drawable.image_1));
        arrayList.add(new Movie("Title 2", "Des 2", R.drawable.image_2));
        arrayList.add(new Movie("Title 3", "Des 3", R.drawable.image_3));

        mAdapter = new MainAdapter(this, arrayList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
