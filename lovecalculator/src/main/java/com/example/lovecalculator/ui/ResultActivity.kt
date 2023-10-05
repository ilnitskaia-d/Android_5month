package com.example.lovecalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ActivityResultBinding
import com.example.lovecalculator.model.LoveModel

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model = intent.getParcelableExtra<LoveModel>("model")!!
        App.appDatabase.loveDao().insert(model)
        binding.tvResult.text = model.toString()
    }
}