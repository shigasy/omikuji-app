package com.example.a1701755.omikuji

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class OmikujiListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_omikuji_list_view)

        var dataArray = mutableListOf<String>()
        dataArray.add("大吉")
        dataArray.add("中吉")
        dataArray.add("小吉")
        dataArray.add("末吉")
        dataArray.add("大凶")
        val listView = findViewById<ListView>(R.id.ListView)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dataArray)
        listView.adapter = adapter
    }
}
