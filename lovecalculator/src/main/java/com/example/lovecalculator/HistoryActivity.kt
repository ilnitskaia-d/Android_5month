package com.example.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.lovecalculator.databinding.ActivityHistoryBinding

class HistoryActivity : ComponentActivity() {
    lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = App.appDatabase.loveDao().getAll()
        list.forEach { model ->
            binding.tvHistory.append("${model.fname}${model.sname}${model.percentage}${model.result}")
        }
    }

}