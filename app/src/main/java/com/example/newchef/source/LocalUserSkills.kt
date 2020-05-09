package com.example.newchef.source

import com.example.newchef.data.UserSkills

object LocalUserSkills {
    private var userSkills: UserSkills = UserSkills()
    private var initialised: Boolean = false

    fun complete() {
        storeUserSkills()
    }

    fun getUserSkills(): UserSkills {
        if(!initialised){
            initialise()
        }
        return userSkills
    }

    private fun initialise() {
        val storedUserSkills = getStoredUserSkills()
        if(storedUserSkills !== null){
            userSkills = storedUserSkills
        }
        initialised = true
    }

    private fun getStoredUserSkills(): UserSkills? {
        return null;
    }

    private fun storeUserSkills() {
        return;
    }
}