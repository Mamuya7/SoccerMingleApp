package com.don.soccermingle.ui.score;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.don.soccermingle.R;

public class ScoreRecyclerAdapter extends RecyclerView.Adapter<ScoreRecyclerAdapter.ScoreViewHolder>{
    Context context;

    public ScoreRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.scores_list_layout,parent,false);
        return new ScoreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ScoreViewHolder extends RecyclerView.ViewHolder {
        TextView homeTeam;
        TextView awayTeam;
        TextView homeScore;
        TextView awayScore;
        TextView matchStatus;

        public ScoreViewHolder(@NonNull View itemView) {
            super(itemView);

            homeTeam = itemView.findViewById(R.id.home_team_view);
            homeScore = itemView.findViewById(R.id.home_score_view);
            awayTeam = itemView.findViewById(R.id.away_team_view);
            awayScore = itemView.findViewById(R.id.away_score_view);
            matchStatus = itemView.findViewById(R.id.match_status_view);
        }
    }
}
