package com.example.android_5month

import android.graphics.Color

class Presenter (val view: CounterView) {
    private val model = Injector.getModel()

    fun increment() {
        model.increment()
        view.showCounter(model.counter)
        if (model.counter == 10)
        {
            view.showToast("Поздравляем")
        }
        if(model.counter == 15)
        {
            view.changeColor(Color.GREEN)
        }
    }

    fun decrement() {
        model.decrement()
        view.showCounter(model.counter)
        if(model.counter == 14)
        {
            view.changeColor(Color.BLACK)
        }
    }
}