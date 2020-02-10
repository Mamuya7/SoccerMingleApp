package com.don.soccermingle.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.don.soccermingle.R;
import com.don.soccermingle.data.FirebaseUtil;
import com.don.soccermingle.data.model.Fixture;
import com.don.soccermingle.data.model.Result;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private EditText hometeam;
    private EditText awayteam;
    private EditText homescore;
    private EditText awayscore;
    private EditText stadium;
    private EditText status;
    private Button save;


    private FirebaseUtil scoreFirebaseUtil;
    private FirebaseDatabase scoreFirebaseDb;
    private DatabaseReference scoreDbReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        FirebaseUtil.openDbReference("fixture");
        scoreFirebaseDb = scoreFirebaseUtil.firebaseDatabase;
        scoreDbReference = scoreFirebaseUtil.databaseReference;

        hometeam = root.findViewById(R.id.htv);
        awayteam = root.findViewById(R.id.atv);
        homescore = root.findViewById(R.id.htsv);
        awayscore = root.findViewById(R.id.awsv);
        stadium = root.findViewById(R.id.stv);
        status = root.findViewById(R.id.msv);
        save = root.findViewById(R.id.save);

        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Result result = new Result(homescore.getText().toString(),
                                awayscore.getText().toString(),"60","40");
                        Fixture fixture = new Fixture(
                                hometeam.getText().toString(), awayteam.getText().toString(),homescore.getText().toString(),
                                awayscore.getText().toString(),stadium.getText().toString(),status.getText().toString(),
                                result
                        );
                        scoreDbReference.push().setValue(fixture);
                        clearFields();
                        Toast.makeText(getContext(),"Fixture Recorded",Toast.LENGTH_LONG);
                    }
                }
        );
        return root;
    }

    public void clearFields(){
        hometeam.setText("");
        homescore.setText("");
        awayteam.setText("");
        awayscore.setText("");
        status.setText("");
        stadium.setText("");
    }
}