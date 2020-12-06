package com.example.rickandmortycharacters.ui.connect

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.rickandmortycharacters.R

class ConnectingFragment : Fragment() {
    interface ConnectListener {
        fun onConnectPressed()
    }
    private var listener: ConnectListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = requireActivity() as? ConnectListener
    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(
                R.layout.fragment_connect,
                container,
                false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val connectButton = view.findViewById<Button>(R.id.button_connect)
        connectButton.setOnClickListener {
            listener?.onConnectPressed()
        }
    }
}