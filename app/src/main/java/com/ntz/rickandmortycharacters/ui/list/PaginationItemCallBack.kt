package com.ntz.rickandmortycharacters.ui.list

import androidx.recyclerview.widget.DiffUtil
import com.ntz.rickandmortycharacters.data.network.model.ResultModel

object PaginationItemCallback : DiffUtil.ItemCallback<ResultModel?>() {

    override fun areItemsTheSame(oldItem: ResultModel, newItem: ResultModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ResultModel, newItem: ResultModel): Boolean {
        return oldItem.name == newItem.name
    }
}