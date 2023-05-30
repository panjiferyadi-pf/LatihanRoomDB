package com.example.latihanroomdb

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanroomdb.data.UserViewModel
import com.example.latihanroomdb.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var mUserViewModel: UserViewModel
    //private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        //return binding.root

        //Menyiapkan Adapter dan recyclerView
        val adapter = UserListAdapter()
        val rvUser = binding.rvUser

        //Menambahkan adapter ke recycleView
        rvUser.adapter = adapter
        rvUser.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
            Log.d("User", user.toString())
        })


        //override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            //super.onViewCreated(view, savedInstanceState)
            binding.addFab.setOnClickListener {
                this.
                findNavController().navigate(R.id.action_listFragment_to_addFragment2)
            }
        //}
        return view
    }
}