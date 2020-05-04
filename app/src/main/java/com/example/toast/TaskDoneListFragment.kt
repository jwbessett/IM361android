package com.example.toast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskDoneListFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var recycler: GeneralRecycler<*, *>

    val tasks = mutableListOf(
        Task("Task One"),
        Task("Task Two"),
        Task("Task Three")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_done_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)

        recycler = GeneralRecycler<TaskItemView, Task>(
            context!!, recyclerView, R.layout.view_task_done_item, tasks) { itemView, item ->
            itemView.textView.text = item.name
        }
    }

    fun removeTask(tasks: Task): Boolean {
        return true
    }

    data class Task(val name: String)
}