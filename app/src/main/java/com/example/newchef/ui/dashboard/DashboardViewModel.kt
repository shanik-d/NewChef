package com.example.newchef.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newchef.data.Skills
import com.example.newchef.source.LocalUserSkills

class DashboardViewModel : ViewModel() {
    private val userSkills = LocalUserSkills.getUserSkills()

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    private var trackedSkillsObservable = MutableLiveData<Set<Skills>>(userSkills.getSkillsTracked())
    private var learnedSkillsObservable = MutableLiveData<Set<Skills>>(userSkills.getSkillsLearned())
    val trackedSkills: LiveData<Set<Skills>> = trackedSkillsObservable
    val learnedSkills: LiveData<Set<Skills>> = learnedSkillsObservable
    val text: LiveData<String> = _text
}