package com.example.ilovexxx.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ilovexxx.R
import com.example.ilovexxx.model.Film

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filmsList = intent.getSerializableExtra("cinemaxxx") as ArrayList<Film>

        // создать адаптер и подключить тут
        val recyclerView: RecyclerView = findViewById(R.id.rvCinema)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = CinemaAdapter(filmsList, applicationContext)
    }

}