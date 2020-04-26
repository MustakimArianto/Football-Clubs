package com.armus.footballclubmvp.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.armus.footballclubmvp.R;
import com.armus.footballclubmvp.data.model.TeamsItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    RecyclerView rvTeam;
    SwipeRefreshLayout swipeRefresh;
    private ProgressBar progressBar;
    private final MainPresenter mainPresenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeam = findViewById(R.id.recycler_main);
        swipeRefresh = findViewById(R.id.swipe_main);
        progressBar = findViewById(R.id.pb_main);

        mainPresenter.getDataListTeams();

        swipeRefresh.setOnRefreshListener(()-> {
            swipeRefresh.setRefreshing(false);
            mainPresenter.getDataListTeams();
        });
    }

    @Override
    public void showProgress() {
        rvTeam.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        rvTeam.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showDataList(List<TeamsItem> teamsItems) {
        rvTeam.setLayoutManager(new LinearLayoutManager(this));
        rvTeam.setAdapter(new MainAdapter(this, teamsItems));
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
