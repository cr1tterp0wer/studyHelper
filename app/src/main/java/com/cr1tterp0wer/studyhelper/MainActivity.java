package com.cr1tterp0wer.studyhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    final String TAG = "MainActivity";

    private StudyFetcher mStudyFetcher;
    private LinearLayout mSubjectLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubjectLayout = findViewById(R.id.subjectLayout);

        mStudyFetcher = new StudyFetcher(this);
        mStudyFetcher.fetchSubjects(new StudyFetcher.OnStudyDataReceivedListener() {
            @Override
            public void onSubjectsReceived(List<Subject> subjects) {
                Log.d(TAG,"We got subjects");
                for (Subject subject : subjects) {
                    Log.d(TAG,"Subject: " + subject.getText());
                    CheckBox cb = new CheckBox(getApplicationContext());
                    cb.setTextSize(18);
                    cb.setText(subject.getText());
                    cb.setTag(subject);
                    mSubjectLayout.addView(cb);
                }
            }

            @Override
            public void onQuestionsReceived(Subject subject, List<Question> questions) {
                Log.d(TAG,"We got Questions for Subject: " + subject);
                for (Question question : questions) {
                    Log.d(TAG,"question: " + question.getText());
                    Log.d(TAG,"answer: " + question.getAnswer());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG,"Error");
            }
        });
    }
}