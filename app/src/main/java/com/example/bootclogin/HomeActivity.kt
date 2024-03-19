package com.example.bootclogin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {

    private lateinit var tvId: TextView
    private lateinit var btnFinish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initSet()
        initData()
        initListener()
    }

    private fun initSet() {
        tvId = findViewById<TextView>(R.id.tv_home_id)
        btnFinish = findViewById<Button>(R.id.btn_finish)
    }

    private fun initData() {
        val intent = intent
        tvId.text = resources.getText(R.string.strIdTag).toString() + intent.getStringExtra("id")
    }

    private fun initListener() {
        btnFinish.setOnClickListener {
            finish()
        }
    }
}