package com.example.mask_cycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btnSignUp = findViewById<Button>(R.id.btnSignUp2)
        btnSignUp.setOnClickListener {
            Toast.makeText(this, "Thanks For Watching^^", Toast.LENGTH_LONG).show()
        }
    }
}