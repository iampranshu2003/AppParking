package com.example.finalparking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val authManager = AuthenticationManager()
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize the EditText views
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
    }

    fun onLoginClick(view: View) {
        val email = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        authManager.login(email, password) { success, errorMessage ->
            if (success) {
                // Login successful, navigate to the main app screen
                // Implement navigation logic as needed
            } else {
                // Display an error message to the user
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onRegisterClick(view: View) {
        val email = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        authManager.register(email, password) { success, errorMessage ->
            if (success) {

            } else {
                // Display an error message to the user
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
