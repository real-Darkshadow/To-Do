package com.example.to_do.UI.RegisterScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.to_do.R
import com.example.to_do.databinding.FragmentRegisterScreenBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterScreen : Fragment() {

    private lateinit var auth:FirebaseAuth
    private var _binding:FragmentRegisterScreenBinding?=null
    private val binding get()=_binding!!
    private lateinit var viewModel: RegisterScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentRegisterScreenBinding.inflate(inflater, container, false)
        val view=binding.root
        binding.loginButton.setOnClickListener{
            findNavController().navigate(R.id.action_registerScreen_to_loginScreen)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        registerevents()
    }

    private fun registerevents() {
        binding.signupButton.setOnClickListener {
            val email=binding.username.text.toString()
            val pass=binding.password.text.toString().trim()
            val confirmpass=binding.confirmpassword.text.toString().trim()
            if (email.isNotEmpty()&& pass.isNotEmpty()&& confirmpass.isNotEmpty()){
                if(pass.equals(confirmpass)){
                    binding.progressbar.visibility=View.VISIBLE
                    auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener({
                        if(it.isSuccessful){
                            findNavController().navigate(R.id.action_registerScreen_to_homeScreen)
                        }
                        else{
                            Log.d("hell",it.exception.toString())
                        }
                        binding.progressbar.visibility=View.GONE
                    })
                }
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