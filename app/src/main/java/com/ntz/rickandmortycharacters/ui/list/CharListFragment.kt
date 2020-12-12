package com.ntz.rickandmortycharacters.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.paging.DataSource
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ntz.rickandmortycharacters.App
import com.ntz.rickandmortycharacters.R
import com.ntz.rickandmortycharacters.data.network.PagedListProvider
import com.ntz.rickandmortycharacters.data.network.model.CharacterDataSourceFactory
import com.ntz.rickandmortycharacters.data.network.model.ResultModel
import com.ntz.rickandmortycharacters.ui.list.adapter.CharListAdapter
import com.ntz.rickandmortycharacters.utils.Constants.COLUMNS_COUNT
import timber.log.Timber
import javax.inject.Inject

class CharListFragment : Fragment() {

    @Inject
    lateinit var viewModel: CharListViewModel

    @Inject
    lateinit var viewModelFactory: CharListViewModelFactory

    lateinit var paginationViewModel: CharListPaginationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.i("ON CREATE VIEW ")
        paginationViewModel =
            CharListPaginationViewModelFactory(CharacterDataSourceFactory(App.factory)).create(
                CharListPaginationViewModel::class.java
            )
//        viewModelFactory = CharListViewModelFactory()
//        viewModel = ViewModelProvider(this, viewModelFactory).get(CharListViewModel::class.java)
//        viewModel.makeApiCall()
        return inflater.inflate(
            R.layout.fragment_characters_list,
            container,
            false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharListAdapter(PaginationItemCallback, ArrayList())
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(requireContext(), COLUMNS_COUNT)

        paginationViewModel.pagedListData.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
        Timber.i("DATA: ${paginationViewModel.pagedListData.value} ")
    }
}