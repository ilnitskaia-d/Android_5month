package com.example.lovecalculator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.lovecalculator.App
import com.example.lovecalculator.HistoryActivity
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ActivityResultBinding
import com.example.lovecalculator.model.LoveModel

class ResultActivity : ComponentActivity() {
    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model = intent.getParcelableExtra<LoveModel>("model")!!
        App.appDatabase.loveDao().insert(model)
        binding.tvFirstName.text = model.fname
        binding.tvSecondName.text = model.sname
        binding.tvResultPercent.text = (model.percentage + "%")
        binding.tvResultComment.text = model.result

        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
    }
}