package uz.gita.contactfragment.ui.presenter

import androidx.lifecycle.LiveData
import uz.gita.contactfragment.data.database.Entities.ContactNames
import uz.gita.contactfragment.data.database.Entities.ContactNumbers

interface MainViewModel {
    val contactsLiveData: LiveData<List<ContactNames>>
    val openDetailLiveData: LiveData<Int>


    fun addContact(contactEntity: ContactNames)
    fun addContactNumber(number: ContactNumbers)
    fun openDetail(id: Int)
    fun getContact(contactNames: ContactNames)


}