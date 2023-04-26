package com.cookandroid.danggeunmarket_clone_project

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cookandroid.danggeunmarket_clone_project.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // StatusBar 투명도 설정
        makeStatusBarTransparent()

        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)


        binding.writeComplete.setOnClickListener {
            val title = binding.writeTitle.text.toString()
            val content = binding.writeContent.text.toString()
            val place = "1초전"
            val cost = binding.writeCost.text.toString()

            HomeAdapter().data.add(
                ResellData(null, title, place, content, cost, 0)
            )
            HomeAdapter().notifyDataSetChanged()

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        // toolbar back btn
        binding.chatBackBtn.setOnClickListener {
            finish()
        }

        binding.writeComplete.setOnClickListener {
            val title = binding.writeTitle.text.toString()
            val content = binding.writeTitle.text.toString()
            val cost = binding.writeCost.text.toString()

        }
    }
}