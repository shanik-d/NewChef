package com.example.newchef.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newchef.data.Skills
import com.example.newchef.data.UserSkills
import com.example.newchef.source.LocalUserSkills

class HomeViewModel : ViewModel() {
    private val userSkills = LocalUserSkills.getUserSkills()

    private var trackedSkillsObservable = MutableLiveData<Set<Skills>>(userSkills.getSkillsTracked())
    private var learnedSkillsObservable = MutableLiveData<Set<Skills>>(userSkills.getSkillsLearned())
    private var nextSkillObservable = MutableLiveData<Skills>(userSkills.getNextUserSkill())

    val trackedSkills: LiveData<Set<Skills>> = trackedSkillsObservable
    val learnedSkills: LiveData<Set<Skills>> = learnedSkillsObservable
    val nextSkill: LiveData<Skills> = nextSkillObservable
}