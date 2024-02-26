package com.viswa.anmpweek01

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.viswa.anmpweek01.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            val playerScore = GameFragmentArgs.fromBundle(requireArguments()).playerScore

            binding.txtScore.text = "$playerName's Scores = $playerScore"
        }

        binding.btnBack.setOnClickListener{
         val action = GameFragmentDirections.actionMainFragment()
                Navigation.findNavController(it).navigate(action)
        }
    }
}