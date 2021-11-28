package com.mj.espressouitestexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mj.espressouitestexample.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }
    }
}