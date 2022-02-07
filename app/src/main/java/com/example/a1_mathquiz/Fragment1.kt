package com.example.a1_mathquiz

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a1_mathquiz.enums.DifficultyMode

class Fragment1 : Fragment(R.layout.fragment_1) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //todo:update findviewbyid
        val easyButton: Button = view.findViewById(R.id.btnEasy)

        easyButton.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment2(DifficultyMode.EASY)

            findNavController().navigate(action)
        }

        val challengeButton: Button = view.findViewById(R.id.btnChallenge)

        challengeButton.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment2(DifficultyMode.CHALLENGE)

            findNavController().navigate(action)
        }
    }
}