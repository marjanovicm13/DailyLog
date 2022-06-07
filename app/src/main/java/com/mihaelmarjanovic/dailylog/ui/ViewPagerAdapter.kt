package com.mihaelmarjanovic.dailylog.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mihaelmarjanovic.dailylog.ui.calendar.CalendarFragment
import com.mihaelmarjanovic.dailylog.ui.logger.LoggerFragment
import com.mihaelmarjanovic.dailylog.ui.settings.SettingsFragment
import com.mihaelmarjanovic.dailylog.ui.stats.StatsFragment

class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private val COUNT = 4

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> LoggerFragment()
            1 -> CalendarFragment()
            2 -> StatsFragment()
            3 -> SettingsFragment()
            else -> LoggerFragment()
        }
    }

    override fun getCount(): Int {
        return COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if(position == 0){
            return "Daylog"
        }
        else if(position == 1){
            return "Calendar"
        }
        else if(position == 2){
            return "Stats"
        }
        else {
            return "Settings"
        }
    }
}