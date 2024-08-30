package com.example.veterant2t

import com.example.veterant2t.ApiSetup.ApiClient
import com.example.veterant2t.ApiSetup.AuthService
import com.example.veterant2t.ApiSetup.loginRequest
import com.example.veterant2t.ApiSetup.loginResponse
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val signUpTextView = findViewById<TextView>(R.id.signUpTextView)


        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            loginUser(username, password)
//            if (username == "" && password == "") {
//                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, HomeScreen::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
//            }
        }

        signUpTextView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


    }


    private fun loginUser(username: String, password: String) {
        val authentication = ApiClient.authService


        val response: Call<loginResponse> = authentication.login(loginRequest(username, password, username))
        response.enqueue(object : Callback<loginResponse> {


            override fun onResponse(call: Call<loginResponse>, response: Response<loginResponse>) {

                if(response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        Toast.makeText(this@LoginActivity, "Login successful", Toast.LENGTH_SHORT).show()
                        ApiClient.onLoginSuccess()
                        val intent = Intent(this@LoginActivity, HomeScreen::class.java)
                        startActivity(intent)
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<loginResponse>, t: Throwable) {
                println(t.message)
                println(t.cause)
            }

        })
    }
}