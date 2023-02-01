package com.example.tipcalci

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Person(var name : String , var age :Int)


class ThirdActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        recyclerView = findViewById(R.id.recyclerView)

        val contacts = createContacts()

        recyclerView.adapter = ContactsAdapter(this,contacts)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun createContacts(): List<Person> {
        val contacts = mutableListOf<Person>()
        for (i in 1..100){
            contacts.add(Person("person $i", i))
        }
        return contacts
    }
}