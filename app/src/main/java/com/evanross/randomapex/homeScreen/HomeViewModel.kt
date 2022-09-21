package com.evanross.randomapex.homeScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.evanross.randomapex.data.AllowedCharactersList
import com.evanross.randomapex.data.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {

    var legendsDropDownOpen = mutableStateOf(true)

    var characters = DataSource.apexCharacters

    private var allowedCharacterList: List<MutableState<Boolean>> = AllowedCharactersList.allowedCharacterList

    //Character selecting functions
    fun isCharacterSelected(id: Int) : Boolean? {
        if (id < 0 || id >= allowedCharacterList.size) return null
        return allowedCharacterList[id].value
    }

    fun selectCharacter(id: Int) {
        allowedCharacterList[id].value = !allowedCharacterList[id].value
    }
    //

    // Rolling functions
    fun rollCharacter() : Boolean{
        val validList = getValidIndexes()
        if (validList.isEmpty()) return false
        return true
    }

    private fun getValidIndexes() : List<Int> {
        val listOfValid = mutableListOf<Int>()
        for(i in allowedCharacterList.indices) {
            if (allowedCharacterList[i].value) listOfValid.add(i)
        }
        return listOfValid.toList()
    }
    //
}
