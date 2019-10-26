package com.example.devfest.ui.frgs

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast

import com.example.devfest.R
import kotlinx.android.synthetic.main.fragment_prefrences.*
import kotlinx.android.synthetic.main.fragment_prefrences.view.*
import kotlinx.android.synthetic.main.fragment_prefrences.view.save_btn
import kotlin.ranges.CharRange.Companion.EMPTY

class PrefrencesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_prefrences, container, false)

        val sharedPref = this.activity?.getSharedPreferences("safety_number", Context.MODE_PRIVATE)
        val anc = sharedPref?.getString("safety_number", "")
        view.safety_number.setText(anc)

        view.save_btn.setOnClickListener {

            val  v = view.safety_number.text.toString()

            Log.d("valeur", v)

            val sharedPrefr = this.activity?.getSharedPreferences("safety_number", Context.MODE_PRIVATE)

            val editor = sharedPrefr?.edit()
            editor?.putString("safety_number", v)
            editor?.apply()

            val anci = sharedPrefr?.getString("safety_number", "NOt found")
            Toast.makeText(context, anci, Toast.LENGTH_LONG).show()


        }

        return view
    }
}
