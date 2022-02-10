package com.example.a1_mathquiz.vms

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a1_mathquiz.entities.Question
import com.example.a1_mathquiz.enums.DifficultyMode
import kotlin.random.Random

/**
 * A1-MathQuiz created by aydin
 * student ID : 991521740
 * on 2022-02-07 */
class Fragment2ViewModel(difficulty: DifficultyMode): ViewModel() {
    var questionsList:MutableList<Question> = mutableListOf()
    var isQuizOver = MutableLiveData<Boolean>(false)
    var currentQuestion:Question? = null
    var score:Int = 0
    var index = 0

    var difficultyLevel: DifficultyMode? = null

    init {
        difficultyLevel = difficulty
        generateQuestions()
    }

    fun generateQuestions(){
        for (i in 1..3){
            val a = Random.nextInt(1, 10)
            val b = Random.nextInt(1, 10)

            if(difficultyLevel == DifficultyMode.EASY){
                val answer = a + b
                val wrongAnswer = Random.nextInt(answer-3, answer-1)
                currentQuestion = Question("What is $a+$b?",answer,listOf(answer,wrongAnswer).shuffled())
                questionsList.add(index, currentQuestion!!)
                //index += 1
            } else if(difficultyLevel == DifficultyMode.CHALLENGE){
                val answer = b*(a+b)-a
                val wrongAnswer = Random.nextInt(answer-3, answer-1)
                currentQuestion = Question("What is $b*($a+$b)-$a?",answer,listOf(answer,wrongAnswer).shuffled())
                questionsList.add(index, currentQuestion!!)
                //index += 1
            }
        }

    }

    fun updateGame(possibleAnswer:String){
        Log.d("ABC", "Question list : ${questionsList}")

        if(possibleAnswer == currentQuestion!!.answer.toString()){
            score =+ 125
        }
        if(questionsList.indexOf(currentQuestion) > 3){
            isQuizOver.value = true
        }
        Log.d("ABC", "Next question : ${questionsList[index+1]}")
        currentQuestion = questionsList[index+1]
        index += 1

    }

}