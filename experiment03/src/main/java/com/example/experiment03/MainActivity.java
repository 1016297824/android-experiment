package com.example.experiment03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUserName;
    private Button buttonSubmit;
    private TextView textViewUserName;
    private EditText editTextNameChange;
    private TextView textViewNamechange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = findViewById(R.id.username1);
        buttonSubmit = findViewById(R.id.button1);
        textViewUserName = findViewById(R.id.text1);
        editTextNameChange  =findViewById(R.id.username2);
        textViewNamechange = findViewById(R.id.text2);

        //buttonSubmit.setOnClickListener(this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = editTextUserName.getText().toString();
                textViewUserName.setText(string);
            }
        });

        //buttonSubmit.setOnClickListener(new View.OnClickListener(){

        //});


        editTextNameChange.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textViewNamechange.setText(s);
                //textViewNamechange.setText(R.string.app_name);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //@Override
        //public Void onClick(View v)   {
        //    switch(v.getid)
        //}

    }
}
