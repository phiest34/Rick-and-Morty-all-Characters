package com.ntz.rickandmortycharacters.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ntz.rickandmortycharacters.R
import com.ntz.rickandmortycharacters.data.network.model.ResultModel
import com.ntz.rickandmortycharacters.ui.list.PaginationItemCallback

class CharListAdapter(

    diffCallBack: DiffUtil.ItemCallback<ResultModel?> = PaginationItemCallback,
    private val charList: MutableList<ResultModel>

) : PagedListAdapter<ResultModel, CharListViewHolder>(diffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout: View = inflater.inflate(R.layout.item_fragment, parent, false)

        return CharListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CharListViewHolder, position: Int) {
        holder.bind(charList[position].name, charList[position].image)
    }

    override fun getItemCount(): Int {
        return charList.size
    }

    fun updateData(value: List<ResultModel>?) {
        charList.clear()
        value?.let { charList.addAll(it) }
        notifyDataSetChanged()
    }
}