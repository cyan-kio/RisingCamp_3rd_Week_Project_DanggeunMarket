package com.cookandroid.danggeunmarket_clone_project

import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cookandroid.danggeunmarket_clone_project.databinding.ActivityWriteBinding

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding
    private lateinit var dbHelper: DBHelper
    private lateinit var database: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // StatusBar 투명도 설정
        makeStatusBarTransparent()

        val id2 = intent.getIntExtra("id", -1)
        Log.d("SQLIDTEST", id2.toString())

        dbHelper = DBHelper(this, "resellData.db", null, 1)
        database = dbHelper.writableDatabase


        var query = "SELECT * FROM resellData WHERE num =" + id2
        var cursor = database.rawQuery(query, null)
        cursor.moveToFirst()
            var title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
            var content = cursor.getString(cursor.getColumnIndexOrThrow("content"))
            var cost = cursor.getString(cursor.getColumnIndexOrThrow("cost"))

        binding.writeTitle.setText(title)
        binding.writeContent.setText(content)
        binding.writeCost.setText(cost)

        binding.writeComplete.setOnClickListener {
            val title = binding.writeTitle.text.toString()
            val content = binding.writeContent.text.toString()
            val placetime = "1초전"
            val cost = binding.writeCost.text.toString()

            var query = "UPDATE resellData SET title = '" + title + "', content = '" + content + "', cost = '" + cost + "' WHERE num =" + id2
            database.execSQL(query)

            Log.d("UPDATETEST", "SUCCESS2")

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
    }
}