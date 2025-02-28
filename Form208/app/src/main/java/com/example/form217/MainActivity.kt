package com.example.form217

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val userName : EditText = findViewById(R.id.user)
        val pinNumber: EditText = findViewById(R.id.pin)
        val login: Button = findViewById(R.id.login)
        val clear: Button = findViewById(R.id.clear)
      login.setOnClickListener {
          val userName = userName.text.toString().trim()
          val pinNumber = pinNumber.text.toString().trim()
          if(userName.isEmpty() || pinNumber.isEmpty())
          {
              Toast.makeText(this,"All fields are mandatory",Toast.LENGTH_LONG).show()
              return@setOnClickListener
           }
          if(!userName.matches(Regex("^[a-zA-Z]+$")))
          {
              Toast.makeText(this,"Invalid username", Toast.LENGTH_LONG).show()
              return@setOnClickListener
          }
          if(!pinNumber.matches(Regex("^[0-9]{4}$")))
          {
              Toast.makeText(this,"Invalid pin number", Toast.LENGTH_LONG).show()
              return@setOnClickListener
          }
          val intent:Intent=Intent(this,MainActivity2::class.java)
          startActivity(intent)
      }
        clear.setOnClickListener {
            userName.text.clear()
            pinNumber.text.clear()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}