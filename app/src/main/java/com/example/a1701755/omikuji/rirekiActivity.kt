package com.example.a1701755.omikuji


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView


class rirekiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rireki)

        val intent = intent
        val arrayList: ArrayList<String> = intent.getStringArrayListExtra("HISTORY")
        val listView = findViewById<ListView>(R.id.ListView)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList)
        listView.adapter = adapter
    }
}
