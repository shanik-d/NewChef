package com.example.newchef.data

object UserSkills {
    // TODO: review use of val/var with mutable arrays
    private val skillsLearned = mutableSetOf<Skills>()
    private val skillsTracked = mutableSetOf<Skills>()
    private var nextUserSkill = Skills.EQUIPMENT_AND_SETUP

    fun getSkillsLearned(): Set<Skills> {
        return skillsLearned
    }

    fun addLearnedSkill(learnedSkillToAdd: Skills) {
        skillsLearned.add(learnedSkillToAdd)
    }

    fun getSkillsTracked(): Set<Skills> {
        return skillsTracked
    }

    fun addTrackedSkill(trackedSkillToAdd: Skills) {
        skillsTracked.add(trackedSkillToAdd)
    }

    fun removeTrackedSkill(trackedSkillToRemove: Skills): Boolean {
        return skillsTracked.remove(trackedSkillToRemove)
    }

    fun convertTrackedSkillToLearnedSkill(skillToConvert: Skills): Boolean {
        val wasInSet = removeTrackedSkill(skillToConvert)
        if(wasInSet) {
            addLearnedSkill(skillToConvert)
        }
        return wasInSet
    }

    fun getNextUserSkill(): Skills {
        return nextUserSkill
    }

    fun setNextUserSkill(skillToMakeNext: Skills) {
        nextUserSkill = skillToMakeNext
    }
}