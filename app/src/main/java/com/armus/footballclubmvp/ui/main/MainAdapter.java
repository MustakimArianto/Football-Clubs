package com.armus.footballclubmvp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.armus.footballclubmvp.R;
import com.armus.footballclubmvp.data.model.TeamsItem;
import com.bumptech.glide.Glide;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final Context context;
    private final List<TeamsItem> dataTeamList;

    public MainAdapter(Context context, List<TeamsItem> dataTeamList) {
        this.context = context;
        this.dataTeamList = dataTeamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_team_football, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TeamsItem teamData = dataTeamList.get(position);

        holder.txtNameTeam.setText(teamData.getStrTeam());
        holder.txtDescteam.setText(teamData.getStrDescriptionEN());

        Glide.with(context).load(teamData.getStrTeamBadge()).into(holder.imgLogoTeam);

        holder.rvItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.IMG_BADGE, teamData.getStrTeamBadge());
                intent.putExtra(DetailActivity.TEAM_NAME, teamData.getStrTeam());
                intent.putExtra(DetailActivity.TEAM_DESC, teamData.getStrDescriptionEN());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataTeamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogoTeam;
        TextView txtNameTeam;
        TextView txtDescteam;
        LinearLayout rvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgLogoTeam = itemView.findViewById(R.id.image_logo_team);
            txtNameTeam = itemView.findViewById(R.id.text_name_team);
            txtDescteam = itemView.findViewById(R.id.text_desc_team);
            rvItem = itemView.findViewById(R.id.rv_item);
        }
    }
}
