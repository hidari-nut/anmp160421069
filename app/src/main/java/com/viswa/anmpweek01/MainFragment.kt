package com.viswa.anmpweek01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.viswa.anmpweek01.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater , container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var num1 = (0..100).random()
        var num2 = (0..100).random()
        var keyAnswerA = num1 + num2

        var scores = 0

        binding.txtQuestion.text = num1.toString() + " + " + num2.toString()

        super.onViewCreated(view, savedInstanceState)
        //val btnStart = view.findViewById<Button>(R.id.btnStart)

        binding.btnSubmit.setOnClickListener {
            if(binding.txtAnswer.text.toString() == keyAnswerA.toString()){

                scores += 100

                 num1 = (0..100).random()
                 num2 = (0..100).random()
                 keyAnswerA = num1 + num2

                binding.txtQuestion.text = num1.toString() + " + " + num2.toString()
                binding.txtAnswer.text = null
            }

            else{
            val name = binding.txtName.text.toString()
            val action = MainFragmentDirections.actionGameFragment(name, scores)
            Navigation.findNavController(it).navigate(action)
            }
        }
    }


}