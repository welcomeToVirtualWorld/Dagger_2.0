package com.example.daggernewsetup.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.daggernewsetup.R
import com.example.daggernewsetup.databinding.ActivityMainBinding
import com.example.daggernewsetup.databinding.FragmentProfileBinding
import com.example.daggernewsetup.di.qualifier.ProfileFragmentInfo
import com.example.daggernewsetup.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Named

class ProfileFragment : DaggerFragment(){
    private lateinit var binding: FragmentProfileBinding

    private lateinit var profileViewModel: ProfileViewModel

    @Inject
    @ProfileFragmentInfo
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileViewModel = ViewModelProvider(this,mViewModelFactory).get(ProfileViewModel::class.java)
        Toast.makeText(requireContext(),"Fragment:",Toast.LENGTH_LONG).show()

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_postFragment)
        }
    }
}