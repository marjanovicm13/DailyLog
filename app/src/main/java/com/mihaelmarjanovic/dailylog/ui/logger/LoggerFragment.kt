package com.mihaelmarjanovic.dailylog.ui.logger

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mihaelmarjanovic.dailylog.ui.DaylogActivity
import com.mihaelmarjanovic.dailylog.OnDayEventListener
import com.mihaelmarjanovic.dailylog.databinding.FragmentLoggerBinding
import com.mihaelmarjanovic.dailylog.di.DayRepositoryFactory
import com.mihaelmarjanovic.dailylog.model.Day


class LoggerFragment : Fragment(), OnDayEventListener {

    private lateinit var binding: FragmentLoggerBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter
    private val dayRepository = DayRepositoryFactory.dayRepository

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoggerBinding.inflate(layoutInflater)
        //val view: View = inflater.inflate(R.layout.fragment_logger, container, false)
        //Add new day button - starts activity to save day
        val btnAddNewDay: Button = binding.btnAdd
        btnAddNewDay.setOnClickListener(View.OnClickListener {
            val activityIntent = Intent(context, DaylogActivity::class.java)
            startActivity(activityIntent)
        })

        //Makes the recycler view, filled with random data
        //recyclerView = view.findViewById(R.id.recyclerview)
        //recyclerView.setHasFixedSize(true);
        //recyclerView.layoutManager = LinearLayoutManager(context)
        //val data = ArrayList<DayViewModel>()

       // for (i in 1..20) {
         //   data.add(DayViewModel("Item " + i))
       // }
        //adapter  = com.mihaelmarjanovic.dailylog.ui.logger.RecyclerViewAdapter()
        //recyclerView.adapter = adapter
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



    private fun setupRecyclerView() {
        recyclerView = binding.recyclerview
        //recyclerView.setHasFixedSize(true);
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = RecyclerViewAdapter()
        adapter.onDaySelectedListener= this
       recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        updateData()
    }

    private fun updateData() {
        adapter.setDays(dayRepository.getAllDays())
    }

    companion object {
        val Tag = "TasksList"

        fun create(): Fragment {
            return LoggerFragment()
        }
    }

    override fun onDaySelected(id: Long?) {

    }

    override fun onDayLongPress(day: Day?): Boolean {
        day?.let { it ->
            //DayRepository.delete(it)
            adapter.setDays(dayRepository.getAllDays())
        }
        return true
    }

}