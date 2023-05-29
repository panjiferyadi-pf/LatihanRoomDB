package com.example.latihanroomdb

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.latihanroomdb.data.User
import com.example.latihanroomdb.data.UserViewModel
import com.example.latihanroomdb.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    //private lateinit var binding: FragmentAddBinding
    private val binding get() = _binding!!
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        mUserViewModel = ViewModelProvider(this)
            .get(UserViewModel::class.java)

        binding.addButton.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase(){
        val firstName = binding.addFirstname1.text.toString()
        val lastName = binding.addLastname1.text.toString()
        val age = Integer.parseInt(binding.addAge1.text.toString())

        val user = User(0, firstName, lastName, age)
        mUserViewModel
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.addButton.setOnClickListener{
//            this.findNavController()
//                .navigate(R.id.action_addFragment_to_listFragment2)
//        }
//    }
}

