package com.example.bootclogin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etId: EditText
    private lateinit var etPw: EditText
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sign_up)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initSet()
        initListener()
    }

    private fun initSet() {
        etName = findViewById<EditText>(R.id.et_sign_up_name)
        etId = findViewById<EditText>(R.id.et_sign_up_id)
        etPw = findViewById<EditText>(R.id.et_sign_up_pw)
        btnSignUp = findViewById<Button>(R.id.btn_sign_up)
    }

    private fun initListener() {
        btnSignUp.setOnClickListener {
            if (!etId.text.isNullOrEmpty() && !etPw.text.isNullOrEmpty() && !etName.text.isNullOrEmpty()) {
                finish()
            } else {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}