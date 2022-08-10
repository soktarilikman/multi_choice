package uz.gita.contactfragment.ui.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.contactfragment.R
import uz.gita.contactfragment.data.database.Entities.ContactNames
import uz.gita.contactfragment.utils.inflate

class ContactAdapter : ListAdapter<ContactNames, ContactAdapter.Holder>(ItemCallback) {


    object ItemCallback : DiffUtil.ItemCallback<ContactNames>() {
        override fun areItemsTheSame(oldItem: ContactNames, newItem: ContactNames):
                Boolean = oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: ContactNames, newItem: ContactNames)
                : Boolean = oldItem.fullName == newItem.fullName && oldItem.id == newItem.id

    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {

//        init {
//            itemView.setOnClickListener { listener?.invoke(getItem(adapterPosition)) }
//        }

        fun bind() {
            val item = getItem(adapterPosition)
            val textTitle: TextView = itemView.findViewById(R.id.name)

            textTitle.text = item.fullName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.Holder =
        Holder(parent.inflate(R.layout.cars))

    override fun onBindViewHolder(holder: ContactAdapter.Holder, position: Int) = holder.bind()


}