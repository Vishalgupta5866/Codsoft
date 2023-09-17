package com.vishal.vishalminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondPageActivity extends AppCompatActivity {
    TextView textquestionview;
    Button submitbutton, quitbutton;
    RadioGroup radiogroup;
    RadioButton radioButton,radioButton2,radioButton3,radioButton4;

    String questions[] = {
            " 1. Who is the Father of our Nation?",
            "2.Who was the first President of India?",
            "3. Who invented Computer?",
            "4.  Brain of computer is?",
            "5.  Which is the longest river on the earth?"
    };
    String option[] = {
            "Rahul Gandhi","Mahatma Gandhi","Dr. B. R. Ambedkar","Lal Bahadur Shastr",
            "Mahatma Gandhi"," Sardar Vallabhbhai Patel","Subhash Chandra Bose ","Dr. B. R. Ambedkar",
            "Alexander Graham Bell","Guglielmo Marconi","Thomas Edison","Charles Babbage",
            "CPU","ROM","SDD","RAM",
            "Yamuna","Ganga","Nile","None of the mentioned"
    };
    String right[] = { "Mahatma Gandhi",
            "Dr. B. R. Ambedkar",
            "Charles Babbage",
            "CPU",
            "Nile"};

    int indexno=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.questiontext);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");


            textView.setText("Hello.........." + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        textquestionview=(TextView) findViewById(R.id.textquestionview);

        radiogroup=(RadioGroup)findViewById(R.id.radiogroup);
        radioButton=(RadioButton)findViewById(R.id.radioButton);
        radioButton2=(RadioButton)findViewById(R.id.radioButton2);
        radioButton3=(RadioButton)findViewById(R.id.radioButton3);
        radioButton4=(RadioButton)findViewById(R.id.radioButton4);
        textquestionview.setText(questions[indexno]);
        radioButton.setText(option[0]);
        radioButton2.setText(option[1]);
        radioButton3.setText(option[2]);
        radioButton4.setText(option[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {



                RadioButton obj = (RadioButton) findViewById(radiogroup.getCheckedRadioButtonId());
                String omg = obj.getText().toString();
//
                if(omg.equals(right[indexno])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                indexno++;

                if (score != null)
                    score.setText(""+correct);

                if(indexno<questions.length)
                {
                    textquestionview.setText(questions[indexno]);
                    radioButton.setText(option[indexno*4]);
                    radioButton2.setText(option[indexno*4 +1]);
                    radioButton3.setText(option[indexno*4 +2]);
                    radioButton4.setText(option[indexno*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultPageActivity.class);
                    startActivity(in);
                }
                radiogroup.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultPageActivity.class);
                startActivity(intent);
            }
        });

    }
}