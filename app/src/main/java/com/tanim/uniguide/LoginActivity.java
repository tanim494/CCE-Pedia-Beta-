package com.tanim.uniguide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String STUDENT_NAME_KEY = "student_name";
    public static final String SEMESTER_KEY = "semester";
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            // Capture the user's input (student name and semester) when they log in
            EditText studentNameEditText = findViewById(R.id.studentNameEditText);
            Spinner semesterSpinner = findViewById(R.id.semesterSpinner);
            Button loginButton = findViewById(R.id.loginButton);

            // Populate the semester dropdown with values from 1 to 8
            ArrayAdapter<String> semesterAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
            semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            for (int i = 1; i <= 8; i++) {
                semesterAdapter.add("Semester " + i);
            }
            semesterSpinner.setAdapter(semesterAdapter);

            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String studentName = studentNameEditText.getText().toString();
                    String selectedSemester = semesterSpinner.getSelectedItem().toString();

                    // Extract the semester ID from the selected semester
                    int semesterId = Integer.parseInt(selectedSemester.split(" ")[1]);
                    // Store the user's input and semester ID in SharedPreferences
                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString(STUDENT_NAME_KEY, studentName);
                    editor.putInt(SEMESTER_KEY, semesterId);
                    Toast.makeText(LoginActivity.this, "Welcome to CCE Pedia " + studentName, Toast.LENGTH_SHORT).show();
                    editor.apply();

                    // Proceed to the main activity
                    goToMainActivity();
                }
            });
    }

    private void goToMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
