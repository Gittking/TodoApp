package com.ozproject.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(val todoList:List<Todo>,val onClick: onClick): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.todo_structure,parent,false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
    
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
       holder.Bind(todoList[position],onClick)
    }

    class TodoViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

        fun Bind(todo:Todo,onClick: onClick){
             val todoText:TextView = itemView.findViewById(R.id.todo_text)
             val checkedTodo = itemView.findViewById<CheckBox>(R.id.checkedTodo)
             val btn_deleteTodo = itemView.findViewById<ImageView>(R.id.delete_item)

          btn_deleteTodo.setOnClickListener {
            onClick.onDelete(adapterPosition)
              Toast.makeText(it.context,"deleted successfully",Toast.LENGTH_SHORT).show()

          }

          todoText.text = todo.todoText
          checkedTodo.isChecked = todo.isChecked
        }
    }
}
data class Todo(
    var todoText: String,
    var isChecked : Boolean = false
)
