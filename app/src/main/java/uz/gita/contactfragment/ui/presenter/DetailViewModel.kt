package uz.gita.contactfragment.ui.presenter

import androidx.lifecycle.LiveData

interface DetailViewModel {
    val backLiveData: LiveData<Unit>

    fun back()
}