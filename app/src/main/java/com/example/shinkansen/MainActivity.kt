package com.example.shinkansen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.
        beginTransaction().
        add(R.id.fragmentContainer,FirstFragment(),"FirstFragment").commit()
        //showFragment(FirstFragment())
    }

    fun showFragment(fragment: FirstFragment){
        val fram = supportFragmentManager.beginTransaction()
        fram.replace(R.id.fragment,fragment)
        fram.commit()
    }


}