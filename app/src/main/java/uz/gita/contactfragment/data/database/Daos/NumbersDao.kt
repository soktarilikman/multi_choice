package uz.gita.contactfragment.data.database.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.gita.contactfragment.data.database.Entities.ContactNumbers

@Dao
interface PhoneNumbersDao {
    @Insert
    fun insert(numbers: ContactNumbers)

    @Query("SELECT * FROM contact_numbers")
    fun getAll(): LiveData<List<ContactNumbers>>

    @Delete
    fun delete(numbers: ContactNumbers)
}