package com.example.rickandmortycharacters.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortycharacters.R
import com.example.rickandmortycharacters.ui.list.adapter.CharListAdapter
import data.network.model.CharacterData

class CharListFragment : Fragment() {
    private lateinit var viewModel: CharListViewModel
    private lateinit var viewModelFactory: CharListViewModelFactory
    private val charHardCoding = listOf(
        CharacterData("Рик", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
        CharacterData("Морти", "https://rickandmortyapi.com/api/character/avatar/2.jpeg"),
        CharacterData("Альберт", "https://rickandmortyapi.com/api/character/avatar/3.jpeg"),
        CharacterData("Дай", "https://rickandmortyapi.com/api/character/avatar/4.jpeg"),
        CharacterData("Денег", "https://rickandmortyapi.com/api/character/avatar/5.jpeg"),
        CharacterData("нижний текст", "https://rickandmortyapi.com/api/character/avatar/6.jpeg")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelFactory = CharListViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(CharListViewModel::class.java)
        return inflater.inflate(
            R.layout.fragment_characters_list,
            container,
            false
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharListAdapter(charHardCoding)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(requireContext(), COLUMNS_COUNT)

    }

    companion object {
        private const val COLUMNS_COUNT = 2
    }
}