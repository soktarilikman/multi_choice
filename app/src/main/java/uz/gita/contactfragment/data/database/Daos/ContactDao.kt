package uz.gita.contactfragment.data.database.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.gita.contactfragment.data.database.Entities.ContactNames

@Dao
interface ContactNamesDao {
    @Insert
    fun insert(contactNames: ContactNames)

    @Query("SELECT * FROM contact_names")
    fun getAll(): LiveData<List<ContactNames>>

    @Delete
    fun delete(contactNames: ContactNames)


    @Query("SELECT * FROM contact_names WHERE full_name = :contactName ORDER BY id DESC LIMIT 1")
    fun getContact(contactName: ContactNames)
}