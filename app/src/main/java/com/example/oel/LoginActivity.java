package com.example.oel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userManager = new UserManager();

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                boolean isAuthenticated = userManager.login(username, password);
                if (isAuthenticated) {
                    String userRole = userManager.getUserRole(username);

                    if (userRole.equals("User")) {
                        // Navigate to user dashboard
                        Intent intent = new Intent(LoginActivity.this, UserDashboard.class);
                        startActivity(intent);
                    } else if (userRole.equals("Responder")) {
                        // Navigate to admin dashboard
                        Intent intent = new Intent(LoginActivity.this, ResponderDashboard.class);
                        startActivity(intent);
                    }
                    // Clear the login fields
                    etUsername.setText("");
                    etPassword.setText("");
                } else {
                    // Display error message for invalid credentials
                    Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}