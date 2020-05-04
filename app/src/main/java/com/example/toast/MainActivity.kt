package com.example.toast

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)

        val adapter = MainActivityPagerAdapter(this)
        viewPager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            if (position == 0) {
                tab.text = "Tasks"
            }

            if (position == 1) {
                tab.text = "Completed"
            }
        }.attach()
    }

    private inner class MainActivityPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            if (position == 0) {
                return TaskListFragment()
            }
            return TaskDoneListFragment()
        }

    }
}
