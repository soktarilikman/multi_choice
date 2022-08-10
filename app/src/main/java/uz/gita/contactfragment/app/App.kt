package uz.gita.contactfragment.app

import android.app.Application
import uz.gita.contactfragment.data.database.DataBase
import uz.gita.contactfragment.repositories.impl.ContactNameRepositoryImpl

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DataBase.init(this)
        ContactNameRepositoryImpl.init()
    }
}