package com.example.lovecalculator

import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter (var api: LoveApi){
    lateinit var view: MainView

    fun attachView(view: MainView){
        this.view = view
    }

    fun getLove(firstName: String, secondName: String) {
        api.countCompatibility(firstName, secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                view.changeFragment(response.body()!!)
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                view.showError(t.message.toString())
            }
        })
    }
}