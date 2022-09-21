package com.evanross.randomapex.apexCharacterScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.evanross.randomapex.data.AllowedCharactersList
import com.evanross.randomapex.data.DataSource
import com.evanross.randomapex.model.ApexCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ApexCharacterViewModel @Inject constructor(

): ViewModel() {

    private val characters = DataSource.apexCharacters
    val apexCharacter : MutableState<ApexCharacter> = mutableStateOf(characters[0])


    var animationComplete = false

    private var allowedCharacterList: List<MutableState<Boolean>> = AllowedCharactersList.allowedCharacterList




    fun setRandomApexCharacter() {
        apexCharacter.value = getRandomApexCharacter()
    }

//    private fun getRandomApexCharacter() : ApexCharacter{
//        val random = Random.nextInt(0, DataSource.apexCharacters.size)
//        return getApexCharacter(random)
//    }

    private fun getApexCharacter(characterId: Int) : ApexCharacter {
        return DataSource.apexCharacters[characterId]
    }


    //Taken from the HomeViewModel. I'll have to change this later on though
    private fun getRandomApexCharacter() : ApexCharacter{
        val validList = getValidIndexes()
        if (validList.isEmpty()) return apexCharacter.value
        return getApexCharacter(validList[Random.nextInt(0, validList.size)])
    }

    private fun getValidIndexes() : List<Int> {
        val listOfValid = mutableListOf<Int>()
        for(i in allowedCharacterList.indices) {
            if (allowedCharacterList[i].value) listOfValid.add(i)
        }
        listOfValid.remove(apexCharacter.value.id)
        return listOfValid.toList()
    }

}
