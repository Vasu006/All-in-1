package com.example.allin1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return LoginPageFragment()
            }
            1 -> {
                return SignupPageFragment()
            }
            else -> {
                return LoginPageFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Login"
            }
            1 -> {
                return "Sign Up"
            }
        }
        return super.getPageTitle(position)

    }
}