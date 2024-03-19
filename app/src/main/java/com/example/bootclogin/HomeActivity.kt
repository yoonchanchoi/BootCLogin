package com.example.bootclogin

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class HomeActivity : AppCompatActivity() {

    private lateinit var tvId: TextView
    private lateinit var btnFinish: Button
    private lateinit var ivTitle: ImageView
    //비트맵 사용시
    //private val arrayListBitmap = ArrayList<Bitmap>()

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
        ivTitle = findViewById<ImageView>(R.id.iv_title)
    }

    private fun initData() {
        val random = Random()
        val images = resources.obtainTypedArray(R.array.myImages)
        val intent = intent
        tvId.text = resources.getText(R.string.strIdTag).toString() + intent.getStringExtra("id")
        ivTitle.setImageDrawable(images.getDrawable(random.nextInt(images.length())))
    }

    private fun initListener() {
        btnFinish.setOnClickListener {
            finish()
        }
    }
}