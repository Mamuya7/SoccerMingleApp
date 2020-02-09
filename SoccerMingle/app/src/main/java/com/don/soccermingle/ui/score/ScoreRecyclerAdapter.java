package com.don.soccermingle.ui.score;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class ScoreRecyclerAdapter extends RecyclerView.Adapter<ScoreRecyclerAdapter.ScoreViewHolder>{
    Context context;
    private FirebaseUtil scoreFirebaseUtil;
    private FirebaseDatabase scoreFirebaseDb;
    private DatabaseReference scoreDbReference;
    private ChildEventListener scoreChildEventListener;

    private static List<Fixture> fixtureList;
    public ScoreRecyclerAdapter(Context context) {
        this.context = context;
        fixtureList = new ArrayList<Fixture>();
//        fixtureList.add(new Fixture("1","man","liva","oldtraford","2","0","FT"));
//        fixtureList.add(new Fixture("2","aseno","everton","emirates","1","1","HT"));

        FirebaseUtil.openDbReference("Fixture");
        scoreFirebaseDb = scoreFirebaseUtil.firebaseDatabase;
        scoreDbReference = scoreFirebaseUtil.databaseReference;

        scoreChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Fixture fixture = dataSnapshot.getValue(Fixture.class);
//                fixture.setId(dataSnapshot.getKey());
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
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.scores_list_layout,parent,false);
        return new ScoreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        Fixture fixture = fixtureList.get(position);
        holder.bind(fixture);
    }

    @Override
    public int getItemCount() {
        return fixtureList.size();
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

        public void bind(Fixture fixture) {
            homeTeam.setText(fixture.getHomeTeam());
            awayTeam.setText(fixture.getAwayTeam());
            homeScore.setText(fixture.getHomeScore());
            awayScore.setText(fixture.getAwayScore());
            matchStatus.setText(fixture.getMatchStatus());
        }
    }
}
