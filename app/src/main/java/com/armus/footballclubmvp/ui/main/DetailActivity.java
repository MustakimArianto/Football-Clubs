package com.armus.footballclubmvp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.armus.footballclubmvp.R;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String IMG_BADGE = "img_badge";
    public static final String TEAM_NAME = "team_name";
    public static final String TEAM_DESC = "team_desc";

    private ImageView imgBadge;
    private TextView teamName;
    private TextView teamDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgBadge = findViewById(R.id.img_badge);
        teamName = findViewById(R.id.team_name);
        teamDesc = findViewById(R.id.team_desc);

        String badge = getIntent().getStringExtra(IMG_BADGE);
        String name = getIntent().getStringExtra(TEAM_NAME);
        String desc = getIntent().getStringExtra(TEAM_DESC);

        Glide.with(this).load(badge).into(imgBadge);
        teamName.setText(name);
        teamDesc.setText(desc);

    }
}
