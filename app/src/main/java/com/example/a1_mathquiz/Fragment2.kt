package com.example.a1_mathquiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.a1_mathquiz.databinding.Fragment2Binding
import com.example.a1_mathquiz.vms.Fragment2ViewModel
import com.example.a1_mathquiz.vms.Fragment2ViewModelFactory


class Fragment2 : Fragment(R.layout.fragment_2) {
    val args:Fragment2Args by navArgs()

    // binding
    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!

    // view model
    private val model:Fragment2ViewModel by viewModels{
        Fragment2ViewModelFactory(args.difficultyMode)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialize the variable
        val binding = Fragment2Binding.bind(view)

        binding.btnAnswer1.setOnClickListener{
            Log.d("ABC", "Received answer 1: ${binding.btnAnswer1.text.toString()}")
            model.updateGame(binding.btnAnswer1.text.toString())
            displayScoreUI(binding)
            displayQuestionUI(binding)
        }

        binding.btnAnswer2.setOnClickListener{
            Log.d("ABC", "Received answer 2: ${binding.btnAnswer2.text.toString()}")
            model.updateGame(binding.btnAnswer2.text.toString())
            displayScoreUI(binding)
            displayQuestionUI(binding)
        }

        binding.btnStartOver.setOnClickListener{
            findNavController().popBackStack()
        }

        binding.swtTurnOnHints.setOnCheckedChangeListener { _, isChecked ->
            // do whatever you need to do when the switch is toggled here
            binding.txtHint.isVisible = isChecked

        }

        Log.d("ABC", "Received difficulty mode: ${args.difficultyMode}")

        displayScoreUI(binding)
        displayQuestionUI(binding)

    }

    fun displayScoreUI(binding: Fragment2Binding){
        binding.txtCurrentScoreNumber.text = model.score.toString()
        val remaining = model.questionsList.count() - model.index
        binding.txtQuestionsRemainingNumber.text = remaining.toString()
    }

    fun displayQuestionUI(binding: Fragment2Binding){
        Log.d("ABC", "Received : ${model.currentQuestion?.questionText}")
        binding.txtQuestion.text = model.currentQuestion?.questionText
        binding.btnAnswer1.text = model.currentQuestion?.choices?.first().toString()
        binding.btnAnswer2.text = model.currentQuestion?.choices?.last().toString()
        binding.txtHint.text = "Correct answer is ${model.currentQuestion?.answer.toString()}"
    }
}