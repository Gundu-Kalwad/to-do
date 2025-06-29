// src/main/java/com/yourpackage/MainActivity.kt
package com.yourpackage

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : Activity() {

    private lateinit var todoInput: EditText
    private lateinit var addButton: Button
    private lateinit var todoListView: ListView
    private val todoList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoInput = findViewById(R.id.todoInput)
        addButton = findViewById(R.id.addButton)
        todoListView = findViewById(R.id.todoListView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todoList)
        todoListView.adapter = adapter

        addButton.setOnClickListener {
            val task = todoInput.text.toString()
            if (task.isNotBlank()) {
                todoList.add(task)
                adapter.notifyDataSetChanged()
                todoInput.text.clear()
            }
        }

        todoListView.setOnItemClickListener { _, _, position, _ ->
            todoList.removeAt(position)
            adapter.notifyDataSetChanged()
        }
    }
}
