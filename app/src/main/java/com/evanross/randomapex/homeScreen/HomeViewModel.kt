package com.evanross.randomapex.homeScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class HomeViewModel : ViewModel() {

    val character : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }

    fun rollCharacter() {
        character.value = Random.nextInt(1, 3)
    }

}
