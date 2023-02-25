package com.example.to_do.UI

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.to_do.R
import com.example.to_do.databinding.FragmentPopupBinding
import com.google.android.material.textfield.TextInputEditText

class popup : DialogFragment() {
    private lateinit var binding:FragmentPopupBinding
    private lateinit var listener:DialogNextButtonClickListener

    fun setlistener(listener:DialogNextButtonClickListener){
        this.listener=listener
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentPopupBinding.inflate(inflater,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reguisterevents()
    }

    private fun reguisterevents() {
        binding.todoadd.setOnClickListener {
            val task=binding.task.text.toString()
            val Description=binding.des.text .toString()

            if(task.isNotEmpty()){
                listener.onSaveTask(task,binding.task, Description)
            }
            else{
                Toast.makeText(context,"Enter Task",Toast.LENGTH_SHORT).show()
            }
        }
    }
    interface DialogNextButtonClickListener{
        fun onSaveTask(todo:String,todoet:TextInputEditText,description:String)
    }

}