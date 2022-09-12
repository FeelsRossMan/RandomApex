package com.evanross.randomapex.homeScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evanross.randomapex.data.DataSource
import com.evanross.randomapex.model.ApexCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {

    var character = mutableStateOf(0)

    var allowedCharacterList: List<MutableState<Boolean>> = List(DataSource.apexCharacters.size) {
        mutableStateOf(true)
    }


    fun rollCharacter() {
        character.value = Random.nextInt(0, DataSource.apexCharacters.size)
    }

}
