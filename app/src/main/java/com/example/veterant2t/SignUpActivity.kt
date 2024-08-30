package com.example.veterant2t

import com.example.veterant2t.ApiSetup.ApiClient
import com.example.veterant2t.ApiSetup.registerRequest
import com.example.veterant2t.ApiSetup.registerResponse
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        signUpButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isEmpty()) {
                usernameEditText.error = "Username is required"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordEditText.error = "Password is required"
                return@setOnClickListener
            }

            // Proceed with sign-up process
            Toast.makeText(this, "Sign Up successful", Toast.LENGTH_SHORT).show()
            // Add your sign-up logic here
            registerUser(username, password)
            // Navigate back to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun registerUser(username: String, password: String) {
        val authService= ApiClient.authService

        val obj: JSONObject = JSONObject()
        obj.put("username", username)
        obj.put("email", username)
        obj.put("password", password)
        val call = authService.register(registerRequest(username, username, password))
        call.enqueue(object : Callback<registerResponse>{
            override fun onResponse(call: Call<registerResponse>, response: Response<registerResponse>)
            {
                if(response.isSuccessful){
                    Toast.makeText(this@SignUpActivity, "Sign Up successful", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this@SignUpActivity, "Sign Up failed", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<registerResponse>, t: Throwable) {
                println(t.message)
                println(t.cause)
            }

        })

    }
}