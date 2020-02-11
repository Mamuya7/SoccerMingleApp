package com.don.soccermingle.ui.score.statistics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.don.soccermingle.R;
import com.don.soccermingle.data.FirebaseUtil;
import com.don.soccermingle.data.model.Fixture;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class StatisticsRecyclerAdapter extends RecyclerView.Adapter<StatisticsRecyclerAdapter.StatisticsViewHolder>{
    Context context;
    private FirebaseUtil scoreFirebaseUtil;
    private FirebaseDatabase scoreFirebaseDb;
    private DatabaseReference scoreDbReference;
    private ChildEventListener scoreChildEventListener;

    private static List<Fixture> fixtureList;
    public StatisticsRecyclerAdapter(Context context) {
        this.context = context;
        fixtureList = new ArrayList<Fixture>();

        FirebaseUtil.openDbReference("fixture");
        scoreFirebaseDb = scoreFirebaseUtil.firebaseDatabase;
        scoreDbReference = scoreFirebaseUtil.databaseReference;

        scoreChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Fixture fixture = dataSnapshot.getValue(Fixture.class);
                fixture.setId(dataSnapshot.getKey());
                fixtureList.add(fixture);

                notifyItemInserted(fixtureList.size()-1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        scoreDbReference.addChildEventListener(scoreChildEventListener);
    }

    @NonNull
    @Override
    public StatisticsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.statistics_list_layout,parent,false);
        return new StatisticsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StatisticsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return fixtureList.size();
    }

    public class StatisticsViewHolder extends RecyclerView.ViewHolder {

        TextView homeValue;
        TextView awayValue;
        TextView statsTitle;
        ProgressBar homeBar;
        ProgressBar awayBar;

        public StatisticsViewHolder(@NonNull View itemView) {
            super(itemView);

            homeValue = itemView.findViewById(R.id.home_value);
            statsTitle = itemView.findViewById(R.id.statistics_title);
            awayValue = itemView.findViewById(R.id.away_value);
            homeBar = itemView.findViewById(R.id.home_progressBar);
            awayBar = itemView.findViewById(R.id.away_progressBar);
        }

        public void bind(Fixture fixture) {
            homeValue.setText(fixture.getHomeTeam());
            awayValue.setText(fixture.getAwayTeam());
            statsTitle.setText(fixture.getResult().getHomeScores());
        }
    }


}
