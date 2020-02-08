package com.don.soccermingle.ui.fixture;

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

import com.don.soccermingle.R;

public class FixtureFragment extends Fragment {

    private FixtureViewModel fixtureViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fixtureViewModel =
                ViewModelProviders.of(this).get(FixtureViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fixture, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        fixtureViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}