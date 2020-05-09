package com.example.newchef.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.newchef.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        /** the below lines pass the text in the view to the viewmodel. The viewmodel updates the
        * text and it gets applied here... I think.
        * But shouldn't the model contain the data to change the text to? As I understand it, the
        * viewmodel should contain only presentational logic.
        */
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        val skillsTrackedTextView: TextView = root.findViewById(R.id.home_fragment_skills_tracked)
        val skillsLearnedTextView: TextView = root.findViewById(R.id.home_fragment_skills_learned)
        val nextSkillTextView: TextView = root.findViewById(R.id.home_fragment_next_skill)
        homeViewModel.trackedSkills.observe(viewLifecycleOwner, Observer {
            skillsTrackedTextView.text = getString(R.string.skills_tracked, it.count())
        })
        homeViewModel.learnedSkills.observe(viewLifecycleOwner, Observer {
            skillsLearnedTextView.text = getString(R.string.skills_learned, it.count())
        })
        homeViewModel.nextSkill.observe(viewLifecycleOwner, Observer {
            nextSkillTextView.text = getString(R.string.next_skill, it.name)
        })
        return root
    }
}
