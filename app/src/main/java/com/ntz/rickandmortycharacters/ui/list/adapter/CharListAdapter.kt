package com.ntz.rickandmortycharacters.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ntz.rickandmortycharacters.R
import com.ntz.rickandmortycharacters.data.network.model.ResultModel
import com.ntz.rickandmortycharacters.ui.list.PaginationItemCallback

class CharListAdapter(
    diffCallBack: DiffUtil.ItemCallback<ResultModel?> = PaginationItemCallback,
    private val charList: LiveData<PagedList<ResultModel?>>
) : PagedListAdapter<ResultModel, CharListViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout: View = inflater.inflate(R.layout.item_fragment, parent, false)

        return CharListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CharListViewHolder, position: Int) {
        holder.bind(charList.value?.get(position)?.name, charList.value?.get(position)?.image)
    }

    override fun getItemCount(): Int {
        if (charList.value == null) {
            return 0
        }
        return charList.value!!.size
    }
}