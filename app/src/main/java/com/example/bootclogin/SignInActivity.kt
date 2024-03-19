package com.example.bootclogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {
    private lateinit var etId: EditText
    private lateinit var etPw: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signin)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initSet()
        initListener()
    }

    private fun initSet() {
        etId = findViewById<EditText>(R.id.et_id)
        etPw = findViewById<EditText>(R.id.et_pw)
        btnLogin = findViewById<Button>(R.id.btn_login)
        btnSignin = findViewById<Button>(R.id.btn_signin)
    }

    private fun initListener() {
        btnLogin.setOnClickListener {
            if (!etId.text.isNullOrEmpty() && !etPw.text.isNullOrEmpty()) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", etId.text.toString())
                intent.putExtra("pw", etPw.text)
                startActivity(intent)
            } else {
                Toast.makeText(this, "아아디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }
        btnSignin.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }


}