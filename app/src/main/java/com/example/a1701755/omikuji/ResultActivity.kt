package com.example.a1701755.omikuji

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_result.*
import org.json.JSONArray

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = intent
        val getValue = intent.getIntExtra("omikujiValue", -1)
        when (getValue) { // 0..4までの数によって表示する画像が変わる
            0 -> imageViewOmikuji.setImageResource(R.drawable.daikiti)
            1 -> imageViewOmikuji.setImageResource(R.drawable.tyukiti)
            2 -> imageViewOmikuji.setImageResource(R.drawable.shokiti)
            3 -> imageViewOmikuji.setImageResource(R.drawable.suekiti)
            4 -> imageViewOmikuji.setImageResource(R.drawable.daikyo)
            else -> imageViewOmikuji.setImageResource(R.drawable.hyoshi)
        }
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            //戻る
            finish()
        }

        val listButton = findViewById<Button>(R.id.listButton)
        listButton.setOnClickListener {
            //OmikujiListViewに画面遷移
            val listIntent = Intent(this, OmikujiListView::class.java)
            startActivity(listIntent)
        }

        val rirekiButton = findViewById<Button>(R.id.rirekibutton)
        var arrayList: ArrayList<String> = ArrayList()

        rirekiButton.setOnClickListener {
            //rirekiActivityに画面遷移
            val rirekiIntent = Intent(this, rirekiActivity::class.java)
            rirekiIntent.putExtra("HISTORY", arrayList)
            startActivity(rirekiIntent)
        }

        //loadしたarrayListを代入
        arrayList = loadArrayList("test")
        when (getValue) { // 0..4までの数によってリストに入る文字が変わる
            0 -> arrayList.add("大吉")
            1 -> arrayList.add("中吉")
            2 -> arrayList.add("小吉")
            3 -> arrayList.add("末吉")
            4 -> arrayList.add("大凶")
            else -> arrayList.add("大吉")
        }
        //arrayListをsave
        saveArrayList("test", arrayList)
    }

    fun saveArrayList(key: String, arrayList: ArrayList<String>) {
        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        val sharedPrefEditor = sharedPreferences.edit()
        val jsonArray = JSONArray(arrayList)
        sharedPrefEditor.putString(key, jsonArray.toString())
        sharedPrefEditor.commit()
    }

    fun loadArrayList(key: String): ArrayList<String> {
        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        val jsonArray = JSONArray(sharedPreferences.getString(key, "[]"))
        val arrayList: ArrayList<String> = ArrayList()
        for (i in 0 until jsonArray.length()) {
            arrayList.add(jsonArray.get(i) as String)
        }
        return arrayList
    }
}
