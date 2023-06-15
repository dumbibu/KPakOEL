package com.example.oel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private Spinner spRole;
    private Button btnSignup;

    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        userManager = new UserManager();

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        spRole = findViewById(R.id.spRole);
        btnSignup = findViewById(R.id.btnSignup);
        String[] roleOptions = {"User", "Responder"};
        // Create ArrayAdapter using roleOptions and default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, roleOptions);

        // Set the adapter to the spinner
        spRole.setAdapter(adapter);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String role = spRole.getSelectedItem().toString();

                User user = new User(username, email, password, role);
                boolean isSignupSuccessful = userManager.signup(user);
                if (isSignupSuccessful) {
                    // Display success message and navigate to login screen

                    // Example success message toast:
                    Toast.makeText(SignupActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();

                    // Example navigation to login screen:
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish(); // Optional: Finish the signup activity so the user cannot navigate back to it
                } else {
                    // Display error message for signup failure

                    // Example error message toast:
                    Toast.makeText(SignupActivity.this, "Signup failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

