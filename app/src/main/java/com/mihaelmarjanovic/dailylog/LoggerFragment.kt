package com.mihaelmarjanovic.dailylog

import RecyclerViewAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mihaelmarjanovic.dailylog.databinding.ActivityMainBinding
import com.mihaelmarjanovic.dailylog.databinding.FragmentLoggerBinding
import java.util.*

class LoggerFragment : Fragment() {

    private lateinit var binding: FragmentLoggerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoggerBinding.inflate(layoutInflater)
        val recyclerview = binding.recyclerview
        recyclerview.layoutManager = LinearLayoutManager(this.context)

        val data = ArrayList<DayViewModel>()

        for (i in 1..20) {
            data.add(DayViewModel("Item " + i))
        }

        val adapter = RecyclerViewAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        return inflater.inflate(R.layout.fragment_logger, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun setupData() {

    }
}