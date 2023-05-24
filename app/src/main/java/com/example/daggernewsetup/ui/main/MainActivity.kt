package com.example.daggernewsetup.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.daggernewsetup.R
import com.example.daggernewsetup.databinding.ActivityMainBinding
import com.example.daggernewsetup.di.qualifier.MainInfo
import com.example.daggernewsetup.ui.BaseActivity
import com.example.daggernewsetup.ui.auth.AuthActivity
import com.example.daggernewsetup.ui.auth.AuthViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

class MainActivity : BaseActivity() {

    lateinit var viewModel: MainViewModel

    @Inject
    @MainInfo
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this,mViewModelFactory).get(MainViewModel::class.java)
        binding.txtLogout.setOnClickListener {
            CoroutineScope(Main).launch {
                viewModel.sessionStoreManager.setIsUserLoogedIn(false)
                startActivity(Intent(this@MainActivity,AuthActivity::class.java))
                finish()
            }

        }
    }


}