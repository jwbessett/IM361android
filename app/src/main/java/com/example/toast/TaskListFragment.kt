package com.example.toast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.view_task_item.*

val tasks = mutableListOf<Task>()

class TaskListFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var recycler: GeneralRecycler<*, *>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val floatingActionButton = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener {
            val dialog = TaskEntryDialogeFragment()

            dialog.positiveCallback = { text ->
                if (text.isNotEmpty()) {
                    // create a short toast
                    Toast.makeText(context, "Added a task $text", Toast.LENGTH_SHORT).show()

                    tasks.add(Task(text))

                }
            }
            dialog.show(fragmentManager!!, "add_task")
        }

        recyclerView = view.findViewById(R.id.recycler_view)

        recycler = GeneralRecycler<TaskItemView, Task>(
            context!!, recyclerView, R.layout.view_task_item, tasks) { itemView, item ->
            itemView.textView.text = item.name

            itemView.checkButton.setOnClickListener {
                doneTasks.add(TaskDoneListFragment.DoneTask(item.name))
                tasks.remove(item)
            }
        }

    }
}