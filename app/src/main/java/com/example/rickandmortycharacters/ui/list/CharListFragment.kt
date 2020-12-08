package com.example.rickandmortycharacters.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortycharacters.R
import com.example.rickandmortycharacters.ui.list.adapter.CharListAdapter
import javax.inject.Inject

class CharListFragment : Fragment() {

    @Inject
    lateinit var viewModel: CharListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // viewModelFactory = CharListViewModelFactory(CharacterRepository(ApiService))
        // viewModel = ViewModelProvider(this, viewModelFactory).get(CharListViewModel::class.java)
        viewModel.makeApiCall()
        return inflater.inflate(
            R.layout.fragment_characters_list,
            container,
            false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharListAdapter(ArrayList())
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(requireContext(), COLUMNS_COUNT)

        viewModel.getCharactersListObserver().observe(viewLifecycleOwner, {
            adapter.updateData(it)
        })

    }

    companion object {
        private const val COLUMNS_COUNT = 2
    }
}