package com.example.daggernewsetup.ui.main.posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggernewsetup.R
import com.example.daggernewsetup.databinding.FragmentPostBinding
import com.example.daggernewsetup.databinding.FragmentProfileBinding
import com.example.daggernewsetup.di.qualifier.PostFragmentInfo
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Named

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostFragment : DaggerFragment() {

    private lateinit var binding: FragmentPostBinding
    lateinit var viewModel: PostViewModel

    @Inject
    lateinit var adapter: CustomAdapter
    @Inject
    @PostFragmentInfo
    lateinit var mViewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_post,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,mViewModelFactory).get(PostViewModel::class.java)

        binding.rvPosts.layoutManager = LinearLayoutManager(requireActivity())
        viewModel.getListOfPost()

        viewModel.data.observe(viewLifecycleOwner) {
            binding.rvPosts.adapter = adapter
            adapter.setUpList(it)
        }
    }

}