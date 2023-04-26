package com.cookandroid.danggeunmarket_clone_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cookandroid.danggeunmarket_clone_project.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // StatusBar 투명 설정 - ViewExtension.kt
        makeStatusBarTransparent()

        val title = intent.getStringExtra("title")
        val placetime = intent.getStringExtra("placetime")
        val cost = intent.getStringExtra("cost")
        val content = intent.getStringExtra("content")

        binding.viewTitle.text = title
        binding.viewPlace.text = placetime
        binding.viewCost.text = cost
        binding.viewContent.text = content

        binding.viewBackBtn.setOnClickListener {
            finish()
        }

        binding.viewHomeBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }
}