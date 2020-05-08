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
import kotlinx.android.synthetic.main.view_task_done_item.view.*

val doneTasks = mutableListOf<TaskDoneListFragment.DoneTask>()

class TaskDoneListFragment : Fragment() {
    lateinit var doneRecyclerView: RecyclerView
    lateinit var doneRecycler: GeneralRecycler<*, *>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_done_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doneRecyclerView = view.findViewById(R.id.recycler_view_done)

        doneRecycler = GeneralRecycler<TaskItemDoneView, DoneTask>(
            context!!, doneRecyclerView, R.layout.view_task_done_item, doneTasks) { itemView, item ->
            itemView.textView.text = item.name

            itemView.removeButton.setOnClickListener {
                doneTasks.remove(item)
            }
        }
    }

    data class DoneTask(val name: String)
}