package com.example.daggernewsetup.ui.auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.daggernewsetup.R
import com.example.daggernewsetup.databinding.ActivityAuthBinding
import com.example.daggernewsetup.model.UserItem
import com.example.daggernewsetup.ui.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    lateinit var viewModel: AuthViewModel

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory


    @Inject
    lateinit var user:UserItem

    @Inject
    lateinit var someString: String

    @set:Inject
    var isApp:Boolean? = null

    @Inject
    lateinit var requestManager: RequestManager


    private lateinit var binding: ActivityAuthBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_auth)
        viewModel = ViewModelProvider(this,mViewModelFactory).get(AuthViewModel::class.java)
        println("someString::->"+someString)
        println("isApp::->"+isApp)
        println("user::->"+user.hashCode())
        setLogo()
        binding.btnLogin.setOnClickListener {
            attemptLogin()
        }
        viewModel.authUser.observe(this) {
            startActivity(Intent(this,MainActivity::class.java))
        }
        handleLoader()
    }

    private fun handleLoader() {
        viewModel.loading.observe(this){
            if (it){
                binding.progress.visibility = View.VISIBLE
            }else{
                binding.progress.visibility = View.GONE
            }
        }
    }

    private fun attemptLogin() {
        if (TextUtils.isEmpty(binding.edtUsername.text.toString())){
            return
        }
        viewModel.getUSer(binding.edtUsername.text.toString().toInt())

    }

    fun setLogo(){
        requestManager.load("https://goo.gl/gEgYUd").into(binding.image)
    }
}