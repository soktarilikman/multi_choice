package uz.gita.contactfragment.ui.presenter.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.contactfragment.ui.presenter.DetailViewModel

class DetailViewModelImpl : DetailViewModel, ViewModel() {
    override val backLiveData: MutableLiveData<Unit> = MutableLiveData()


    override fun back() {
        backLiveData.value = Unit
    }
}