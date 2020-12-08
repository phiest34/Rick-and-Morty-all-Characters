package com.example.rickandmortycharacters.ui.list.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortycharacters.R

class CharListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val characterName: TextView = itemView.findViewById(R.id.character_name)
    private val characterImage: ImageView = itemView.findViewById(R.id.character_image)

    fun bind(name: String, imageUri: String?) {
        characterName.text = name
        imageUri?.let {
            Glide.with(characterImage.context).load(it).into(characterImage)

        }
    }
}