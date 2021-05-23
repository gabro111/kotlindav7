package com.example.davnumber7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleViewAdapter(private val list:MutableList<Note>):RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder>(){

    class RecycleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val textView = itemView.findViewById<TextView>(R.id.recTextView)
        val removeButton: ImageButton = itemView.findViewById<ImageButton>(R.id.removeButton)
        fun bindNote(note:Note){

            textView.text =note.text;

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycle_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bindNote(list[position])
        holder.removeButton.setOnClickListener{

            list.removeAt(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, list.size);
        }

    }

    override fun getItemCount() = list.size
}