package com.example.viewmodel_sample

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val data: MutableList<Person> = mutableListOf(
    Person("Alice", "alice@gmail.com", 20),
    Person("Bob", "bob@gmail.com", 25),
    Person("Charlie", "charle@gmail.com", 30)
    )

    fun getPersonList(): List<Person> {
        return data
    }

    fun getPerson(id: Int): Person {
        return data[id]
    }

    fun setParson(person: Person) {
        data.add(person)
    }
}

class Person(
    var name:String,
    var email:String,
    var age:Int
)