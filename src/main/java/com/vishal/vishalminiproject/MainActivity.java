package com.vishal.vishalminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button start;
EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         start=(Button)findViewById(R.id.start);

        editName=(EditText)findViewById(R.id.editName);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editName.getText().toString())) {
                    Toast.makeText(MainActivity.this, "First Enter your Name To Start a Quiz", Toast.LENGTH_SHORT).show();
                }
                else {
                    String name = editName.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), SecondPageActivity.class);
                    intent.putExtra("myname", name);
                    startActivity(intent);
                }

            }
        });


    }
}