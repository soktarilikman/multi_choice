package uz.gita.contactfragment.repositories

import androidx.lifecycle.LiveData
import uz.gita.contactfragment.data.database.Entities.ContactNames

interface Repository {
    fun getAllContacts():LiveData<List<ContactNames>>
    fun insert(contactNames: ContactNames)
}