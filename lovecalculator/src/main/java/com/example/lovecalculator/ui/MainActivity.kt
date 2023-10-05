package com.example.lovecalculator.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.lovecalculator.MainPresenter
import com.example.lovecalculator.MainView
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.LoveModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainView {
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initButtons()
    }

    private fun initButtons() {
        with(binding) {
            btnCalculate.setOnClickListener {
                presenter.getLove(etFirstName.text.toString(), etSecondName.text.toString())
            }
        }
    }

    override fun changeFragment(loveModel: LoveModel) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("model", loveModel)
        startActivity(intent)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}
