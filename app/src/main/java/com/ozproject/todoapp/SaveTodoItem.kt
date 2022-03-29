package com.ozproject.todoapp
import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.enter_todo_item_layout.*
import kotlinx.android.synthetic.main.todo_structure.*


class SaveTodoItem : AppCompatActivity() {
  //  private lateinit var todo: Todo
    companion object  {
     val sharedPreferences = SharedPreferences()
  }

    @SuppressLint("RestrictedApi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.enter_todo_item_layout)

        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

              val todoText = findViewById<EditText>(R.id.etTodo_item)

                btnSaveTodo.setOnClickListener {
            val   todo = Todo(todoText.text.toString(),false)

                if(TextUtils.isEmpty(todoText.text.toString())){
                    Toast.makeText(this,"Empty field not allowed",Toast.LENGTH_SHORT).show()
                }

            else{
                    MainActivity.todoList.add(todo)
                    sharedPreferences.saveTodoListInPref(this,MainActivity.todoList)
                    todoText.text.clear()
                    MainActivity.adapter.notifyItemInserted(MainActivity.todoList.size-1)
                }
        }

    }

}