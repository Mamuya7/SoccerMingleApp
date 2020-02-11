package com.don.soccermingle.ui.score.statistics;

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

public class StatisticsFragment extends Fragment {

    private StatisticsViewModel statisticsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        statisticsViewModel =
                ViewModelProviders.of(this).get(StatisticsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_statistics, container, false);

        RecyclerView staisticsRecycler = root.findViewById(R.id.statistics_recycler);
        StatisticsRecyclerAdapter statisticsAdapter = new StatisticsRecyclerAdapter(root.getContext());
        staisticsRecycler.setAdapter(statisticsAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(root.getContext());
        staisticsRecycler.setLayoutManager(linearLayoutManager);
        return root;
    }
}