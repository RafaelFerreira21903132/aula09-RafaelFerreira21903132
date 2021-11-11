package com.example.exemplosqlitedb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import layout.TarefaRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var tarefaViewModel: TarefaViewModel
    private val newTarefaActivityRequestCode = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = TarefaRecyclerViewAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        tarefaViewModel = ViewModelProvider(this).get(TarefaViewModel::class.java)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NovaTarefaActivity::class.java)
            startActivityForResult(intent, newTarefaActivityRequestCode)
        }
    }
        override fun onActivityResult(requestCode: Int, resultCode: Int, data:
        Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == newTarefaActivityRequestCode && resultCode ==
                Activity.RESULT_OK) {
                data?.getStringExtra(NovaTarefaActivity.EXTRA_REPLY)?.let {
                    val word = Tarefa(2,it)
                    tarefaViewModel.insert(word)
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}