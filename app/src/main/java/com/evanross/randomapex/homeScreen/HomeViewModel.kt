package com.evanross.randomapex.homeScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evanross.randomapex.data.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {

    var character = mutableStateOf(0)

    fun rollCharacter() {
        character.value = Random.nextInt(0, DataSource.apexCharacters.size)
    }

}
