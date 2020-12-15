package com.ntz.rickandmortycharacters.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ntz.rickandmortycharacters.App
import com.ntz.rickandmortycharacters.R
import com.ntz.rickandmortycharacters.data.network.model.CharacterDataSource
import com.ntz.rickandmortycharacters.data.network.model.CharacterDataSourceFactory
import com.ntz.rickandmortycharacters.data.network.model.ResultModel
import com.ntz.rickandmortycharacters.di.character.CharacterModule
import com.ntz.rickandmortycharacters.ui.list.adapter.CharListAdapter
import com.ntz.rickandmortycharacters.utils.Constants.COLUMNS_COUNT
import timber.log.Timber
import javax.inject.Inject

class CharListFragment : Fragment() {

    lateinit var paginationViewModel: CharListPaginationViewModel

    @Inject
    lateinit var characterDataSourceFactory: CharacterDataSourceFactory

    init {
        App.appComponent.inject(CharacterModule()).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_characters_list,
            container,
            false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        paginationViewModel =
            CharListPaginationViewModelFactory(characterDataSourceFactory).create(
                CharListPaginationViewModel::class.java
            )
        val adapter = CharListAdapter(PaginationItemCallback, paginationViewModel.pagedListData)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(requireContext(), COLUMNS_COUNT)

        paginationViewModel.pagedListData.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }
}