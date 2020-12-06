package com.example.rickandmortycharacters.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmortycharacters.R
import com.example.rickandmortycharacters.ui.connect.ConnectingFragment
import com.example.rickandmortycharacters.ui.list.CharListFragment

class MainActivity : AppCompatActivity(), ConnectingFragment.ConnectListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.root, ConnectingFragment())
                .commit()
    }
    override fun onConnectPressed() {
        supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.root, CharListFragment())
                .commit()
    }
}