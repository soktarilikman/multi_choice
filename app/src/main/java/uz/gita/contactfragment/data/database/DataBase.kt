package uz.gita.contactfragment.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.contactfragment.data.database.Daos.ContactNamesDao
import uz.gita.contactfragment.data.database.Daos.PhoneNumbersDao
import uz.gita.contactfragment.data.database.Entities.ContactNames
import uz.gita.contactfragment.data.database.Entities.ContactNumbers

@Database(entities = [ContactNames::class, ContactNumbers::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun ContactNamesDao(): ContactNamesDao
    abstract fun PhoneNumbersDao(): PhoneNumbersDao

    companion object {
        private var instance: DataBase? = null

        fun init(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "appdatabse"
                )
                    .allowMainThreadQueries()
                    .build()
            }
        }

        fun getDatabase() = instance!!
    }
}