package com.thewire.viewsexperiments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class NavFragment : Fragment() {

    companion object {
        fun newInstance() = NavFragment()
    }

    private lateinit var viewModel: NavViewModel
    private lateinit var textNavButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_nav, container, false)
        textNavButton = v.findViewById(R.id.text_nav_button)
        return v;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[NavViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()
        setupNav()
    }

    fun setupNav() {
        textNavButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navFragment_to_textFragment);
        }
    }
}