package com.tech387.arch.main;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.tech387.arch.R;
import com.tech387.arch.ViewModelFactory;
import com.tech387.arch.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        //setup ViewModel
        setupViewModel();

        //Finding views
        mToolbar = findViewById(R.id.toolbar);

        //Setup
        setupToolbar();
        setupFragment();
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


    private void setupViewModel() {
        mViewModel = ViewModelFactory.obtainViewModel(this, MainViewModel.class);
        mViewModel.getOpenMovieEvent().observe(this, aVoid -> {
            //Open a new Activity
        });
    }

    private void setupFragment() {
        MainFragment viewExerciseFragment =
                (MainFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if (viewExerciseFragment == null) {
            viewExerciseFragment = MainFragment.newInstance();
            ActivityUtils.replaceFragmentInActivity(
                    getSupportFragmentManager(), viewExerciseFragment, R.id.container);
        }
    }

}
