package com.ozproject.todoapp

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPreferences {

   private lateinit var sharePref:SharedPreferences

    val String_LIST_KEY = "TodoList"
    val gson =  Gson()

    fun saveTodoListInPref(context:Context,todo:List<Todo>){
          val jsonTodoStringList = gson.toJson(todo)
          sharePref = context.getSharedPreferences(String_LIST_KEY,Context.MODE_PRIVATE)
          sharePref.edit().putString(String_LIST_KEY,jsonTodoStringList).apply()
    }

    fun getSavedTodoList(context: Context):ArrayList<Todo> {
        sharePref = context.getSharedPreferences(String_LIST_KEY, Context.MODE_PRIVATE)
        val emptyList = gson.toJson(ArrayList<Todo>())
        val jsonTodoStringList = sharePref.getString(String_LIST_KEY, emptyList)
        val type = object : TypeToken<List<Todo>>() {}.type
        val list: ArrayList<Todo> = gson.fromJson(jsonTodoStringList,type)
        return list
    }

//        if(jsonTodoStringList!=null){
//            return list
//        }
//        else{
//            return arrayListOf<Todo>()
//        }
//       return if (jsonTodoStringList != null) {
//            gson.fromJson(jsonTodoStringList, object : TypeToken<List<Todo>>() {}.type)
//
//        } else {
//            return todoList
//        }
}