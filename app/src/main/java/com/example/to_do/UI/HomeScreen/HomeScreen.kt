
package com.example.to_do.UI.HomeScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.to_do.R
import com.example.to_do.UI.popup
import com.example.to_do.databinding.FragmentHomeScreenBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class HomeScreen : Fragment(), popup.DialogNextButtonClickListener {


    private lateinit var viewModel: HomeScreenViewModel
    private var bindingg:FragmentHomeScreenBinding?=null
    private val binding get()=bindingg!!
    private lateinit var  auth:FirebaseAuth
    private  lateinit var databaseref:DatabaseReference
    private lateinit var popUpfrag:popup


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingg=FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        registerevents()

    }

    private fun registerevents() {
        binding.addbutton.setOnClickListener {
            popUpfrag= popup()
            popUpfrag.setlistener(this)
            popUpfrag.show(childFragmentManager,"popupfragment")
        }
    }

    private fun init(view: View) {
        auth=FirebaseAuth.getInstance()
        databaseref=FirebaseDatabase.getInstance().reference

    }

    override fun onSaveTask(todo: String, todoet: TextInputEditText, description: String) {
        TODO("Not yet implemented")
    }


}