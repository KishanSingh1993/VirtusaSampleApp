package com.example.testproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView emailTextView;
    DataViewModel dataViewModel;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTextView = findViewById(R.id.emailtxt);
        editText = findViewById(R.id.etendpoint);

        Button getData = findViewById(R.id.button);

        getData.setOnClickListener(this);


         dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);


    }

    public void getApiData(){
        dataViewModel.getHeroes().observe(this, new Observer<Root>() {
            @Override
            public void onChanged(@Nullable Root responseData) {

                assert responseData != null;
                Data data = responseData.getData();
                Log.d("Email",data.getEmail());
                emailTextView.setText(data.getEmail());

            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.button) {

            Log.d("Id",editText.getText().toString());

            dataViewModel.id = Integer.parseInt(editText.getText().toString());

            getApiData();
        }

    }
}