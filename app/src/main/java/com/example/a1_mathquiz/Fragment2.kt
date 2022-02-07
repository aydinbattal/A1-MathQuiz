package com.example.a1_mathquiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs


class Fragment2 : Fragment(R.layout.fragment_2) {
    val args:Fragment2Args by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("ABC", "Received difficulty mode: ${args.difficultyMode}")

    }
}