package com.example.lovecalculator

import com.example.lovecalculator.model.LoveModel

interface MainView {
    fun changeFragment(loveModel: LoveModel)
    fun showError(error: String)
}