package com.example.newchef.ui.resources

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.newchef.R

class ResourcesFragment : Fragment() {

    private lateinit var resourcesViewModel: ResourcesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        resourcesViewModel =
                ViewModelProviders.of(this).get(ResourcesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_resources, container, false)
        val textView: TextView = root.findViewById(R.id.text_resources)
        resourcesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
