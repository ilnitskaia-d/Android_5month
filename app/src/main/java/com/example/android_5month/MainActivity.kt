package com.example.android_5month

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_5month.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(), CounterView {
    lateinit var binding : ActivityMainBinding
    private val presenter= Injector.getPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() {
        binding.btnPlus.setOnClickListener {
            presenter.increment()
        }
        binding.btnMinus.setOnClickListener {
            presenter.decrement()
        }
    }

    override fun showCounter(counter: Int) {
        binding.tvCounter.text = counter.toString()
    }

    override fun changeColor(color: Int) {
        binding.tvCounter.setTextColor(color)
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}