package com.mihaelmarjanovic.dailylog.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mihaelmarjanovic.dailylog.R
import com.mihaelmarjanovic.dailylog.databinding.FragmentCalenderBinding

class CalendarFragment : Fragment() {

    private lateinit var binding: FragmentCalenderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_calender, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun setupData() {

    }
}