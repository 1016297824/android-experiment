package com.example.experiment11;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.experiment11.util.SharedPreferencesUtils;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.act_main_edittext);
        textView = findViewById(R.id.act_main_textView);
        button = findViewById(R.id.act_main_button);
        // 获取值，没有默认值为空
        textView.setText(SharedPreferencesUtils.getMyedit());

        button.setOnClickListener(v -> {
            SharedPreferencesUtils.putMyedit(editText.getEditableText().toString());
        });
    }
}
