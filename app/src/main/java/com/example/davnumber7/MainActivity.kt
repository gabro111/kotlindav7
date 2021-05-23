package com.example.davnumber7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // Note-classit vaketebdi tavidan da mivxvdi ro ar iyo sachiro
//    private val notes = ArrayList<Note>();
    private val notes = mutableSetOf<String>();
    private val adapter = RecycleViewAdapter(notes);
    private lateinit var editText: EditText;
    private lateinit var button: Button
    private lateinit var recyclerView: RecyclerView;
    private lateinit var recyclerViewAdapter: RecycleViewAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextNote)
        button = findViewById(R.id.button)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerViewAdapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerViewAdapter
        button.setOnClickListener{
            val container =  editText.text;

            if (container.isEmpty()){
                return@setOnClickListener
            }
            notes.add(container.toString())
            adapter.notifyDataSetChanged()
        }
    }
}