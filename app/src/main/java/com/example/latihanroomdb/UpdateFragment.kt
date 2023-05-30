package com.example.latihanroomdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.latihanroomdb.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {
    //Mendeklarasikan variabel args
    private val args by navArgs<UpdateFragmentArgs>()

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!
    //private lateinit var binding: FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.updateFirstname.setText(args.currentUser.firstName)
        binding.updateLastname.setText(args.currentUser.lastName)
        binding.updateAge.setText(args.currentUser.age.toString())
        return view
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.updateButton.setOnClickListener{
//            this.findNavController().navigate(R.id.action_updateFragment_to_listFragment2)
//        }
//    }

}