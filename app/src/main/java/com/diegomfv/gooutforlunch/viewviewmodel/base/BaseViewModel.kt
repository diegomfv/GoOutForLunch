package com.diegomfv.gooutforlunch.viewviewmodel.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.diegomfv.gooutforlunch.utils.TriggerOnce
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    var initializer = true

    fun initialize(vararg func: () -> Unit) {
        if (initializer) {
            func.forEach { it.invoke() }
            initializer = false
        }
    }

    var triggerProgressLayoutLiveData = MutableLiveData<TriggerOnce<Boolean>>()

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        Timber.w("onCleared() called")
        disposeDisposables()
        super.onCleared()
    }

    private fun disposeDisposables() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
            compositeDisposable.clear()
        }
    }
}
