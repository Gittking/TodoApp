package com.ozproject.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozproject.todoapp.SaveTodoItem.Companion.sharedPreferences
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() , onClick {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        todoList = sharedPreferences.getSavedTodoList(this)
         adapter =  TodoAdapter(todoList,this)
         Recycler_Todo.adapter = adapter
         Recycler_Todo.layoutManager = LinearLayoutManager(this)


         todo_add_icon.setOnClickListener {
                val intent = Intent(this,SaveTodoItem::class.java)
                startActivity(intent)
            }

         }

    override fun onDelete(position:Int){
          todoList.remove(todoList[position])
          adapter.notifyItemRemoved(position)
          adapter.notifyItemRangeChanged(position, todoList.size)
          sharedPreferences.saveTodoListInPref(this, todoList)
     }


       companion object:onClick {
           override fun onDelete(position: Int){
           }
           var todoList = ArrayList<Todo>()
           var adapter:TodoAdapter = TodoAdapter(todoList,this)
       }

}






