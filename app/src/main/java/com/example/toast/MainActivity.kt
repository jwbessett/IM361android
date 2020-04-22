package com.example.toast

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.System.console
import androidx.viewpager2.widget.ViewPager2


class MainActivity : FragmentActivity() {
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)

        val adapter = MainActivityPagerAdapter(this)
        viewPager.adapter = adapter
    }

    private inner class MainActivityPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return TaskListFragment()
        }

    }
}
