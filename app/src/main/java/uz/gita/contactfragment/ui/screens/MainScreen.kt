package uz.gita.contactfragment.ui.screens

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.gita.contactfragment.R
import uz.gita.contactfragment.data.database.Entities.ContactNames
import uz.gita.contactfragment.data.database.Entities.ContactNumbers
import uz.gita.contactfragment.ui.adapters.ContactAdapter
import uz.gita.contactfragment.ui.presenter.MainViewModel
import uz.gita.contactfragment.ui.presenter.impl.MainViewModelImpl

class MainScreen : Fragment(R.layout.main_screen) {


    private val viewModel: MainViewModel by lazy {ViewModelProvider(this)[MainViewModelImpl::class.java] }
    private val adapter: ContactAdapter by lazy { ContactAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = view.findViewById<RecyclerView>(R.id.list)
        val btnAdd: FloatingActionButton = view.findViewById(R.id.btnAdd)
        list.adapter = adapter
        btnAdd.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(requireContext())
            val inflater = this.layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_add_contact, null)
            dialogBuilder.setView(dialogView)
            var saveBtn = dialogView.findViewById<Button>(R.id.button1)
            val alertDialog = dialogBuilder.create()
            saveBtn.setOnClickListener {
                val name = dialogView.findViewById<EditText>(R.id.name).text.toString() //      val number = dialogView.findViewById<EditText>(R.id.number).text.toString()
                viewModel.addContact(ContactNames(0, name))

                alertDialog.dismiss()
            }


            alertDialog.show()

        }
     viewModel.contactsLiveData.observe(viewLifecycleOwner, contactsObserver)

    }

    private val contactsObserver = Observer<List<ContactNames>> { adapter.submitList(it) }


}