package com.evanross.randomapex.apexCharacterScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.evanross.randomapex.data.DataSource
import com.evanross.randomapex.model.ApexCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ApexCharacterViewModel @Inject constructor(

): ViewModel() {
    val characters = DataSource.apexCharacters
    var animationComplete = false
    val apexCharacter = mutableStateOf(
        getRandomApexCharacter()
    )
    fun setRandomApexCharacter() {
        apexCharacter.value = getRandomApexCharacter()
    }

    private fun getRandomApexCharacter() : ApexCharacter{
        val random = Random.nextInt(0, DataSource.apexCharacters.size)
        return getApexCharacter(random)
    }

    private fun getApexCharacter(characterId: Int) : ApexCharacter {
        return DataSource.apexCharacters[characterId]
    }

}
