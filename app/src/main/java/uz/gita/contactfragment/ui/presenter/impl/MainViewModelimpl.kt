package uz.gita.contactfragment.ui.presenter.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.contactfragment.data.database.Entities.ContactNames
import uz.gita.contactfragment.data.database.Entities.ContactNumbers
import uz.gita.contactfragment.repositories.impl.ContactNameRepositoryImpl
import uz.gita.contactfragment.ui.presenter.MainViewModel

class MainViewModelImpl : MainViewModel, ViewModel() {
    private val repository = ContactNameRepositoryImpl.getRepository()

    override val contactsLiveData: LiveData<List<ContactNames>> = repository.getAllContacts()

    override val openDetailLiveData: MutableLiveData<Int> = MutableLiveData()

    override fun addContact(contactNames: ContactNames) {
        repository.insert(contactNames)
    }

   override fun addContactNumber(number: ContactNumbers) {
        repository.insertNumber(number)
    }

  override  fun getContact(contactNames: ContactNames) = repository.getContactId(contactNames)
    override fun openDetail(id: Int) {
        openDetailLiveData.value = id
    }
}