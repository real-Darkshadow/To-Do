package com.example.to_do.UI.LoginScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.to_do.R
import com.example.to_do.databinding.FragmentLoginScreenBinding
import com.example.to_do.databinding.FragmentRegisterScreenBinding
import com.google.firebase.auth.FirebaseAuth

class LoginScreen : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentLoginScreenBinding?=null
    private val binding get()=_binding!!

    private lateinit var viewModel: LoginScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentLoginScreenBinding.inflate(inflater, container, false)
        val view=binding.root
        binding.signupButton.setOnClickListener{
            findNavController().navigate(R.id.action_loginScreen_to_registerScreen)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        registerevents()
    }

    private fun registerevents() {
        binding.loginButton.setOnClickListener {
            val email=binding.username.text.toString()
            val pass=binding.password.text.toString().trim()
            if (email.isNotEmpty()&& pass.isNotEmpty()){
                    auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener({
                        if(it.isSuccessful){
                            findNavController().navigate(R.id.action_loginScreen_to_homeScreen)
                        }
                        else{
                            Log.d("hell",it.exception.toString())
                        }
                    })
            }
        }
    }

    private fun init(view: View) {
        auth=FirebaseAuth.getInstance()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}