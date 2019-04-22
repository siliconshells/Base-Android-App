package com.pixelresolve.pixa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EntranceActivity extends AppCompatActivity {

    TextView mFullname;
    Button mLogoutButton;

    @Override
    public void onPause()
    {
        super.onPause();
        onClick(null);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        mFullname = findViewById(R.id.textView3);
        mLogoutButton = findViewById(R.id.button);

        Intent myIntent = getIntent(); // gets the previously created intent
        mFullname.setText(myIntent.getStringExtra("fullname"));

        mLogoutButton.setOnClickListener(this::onClick);
    }

    private void onClick(View v) {
        View v1 = v;
        finish();
    }
}
