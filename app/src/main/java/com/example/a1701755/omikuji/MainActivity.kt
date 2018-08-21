package com.example.a1701755.omikuji

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val random = Random()
        val moveTestButton = findViewById<Button>(R.id.moveTest)

        moveTestButton.setOnClickListener{
            val resultIntent = Intent(this, ResultActivity::class.java)
            resultIntent.putExtra("omikujiValue",random.nextInt(5))
            startActivity(resultIntent)
            //アニメーション
            overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_top)
        }
    }
}