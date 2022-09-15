package com.evanross.randomapex.homeScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evanross.randomapex.data.AllowedCharactersList
import com.evanross.randomapex.data.AllowedCharactersList.allowedCharacterList
import com.evanross.randomapex.data.DataSource
import com.evanross.randomapex.model.ApexCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {


    var characters = DataSource.apexCharacters
    var returnId = 0

    private var allowedCharacterList: List<MutableState<Boolean>> = AllowedCharactersList.allowedCharacterList


    fun rollCharacter() : Boolean{
        val validList = getValidIndexes()
        if (validList.isEmpty()) return false
        returnId = validList[Random.nextInt(0, validList.size)]
        return true
    }

    fun isSelected(id: Int) : Boolean? {
        if (id < 0 || id >= allowedCharacterList.size) return null
        return allowedCharacterList[id].value
    }

    fun select(id: Int) {
        allowedCharacterList[id].value = !allowedCharacterList[id].value
    }

    private fun getValidIndexes() : List<Int> {
        val listOfValid = mutableListOf<Int>()
        for(i in allowedCharacterList.indices) {
            if (allowedCharacterList[i].value) listOfValid.add(i)
        }
        return listOfValid.toList()
    }
}
