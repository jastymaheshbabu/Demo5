package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var cbRememberMe: CheckBox
    private lateinit var tvForgotPassword: TextView
    private lateinit var btnLogin: MaterialButton
    private lateinit var btnGoogleLogin: MaterialButton
    private lateinit var btnFacebookLogin: MaterialButton
    private lateinit var tvSignUp: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initializeViews()
        setupClickListeners()
    }

    private fun initializeViews() {
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        cbRememberMe = findViewById(R.id.cbRememberMe)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnGoogleLogin = findViewById(R.id.btnGoogleLogin)
        btnFacebookLogin = findViewById(R.id.btnFacebookLogin)
        tvSignUp = findViewById(R.id.tvSignUp)
        progressBar = findViewById(R.id.progressBar)
    }

    private fun setupClickListeners() {
        btnLogin.setOnClickListener {
            if (validateInputs()) {
                performLogin()
            }
        }

        tvForgotPassword.setOnClickListener {
            handleForgotPassword()
        }

        btnGoogleLogin.setOnClickListener {
            handleGoogleLogin()
        }

        btnFacebookLogin.setOnClickListener {
            handleFacebookLogin()
        }

        tvSignUp.setOnClickListener {
            navigateToSignUp()
        }
    }

    private fun validateInputs(): Boolean {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // Reset errors
        tilEmail.error = null
        tilPassword.error = null

        // Validate email
        if (email.isEmpty()) {
            tilEmail.error = "Email is required"
            etEmail.requestFocus()
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.error = "Please enter a valid email"
            etEmail.requestFocus()
            return false
        }

        // Validate password
        if (password.isEmpty()) {
            tilPassword.error = "Password is required"
            etPassword.requestFocus()
            return false
        }

        if (password.length < 6) {
            tilPassword.error = "Password must be at least 6 characters"
            etPassword.requestFocus()
            return false
        }

        return true
    }

    private fun performLogin() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val rememberMe = cbRememberMe.isChecked

        // Show progress bar
        showLoading(true)

        // Simulate API call with a delay
        btnLogin.postDelayed({
            // Hide progress bar
            showLoading(false)

            // For demo purposes, accept any valid email/password
            // In a real app, you would make an API call here
            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(
                    this,
                    "Login successful! Welcome back.",
                    Toast.LENGTH_SHORT
                ).show()

                // Save login state if remember me is checked
                if (rememberMe) {
                    saveLoginState(email)
                }

                // Navigate to main activity
                navigateToMainActivity()
            } else {
                Toast.makeText(
                    this,
                    "Login failed. Please check your credentials.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }, 2000) // 2 second delay to simulate network call
    }

    private fun handleForgotPassword() {
        val email = etEmail.text.toString().trim()
        
        if (email.isEmpty()) {
            Toast.makeText(
                this,
                "Please enter your email first",
                Toast.LENGTH_SHORT
            ).show()
            etEmail.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(
                this,
                "Please enter a valid email",
                Toast.LENGTH_SHORT
            ).show()
            etEmail.requestFocus()
            return
        }

        // In a real app, you would send a password reset email
        Toast.makeText(
            this,
            "Password reset link sent to $email",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun handleGoogleLogin() {
        Toast.makeText(
            this,
            "Google login will be implemented here",
            Toast.LENGTH_SHORT
        ).show()
        
        // In a real app, you would integrate Google Sign-In SDK
        // Example: Start Google Sign-In intent
    }

    private fun handleFacebookLogin() {
        Toast.makeText(
            this,
            "Facebook login will be implemented here",
            Toast.LENGTH_SHORT
        ).show()
        
        // In a real app, you would integrate Facebook Login SDK
        // Example: Start Facebook Login flow
    }

    private fun navigateToSignUp() {
        Toast.makeText(
            this,
            "Navigate to Sign Up screen",
            Toast.LENGTH_SHORT
        ).show()
        
        // In a real app, you would start SignUpActivity
        // val intent = Intent(this, SignUpActivity::class.java)
        // startActivity(intent)
    }

    private fun navigateToMainActivity() {
        // In a real app, you would navigate to your main activity
        Toast.makeText(
            this,
            "Navigating to main screen...",
            Toast.LENGTH_SHORT
        ).show()
        
        // val intent = Intent(this, MainActivity::class.java)
        // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        // startActivity(intent)
        // finish()
    }

    private fun saveLoginState(email: String) {
        // Save login state using SharedPreferences
        val sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", true)
        editor.putString("userEmail", email)
        editor.apply()
    }

    private fun showLoading(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
            btnLogin.isEnabled = false
            btnLogin.alpha = 0.5f
        } else {
            progressBar.visibility = View.GONE
            btnLogin.isEnabled = true
            btnLogin.alpha = 1.0f
        }
    }
}
