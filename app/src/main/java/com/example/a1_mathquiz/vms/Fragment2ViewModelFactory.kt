package com.example.a1_mathquiz.vms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a1_mathquiz.enums.DifficultyMode

/**
 * A1-MathQuiz created by aydin
 * student ID : 991521740
 * on 2022-02-09 */

class Fragment2ViewModelFactory(private val difficulty: DifficultyMode)  : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Fragment2ViewModel::class.java)) {
            return Fragment2ViewModel(difficulty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
