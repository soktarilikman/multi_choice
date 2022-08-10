package uz.gita.contactfragment.repositories.impl

import androidx.lifecycle.LiveData
import uz.gita.contactfragment.data.database.Daos.PhoneNumbersDao
import uz.gita.contactfragment.data.database.DataBase
import uz.gita.contactfragment.data.database.Entities.ContactNames
import uz.gita.contactfragment.data.database.Entities.ContactNumbers
import uz.gita.contactfragment.repositories.Repository


class ContactNameRepositoryImpl : Repository {
    private val contactNameDao = DataBase.getDatabase().ContactNamesDao()
    private val phoneNumberDao = DataBase.getDatabase()?.PhoneNumbersDao()

    companion object {
        private var contactNameRepository: ContactNameRepositoryImpl? = null

        fun init() {
            if (contactNameRepository == null) {
                contactNameRepository = ContactNameRepositoryImpl()
            }
        }

        fun getRepository() = contactNameRepository!!
    }

    fun getContactId(contactNames: ContactNames) = contactNameDao.getContact(contactNames)

    override fun getAllContacts(): LiveData<List<ContactNames>> = contactNameDao.getAll()

    override fun insert(contactNames: ContactNames): Unit = contactNameDao.insert(contactNames)
     fun insertNumber(phoneNumber:ContactNumbers): Unit = phoneNumberDao.insert(phoneNumber)
}