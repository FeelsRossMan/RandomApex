package com.evanross.randomapex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.evanross.randomapex.databinding.FragmentHomeBinding
import com.evanross.randomapex.homeScreen.HomeViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val rollModel: HomeViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val nameObserver = Observer<Int> {
                newChar -> binding.characterRolled.text = newChar.toString()
        }
        rollModel.character.observe(viewLifecycleOwner, nameObserver)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomButton.setOnClickListener {
            //findNavController().navigate(R.id.action_HomeFragment_to_RandomFragment)
            rollModel.rollCharacter()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}