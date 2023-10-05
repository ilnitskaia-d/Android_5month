package com.example.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculator.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = App.appDatabase.loveDao().getAll()
        list.forEach { model ->
            binding.tvHistory.text = "${model.fname}${model.sname}${model.percentage}${model.result}"
        }
        initButtons()
    }

    private fun initButtons() {
        with(binding){

        }
    }
}