package com.example.davnumber7

import android.content.Context
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
    private var notes = mutableSetOf<String>();
    private lateinit var editText: EditText;
    private lateinit var button: Button
    private lateinit var recyclerView: RecyclerView;
    private lateinit var recyclerViewAdapter: RecycleViewAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        val savedText = sharedPref.getStringSet("NOTE", null)
        editText = findViewById(R.id.editTextNote)
        button = findViewById(R.id.button)
        recyclerView = findViewById(R.id.recyclerView)



        if (savedText != null) {
            savedText.forEach {
                Log.i("asd",it)
            }
            notes = savedText

        }




        recyclerViewAdapter = RecycleViewAdapter(notes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerViewAdapter



        button.setOnClickListener{
            val container =  editText.text;

            if (container.isEmpty()){
                return@setOnClickListener
            }
            notes.add(container.toString())
            //sharedPref.edit().remove("NOTE").commit()
            sharedPref.edit().remove("NOTE").apply()

            sharedPref.edit().putStringSet("NOTE",notes).apply()
            recyclerViewAdapter.notifyDataSetChanged()
            //sharedPref.edit().putStringSet("NOTE",null).apply()
        }
    }
}