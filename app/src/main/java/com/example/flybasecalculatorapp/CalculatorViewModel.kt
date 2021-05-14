package com.example.flybasecalculatorapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * created by Ramanuj Kesharawani on 14/5/21
 */
class CalculatorViewModel : ViewModel() {

    private val _rawCalculationString = MutableLiveData<String>("")
    val rawCalculationString: LiveData<String>
        get() = _rawCalculationString

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun validateInput(string: String) {
        val prevString = _rawCalculationString.value!!
        when (string) {
            "x", "/", "-", "+" -> {
                if (prevString.isNotEmpty() && prevString[prevString.length - 1].toString().matches("[0-9]+".toRegex())) {
                    _rawCalculationString.value += string
                }else{
                    _errorMessage.value = "Please enter valid input"
                }
            }
            else -> {
                _rawCalculationString.value += string
            }
        }

    }


}