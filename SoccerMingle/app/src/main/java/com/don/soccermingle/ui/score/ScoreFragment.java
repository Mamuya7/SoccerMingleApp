package com.don.soccermingle.ui.score;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.don.soccermingle.R;
import com.don.soccermingle.data.FirebaseUtil;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScoreFragment extends Fragment {

    private ScoreViewModel scoreViewModel;
    private ScoreRecyclerAdapter scoreRecyclerAdapter;
    private FirebaseUtil scoreFirebaseUtil;
    private FirebaseDatabase scoreFirebaseDb;
    private DatabaseReference scoreDbReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scoreViewModel =
                ViewModelProviders.of(this).get(ScoreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_score, container, false);

        FirebaseUtil.openDbReference("soccermingle");
        scoreFirebaseDb = scoreFirebaseUtil.firebaseDatabase;
        scoreDbReference = scoreFirebaseUtil.databaseReference;

        scoreRecyclerAdapter = new ScoreRecyclerAdapter(root.getContext());
        RecyclerView scoreRecyclerView = root.findViewById(R.id.score_recycler_view);
        scoreRecyclerView.setAdapter(scoreRecyclerAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(root.getContext());
        scoreRecyclerView.setLayoutManager(linearLayoutManager);
        return root;
    }
}