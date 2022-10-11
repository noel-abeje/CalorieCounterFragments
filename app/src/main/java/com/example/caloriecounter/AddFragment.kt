package com.example.caloriecounter

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.fragment_list.view.*


class AddFragment : Fragment() {

    lateinit var mCalorieViewModel: CalorieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        mCalorieViewModel = ViewModelProvider(this).get(CalorieViewModel::class.java)

        view.addButton.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {

        val foodItem = addFoodItem.text.toString()
        val calories = addCalories.text

        if (inputCheck(foodItem, calories)) {
            //create user object
            val info = Calories(0,foodItem, Integer.parseInt(calories.toString()))
            //Add to database
            mCalorieViewModel.addFood(info)
            Toast.makeText(requireContext(), "Succeddfully added!", Toast.LENGTH_LONG).show()
            //Navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }else{
            Toast.makeText(requireContext(),"Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(foodItem: String, calories: Editable): Boolean{
        return !(TextUtils.isEmpty(foodItem) && calories.isEmpty())
    }

}