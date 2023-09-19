package com.example.android_5month

class Injector {

    companion object {
        fun getModel(): Model {
            return Model()
        }
        fun getPresenter(view: CounterView): Presenter {
            return Presenter(view)
        }
    }
}