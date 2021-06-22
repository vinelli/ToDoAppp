package com.kanayo.todoappp

import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    val validUsername = "admin"
    val validPassword = "admin"

    private lateinit var usernameInput : EditText
    private lateinit var passwordInput : EditText
    private lateinit var signinButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.UsernameInput)
        passwordInput = findViewById(R.id.PasswordInput)
        signinButton = findViewById(R.id.SubmitButton)

        signinButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            login(username, password)
        }
    }
    private fun login(username: String, password: String) {
        if (isValidCredentials(username, password)) {
            val intent: Intent = Intent(this, HomeActivity ::class.java)
            intent.putExtra("name", username)
            startActivity(intent)
        } else {
            Toast.makeText(applicationContext, "something went wrong", Toast.LENGTH_LONG).show()
        }
    }

    private fun isValidCredentials(username: String, password: String):Boolean {
        if (username == validUsername && password == validPassword) return true
        return false
    }
}