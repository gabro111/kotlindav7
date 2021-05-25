package com.example.davnumber7

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleViewAdapter(private val list:MutableSet<String>):RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder>(){

    class RecycleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val sharedPreferences1: SharedPreferences = itemView.context.getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        private val textView = itemView.findViewById<TextView>(R.id.recTextView)
        val removeButton: ImageButton = itemView.findViewById<ImageButton>(R.id.removeButton)
        fun bindNote(note:String){

            textView.text =note;

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycle_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bindNote(list.elementAt(position))
        holder.removeButton.setOnClickListener{

            list.remove(list.elementAt(position))

            holder.sharedPreferences1.edit().remove("NOTE").apply()
            holder.sharedPreferences1.edit().putStringSet("NOTE",list).apply()
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, list.size);
        }

    }

    override fun getItemCount() = list.size
}