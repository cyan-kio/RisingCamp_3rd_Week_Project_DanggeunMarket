package com.cookandroid.danggeunmarket_clone_project

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cookandroid.danggeunmarket_clone_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var homeFragment: HomeFragment
    private lateinit var livingFragment: LivingFragment
    private lateinit var aroundFragment: AroundFragment
    private lateinit var chatFragment: ChatFragment
    private lateinit var myFragment: MyFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // StatusBar 투명 설정 - ViewExtension.kt
        makeStatusBarTransparent()

        // BottomNavigationView 색 설정
        binding.mainBottomNavigationView.itemIconTintList = null

        // Fragment 선언
        homeFragment = HomeFragment()
        livingFragment = LivingFragment()
        aroundFragment = AroundFragment()
        chatFragment = ChatFragment()
        myFragment = MyFragment()

        // Fragment 초기화
        changeFragment(homeFragment)
    }


    override fun onResume() {
        super.onResume()
        // BottomNavigationView_Fragment
        binding.mainBottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    changeFragment(homeFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.menu_living -> {
                    changeFragment(livingFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.menu_around -> {
                    changeFragment(aroundFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.menu_chat -> {
                    changeFragment(chatFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.menu_my -> {
                    changeFragment(myFragment)
                    return@setOnItemSelectedListener true
                }
            }
            true
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}
