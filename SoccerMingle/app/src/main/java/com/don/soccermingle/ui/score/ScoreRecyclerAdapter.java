package com.don.soccermingle.ui.score;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
    public final FragmentActivity parentActivity;
    Context context;
    private FirebaseUtil scoreFirebaseUtil;
    private FirebaseDatabase scoreFirebaseDb;
    private DatabaseReference scoreDbReference;
    private ChildEventListener scoreChildEventListener;

    private static List<Fixture> fixtureList;
    public ScoreRecyclerAdapter(Context context, FragmentActivity parentActivity) {
        this.parentActivity = parentActivity;
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
        private final View scoreItemView;

        TextView homeTeam;
        TextView awayTeam;
        TextView homeScore;
        TextView awayScore;
        TextView matchStatus;

        public ScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            this.scoreItemView = itemView;

            homeTeam = itemView.findViewById(R.id.home_team_view);
            homeScore = itemView.findViewById(R.id.home_score_view);
            awayTeam = itemView.findViewById(R.id.away_team_view);
            awayScore = itemView.findViewById(R.id.away_score_view);
            matchStatus = itemView.findViewById(R.id.match_status_view);
        }

        public void bind(Fixture fixture) {
            homeTeam.setText(fixture.getHomeTeam());
            awayTeam.setText(fixture.getAwayTeam());
            homeScore.setText(fixture.getResult().getHomeScores());
            awayScore.setText(fixture.getResult().getAwayScores());
            matchStatus.setText(fixture.getMatchStatus());

            scoreItemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Fragment scoreDetails = new ScoreDetails();
                            FragmentManager fragmentManager = parentActivity.getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.score_fragment,scoreDetails);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    }
            );
        }
    }
}
