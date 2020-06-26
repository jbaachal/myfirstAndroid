package com.achal.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.Navigation.findNavController


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //view.findViewById<Button>(R.id.random_button).setOnClickListener {
        //    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
       // }

        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        //Get the text of the view and convert it to an Int.
        val currentCount = showCountTextView.text.toString().toInt()

        //Create an action with currentCount as the argument to actionFirstFragmentToSecondFragment()
        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
       // val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()

        findNavController().navigate(action)

        //find the toast_button by its ID and set a click listener
        view.findViewById<Button>(R.id.toast_button).setOnClickListener{
            //Create a Toast with some text to appear for a short time
            val myToast=Toast.makeText(context,"Hello Tester", Toast.LENGTH_SHORT)

            //show the Toast
            myToast.show()
        }

        view.findViewById<Button>(R.id.count_button).setOnClickListener{
            countMe(view)
        }
    }

    private fun countMe(view: View){
        //Get the text view
        val showCountTextView=view.findViewById<TextView>(R.id.textview_first)

        //get the value of the text view
        val counstring=showCountTextView.text.toString()

        var count =counstring.toInt()
        count++

        showCountTextView.text = count.toString()

    }
}