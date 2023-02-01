package com.example.tipcalci

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(val context: Context,val contacts: List<Person>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_person, parent ,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        private val tvPersonName  = itemView.findViewById<TextView>(R.id.tvPersonName)
        private val tvPersonAge  = itemView.findViewById<TextView>(R.id.tvPersonAge)

        fun bind(contact: Person) {
            tvPersonName.text = contact.name
            tvPersonAge.text = contact.age.toString()

        }

    }

}
