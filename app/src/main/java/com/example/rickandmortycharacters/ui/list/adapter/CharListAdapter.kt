package com.example.rickandmortycharacters.ui.list.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortycharacters.R
import data.network.model.CharacterData

class CharListAdapter(private val charList: List<CharacterData>) :
    RecyclerView.Adapter<CharListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout: View = inflater.inflate(R.layout.item_fragment, parent, false)

        return CharListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CharListViewHolder, position: Int) {
        Log.i("adapter", " some text ${charList[position].name}")
        holder.bind(charList[position].name, charList[position].imageUri)
    }

    override fun getItemCount(): Int {
        return charList.size
    }

}